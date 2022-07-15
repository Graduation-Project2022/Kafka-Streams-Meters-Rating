package serde;


import cdr.types.*;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import org.apache.kafka.common.serialization.Serdes;

import java.util.HashMap;
import java.util.Map;

public class AppSerdes extends Serdes {

    private static final String  SCHEMA_REGISTRY_URL = "http://localhost:8081";
//private static final String  SCHEMA_REGISTRY_URL = "http://192.168.73.162:8081";
    public static SpecificAvroSerde<Reading> Reading() {
        SpecificAvroSerde<Reading> serde = new SpecificAvroSerde<>();
        Map<String, Object> serdeConfigs = new HashMap<>();
        serdeConfigs.put("schema.registry.url", SCHEMA_REGISTRY_URL);
        serde.configure(serdeConfigs, false);

        return serde;
    }

    public static SpecificAvroSerde<Meter> Meter() {
        SpecificAvroSerde<Meter> serde = new SpecificAvroSerde<>();

        Map<String, Object> serdeConfigs = new HashMap<>();
        serdeConfigs.put("schema.registry.url", SCHEMA_REGISTRY_URL);
        serde.configure(serdeConfigs, false);

        return serde;
    }

    public static SpecificAvroSerde<ReadingMeterType> ReadingMeterType() {
        SpecificAvroSerde<ReadingMeterType> serde = new SpecificAvroSerde<>();

        Map<String, Object> serdeConfigs = new HashMap<>();
        serdeConfigs.put("schema.registry.url", SCHEMA_REGISTRY_URL);
        serde.configure(serdeConfigs, false);

        return serde;
    }

    public static SpecificAvroSerde<CurrentReading> CurrentReading() {
        SpecificAvroSerde<CurrentReading> serde = new SpecificAvroSerde<>();

        Map<String, Object> serdeConfigs = new HashMap<>();
        serdeConfigs.put("schema.registry.url", SCHEMA_REGISTRY_URL);
        serde.configure(serdeConfigs, false);

        return serde;
    }

    public static SpecificAvroSerde<MeterReadingCurrentReading> MeterReadingCurrentReading() {
        SpecificAvroSerde<MeterReadingCurrentReading> serde = new SpecificAvroSerde<>();

        Map<String, Object> serdeConfigs = new HashMap<>();
        serdeConfigs.put("schema.registry.url", SCHEMA_REGISTRY_URL);
        serde.configure(serdeConfigs, false);

        return serde;
    }

    public static SpecificAvroSerde<ReadingHistory> ReadingHistory() {
        SpecificAvroSerde<ReadingHistory> serde = new SpecificAvroSerde<>();

        Map<String, Object> serdeConfigs = new HashMap<>();
        serdeConfigs.put("schema.registry.url", SCHEMA_REGISTRY_URL);
        serde.configure(serdeConfigs, false);

        return serde;
    }

}
