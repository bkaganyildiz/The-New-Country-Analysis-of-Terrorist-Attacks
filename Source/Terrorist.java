 
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * 
 */
public abstract class Terrorist extends Entity {

    /**
     * Default constructor
     */
    
    /**
     * @param ...
     */
    private Environment environment ;  
    private boolean isEquipped , isBrainWashed ;
    
    public  Terrorist(Position pos,boolean eq,boolean brain,StepStrategy strategy,Environment env) {
        setEnvironment(env);
        super.setPosition(pos);
        setIsBrainWashed(brain);
        setIsEquipped(eq);
        super.setStrategy(strategy);
        //setStrategy(strategy);  
    }
    /*
     * @param g2d 
     * @return
     */
    public abstract void draw(Graphics2D g2d);

    /**
     * @return the environment
     */
    public Environment getEnvironment() {
        return environment;
    }

    /**
     * @param environment the environment to set
     */
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    /**
     * @return the isEquipped
     */
    public boolean isIsEquipped() {
        return isEquipped;
    }

    /**
     * @param isEquipped the isEquipped to set
     */
    public void setIsEquipped(boolean isEquipped) {
        this.isEquipped = isEquipped;
    }

    /**
     * @return the isBrainWashed
     */
    public boolean isIsBrainWashed() {
        return isBrainWashed;
    }

    /**
     * @param isBrainWashed the isBrainWashed to set
     */
    public void setIsBrainWashed(boolean isBrainWashed) {
        this.isBrainWashed = isBrainWashed;
    }

    

}