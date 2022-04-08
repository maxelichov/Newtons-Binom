package logic;

import java.util.List;

public class Preferences {
    private float intensity;
    private float minCredits;
    private List<Course> prefCourse;
    private float maxHoursForStudyingInWeek;
    private WeekSchedule unavailablityWeekSchedule;

    public Preferences(float intensity,
                       float minCredits,
                       List<Course> prefCourse,
                       float maxHoursForStudyingInWeek,
                       WeekSchedule unavailablityWeekSchedule){
        this.intensity=intensity;
        this.minCredits=minCredits;
        this.prefCourse=prefCourse;
        this.maxHoursForStudyingInWeek=maxHoursForStudyingInWeek;
        this.unavailablityWeekSchedule=unavailablityWeekSchedule;
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




}
