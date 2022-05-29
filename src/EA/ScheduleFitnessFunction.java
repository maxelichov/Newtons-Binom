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
    int generation;
    int indexForGeneration;
    public ScheduleFitnessFunction(Preferences preferences)
    {
        this.preferences = preferences;
        generation=0;
        indexForGeneration=0;
    }

    @Override
    public double getFitness(Schedule candidate, List<? extends Schedule> list)
    {
        indexForGeneration++;
        if(indexForGeneration%list.size() == list.size()-1){
            generation++;
            System.out.println("*****************************");
            indexForGeneration=0;
        }

        double finalFitnessScore = 100;

        /*
        if(! isAllMustHaveCoursesInCandidate(candidate.getCourses(), preferences.getMustHaveCourses())){
            finalFitnessScore -= 2*generation;
        }

         */

        double testsSpacingFitnessScore = 0;
        double intestinyFitnessScore = 0;
        double creditPointFitnessScore = 0;
        double repeatingCoursesFitnessScore = 0;
        double mustHaveCoursesFitnessScore = 0;

        mustHaveCoursesFitnessScore = evaluateMustHaveCourses(candidate.getCourses());
        candidate.setMustHaveCourseCoursesFitnessScore(mustHaveCoursesFitnessScore);
        finalFitnessScore += mustHaveCoursesFitnessScore;

        List<Date> ATests = insertSortAtest(candidate.getCourses());
        List<Date> BTests = insertSortBtest(candidate.getCourses());
        List<Date> AAndBTests = new ArrayList<Date>();
        AAndBTests.addAll(ATests);
        AAndBTests.addAll(BTests);
        Collections.sort(AAndBTests);



        testsSpacingFitnessScore = evaluateDateSpacing(AAndBTests);
        candidate.setExamsFitnessScore(testsSpacingFitnessScore);
        finalFitnessScore += testsSpacingFitnessScore;


        intestinyFitnessScore = evaluateSchduleIntensity(candidate)* preferences.getPercentageIntensity()/100;
        candidate.setIntensityFitnessScore(intestinyFitnessScore);
        finalFitnessScore += intestinyFitnessScore;



        creditPointFitnessScore = evaluateSchdulePointFitnessScore(candidate) * preferences.getPercentageMinCredits()/100;
        candidate.setPointFitnessScore(creditPointFitnessScore);
        finalFitnessScore += creditPointFitnessScore ;


        double overlapTimeLessonsFitnessScore = evaluateOverLappingLessonsFitnessScore(candidate);
        candidate.setLessonsOverlappingFitnessScore(overlapTimeLessonsFitnessScore);
        finalFitnessScore += overlapTimeLessonsFitnessScore;


        repeatingCoursesFitnessScore = repeatingCoursesFitnessScore(candidate);
        candidate.setRepeatingCoursesFitnessScore(repeatingCoursesFitnessScore);
        finalFitnessScore += repeatingCoursesFitnessScore;


        if(finalFitnessScore < 0)
        {
            finalFitnessScore = 0;
        }

        candidate.setFinalFitnessScore(finalFitnessScore);


        System.out.println(finalFitnessScore);

        return   finalFitnessScore;

    }

    private int evaluateMustHaveCourses(List<Course> courses) {
        int res=0;
        int numOfMustHaveCoursesInCoursesList = 0;
        for(Course mustHaveCourse : preferences.getMustHaveCourses()){
            for(Course course : courses){
                if(course.isSameName(mustHaveCourse.getCourseName())){
                    res+=20;
                    numOfMustHaveCoursesInCoursesList++;
                    break;
                }
            }
        }

        //res += (numOfMustHaveCoursesInCoursesList - preferences.getMustHaveCourses().size()) * generation;
        return res;
    }

    private boolean isAllMustHaveCoursesInCandidate(List<Course> candidateCourses, List<Course> mustHaveCourses) {
        int i=0;
        for(Course mustHaveCourse : mustHaveCourses){
            for(Course candidateCourse : candidateCourses){
                if(mustHaveCourse.isSameName(candidateCourse.getCourseName())){
                    i++;
                    break;
                }
            }
        }

        if(mustHaveCourses.size()==i){
            return true;
        }
        else{
            return false;
        }
    }

    private double repeatingCoursesFitnessScore(Schedule candidate)
    {
        double res=0;
        Set<String> courseNames = new HashSet<String >();

        for(Course course: candidate.getCourses())
        {

            courseNames.add(course.getCourseName());

        }

        res= (candidate.getCourses().size() - courseNames.size()) * (-generation);
        return res;

    }

    private double evaluateByCourseType(Schedule candidate) {
        double res=0;
        for (Course course: candidate.getCourses()) {
            if(course.getMandatory()){
                res +=10;
            }else{
                res +=20;
            }
        }
        return res;
    }

    private double evaluateOverLappingLessonsFitnessScore(Schedule schedule)
    {
        List<Course>coursess=schedule.getCourses();
        for(Course course1:coursess){
            for(Course course2:coursess){
                if(!course1.equals(course2)){
                    if(course1.compareLessonsInCourses(course2)){
                        return - generation;
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
            return (totalCredits - preferences.getMinCredits()) * 10;
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
            if(course.getTestA()!=null){
                res.add(course.getTestA());
            }
        }
        Collections.sort(res);
        return res;
    }

    private List<Date> insertSortBtest(List<Course> courses)
    {
        List<Date>res=new ArrayList<Date>();
        for(Course course:courses){
            if(course.getTestB()!=null){
                res.add(course.getTestB());
            }
        }
        Collections.sort(res);
        return res;
    }


    @Override
    public boolean isNatural() {
        return true;
    }
}
