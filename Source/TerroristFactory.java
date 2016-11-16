 
import java.awt.Graphics2D;
import java.util.*;

/**
 * 
 */
public class TerroristFactory extends EntityFactory {

    /**
     * Default constructor
     */
  

    @Override
    public Entity createEntity(Environment env) {
        Random random = new Random()  ; 
        Position pos = new Position() ;
        int min = env.getGPHeight(); 
        int max = env.getHeight(); 
        pos.setY(random.nextInt((max - min) -19) + min) ;
        pos.setX(random.nextInt(env.getWidth()-20)) ; 
        StepStrategy strategy = env.generateTerrorStrategy();
        Terrorist newTerror = new RecentlyDeceived(pos,false,false,strategy,env) ; 
        
        return newTerror ;    
    }

}