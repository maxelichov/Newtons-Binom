package logic;

import java.util.List;

public  class Preferences
{

    private int percentageIntensity;
    private int percentageMaxHoursForStudyingInWeek;
    private int percentageMinCredits;
    private float intensity;
    private float minCredits;
    private List<Course> prefCourse;
    private float maxHoursForStudyingInWeek;
    private WeekSchedule unavailablityWeekSchedule;

    public Preferences(float intensity, int percentageIntensity,
                       float minCredits, int percentageMinCredits,
                       List<Course> prefCourse,
                       float maxHoursForStudyingInWeek, int percentageMaxHoursForStudyingInWeek,
                       WeekSchedule unavailablityWeekSchedule){
        if(!(0<=percentageIntensity && percentageIntensity<=100
        && 0<=percentageMinCredits && percentageMinCredits<=100
        && 0<=percentageMaxHoursForStudyingInWeek && percentageMaxHoursForStudyingInWeek<=100 )){
            //todo throw Exceptions
        }
        this.intensity=intensity;
        this.minCredits=minCredits;
        this.prefCourse=prefCourse;
        this.maxHoursForStudyingInWeek=maxHoursForStudyingInWeek;
        this.unavailablityWeekSchedule=unavailablityWeekSchedule;
        this.percentageIntensity=percentageIntensity;
        this.percentageMinCredits=percentageMinCredits;
        this.percentageMaxHoursForStudyingInWeek=percentageMaxHoursForStudyingInWeek;
    }

    public float getIntensity() {
        return intensity;
    }

    public float getMinCredits() {
        return minCredits;
    }

    public List<Course> getPrefCourse() {
        return prefCourse;
    }

    public float getMaxHoursForStudyingInWeek() {
        return maxHoursForStudyingInWeek;
    }

    public WeekSchedule getUnavailablityWeekSchedule() {
        return unavailablityWeekSchedule;
    }

    public int getPercentageIntensity()
    {
        return percentageIntensity;
    }

    public int getPercentageMaxHoursForStudyingInWeek()
    {
        return percentageMaxHoursForStudyingInWeek;
    }

    public int getPercentageMinCredits()
    {
        return percentageMinCredits;
    }
}
