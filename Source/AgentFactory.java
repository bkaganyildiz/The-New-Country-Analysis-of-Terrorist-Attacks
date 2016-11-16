 
import java.util.*;

/**
 * 
 */
public class AgentFactory extends EntityFactory {

    /**
     * Default constructor
     */
    
    @Override
    public Entity createEntity(Environment env) {
        return new Agent(env) ; 
    }

}