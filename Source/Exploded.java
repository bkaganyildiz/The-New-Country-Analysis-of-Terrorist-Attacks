 
import java.awt.Graphics2D;

/**
 * 
 */
public class Exploded extends TerroristDecorator {

    /**
     * Default constructor
     */
   

    /**
     * @param t
     */
    public  Exploded(Terrorist t) {
        // TODO implement here,
        super(t);
        
    }

    /**
     * @param g2d 
     * @return
     */
    public void draw(Graphics2D g2d) {
        // TODO implement here
        Terrorist t = getDecoratedTerrorist(); 
        t.draw(g2d);
        
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