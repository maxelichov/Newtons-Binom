package EAPackage;

import LOGIC.Course;
import LOGIC.Schedule;
import org.uncommons.maths.random.MersenneTwisterRNG;
import org.uncommons.maths.random.Probability;
import org.uncommons.watchmaker.framework.EvolutionaryOperator;
import org.uncommons.watchmaker.framework.GenerationalEvolutionEngine;
import org.uncommons.watchmaker.framework.operators.EvolutionPipeline;
import org.uncommons.watchmaker.framework.selection.RouletteWheelSelection;
import org.uncommons.watchmaker.framework.termination.ElapsedTime;
import org.uncommons.watchmaker.framework.termination.GenerationCount;
import java.util.ArrayList;
import java.util.List;




public class EAManager {





public void initEngine(List<Course> courses) {


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

          generateGeneration(engine);

}

public void generateGeneration(GenerationalEvolutionEngine<Schedule> engine) {



    Schedule winningSchedule = engine.evolve(10, // individuals per generation
            0, // Elites per generation
            new GenerationCount(10));

        // Go!
    winningSchedule = engine.evolve(10, // individuals per generation
                0, // Elites per generation
                new ElapsedTime(100));




    winningSchedule.printSchedule();
         // Display the health of each generation
    //engine.addEvolutionObserver(new EAPackage.ScheduleObserver());


    // Go!





}





}
