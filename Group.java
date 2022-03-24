import java.util.ArrayList;
import java.util.List;

public class Group implements Cloneable{
    List<Lesson> lessons=new ArrayList<Lesson>();

    public Group(List<Lesson> lessons){
        this.lessons=lessons;
    }

    public Group() {
        lessons=new ArrayList<Lesson>();
    }


    @Override
    public Object clone()throws CloneNotSupportedException{
        return super.clone();
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
