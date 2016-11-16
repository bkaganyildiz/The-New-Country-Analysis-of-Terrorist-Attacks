 
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 * 
 */
public class Soldier extends Entity {

    private Environment env; 
    /**
     * Default constructor
     */

    public Soldier(Environment env) {
        this.env = env;
        Random random = new Random()  ; 
        Position pos = new Position() ;
        int min = env.getGPHeight(); 
        int max = env.getHeight(); 
        pos.setY(random.nextInt((max - min) -19) + min) ;
        pos.setX(random.nextInt(env.getWidth()-20)) ; 
        setPosition(pos);
        //img = new BufferedImage() ;
    }
    
    

    /**
     * @param g2d 
     * @return
     */
    @Override
    public  void draw(Graphics2D g2d){
        BasicStroke bStroke; 
        BufferedImage img = env.getSoldierImage() ; 
        Position pos = getPosition();
        g2d.drawImage(img, (int)pos.getX(), (int)pos.getY(), 40, 40, null);
        bStroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
        g2d.setColor(Color.BLUE);
        g2d.setStroke(bStroke);
        g2d.drawOval((int)pos.getX()-10,(int)pos.getY()-10, 60, 60);
        g2d.drawString("Soldier", (float) pos.getX(), (float) (int)pos.getY()-15);
        g2d.drawString(this.getStrategy().getName(), (float) pos.getX()+8, (float) (int)pos.getY()+70);

    }

    @Override
    public void step(double deltaTime) {
       this.getStrategy().step(this,deltaTime);
    }

}