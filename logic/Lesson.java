package logic;

public class Lesson implements Cloneable{
    private Days day;
    private RangeTime rangeTime;


    public Lesson(Days day, RangeTime rangeTime){
        this.day=day;
        this.rangeTime=rangeTime;
    }


    @Override
    public Object clone()throws CloneNotSupportedException{




        Lesson clonedLesson = (Lesson)super.clone();

        return clonedLesson;
      //  return super.clone();
    }


    @Override
    public String toString() {
        return "LOGIC.Lesson{" +
                "day=" + day +
                ", rangeTime=" + rangeTime +
                '}';
    }

    public Days getDay() {
        return day;
    }

    public RangeTime getRangeTime() {
        return rangeTime;
    }
}
