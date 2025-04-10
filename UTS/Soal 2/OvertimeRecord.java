import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

// Class to record overtime
class OvertimeRecord {
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private int hours;
    private boolean isWeekend;
    
    public OvertimeRecord(LocalDate date, LocalTime startTime, LocalTime endTime) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.hours = calculateHours();
        this.isWeekend = isWeekendDay(date);
    }
    
    private int calculateHours() {
        return (int) Duration.between(startTime, endTime).toHours();
    }
    
    private boolean isWeekendDay(LocalDate date) {
        DayOfWeek day = date.getDayOfWeek();
        return day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY;
    }
    
    public int getHours() {
        return hours;
    }
    
    public boolean isWeekend() {
        return isWeekend;
    }
}