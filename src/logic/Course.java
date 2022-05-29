package logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Course implements Cloneable{



    private String courseName;
    private double credits;
    private int difficulty;
    private List<Group> groups;
    private Date testA;
    private Date testB;
    private Boolean isMandatory;



    public Course()
    {

        groups = new ArrayList<Group>();
    }

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
        this.testA = testA;
        this.testB = testB;
        this.isMandatory=mandatory;

        groups=new ArrayList<Group>();
    }





    @Override
    public Object clone()throws CloneNotSupportedException{


        Course clonedCourse = new Course();
        clonedCourse = (Course)super.clone();
        List<Group> clonedGroupList = new ArrayList<Group>(this.groups.size());

        for (Group group: groups) {

            clonedGroupList.add((Group) group.clone());

        }

        clonedCourse.setGroups(clonedGroupList);

        return clonedCourse;
     //  return super.clone();
    }

    public void setGroups(List<Group> groupList) {

        this.groups = groupList;

    }





    public boolean compareLessonsInCourses(Course course)//if there have range time overLaps with two lessons from different courses
    {

        List<Lesson> lessons = getAllLessons(this);
        List<Lesson> otherLesson = getAllLessons(course);


        for(Lesson lesson1:lessons){
            for(Lesson lesson2:otherLesson){
                TimeRange timeRange1 = lesson1.getRangeTime();
                TimeRange timeRange2 = lesson2.getRangeTime();
                if(timeRange1.overlaps(timeRange2)){
                    return true;
                }
            }
        }

        return false;
    }

    private List<Lesson> getAllLessons(Course course)
    {
        List<Lesson> res=new ArrayList<Lesson>();
        for(Group group: course.getGroups())
        {


            for (Lesson lesson: group.getLessons())
            {
                res.add(lesson);

            }


        }
        return res;
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
        return "LOGIC.Course{" + "\n"+
                "courseName='" + courseName + '\'' + "\n" +
                ", groups=" + groups +
                '}';
    }

    public Boolean isSameName(String courseName){
        return this.courseName.equals(courseName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Double.compare(course.credits, credits) == 0 && difficulty == course.difficulty && courseName.equals(course.courseName) && Objects.equals(testA, course.testA) && Objects.equals(testB, course.testB) && isMandatory.equals(course.isMandatory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseName, credits, difficulty, testA, testB, isMandatory);
    }
}
