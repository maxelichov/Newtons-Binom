import java.util.ArrayList;
import java.util.List;

public class Group implements Cloneable
{
    List<Lesson> lessons=new ArrayList<Lesson>();

    public Group(List<Lesson> lessons){
        this.lessons=lessons;
    }

    public Group() {
        lessons=new ArrayList<Lesson>();
    }



    @Override
    public Object clone()throws CloneNotSupportedException{

        Group clonedGroup = new Group();

        clonedGroup =  (Group) super.clone();
        List<Lesson> clonedLessons = new ArrayList<Lesson>(lessons.size());

        for (Lesson lesson: lessons) {

            clonedLessons.add((Lesson) lesson.clone());


        }

        clonedGroup.setLessons(clonedLessons);

        return clonedGroup;
        //return super.clone();
    }

    private void setLessons(List<Lesson> clonedLessons) {

            this.lessons = clonedLessons;
    }


    @Override
    public String toString() {
        return "Group{" +
                "lessons=" + lessons +
                '}';
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void addLesson(Lesson currLesson) {
        lessons.add(currLesson);
    }
}
