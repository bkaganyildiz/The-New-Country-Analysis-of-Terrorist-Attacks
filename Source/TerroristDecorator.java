 
import java.awt.Graphics2D;
import java.util.*;

/**
 * 
 */
public abstract class TerroristDecorator extends Terrorist {

    /**
     * Default constructor
     */
    /*public TerroristDecorator() {
    }*/

    /**
     * 
     */
    private Terrorist decoratedTerrorist ; 
    /**
     * @param t
     */
    public TerroristDecorator(Terrorist t) {
        // TODO implement here
        super(t.getPosition(),t.isIsEquipped(),t.isIsBrainWashed(),t.getStrategy(),t.getEnvironment()) ; 
        
        setDecoratedTerrorist(t)  ;
        System.out.println("Asasdasfasfas");
        System.out.println(t.getStrategy() == null);
        setPosition(t.getPosition());
        setIsBrainWashed(t.isIsBrainWashed());
        setIsEquipped(t.isIsEquipped());
        //setStrategy(t.getStrategy());
    } 

    /**
     * @return the decoratedTerrorist
     */
    public Terrorist getDecoratedTerrorist() {
        return decoratedTerrorist;
    }

    /**
     * @param decoratedTerrorist the decoratedTerrorist to set
     */
    public void setDecoratedTerrorist(Terrorist decoratedTerrorist) {
        this.decoratedTerrorist = decoratedTerrorist;
    }
    
    

}