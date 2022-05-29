package logic;

import java.util.ArrayList;
import java.util.List;

public class DaySchedule
{
    private Days day;
    private List<TimeRange> listStartEnd;

    public DaySchedule(Days day){
        listStartEnd=new ArrayList<TimeRange>();
        this.day=day;
    }

    public void addRangeToDay(TimeRange range){
        listStartEnd.add(range);
    }

    public boolean isAvailabile(TimeRange timeRange)
    {
        for(TimeRange curr : listStartEnd){
            if(!curr.overlaps(timeRange)){
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "LOGIC.DaySchedule{" +
                "day=" + day +
                ", listStartEnd=" + listStartEnd +
                '}';
    }
}
