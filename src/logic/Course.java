package logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        this.groups = groups;
        this.testA = testA;
        this.testB = testB;
        this.isMandatory=isMandatory;

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
                RangeTime rangeTime1 = lesson1.getRangeTime();
                RangeTime rangeTime2 = lesson2.getRangeTime();
                if(rangeTime1.overlaps(rangeTime2)){
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
        return "LOGIC.Course{" +
                "courseName='" + courseName + '\'' +
                ", groups=" + groups +
                '}';
    }

    public Boolean isSameName(String courseName){
        return this.courseName.equals(courseName);
    }
}
