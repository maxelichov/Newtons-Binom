import java.util.ArrayList;
import java.util.List;

public class Schedule implements Cloneable{
    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    List<Course> courses=new ArrayList<Course>();

    public Schedule(List<Course> courses){
        this.courses=courses;
    }

    @Override
    public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }


    @Override
    public String toString() {
        return "Schedule{" +
                "courses=" + courses +
                '}';
    }

    public void printStrategy() {
        System.out.println(this.toString());
    }
}
