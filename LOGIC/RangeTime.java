package LOGIC;

import java.time.LocalTime;
//todo: what if end time<start time
public class RangeTime {
    private LocalTime startTime;// = LocalTime.of(12, 20);
    private LocalTime endTime;// = LocalTime.of(12, 20);

    public RangeTime(LocalTime startTime, LocalTime endTime){
        this.startTime=startTime;
        this.endTime=endTime;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public boolean overlaps(RangeTime rangeTime) {
        if(rangeTime.endTime.isBefore(startTime) || rangeTime.startTime.isAfter(endTime)){
            return true;
        }
        return false;
    }


    @Override
    public String toString() {
        return "LOGIC.RangeTime{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
