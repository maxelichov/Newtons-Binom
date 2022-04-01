package EAPackage;

import LOGIC.Course;
import LOGIC.Schedule;
import org.uncommons.maths.random.Probability;
import org.uncommons.watchmaker.framework.operators.AbstractCrossover;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

//todo
public class ScheduleCrossover extends AbstractCrossover<Schedule> {
    public ScheduleCrossover(Probability probability) {
        super(31,probability);
    }


    @Override
    protected List<Schedule> mate(Schedule schedule1, Schedule schedule2, int crossover, Random random) {

        List<Schedule> children=new ArrayList<Schedule>();
        //4     2-2
        //5     2-3
        Schedule cloneSchedule1 = null, cloneSchedule2=null;
        try {
            cloneSchedule1 = (Schedule)schedule1.clone();
            cloneSchedule2 = (Schedule)schedule2.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        List<Course>listClone1=cloneSchedule1.getCourses();
        List<Course>listClone2=cloneSchedule2.getCourses();

        listClone2.add(listClone1.remove(0));
        listClone1.add(listClone2.remove(0));

        children.add(cloneSchedule1);
        children.add(cloneSchedule2);

        return children;
    }

    public void givenList_shouldReturnARandomElement() {
        List<Integer> givenList = Arrays.asList(1, 2, 3);
        Random rand = new Random();
        int randomElement = givenList.get(rand.nextInt(givenList.size()));
    }
}
