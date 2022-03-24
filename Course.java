import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Course implements Cloneable{
    private String courseName;
    private double credits;
    private int difficulty;
    private List<Group> groups = new ArrayList<Group>();
    private Date testA;
    private Date testB;
    private Boolean isMandatory;

    public Course(String courseName, float credits, int difficulty, List groups, Date testA, Date testB, Boolean isMandatory) {
        this.courseName = courseName;
        this.credits = credits;
        this.difficulty = difficulty;
        this.groups = groups;
        this.testA = testA;
        this.testB = testB;
        this.isMandatory=isMandatory;
    }

    public Course(String courseName, double credits, int difficulty, Date testA, Date testB, Boolean mandatory) {
        this.courseName = courseName;
        this.credits = credits;
        this.difficulty = difficulty;
        this.groups = groups;
        this.testA = testA;
        this.testB = testB;
        this.isMandatory=isMandatory;

        groups=new ArrayList<Group>();
    }


    @Override
    public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }

    public List<Group> getGroups(){
        return groups;
    }

    public String getCourseName() {
        return courseName;
    }

    public double getCredits() {
        return credits;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public Date getTestA() {
        return testA;
    }

    public Date getTestB() {
        return testB;
    }

    public Boolean getMandatory() {
        return isMandatory;
    }

    public void addGroup(Group newGroup){
        //todo: check if newGroup already exist in groups
        groups.add(newGroup);
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", groups=" + groups +
                '}';
    }
}
