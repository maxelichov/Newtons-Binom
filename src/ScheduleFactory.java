import org.uncommons.watchmaker.framework.CandidateFactory;

import java.util.Collection;
import java.util.List;
import java.util.Random;

public class ScheduleFactory implements CandidateFactory {

    private final List<Course> courses;

    public ScheduleFactory(List<Course> courses) {
        this.courses=courses;
    }

    @Override
    public List generateInitialPopulation(int i, Random random) {
        return null;
    }

    @Override
    public List generateInitialPopulation(int i, Collection collection, Random random) {
        return null;
    }

    @Override
    public Object generateRandomCandidate(Random random) {
        return null;
    }
}
