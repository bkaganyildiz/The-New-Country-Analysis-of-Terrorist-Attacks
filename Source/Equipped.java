 

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * 
 */
public class Equipped extends TerroristDecorator {

    /**
     * Default constructor
     */

    /**
     * @param t
     */
    public Equipped(Terrorist t) {
        // TODO implement here
        super(t) ;
        
    }

    /**
     * @param g2d 
     * @return
     */
    public void draw(Graphics2D g2d) {
        // TODO implement here
        Terrorist t = getDecoratedTerrorist(); 
        BufferedImage equipped  ;
        t.draw(g2d);
        equipped = getEnvironment().getEquipped();
        g2d.drawImage(equipped, (int)getPosition().getX()+80, (int)getPosition().getY()+45, 30, 30, null);
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