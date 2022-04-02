package EA;

import logic.Course;
import logic.Schedule;
import org.uncommons.watchmaker.framework.CandidateFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;




public class ScheduleFactory implements CandidateFactory {

    private final List<Course> courses;

    public ScheduleFactory(List<Course> courses) {
        this.courses=courses;
    }

    @Override
    public List<Schedule> generateInitialPopulation(int populationSize, Random random) {

        List<Schedule> res = new ArrayList<Schedule>();

        for(int i=0;i<populationSize;i++){
            List<Course> coursesList=new ArrayList<Course>();
            for(int j=0;j<6;j++){
                Course temp=courses.get(random.nextInt(courses.size()));
                if(!coursesList.contains(temp)){
                    coursesList.add(temp);
                }
            }
            res.add(new Schedule(coursesList));
        }
        return res;
    }

    @Override
    public List generateInitialPopulation(int populationSize, Collection collection, Random random) {
        List<Schedule>res=new ArrayList<Schedule>();

        for(int i=0;i<populationSize;i++){
            List<Course> coursesList=new ArrayList<Course>();
            for(int j=0;j<6;j++){
                Course temp=courses.get(random.nextInt(courses.size()));
                if(!coursesList.contains(temp)){
                    coursesList.add(temp);
                }
            }
            res.add(new Schedule(coursesList));
        }
        return res;
    }

    @Override
    public Object generateRandomCandidate(Random random) {
        System.out.println("generateRandomCandidate");
        return null;
    }
}
