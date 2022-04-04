package EA;

import logic.Course;
import logic.Schedule;
import org.uncommons.maths.random.MersenneTwisterRNG;
import org.uncommons.maths.random.Probability;
import org.uncommons.watchmaker.framework.EvolutionaryOperator;
import org.uncommons.watchmaker.framework.GenerationalEvolutionEngine;
import org.uncommons.watchmaker.framework.operators.EvolutionPipeline;
import org.uncommons.watchmaker.framework.selection.RouletteWheelSelection;
import org.uncommons.watchmaker.framework.termination.GenerationCount;
import java.util.ArrayList;
import java.util.List;




public class EAManager
{

    private List<Course> courses;
    private ArrayList<EvolutionaryOperator<Schedule>> operators = new ArrayList<EvolutionaryOperator<Schedule>>();
    private EvolutionaryOperator<Schedule> pipeline;
    private GenerationalEvolutionEngine<Schedule> engine;
    private ScheduleMutation scheduleMutation;
    private ScheduleCrossover scheduleCrossover;



    public EAManager(List<Course> filteredCourses)
    {
        courses=new ArrayList<Course>(filteredCourses.size());
        cloneAndSetCourses(filteredCourses);
        scheduleMutation = new ScheduleMutation(new Probability(.001d), new Probability(.005d),courses);
        scheduleCrossover = new ScheduleCrossover(new Probability(.9d));
    }



    public void cloneAndSetCourses(List<Course> coursesToClone)
    {


        try
        {
            for (Course course: coursesToClone)
            {
                courses.add((Course)course.clone());
            }
        }
        catch (CloneNotSupportedException e)
        {
            e.printStackTrace();
        }


    }

    public void initOperators()
    {

        //TODO: implement crossover and mutation

        operators.add(scheduleMutation);
        operators.add(scheduleCrossover);
        pipeline = new EvolutionPipeline<Schedule>(operators);


    }


    public void runEngine(List<Course> courses)
    {


        initOperators();
        engine = new GenerationalEvolutionEngine<Schedule>(
                new ScheduleFactory(courses),
                pipeline,
                new ScheduleFitnessFunction(),
                new RouletteWheelSelection(),
                new MersenneTwisterRNG());

        engine.setSingleThreaded(false);

        generateGeneration(engine);

    }


    public void generateGeneration(GenerationalEvolutionEngine<Schedule> engine)
    {

        Schedule winningSchedule;

        winningSchedule = engine.evolve(10, // individuals per generation
                0, // Elites per generation
                new GenerationCount(10));

            // Go!
    //    winningSchedule = engine.evolve(4, // individuals per generation
    //                0, // Elites per generation
    //                new ElapsedTime(100));


        winningSchedule.printSchedule();
             // Display the health of each generation
        //engine.addEvolutionObserver(new EAPackage.ScheduleObserver());


        // Go!

    }



}