package EA;

import logic.Course;
import logic.Group;
import logic.Schedule;
import org.uncommons.maths.random.Probability;
import org.uncommons.watchmaker.framework.operators.AbstractCrossover;

import java.util.*;

//todo
public class ScheduleCrossover extends AbstractCrossover<Schedule> {
    private final List<Course> mustHaveCourses;

    public ScheduleCrossover(Probability probability, List<Course>mustHaveCourses) {
        super(31,probability);
        this.mustHaveCourses=mustHaveCourses;
    }


    @Override
    protected List<Schedule> mate(Schedule schedule1, Schedule schedule2, int crossover, Random random) {
        List<Schedule> children;


        List<Course> mustHaveCoursesSchedule1=schedule1.removeCourses(mustHaveCourses);
        List<Course> mustHaveCoursesSchedule2=schedule2.removeCourses(mustHaveCourses);





        switch (random.nextInt(2)) {
            case 0: {
                children =  crossOverStrategy1(schedule1,schedule2,random);
                break;
            }
            case 1: {
                children = crossOverStrategy2(schedule1, schedule2, random);
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + random.nextInt(2));
        }


        schedule1.addCoursess(mustHaveCoursesSchedule1);
        schedule2.addCoursess(mustHaveCoursesSchedule2);




        children.get(0).addCoursess(mustHaveCoursesSchedule1);
        children.get(1).addCoursess(mustHaveCoursesSchedule2);



        return children;
    }



    //this method take all parent's courses randomize divides for 2 children such that:
    //The number of courses of child 1 is the same as the number of courses of parent 1
    //The number of courses of child 2 is the same as the number of courses of parent 2
    private List<Schedule> crossOverStrategy2(Schedule schedule1, Schedule schedule2, Random random) {
        ArrayList<Schedule> children = new ArrayList<Schedule>();

        List<Course> allCourses=new ArrayList<Course>();
        allCourses.addAll(schedule1.getCourses());
        allCourses.addAll(schedule2.getCourses());

        List<Course> child1Courses=new ArrayList<Course>();

        for(int i = 0; i< schedule1.getCourses().size(); i++){
            int randIndex = random.nextInt(allCourses.size());
            child1Courses.add(allCourses.get(randIndex));
            allCourses.remove(randIndex);
        }

        children.add(new Schedule(child1Courses));
        children.add(new Schedule(allCourses));

        return children;
    }

    //this method take all parent's courses and randomize give half foreach child
    private List<Schedule> crossOverStrategy1(Schedule schedule1, Schedule schedule2, Random random) {
        List<Schedule> children = new ArrayList<Schedule>();

        List<Course> allCourses=new ArrayList<Course>();
        allCourses.addAll(schedule1.getCourses());
        allCourses.addAll(schedule2.getCourses());

        List<Course> child1Courses=new ArrayList<Course>();
        List<Course> child2Courses=new ArrayList<Course>();
        int allCoursesSize=allCourses.size();

        for(int i=0; i<allCoursesSize; i++){
            int randIndex = random.nextInt(allCourses.size());
            Course currCourse = allCourses.get(randIndex);
            allCourses.remove(randIndex);
            if(i%2==0){
                child1Courses.add(currCourse);
            }else{
                child2Courses.add(currCourse);
            }
        }
        children.add(new Schedule(child1Courses));
        children.add(new Schedule(child2Courses));

        return children;
    }

    public void givenList_shouldReturnARandomElement() {
        List<Integer> givenList = Arrays.asList(1, 2, 3);
        Random rand = new Random();
        int randomElement = givenList.get(rand.nextInt(givenList.size()));
    }
}
