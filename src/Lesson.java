import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;


public class Lesson implements Cloneable{
    private DayOfWeek day;
    private LocalTime startTime;// = LocalTime.of(12, 20);
    private LocalTime endTime;// = LocalTime.of(12, 20);


    public Lesson(DayOfWeek day, LocalTime startTime, LocalTime endTime){
        this.day=day;
        this.startTime=startTime;
        this.endTime=endTime;

    }


    @Override
    public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }


    @Override
    public String toString() {
        return "Lesson{" +
                "day=" + day +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
