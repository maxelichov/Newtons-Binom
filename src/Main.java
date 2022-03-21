import org.uncommons.maths.random.MersenneTwisterRNG;
import org.uncommons.maths.random.Probability;
import org.uncommons.watchmaker.framework.EvolutionEngine;
import org.uncommons.watchmaker.framework.EvolutionaryOperator;
import org.uncommons.watchmaker.framework.GenerationalEvolutionEngine;
import org.uncommons.watchmaker.framework.SelectionStrategy;
import org.uncommons.watchmaker.framework.operators.EvolutionPipeline;
import org.uncommons.watchmaker.framework.selection.RouletteWheelSelection;
import org.uncommons.watchmaker.framework.termination.ElapsedTime;
import org.uncommons.watchmaker.framework.termination.GenerationCount;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

// Factory for random 11-character Strings.
	// write your code here
        List<Course> courses=new ArrayList<>();
        for(int i=0;i<10;i++){
            courses.add(new Course("A"+i,i));
        }

        ArrayList<EvolutionaryOperator<Schedule>> operators = new ArrayList<EvolutionaryOperator<Schedule>>();
        operators.add(new ScheduleMutation(new Probability(.001d), new Probability(.005d)));
        operators.add(new ScheduleCrossover(new Probability(.9d)));
        EvolutionaryOperator<Schedule> pipeline = new EvolutionPipeline<Schedule>(operators);




        GenerationalEvolutionEngine<Schedule> engine = new GenerationalEvolutionEngine<Schedule>(
                new ScheduleFactory(courses),
                pipeline,
                new ScheduleFitnessFunction(),
                new RouletteWheelSelection(),
                new MersenneTwisterRNG());


        engine.setSingleThreaded(false);

        // Display the health of each generation
        //engine.addEvolutionObserver(new ScheduleObserver());


        // Go!
        Schedule winningStrat = engine.evolve(10, // individuals per generation
                0, // Elites per generation
                new GenerationCount(10));
        /*
        // Go!
        Schedule winningStrat = engine.evolve(10, // individuals per generation
                0, // Elites per generation
                new ElapsedTime(100));

         */

        winningStrat.printStrategy();

    }
}
