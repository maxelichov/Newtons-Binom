import org.uncommons.maths.random.Probability;
import org.uncommons.watchmaker.framework.EvolutionaryOperator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


//todo

public class ScheduleMutation implements EvolutionaryOperator<Schedule> {
    public ScheduleMutation(Probability probability, Probability probability1) {
        System.out.println("    public ScheduleMutation(Probability probability, Probability probability1) {");
    }


    // TODO: all possible mutations:
    //1. change group
    //2. change course
    //3. add course
    //4. drop course
    //5.




    @Override
    public List<Schedule> apply(List<Schedule> list, Random random) {

        //TODO:It is important to note that this method operates on the list of candidates returned by the selection
        // strategy and not on the current population
        // . Each entry in the list (not each individual - the list may contain the same individual more than once) must be operated on exactly once.

        System.out.println("    public List<Schedule> apply(List<Schedule> list, Random random) {");

        List<Schedule> tmp = new ArrayList<Schedule>(list.size());


//        List<Dog> clone = new ArrayList<Dog>(list.size());
//        for (Dog item : list) clone.add(item.clone());

        for (Schedule clonedSchedule: list) {

            try {


                tmp.add((Schedule)clonedSchedule.clone());

            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }


        }


        Schedule fromTmp = tmp.get(0);
        Schedule fromList = list.get(0);



        System.out.println(fromTmp);
        System.out.println(fromList);


        System.out.println("going to change fromTmp");

        fromTmp.removeCourse("operation system");



        System.out.println(fromTmp);
        System.out.println(fromList);




        return list;
    }
}



