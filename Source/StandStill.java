 
import java.util.*;

/**
 * 
 */
public class StandStill extends StepStrategy {

    /**
     * Default constructor
     */
    public StandStill(Environment env) {
        setEnvironment(env);
        setNumberOfTurns(0);
    }


    /**
     * @param ...
     */
    public void standStill() {
        // TODO implement here
    }

    @Override
    public String getName() {
        return "SS" ;
    }

    @Override
    public boolean isFinished() {
        return (getNumberOfTurns()>30) ; 
    }

    @Override
    public void step(Entity e, double deltaTime) {
        setNumberOfTurns(getNumberOfTurns()+1) ;
    }

}