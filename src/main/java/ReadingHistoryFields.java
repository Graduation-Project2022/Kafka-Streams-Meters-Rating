import cdr.types.ReadingHistory;
import cdr.types.ReadingMeterType;

import java.util.Date;

public class ReadingHistoryFields {
        public static ReadingHistory getReadingHistoryFields(ReadingMeterType readingMeterType){
            ReadingHistory readingHistory = new ReadingHistory();
            readingHistory.setReading(readingMeterType.getReading());
            readingHistory.setLastUpdate(new Date().toInstant());
            readingHistory.setMeterID(readingMeterType.getMeterID());
            return readingHistory;
        }
}
