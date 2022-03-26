import java.util.ArrayList;
import java.util.List;

public class Schedule implements Cloneable{



   private   List<Course> courses = new ArrayList<Course>();


    public Schedule(List<Course> courses){
        this.courses=courses;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }


    public void Schdeule() {}

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


    @Override
    public String toString() {
        return "Schedule{" +
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


    public void printStrategy() {
        System.out.println(this.toString());
    }

    public void removeCourse(String courseName) {

        //TODO: if getCourseByName returnes null?

        courses.remove(getCourseByName(courseName));

    }
}
