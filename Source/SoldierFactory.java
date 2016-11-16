 
import java.util.*;

/**
 * 
 */
public class SoldierFactory extends EntityFactory {

    /**
     * Default constructor
     */

    /**
     *
     * @param env
     * @return
     */
    @Override
    public Entity createEntity(Environment env) {
        return new Soldier(env) ; 
    }

}