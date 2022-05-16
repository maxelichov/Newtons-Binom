package logic;

import java.util.ArrayList;
import java.util.List;

public class Schedule implements Cloneable{



   private List<Course> courses = new ArrayList<Course>();
   private double examsfitnessScore = 0;
   private double intensityFitnessScore = 0;
   private double finalFitnessScore = 0;
   private double finalFitnessCreditPoints = 0;
   private double finalLessonsOverlapingFitnessPoints = 0;
   private double finalRepeatingCoursesFitneesScore = 0;


    public Schedule(List<Course> courses){
        this.courses=courses;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public Object clone()throws CloneNotSupportedException{


      Schedule clonedSchedule  = (Schedule)super.clone();

      List<Course> clonedCoursesList = new ArrayList<Course>(courses.size());

      for (Course course: courses){

          clonedCoursesList.add((Course) course.clone());

      }


          clonedSchedule.setCourses(clonedCoursesList);

      return clonedSchedule;




    }


    public void setExamsfitnessScore(double fitnessScore)
    {
        this.examsfitnessScore = fitnessScore;
    }


    @Override
    public String toString() {
        return "LOGIC.Schedule{" +
                "courses=" + courses +
                '}';
    }

    public Course getCourseByName(String courseName) {


        for (Course curr: courses) {

            if(curr.getCourseName().equals(courseName)){
                return curr;
            }


        }

        return null;
    }


    public void printSchedule() {
        System.out.println(this.toString());
    }

    public void removeCourse(String courseName) {
        removeCourse(getCourseByName(courseName));

    }
    public void removeCourse(Course course) {
        courses.remove(course);

    }


    public void addCourseToSchedule(Course courseToAdd)
    {

        courses.add(courseToAdd);


    }


    public void setIntensityFitnessScore(double intestinyFitnessScore)
    {

        this.intensityFitnessScore = intestinyFitnessScore;
    }

    public void setFinalFitnessScore(double finaFitness)
    {

        this.finalFitnessScore = finaFitness;
    }

    public void setPointFitnessScore(double creditPointFitnessScore)
    {
        this.finalFitnessCreditPoints = creditPointFitnessScore;

    }

    public void setLessonsOverlapingFitnessScore(double overlapTimeLessonsFitnessScore)
    {
        this.finalLessonsOverlapingFitnessPoints = overlapTimeLessonsFitnessScore;
    }

    public void setRepeatingCoursesFitnessScore(double repeatingCoursesFitneesScore)
    {
        this.finalRepeatingCoursesFitneesScore = repeatingCoursesFitneesScore;

    }
}
