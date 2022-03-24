import java.util.ArrayList;
import java.util.List;

public class DaySchedule {
    private Days day;
    private List<RangeTime> listStartEnd;

    public DaySchedule(Days day){
        listStartEnd=new ArrayList<RangeTime>();
        this.day=day;
    }

    public void addRangeToDay(RangeTime range){
        listStartEnd.add(range);
    }

    public boolean isAvailabile(RangeTime rangeTime) {
        for(RangeTime curr : listStartEnd){
            if(!curr.overlaps(rangeTime)){
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "DaySchedule{" +
                "day=" + day +
                ", listStartEnd=" + listStartEnd +
                '}';
    }
}
