 

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
public class Untouchable extends Entity {

    /**
     * Default constructor
     */
    private String fl ;
    private Environment env ; 
    private BufferedImage img ;
    public Untouchable(Environment env,String fileLocation) {
        this.env = env ; 
        this.fl = fileLocation ; 
        try
        {
            img = ImageIO.read(new File(this.fl));
        }
        catch(IOException e)
        {
            img = null;
        }
        Random random = new Random();
        Position pos = new Position() ;
        int min = env.getGPHeight(); 
        int max = env.getHeight(); 
        pos.setY(random.nextInt((max - min) -19) + min) ;
        pos.setX(random.nextInt(env.getWidth()-20)) ; 
        setPosition(pos) ; 
    }
    /**
     * @param g2d 
     * @return
     */
    
    @Override
    public  void draw(Graphics2D g2d){
        Position position = getPosition() ; 
        g2d.setStroke(new BasicStroke(2));
        g2d.drawImage(img, (int)position.getX(), (int)position.getY(), 40, 40, null);
        g2d.setColor(Color.black);
        g2d.drawRect((int)position.getX()-10, (int)position.getY()-10, 60, 60);
        g2d.setColor(Color.blue);
        g2d.drawString("Untouchable", (float) position.getX()-20, (float) (int)position.getY()-15);
        g2d.drawString(this.getStrategy().getName(), (float) position.getX()+8, (float) (int)position.getY()+70);

    };

    @Override
    public void step(double deltaTime) {
        this.getStrategy().step(this,deltaTime);
    }

}