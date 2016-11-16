 
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

/**
 * 
 */
public class Citizen extends Entity {

    /**
     * Default constructor
     */
    private Color color ;  
    
    public Citizen(Environment env) {
        Random random = new Random()  ; 
        Position pos = new Position() ;
        int min = env.getGPHeight(); 
        int max = env.getHeight(); 
        pos.setY(random.nextInt((max - min) -19) + min) ;
        pos.setX(random.nextInt(env.getWidth()-20)) ; 
        setPosition(pos) ;
        int R = (int) (Math.random() * 256);
        int G = (int) (Math.random() * 256);
        int B = (int) (Math.random() * 256); 
        color = new Color(R,G,B) ; 
        
    }
    
    
    /**
     * @param g2d 
     * @return
     */
    @Override
    public  void draw(Graphics2D g2d){
        Position pos = getPosition() ;
        g2d.setColor(color) ; 
        g2d.fillOval(pos.getX(), pos.getY(), 20, 20);
        g2d.setColor(color.blue);
        g2d.drawString("Citizen", (float) pos.getX()-15, (float) (int)pos.getY()-5);
        g2d.drawString(this.getStrategy().getName(), (float) pos.getX(), (float) (int)pos.getY()+35);

    }

    @Override
    public void step(double deltaTime) {
        this.getStrategy().step(this,deltaTime);
    }

}