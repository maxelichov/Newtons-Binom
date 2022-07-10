package logic;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main
{

    public static void main(String[] args)
    {

        /*
        todo
        1. work with files
        2. servers
        3. ui platform
        4. let user to control evolution setting
         */
        LogicManager logicManager = new LogicManager();

        WeekSchedule WeekSchedule= new WeekSchedule();
        WeekSchedule.insertNewRange(Days.SATURDAY, new TimeRange(LocalTime.of(16, 00),LocalTime.of(00, 00)));
        WeekSchedule.insertNewRange(Days.SATURDAY, new TimeRange(LocalTime.of(00, 00),LocalTime.of(17, 00)));
        WeekSchedule.insertNewRange(Days.THURSDAY, new TimeRange(LocalTime.of(7, 00),LocalTime.of(23, 59)));


        List<Course> courses = new ArrayList<Course>();


        List<Lesson> computabilityLList1=new ArrayList<Lesson>();
        computabilityLList1.add(new Lesson(Days.WEDNESDAY,new TimeRange(LocalTime.of(16,00),LocalTime.of(18,00))));
        computabilityLList1.add(new Lesson(Days.THURSDAY,new TimeRange(LocalTime.of(16,00),LocalTime.of(19,00))));
        Group computabilityG1=new Group(computabilityLList1);
        List<Group> computabilityGList = new ArrayList<Group>();
        computabilityGList.add(computabilityG1);

        List<Lesson> computabilityLList2=new ArrayList<Lesson>();
        computabilityLList2.add(new Lesson(Days.SUNDAY,new TimeRange(LocalTime.of(16,00),LocalTime.of(18,00))));
        computabilityLList2.add(new Lesson(Days.THURSDAY,new TimeRange(LocalTime.of(16,00),LocalTime.of(19,00))));
        Group computabilityG2=new Group(computabilityLList2);
        computabilityGList.add(computabilityG2);

        Course computability=new Course("computability",4,7,computabilityGList, new Date(2022,7,13) ,new Date(2022,8,21),true);
        courses.add(computability);

        /////////////////////////////////////////////////////////////////////

        List<Lesson> designPatternsList1=new ArrayList<Lesson>();
        designPatternsList1.add(new Lesson(Days.THURSDAY,new TimeRange(LocalTime.of(10,00),LocalTime.of(12,00))));
        Group designPatternsG1=new Group(designPatternsList1);
        List<Group> designPatternsGList = new ArrayList<Group>();
        designPatternsGList.add(designPatternsG1);


        Course designPatterns=new Course("design patterns",4,6,designPatternsGList, null ,null,false);
        courses.add(designPatterns);


        /////////////////////////////////////////////////////////////////////

        /////////////////////////////////////////////////////////////////////

        List<Lesson> calculus1LList1=new ArrayList<Lesson>();
        calculus1LList1.add(new Lesson(Days.SUNDAY,new TimeRange(LocalTime.of(8,00),LocalTime.of(10,00))));
        calculus1LList1.add(new Lesson(Days.TUESDAY,new TimeRange(LocalTime.of(11,00),LocalTime.of(2,00))));
        Group calculus1G1=new Group(calculus1LList1);
        List<Group> calculusGList = new ArrayList<Group>();
        calculusGList.add(calculus1G1);

        List<Lesson> calculus1LList2=new ArrayList<Lesson>();
        calculus1LList2.add(new Lesson(Days.MONDAY,new TimeRange(LocalTime.of(9,00),LocalTime.of(11,00))));
        calculus1LList2.add(new Lesson(Days.WEDNESDAY,new TimeRange(LocalTime.of(12,00),LocalTime.of(15,00))));
        Group calculus1G2=new Group(calculus1LList2);
        calculusGList.add(calculus1G2);

        Course calculus1=new Course("calculus1",6,8,calculusGList, new Date(2022,8,25) ,new Date(2022,9,10),true);
        courses.add(calculus1);


        /////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////

        List<Lesson> calculus2LList1=new ArrayList<Lesson>();
        calculus2LList1.add(new Lesson(Days.WEDNESDAY,new TimeRange(LocalTime.of(10,00),LocalTime.of(12,00))));
        calculus2LList1.add(new Lesson(Days.THURSDAY,new TimeRange(LocalTime.of(12,00),LocalTime.of(14,00))));
        Group calculus2G1=new Group(calculus2LList1);
        List<Group> calculus2GList = new ArrayList<Group>();
        calculus2GList.add(calculus2G1);

        List<Lesson> calculus2LList2=new ArrayList<Lesson>();
        calculus2LList2.add(new Lesson(Days.SUNDAY,new TimeRange(LocalTime.of(9,00),LocalTime.of(11,00))));
        calculus2LList2.add(new Lesson(Days.THURSDAY,new TimeRange(LocalTime.of(11,00),LocalTime.of(13,00))));
        Group calculus2G2=new Group(calculus2LList2);
        calculus2GList.add(calculus2G2);

        Course calculus2=new Course("calculus2",5,8,calculus2GList, new Date(2022,8,23) ,new Date(2022,9,11),true);
        courses.add(calculus2);


        /////////////////////////////////////////////////////////////////////



        List<Lesson> osLList=new ArrayList<Lesson>();
        osLList.add(new Lesson(Days.SUNDAY,new TimeRange(LocalTime.of(12,00),LocalTime.of(14,30))));
        osLList.add(new Lesson(Days.THURSDAY,new TimeRange(LocalTime.of(13,00),LocalTime.of(15,00))));
        Group osG=new Group(osLList);//todo: more groups
        List<Group> osGList = new ArrayList<Group>();
        osGList.add(osG);
        Course os=new Course("operating systems",4,8,osGList, new Date(2022,8,30) ,new Date(2022,9,10),true);
        courses.add(os);



        List<Lesson> javaList=new ArrayList<Lesson>();
        javaList.add(new Lesson(Days.SUNDAY,new TimeRange(LocalTime.of(12,00),LocalTime.of(14,30))));
        javaList.add(new Lesson(Days.WEDNESDAY,new TimeRange(LocalTime.of(13,00),LocalTime.of(15,00))));
        Group javaG=new Group(javaList);//todo: more groups
        List<Group> javaGList = new ArrayList<Group>();
        javaGList.add(javaG);
        Course java=new Course("JAVA",4,10,javaGList, new Date(2022,7,17) ,new Date(2022,8,29),true);
        courses.add(java);



        List<Lesson> csharpList=new ArrayList<Lesson>();
        csharpList.add(new Lesson(Days.SUNDAY,new TimeRange(LocalTime.of(12,00),LocalTime.of(14,30))));
        csharpList.add(new Lesson(Days.WEDNESDAY,new TimeRange(LocalTime.of(13,00),LocalTime.of(15,00))));
        Group csharpG=new Group(csharpList);//todo: more groups
        List<Group> csharpGList = new ArrayList<Group>();
        csharpGList.add(csharpG);
        Course csharp=new Course("CSharp",4,7,csharpGList, new Date(2022,7,20) ,new Date(2022,9,5),true);
        courses.add(csharp);

        List<Lesson> networkingL=new ArrayList<Lesson>();
        networkingL.add(new Lesson(Days.SUNDAY,new TimeRange(LocalTime.of(12,00),LocalTime.of(14,30))));
        networkingL.add(new Lesson(Days.THURSDAY,new TimeRange(LocalTime.of(13,00),LocalTime.of(15,00))));
        Group networkingG = new Group(networkingL);//todo: more groups
        List<Group> networkingGList = new ArrayList<Group>();
        networkingGList.add(networkingG);
        Course networking =new Course("Networking",4,7,networkingGList, new Date(2022,7,27) ,new Date(2022,8,24),true);
        courses.add(networking);



        List<Lesson> dataBasesL=new ArrayList<Lesson>();
        dataBasesL.add(new Lesson(Days.SUNDAY,new TimeRange(LocalTime.of(12,00),LocalTime.of(14,30))));
        dataBasesL.add(new Lesson(Days.FRIDAY,new TimeRange(LocalTime.of(13,00),LocalTime.of(15,00))));


        List<Lesson> dataBasesL2=new ArrayList<Lesson>();
        dataBasesL2.add(new Lesson(Days.THURSDAY,new TimeRange(LocalTime.of(10,00),LocalTime.of(12,30))));
        dataBasesL2.add(new Lesson(Days.WEDNESDAY,new TimeRange(LocalTime.of(14,00),LocalTime.of(16,00))));



        Group dataBasesG = new Group(dataBasesL);//todo: more groups

        Group dataBasesG2 = new Group(dataBasesL2);//todo: more groups

        List<Group> dataBasesGList = new ArrayList<Group>();


        dataBasesGList.add(dataBasesG);
        dataBasesGList.add(dataBasesG2);

        Course dataBasess =new Course("Data Bases",3,5,dataBasesGList, new Date(2022,7,27) ,new Date(2022,8,24),true);
        courses.add(dataBasess);


        List<Lesson> complexityL=new ArrayList<Lesson>();
        complexityL.add(new Lesson(Days.SUNDAY,new TimeRange(LocalTime.of(12,00),LocalTime.of(14,30))));
        complexityL.add(new Lesson(Days.FRIDAY,new TimeRange(LocalTime.of(13,00),LocalTime.of(15,00))));

        List<Lesson> complexityL2=new ArrayList<Lesson>();
        complexityL.add(new Lesson(Days.MONDAY,new TimeRange(LocalTime.of(10,00),LocalTime.of(14,30))));
        complexityL.add(new Lesson(Days.FRIDAY,new TimeRange(LocalTime.of(14,00),LocalTime.of(18,00))));

        List<Lesson> complexityL3=new ArrayList<Lesson>();
        complexityL.add(new Lesson(Days.THURSDAY,new TimeRange(LocalTime.of(13,20),LocalTime.of(15,40))));
        complexityL.add(new Lesson(Days.SATURDAY,new TimeRange(LocalTime.of(17,10),LocalTime.of(19,30))));

        Group complexityG = new Group(complexityL);
        Group complexityG2 = new Group(complexityL2);
        Group complexityG3 = new Group(complexityL3);

        List<Group> complexityGList = new ArrayList<Group>();
        complexityGList.add(complexityG);
        complexityGList.add(complexityG2);
        complexityGList.add(complexityG3);

        Course complexity =new Course("Complexity",5,10,dataBasesGList, new Date(2022,7,27) ,new Date(2022,8,24),true);
        courses.add(complexity);



        List<Lesson> workshopL=new ArrayList<Lesson>();
        workshopL.add(new Lesson(Days.SUNDAY,new TimeRange(LocalTime.of(12,00),LocalTime.of(14,30))));
        workshopL.add(new Lesson(Days.FRIDAY,new TimeRange(LocalTime.of(13,00),LocalTime.of(15,00))));
        Group workshopG = new Group(workshopL);
        List<Group> workshopGList = new ArrayList<Group>();
        workshopGList.add(workshopG);
        Course workshop = new Course("WorkShop",6,6,workshopGList, null ,null,true);
        courses.add(workshop);



        List<Course> mustCourses=new ArrayList<Course>();
        mustCourses.add(java);
        mustCourses.add(calculus1);
        Preferences pref = new Preferences(30,100,13,100,courses,40,100,WeekSchedule,mustCourses);


        logicManager.filterCourses(pref);

        logicManager.startEngine();

    }
}
