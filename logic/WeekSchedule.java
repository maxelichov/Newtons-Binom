package logic;

import java.util.ArrayList;
import java.util.List;

public class WeekSchedule
{
    private List<DaySchedule> weekSchedule;

    public WeekSchedule()
    {
        weekSchedule=new ArrayList<DaySchedule>(7);
        for(int i=0 ; i<7 ; i++){
            weekSchedule.add(new DaySchedule(Days.getEnum(i)));
        }
    }

    public void insertNewRange(Days day, RangeTime range){
        weekSchedule.get(day.getValue()).addRangeToDay(range);
    }

    public boolean isAvailabile(Days day, RangeTime rangeTime)
    {
        return weekSchedule.get(day.getValue()).isAvailabile(rangeTime);
    }


    @Override
    public String toString()
    {
        String res="LOGIC.WeekSchedule\n";
        for(DaySchedule day:weekSchedule) {
            res+=day.toString()+"\n";
        }
        return res;
    }
}
