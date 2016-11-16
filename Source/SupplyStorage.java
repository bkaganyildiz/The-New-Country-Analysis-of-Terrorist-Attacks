 
import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.util.Random;

/**
 * 
 */
public class SupplyStorage extends Entity {

    /**
     * Default constructor
     */
    private Position pos ;
    public SupplyStorage(Environment env ) {
        Random random = new Random()  ; 
        int min = env.getGPHeight(); 
        int max = env.getHeight(); 
        pos = new Position(); 
        pos.setY(random.nextInt((max - min) -100) + min) ;
        pos.setX(random.nextInt(env.getWidth()-100)) ; 
        setPosition(pos);
    }

    /**
     * @param g2d 
     * @return
     */
    public  void draw(Graphics2D g2d){
        BasicStroke bs = new BasicStroke();
         g2d.setStroke(bs);
         g2d.setColor(java.awt.Color.red);
         g2d.drawOval(getPosition().getX(),getPosition().getY(),75,75) ; 
         g2d.setColor(java.awt.Color.decode("#FF7F50"));
         g2d.fillOval(getPosition().getX(),getPosition().getY(),75,75) ;
         g2d.setColor(java.awt.Color.blue);
         g2d.drawString("Storage",getPosition().getX()+10, getPosition().getY()+40) ; 
    }

    @Override
    public void step(double deltaTime) {
    }

}