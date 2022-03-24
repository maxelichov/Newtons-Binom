import org.uncommons.maths.random.Probability;
import org.uncommons.watchmaker.framework.EvolutionaryOperator;

import java.util.List;
import java.util.Random;
//todo
public class ScheduleMutation implements EvolutionaryOperator<Schedule> {
    public ScheduleMutation(Probability probability, Probability probability1) {
        System.out.println("    public ScheduleMutation(Probability probability, Probability probability1) {");
    }

    @Override
    public List<Schedule> apply(List<Schedule> list, Random random) {
        System.out.println("    public List<Schedule> apply(List<Schedule> list, Random random) {");
        for(int i=0;i<list.size();i++){
            List<Course> temp=list.get(i).getCourses();

        }
        return list;
    }
}
