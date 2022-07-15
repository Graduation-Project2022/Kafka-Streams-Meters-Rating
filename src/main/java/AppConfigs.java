public abstract class AppConfigs {
    public static final String  APP_NAME = "MeterRatingAp";
    //public static final String  BROKERS = "localhost:9092,localhost:9093,localhost:9094";
    public static final String  BROKERS = "192.168.73.162:9092,192.168.73.162:9093,192.168.73.162:9094";
    public static final String  TOPIC_NIFI_READING_NAME = "nifi-reading";
    public static final String  REPARTIONING_TOPIC_METERID_NAME = "reading-meter-type-with-meterID-key-topic";
    public static final String  SINK_TOPIC_CURRENT_READING_NAME = "sink-topic-currentreading";
    public static final String  SINK_TOPIC_READING_HISTORY_NAME = "sink-topic-readinghistory";
    
    //Created By Default By KafkaConnect Source
    public static final String  SOURCE_TOPIC_METER_NAME =  "source2-topic-meter";
    public static final String  SOURCE_TOPIC_CURRENT_READING_NAME = "source-topic-currentreading";

}
