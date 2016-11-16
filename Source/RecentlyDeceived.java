 

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * 
 */
public class RecentlyDeceived extends Terrorist {

    /**
     * Default constructor
     */
    private BufferedImage terroristImage ;
    
    public RecentlyDeceived(Position pos,boolean eq,boolean brain,StepStrategy strategy,Environment env) {
         super(pos,eq,brain,strategy,env) ; 
         //this.setStrategy(strategy);
    }


    /**
     * @param e
     */
   

    /**
     * @param g2d 
     * @return
     */
    public void draw(Graphics2D g2d) {
        // TODO implement here
        Position position =  getPosition() ; 
        BasicStroke bStroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0); 
        this.terroristImage = getEnvironment().getTerroristImage();
        g2d.drawImage(terroristImage, (int)position.getX()+45, (int)position.getY()+45, 40, 40, null);
        g2d.setColor(Color.RED);
        g2d.setStroke(bStroke);
        g2d.drawOval((int)position.getX(),(int)position.getY(), 125, 125);
        g2d.setColor(Color.blue);
        g2d.drawString("Terrorist", (float) position.getX()+36, (float) (int)position.getY()+45);  
       
        if (getStrategy() != null)
            g2d.drawString(getStrategy().getName(), (float) position.getX()+50, (float) (int)position.getY()+105);
 
    }
     

    @Override
    public void step(double deltaTime) {
       super.getStrategy().step(this,deltaTime);
    }

}