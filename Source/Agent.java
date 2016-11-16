 
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * 
 */
public class Agent extends Entity {

    /**
     * Default constructor
     */
    private Environment env ; 
    
    
    public Agent(Environment env) { 
        this.env = env;
        Position position  ;
        Random random = new Random()  ; 
        position = new Position() ;
        int min = env.getGPHeight(); 
        int max = env.getHeight(); 
        position.setY(random.nextInt((max - min) -19) + min) ;
        position.setX(random.nextInt(env.getWidth()-20)) ; 
        setPosition(position);
    }
    
   

    /**
     * @param g2d 
     * @return
     */
    @Override
    public  void draw(Graphics2D g2d){
        Position position ; 
        position = getPosition() ; 
        BufferedImage agentImage ; 
        BasicStroke bStroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0); 
        agentImage = env.getAgentImage();
        g2d.drawImage(agentImage, (int)position.getX(), (int)position.getY(), 40, 40, null);
        g2d.setColor(Color.GREEN);
        g2d.setStroke(bStroke);
        g2d.drawOval((int)position.getX()-10,(int)position.getY()-10, 60, 60);
        g2d.setColor(Color.blue);
        g2d.drawString("Agent", (float) position.getX(), (float) (int)position.getY()-15);
        g2d.drawString(this.getStrategy().getName(), (float) position.getX()+8, (float) (int)position.getY()+70);
        
    }

    @Override
    public void step(double deltaTime) {
       this.getStrategy().step(this,deltaTime);

    }

}