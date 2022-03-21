import org.uncommons.watchmaker.framework.FitnessEvaluator;

import java.util.List;

public class ScheduleFitnessFunction implements FitnessEvaluator<Schedule> {
    @Override
    public double getFitness(Schedule candidate, List<? extends Schedule> list) {
        double res=0;
        List<Course>courses=candidate.getCourses();
        for(Course currCourse:courses){
            res+=currCourse.getCredits();
        }
        return res;
    }

    @Override
    public boolean isNatural() {
        return false;
    }
}
