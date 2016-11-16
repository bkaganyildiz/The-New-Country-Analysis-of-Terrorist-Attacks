 
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * 
 */
public abstract class Entity {

    /**
     * Default constructor
     */
    public Entity() {
    }

    /**
     * 
     */
    private Color color;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private double speed;
    
    private StepStrategy strategy ;

    /**
     * 
     */
    private Position position;

    /**
     * 
     

    /**
     * @param deltaTime 
     * @return
     */
    public abstract void step(double deltaTime) ;

    /**
     * @param g2d 
     * @return
     */
    public abstract void draw(Graphics2D g2d);
    
    public void setPosition (Position pos ) {
        this.position = pos ; 
    }
    public Position getPosition() {
        return this.position ;
    }

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * @return the strategy
     */
    public StepStrategy getStrategy() {
        return strategy;
    }

    /**
     * @param strategy the strategy to set
     */
    public void setStrategy(StepStrategy strategy) {
        this.strategy = strategy;
    }

}