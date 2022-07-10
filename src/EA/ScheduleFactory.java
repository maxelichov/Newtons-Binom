package EA;

import logic.Course;
import logic.Group;
import logic.Schedule;
import org.uncommons.watchmaker.framework.CandidateFactory;

import java.util.*;


public class ScheduleFactory implements CandidateFactory {

    private final List<Course> courses;
    private final List<Course> mustHaveCourses;

    public ScheduleFactory(List<Course> courses, List<Course> mustHaveCourses)
    {
        this.courses=courses;
        this.mustHaveCourses=mustHaveCourses;
    }



    @Override
    public List<Schedule> generateInitialPopulation(int populationSize, Random random) {

        List<Schedule> res = new ArrayList<Schedule>();



        for(int i=0;i<populationSize;i++){
            List<Course> coursesList = new ArrayList<Course>();


            handleMustHaveCourses(coursesList);

            handleRandomCourses(random, coursesList);

            res.add(new Schedule(coursesList));

        }
        return res;
    }

    private void handleRandomCourses(Random random, List<Course> coursesList) {
        for(int j=0 ; j<4 ; j++){
            Course temp=courses.get(random.nextInt(courses.size()));
            Course newCourse = cloneCourseWithOnlyOneGroup(temp);
            if(newCourse != null){
                if(!coursesList.contains(newCourse)){
                    coursesList.add(newCourse);
                }
            }else {
                //todo throw exception
                System.out.println("Something Went wrong!");
            }
        }
    }

    private void handleMustHaveCourses(List<Course> coursesList) {
        for(Course mustHaveCourse : mustHaveCourses){
            Course newCourse = cloneCourseWithOnlyOneGroup(mustHaveCourse);
            if(newCourse != null){
                coursesList.add(newCourse);
            }else{
                //todo throw exception
                System.out.println("Something Went wrong!");
            }
        }
    }


    private Course cloneCourseWithOnlyOneGroup(Course course) {

        //get all courses that wasn't in
        Random random = new Random();
        int randIndexForGroup = random.nextInt(course.getGroups().size());
        Course newCourse = null;
            try {
                newCourse = (Course) course.clone();
                List<Group> newGroup = Arrays.asList(newCourse.getGroups().get(randIndexForGroup));
                newCourse.setGroups(newGroup);
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        return newCourse;

    }


    @Override
    public List<Schedule> generateInitialPopulation(int populationSize, Collection collection, Random random) {
        return generateInitialPopulation(populationSize, random);
    }

    @Override
    public Object generateRandomCandidate(Random random) {
        System.out.println("generateRandomCandidate");
        return null;
    }
}
