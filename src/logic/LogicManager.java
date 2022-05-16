package logic;

import EA.EAManager;

import java.util.ArrayList;
import java.util.List;


public class LogicManager
{


    private EAManager EAEngineManager;
    private List<Course> filteredCourses;
    private Preferences pref;


    public void filterCourses(Preferences pref)
    {
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

        setFilteredCourses(res);
        EAEngineManager  = new EAManager(res, pref);

    }


    public void setFilteredCourses(List<Course> courses)
    {


        filteredCourses = courses;


    }

    public void startEngine()
    {

        EAEngineManager.runEngine(filteredCourses);

    }

    public List<Course> getValidCourses()
    {

            return this.filteredCourses;

    }



}
