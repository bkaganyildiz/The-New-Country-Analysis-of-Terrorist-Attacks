 
import java.util.*;

/**
 * 
 */
public abstract class EntityFactory {

    /**
     * Default constructor
     */
    private Position pos ; 
    /**
     * @param ... 
     * @return
     */
    public abstract Entity createEntity(Environment env) ;

}