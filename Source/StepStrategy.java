 
import java.util.*;

/**
 * 
 */
public abstract class StepStrategy {

    /**
     * Default constructor
     */
    private int numberOfTurns;
    private Environment environment;
    
    public StepStrategy() {
    }

    /**
     * 
     

    /**
     * @return
     */
    public abstract String getName() ;

    /**
     * @return
     */
    public  boolean isFinished()  {
        return (numberOfTurns==0) ;
    }
    public void setNumberOfTurns(int numberOfTurns) {
        this.numberOfTurns = numberOfTurns;
    }
    public int getNumberOfTurns() {
        return this.numberOfTurns ;
    }
    public Environment getEnvironment() {
        return environment;
    }
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    /**
     * @param e 
     * @param deltaTime 
     * @return
     */
    public abstract void step(Entity e, double deltaTime) ;

}