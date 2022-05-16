package EA;

import logic.Course;
import logic.Preferences;
import logic.Schedule;
import org.uncommons.watchmaker.framework.FitnessEvaluator;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class ScheduleFitnessFunction implements FitnessEvaluator<Schedule>
{
    Preferences preferences;

    public ScheduleFitnessFunction(Preferences preferences)
    {
        this.preferences = preferences;
    }

    @Override
    public double getFitness(Schedule candidate, List<? extends Schedule> list)
    {
        double finalFitnessScore = 100;

        double testsSpacingFitnessScore = 0;
        double intestinyFitnessScore = 0;
        double creditPointFitnessScore = 0;
        double repeatingCoursesFitneesScore = 0;

        List<Date> ATests = insertSortAtest(candidate.getCourses());
        List<Date> BTests = insertSortBtest(candidate.getCourses());
        List<Date> AAndBTests = new ArrayList<Date>();
        AAndBTests.addAll(ATests);
        AAndBTests.addAll(BTests);
        Collections.sort(AAndBTests);



        testsSpacingFitnessScore = evaluateDateSpacing(AAndBTests);
        candidate.setExamsfitnessScore(testsSpacingFitnessScore);
        finalFitnessScore += testsSpacingFitnessScore;


        intestinyFitnessScore = evaluateSchduleIntensity(candidate)* preferences.getPercentageIntensity()/100;
        candidate.setIntensityFitnessScore(intestinyFitnessScore);
        finalFitnessScore += intestinyFitnessScore;



        creditPointFitnessScore = evaluateSchdulePointFitnessScore(candidate) * preferences.getPercentageMinCredits()/100;
        candidate.setPointFitnessScore(creditPointFitnessScore);
        finalFitnessScore += creditPointFitnessScore ;


        double overlapTimeLessonsFitnessScore = evaluateOverLapingLessonsFitnessScore(candidate);
        candidate.setLessonsOverlapingFitnessScore(overlapTimeLessonsFitnessScore);
        finalFitnessScore += overlapTimeLessonsFitnessScore;


        repeatingCoursesFitneesScore = repeatingCoursesFintnessScore(candidate);
        candidate.setRepeatingCoursesFitnessScore(repeatingCoursesFitneesScore);
        finalFitnessScore += repeatingCoursesFitneesScore;


        if(finalFitnessScore < 0)
        {
            finalFitnessScore = 0;
        }

        candidate.setFinalFitnessScore(finalFitnessScore);


        System.out.println(finalFitnessScore);

        return   finalFitnessScore;

    }

    private double repeatingCoursesFintnessScore(Schedule candidate)
    {

        Set<String> courseNames = new HashSet<String >();

        for(Course course: candidate.getCourses())
        {

            courseNames.add(course.getCourseName());

        }

        return (candidate.getCourses().size() - courseNames.size()) *-30;

    }

    private double evaluateOverLapingLessonsFitnessScore(Schedule schedule)
    {
        List<Course>coursess=schedule.getCourses();
        for(Course course1:coursess){
            for(Course course2:coursess){
                if(!course1.equals(course2)){
                    if(course1.compareLessonsInCourses(course2)){
                        return 0;
                    }
                }
            }
        }
        return 10;
    }

    private double evaluateSchdulePointFitnessScore(Schedule schedule)
    {
        double totalCredits=0;
        for(Course course: schedule.getCourses()){
            totalCredits+=course.getCredits();
        }

        if(totalCredits<preferences.getMinCredits()){
            return 0;
        }else {
            return 10;
        }
    }



    private double evaluateSchduleIntensity(Schedule candidate)
    {

        int totalScheduleDifficulty = 0;

        for(int i = 0; i < candidate.getCourses().size(); i++)
        {
            totalScheduleDifficulty += candidate.getCourses().get(i).getDifficulty();
        }

        if(totalScheduleDifficulty > preferences.getIntensity())
        {
            totalScheduleDifficulty = (int)(totalScheduleDifficulty - preferences.getIntensity()) *-2; //consider to punish!.
        }


        //what if he gets a realy easy schedule? should we punish?

        /*if(totalScheduleDifficulty < 0)
        {
            totalScheduleDifficulty = 0;
        }*/

        return  totalScheduleDifficulty;
    }


    private double evaluateDateSpacing(List<Date> dateList)
    {
        //0    1    2    3    4    5    6    7    8
        double res = 0;
        long difference = 0;
        //double avgDifferenceInTime = (dateList.get(0).getTime() - dateList.get(dateList.size()-1).getTime())/dateList.size();
        for(int i=0;i<dateList.size()-1; i++){
            difference = (dateList.get(i+1).getTime() - dateList.get(i).getTime());

            double resultFromMathFunc =  arctanXdiv3(TimeUnit.MILLISECONDS.toDays(difference));

            resultFromMathFunc /= dateList.size();

          res+=resultFromMathFunc;
        }



        return res;
    }

    private double arctanXdiv3(long difference)
    {
        return 50* Math.atan(difference/3);
    }

    private List<Date> insertSortAtest(List<Course> courses)
    {
        List<Date>res=new ArrayList<Date>();
        for(Course course:courses){
            res.add(course.getTestA());
        }
        Collections.sort(res);
        return res;
    }

    private List<Date> insertSortBtest(List<Course> courses)
    {
        List<Date>res=new ArrayList<Date>();
        for(Course course:courses){
            res.add(course.getTestB());
        }
        Collections.sort(res);
        return res;
    }


    @Override
    public boolean isNatural() {
        return true;
    }
}
