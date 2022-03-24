import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Logic {
    private Prefernces pref;


    public List<Course> filterCourses(Prefernces pref){
        List<Course>res=new ArrayList<Course>();
        for(Course currCourse : pref.getPrefCourse()){
            Course newCourse=new Course(currCourse.getCourseName(),currCourse.getCredits(),currCourse.getDifficulty(),currCourse.getTestA(),currCourse.getTestB(),currCourse.getMandatory());
            Boolean flag=false;
            for(Group currGroup : currCourse.getGroups()){
                Group newGroup=new Group();
                for(Lesson currLesson : currGroup.getLessons()){
                    if(pref.getUnavailablityWeekSchedule().isAvailabile(currLesson.getDay(),currLesson.getRangeTime())){
                        newGroup.addLesson(currLesson);
                        flag=true;
                    }else{
                        System.out.println("dff");
                        break;
                    }
                }

                if(flag){
                    newCourse.addGroup(newGroup);
                }
            }

            if(flag){
                res.add(newCourse);
            }
        }

        return res;
    }
}
