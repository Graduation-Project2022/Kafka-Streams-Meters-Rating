import cdr.types.CurrentReading;
import cdr.types.MeterReadingCurrentReading;


import java.util.Date;

public class GetNewCurrentReading {


    public static CurrentReading newCurrentReading(MeterReadingCurrentReading meterReadingCurrentReading) {
        float newTotalReading = meterReadingCurrentReading.getTotalReading() + meterReadingCurrentReading.getCurrentReading();
        CurrentReading currentReading = new CurrentReading();
        currentReading.setCurrentReadingID(meterReadingCurrentReading.getCurrentReadingID());
        currentReading.setMeterID(meterReadingCurrentReading.getMeterID());
        currentReading.setTotalReading(newTotalReading);
        currentReading.setLastUpdate(new Date().toInstant());
        // This will be replaced with plans calculation
        return currentReading;
    }
}
