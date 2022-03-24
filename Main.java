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

import java.sql.Array;
import java.text.DateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {

// Factory for random 11-character Strings.
        // write your code here

        WeekSchedule WeekSchedule= new WeekSchedule();
        WeekSchedule.insertNewRange(Days.FRIDAY, new RangeTime(LocalTime.of(16, 00),LocalTime.of(00, 00)));
        WeekSchedule.insertNewRange(Days.SATURDAY, new RangeTime(LocalTime.of(00, 00),LocalTime.of(17, 00)));
        WeekSchedule.insertNewRange(Days.WEDNESDAY, new RangeTime(LocalTime.of(7, 00),LocalTime.of(23, 59)));

        System.out.println(WeekSchedule);




        List<Course> courseList= new ArrayList<Course>();

        /*
        List<Lesson> javaLList=new ArrayList<Lesson>();
        javaLList.add(new Lesson(Days.SUNDAY,new RangeTime(LocalTime.of(16,00),LocalTime.of(20,00))));
        Group javaG=new Group(javaLList);
        List<Group> javaGList = new ArrayList<Group>();
        javaGList.add(javaG);
        Course java=new Course("java",4,10,javaGList,null,null,false);
        courseList.add(java);


         */


        List<Lesson> computabilityLList1=new ArrayList<Lesson>();
        computabilityLList1.add(new Lesson(Days.WEDNESDAY,new RangeTime(LocalTime.of(16,00),LocalTime.of(18,00))));
        computabilityLList1.add(new Lesson(Days.THURSDAY,new RangeTime(LocalTime.of(16,00),LocalTime.of(19,00))));
        Group computabilityG1=new Group(computabilityLList1);
        List<Group> computabilityGList = new ArrayList<Group>();
        computabilityGList.add(computabilityG1);

        List<Lesson> computabilityLList2=new ArrayList<Lesson>();
        computabilityLList2.add(new Lesson(Days.SUNDAY,new RangeTime(LocalTime.of(16,00),LocalTime.of(18,00))));
        computabilityLList2.add(new Lesson(Days.THURSDAY,new RangeTime(LocalTime.of(16,00),LocalTime.of(19,00))));
        Group computabilityG2=new Group(computabilityLList2);
        computabilityGList.add(computabilityG2);

        Course computability=new Course("computability",4,7,computabilityGList, new Date(2022,7,13) ,new Date(2022,8,14),true);
        courseList.add(computability);



        List<Lesson> osLList=new ArrayList<Lesson>();
        osLList.add(new Lesson(Days.SUNDAY,new RangeTime(LocalTime.of(12,00),LocalTime.of(14,30))));
        osLList.add(new Lesson(Days.THURSDAY,new RangeTime(LocalTime.of(13,00),LocalTime.of(15,00))));
        Group osG=new Group(osLList);//todo: more groups
        List<Group> osGList = new ArrayList<Group>();
        osGList.add(osG);
        Course os=new Course("operation system",4,8,osGList, new Date(2022,7,27) ,new Date(2022,8,24),true);
        courseList.add(os);


        Prefernces pref=new Prefernces(10,4,courseList,30,WeekSchedule);

        Logic logic=new Logic();
        List<Course>validCourses = logic.filterCourses(pref);

        System.out.println(validCourses);

/*
        List<Course> courses=new ArrayList<>();
        for(int i=0;i<10;i++){
            //courses.add(new Course("A"+i,i));
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

        /*
        winningStrat.printStrategy();


         */


    }
}
