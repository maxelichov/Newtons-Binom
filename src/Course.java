import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Course implements Cloneable{
    String courseName;
    double credits;

    /*
    float difficulty;
    List<Group> groups = new ArrayList<Group>();
    Date testA;
    Date testB;

    public Course(String courseName, float credits, float difficulty, List groups, Date testA, Date testB) {
        this.courseName = courseName;
        this.credits = credits;
        this.difficulty = difficulty;
        this.groups = groups;
        this.testA = testA;
        this.testB = testB;
    }

     */



    @Override
    public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }


    public double getCredits() {
        return credits;
    }


    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", credits=" + credits +
                '}';
    }

    public Course(String s, int i) {
        this.courseName = s;
        this.credits=i;
    }

    public void setCredits(int i) {
        credits=i;
    }
}
