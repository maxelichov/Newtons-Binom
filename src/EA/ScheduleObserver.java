package EA;

import org.uncommons.watchmaker.framework.EvolutionObserver;
import org.uncommons.watchmaker.framework.PopulationData;



// TODO: do we need this??


public class ScheduleObserver implements EvolutionObserver {

    @Override
    public void populationUpdate(PopulationData arg0) {
        // TODO Auto-generated method stub
        System.out.println("Generation " + arg0.getGenerationNumber() + ":\t" +  arg0.getBestCandidateFitness());
    }

}
