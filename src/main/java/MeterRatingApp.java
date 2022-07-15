import cdr.types.*;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Produced;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import serde.AppSerdes;

import java.util.Date;
import java.util.Properties;

public class MeterRatingApp {
    private static final Logger logger = LogManager.getLogger(MeterRatingApp.class);

    public static void main(String[] args) {
        Properties props = new Properties();

        props.put(StreamsConfig.APPLICATION_ID_CONFIG, AppConfigs.APP_NAME);
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, AppConfigs.BROKERS);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        props.put(StreamsConfig.COMMIT_INTERVAL_MS_CONFIG, 0);

        StreamsBuilder streamsBuilder = new StreamsBuilder();

        // MeterSerial: {meterID ,meterSerial, meterType}
        KTable<String, Meter> meterKTable = streamsBuilder.table(AppConfigs.SOURCE_TOPIC_METER_NAME,
                Consumed.with(AppSerdes.String(), AppSerdes.Meter()));
        meterKTable.toStream().peek((k, v) -> System.out.println("Meter:  --> " + " key: " + k + " value: " + v));

        // MeterID: {currentReadingId, meterID, invoice, totalReading, lastUpdate}
        KTable<String, CurrentReading> currentReadingKTable = streamsBuilder.table(AppConfigs.SOURCE_TOPIC_CURRENT_READING_NAME,
                Consumed.with(AppSerdes.String(), AppSerdes.CurrentReading()));
        currentReadingKTable.toStream().peek((k, v) -> System.out.println("CurrentReading: --> " + " key: " + k + " value: " + v));

        // MeterSerial: {reading, meterSerial, lastUpdate}
        KStream<String, Reading> readingKStream = streamsBuilder.stream(AppConfigs.TOPIC_NIFI_READING_NAME,
                Consumed.with(AppSerdes.String(), AppSerdes.Reading()));
        readingKStream.peek((k, v) -> System.out.println("NifiReading: --> " + " key: " + k + " value: " + v));

        //Joining Meter and Reading To get the type of meter
        // out MeterSerial: {reading, meterID, meterType, lastUpdate}
        KStream<String, ReadingMeterType> readingTypeKStream = readingKStream.join(meterKTable,
                (reading, meter) ->
                        ReadingMeterType.newBuilder()
                                .setMeterID(meter.getMeterID())
                                .setMeterType(meter.getMeterType())
                                .setReading(reading.getReading())
                                .setLastUpdate(new Date().toInstant())
                                .build()


        ).peek((k, v) -> System.out.println("ReadingMeterType: --> " + " key: " + k + " value: " + v));

        KStream<String, ReadingHistory> readingHistoryKStream = readingTypeKStream.mapValues(
                (readingMeterType) ->
                        ReadingHistoryFields.getReadingHistoryFields(readingMeterType)
        );
        readingHistoryKStream.to(AppConfigs.SINK_TOPIC_READING_HISTORY_NAME,
                Produced.with(AppSerdes.String(), AppSerdes.ReadingHistory()));

        //Mapping The ReadingType key to meterID
        //out meterID: {reading, meterID, meterSerial, meterType, lastUpdate}
        KStream<String, ReadingMeterType> readingTypeMappedKStream = readingTypeKStream.selectKey(
                (k, v) -> v.getMeterID() + ""
        ).peek((k, v) ->
                System.out.println("Changing Key to meterID With Type: --> " + " key: " + k + " value: " + v));

        readingTypeMappedKStream.to(AppConfigs.REPARTIONING_TOPIC_METERID_NAME,
                Produced.with(AppSerdes.String(), AppSerdes.ReadingMeterType()));

        KStream<String, ReadingMeterType> readingTypeMeterIDKStream = streamsBuilder.stream(AppConfigs.REPARTIONING_TOPIC_METERID_NAME,
                Consumed.with(AppSerdes.String(), AppSerdes.ReadingMeterType()));

        //Joining ReadingMeterType with  current Reading to get the Total Reading
        //out meterID: {reading, meterId, meterType, currentReading, totalReading,lastUpdate}
        KStream<String, MeterReadingCurrentReading> meterReadingCurrentReadingKStream =
                readingTypeMeterIDKStream.join(currentReadingKTable,
                        (readingMeterMappedType, currentInvoice) ->
                                MeterReadingCurrentReading.newBuilder()
                                        .setMeterID(readingMeterMappedType.getMeterID())
                                        .setCurrentReadingID(currentInvoice.getCurrentReadingID())
                                        .setCurrentReading(readingMeterMappedType.getReading())
                                        .setTotalReading(currentInvoice.getTotalReading())
                                        .setLastUpdate(new Date().toInstant())
                                        .build()

                ).peek((k, v) ->
                        System.out.println("MeterReadingCurrentReading --> " + " key: " + k + " value: " + v));

        //New Current Reading
        KStream<String, CurrentReading> newCurrentReadingKStream =
                meterReadingCurrentReadingKStream.mapValues(
                        (meterReadingCurrentReading) ->
                                GetNewCurrentReading.newCurrentReading(meterReadingCurrentReading));
        newCurrentReadingKStream
                .peek((k, v) -> System.out.println("New Invoice --> " + " key: " + k + " value: " + v))
                .to(AppConfigs.SINK_TOPIC_CURRENT_READING_NAME,
                        Produced.with(AppSerdes.String(), AppSerdes.CurrentReading()));

        KafkaStreams streams = new KafkaStreams(streamsBuilder.build(), props);

        logger.info("******** Starting Streams*****");
        streams.start();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            logger.info("Stopping Streams");
            streams.close();
        }));
    }

}
