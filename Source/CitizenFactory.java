 
import java.awt.Color;
import java.util.*;

/**
 * 
 */
public class CitizenFactory extends EntityFactory {

    /**
     * Default constructor
     */
    
    
    
    public Entity createEntity(Environment env) {
        
        return new Citizen(env); 
    }

}