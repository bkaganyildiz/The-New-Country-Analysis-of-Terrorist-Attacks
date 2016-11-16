 
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * 
 */
public class BrainWashed extends TerroristDecorator {

    /**
     * Default constructor
     */

    /**
     * @param t
     */
    public  BrainWashed(Terrorist t) {
        // TODO implement here
        super(t);
        
    }

    /**
     * @param g2d 
     * @return
     */
    public void draw(Graphics2D g2d) {
        
        Terrorist t = getDecoratedTerrorist(); 
        BufferedImage brainWashed  ;
        t.draw(g2d) ; 
        brainWashed = getEnvironment().getBrain();
        g2d.drawImage(brainWashed, (int)t.getPosition().getX()+5, (int)t.getPosition().getY()+45, 30, 30, null);
   
    }
    @Override
    public void setStrategy(StepStrategy ss) {
        getDecoratedTerrorist().setStrategy(ss);
    } 
    @Override 
    public StepStrategy getStrategy() {
        return getDecoratedTerrorist().getStrategy() ; 
    } 
     @Override 
    public void setPosition (Position pos ) {
        this.getDecoratedTerrorist().setPosition(pos); 
    }
     @Override 
    public Position getPosition() {
        return this.getDecoratedTerrorist().getPosition() ;
    }

    @Override
    public void step(double deltaTime) {
      this.getDecoratedTerrorist().getStrategy().step(this,deltaTime);

    }


}