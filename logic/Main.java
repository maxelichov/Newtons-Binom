package logic;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main
{

    public static void main(String[] args)
    {

        LogicManager logicManager = new LogicManager();

        WeekSchedule WeekSchedule= new WeekSchedule();
        WeekSchedule.insertNewRange(Days.SATURDAY, new RangeTime(LocalTime.of(16, 00),LocalTime.of(00, 00)));
        WeekSchedule.insertNewRange(Days.SATURDAY, new RangeTime(LocalTime.of(00, 00),LocalTime.of(17, 00)));
        WeekSchedule.insertNewRange(Days.THURSDAY, new RangeTime(LocalTime.of(7, 00),LocalTime.of(23, 59)));


        List<Course> courses = new ArrayList<Course>();


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
        courses.add(computability);



        List<Lesson> osLList=new ArrayList<Lesson>();
        osLList.add(new Lesson(Days.SUNDAY,new RangeTime(LocalTime.of(12,00),LocalTime.of(14,30))));
        osLList.add(new Lesson(Days.THURSDAY,new RangeTime(LocalTime.of(13,00),LocalTime.of(15,00))));
        Group osG=new Group(osLList);//todo: more groups
        List<Group> osGList = new ArrayList<Group>();
        osGList.add(osG);
        Course os=new Course("operating systems",4,8,osGList, new Date(2022,7,27) ,new Date(2022,8,24),true);
        courses.add(os);



        List<Lesson> javaList=new ArrayList<Lesson>();
        javaList.add(new Lesson(Days.SUNDAY,new RangeTime(LocalTime.of(12,00),LocalTime.of(14,30))));
        javaList.add(new Lesson(Days.WEDNESDAY,new RangeTime(LocalTime.of(13,00),LocalTime.of(15,00))));
        Group javaG=new Group(javaList);//todo: more groups
        List<Group> javaGList = new ArrayList<Group>();
        javaGList.add(javaG);
        Course java=new Course("JAVA",4,10,javaGList, new Date(2022,7,27) ,new Date(2022,8,24),true);
        courses.add(java);



        List<Lesson> csharpList=new ArrayList<Lesson>();
        csharpList.add(new Lesson(Days.SUNDAY,new RangeTime(LocalTime.of(12,00),LocalTime.of(14,30))));
        csharpList.add(new Lesson(Days.WEDNESDAY,new RangeTime(LocalTime.of(13,00),LocalTime.of(15,00))));
        Group csharpG=new Group(csharpList);//todo: more groups
        List<Group> csharpGList = new ArrayList<Group>();
        csharpGList.add(csharpG);
        Course csharp=new Course("CSharp",4,7,csharpGList, new Date(2022,7,27) ,new Date(2022,8,24),true);
        courses.add(csharp);

        List<Lesson> networkingL=new ArrayList<Lesson>();
        networkingL.add(new Lesson(Days.SUNDAY,new RangeTime(LocalTime.of(12,00),LocalTime.of(14,30))));
        networkingL.add(new Lesson(Days.THURSDAY,new RangeTime(LocalTime.of(13,00),LocalTime.of(15,00))));
        Group networkingG = new Group(networkingL);//todo: more groups
        List<Group> networkingGList = new ArrayList<Group>();
        networkingGList.add(networkingG);
        Course networking =new Course("Networking",4,7,networkingGList, new Date(2022,7,27) ,new Date(2022,8,24),true);
        courses.add(networking);



        List<Lesson> dataBasesL=new ArrayList<Lesson>();
        dataBasesL.add(new Lesson(Days.SUNDAY,new RangeTime(LocalTime.of(12,00),LocalTime.of(14,30))));
        dataBasesL.add(new Lesson(Days.FRIDAY,new RangeTime(LocalTime.of(13,00),LocalTime.of(15,00))));


        List<Lesson> dataBasesL2=new ArrayList<Lesson>();
        dataBasesL2.add(new Lesson(Days.THURSDAY,new RangeTime(LocalTime.of(10,00),LocalTime.of(12,30))));
        dataBasesL2.add(new Lesson(Days.WEDNESDAY,new RangeTime(LocalTime.of(14,00),LocalTime.of(16,00))));



        Group dataBasesG = new Group(dataBasesL);//todo: more groups

        Group dataBasesG2 = new Group(dataBasesL2);//todo: more groups

        List<Group> dataBasesGList = new ArrayList<Group>();


        dataBasesGList.add(dataBasesG);
        dataBasesGList.add(dataBasesG2);

        Course dataBasess =new Course("Data Bases",3,5,dataBasesGList, new Date(2022,7,27) ,new Date(2022,8,24),true);
        courses.add(dataBasess);


        List<Lesson> complexityL=new ArrayList<Lesson>();
        complexityL.add(new Lesson(Days.SUNDAY,new RangeTime(LocalTime.of(12,00),LocalTime.of(14,30))));
        complexityL.add(new Lesson(Days.FRIDAY,new RangeTime(LocalTime.of(13,00),LocalTime.of(15,00))));

        List<Lesson> complexityL2=new ArrayList<Lesson>();
        complexityL.add(new Lesson(Days.MONDAY,new RangeTime(LocalTime.of(10,00),LocalTime.of(14,30))));
        complexityL.add(new Lesson(Days.FRIDAY,new RangeTime(LocalTime.of(14,00),LocalTime.of(18,00))));

        List<Lesson> complexityL3=new ArrayList<Lesson>();
        complexityL.add(new Lesson(Days.THURSDAY,new RangeTime(LocalTime.of(13,20),LocalTime.of(15,40))));
        complexityL.add(new Lesson(Days.SATURDAY,new RangeTime(LocalTime.of(17,10),LocalTime.of(19,30))));

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
        workshopL.add(new Lesson(Days.SUNDAY,new RangeTime(LocalTime.of(12,00),LocalTime.of(14,30))));
        workshopL.add(new Lesson(Days.FRIDAY,new RangeTime(LocalTime.of(13,00),LocalTime.of(15,00))));
        Group workshopG = new Group(workshopL);
        List<Group> workshopGList = new ArrayList<Group>();
        complexityGList.add(workshopG);
        Course workshop = new Course("WorkShop",6,6,dataBasesGList, new Date(2022,7,27) ,new Date(2022,8,24),true);
        courses.add(workshop);


        Preferences pref = new Preferences(10,4,courses,30,WeekSchedule);


        logicManager.filterCourses(pref);

        logicManager.startEngine();

    }
}
