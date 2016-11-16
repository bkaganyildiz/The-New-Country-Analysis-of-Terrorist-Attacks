 

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.JDialog;

import javax.swing.JPanel;

/**
 * 
 */
public class Display extends JPanel {

    /**
     * Default constructor
     */
    
    private Environment environment ; 
    private BufferedImage turkeyMap  ; 
    private BufferedImage logo ; 
    private JButton pause , addTerrorists  ; 
    private boolean paused ; 
    
    public Display(Environment env) {
        super() ; 
        environment = env ;
        pause = new JButton("Pause") ; 
        pause.setToolTipText("Pause the game ! ");
        pause.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // display/center the jdialog when the button is pressed
                if(!paused){
                    paused = true ;
                    pause.setText("Resume");
                    pause.setToolTipText("Resume the game !");
                }
                else{
                    paused = false ; 
                    pause.setText("Pause");
                    pause.setToolTipText("Pause the game !");
                }
              
            }
        });
        addTerrorists = new JButton("Add Terrorist") ; 
        addTerrorists.setToolTipText("Add Random Terrorist Less Than 4 ! ");
        addTerrorists.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // display/center the jdialog when the button is pressed
                if(environment.getTerrorists().size()<=3) {
                    EntityFactory terroristFactory = new TerroristFactory() ; 
                    environment.addTerrorists((Terrorist) terroristFactory.createEntity(environment));
                }
              
            }
        });
        add (pause ) ; 
        add( addTerrorists );
        //setBackground(java.awt.Color.WHITE);
        /**/
    
        //turkeyMap = Toolkit.getDefaultToolkit().createImage("Map.gif") ;
    }
    public boolean getPaused() {
        return this.paused ; 
    }
        //logoPanel=new JPanel(){
    @Override
    public Dimension getPreferredSize(){
        // TODO implement here
        return new Dimension(environment.getWidth(),environment.getHeight());
    }
    @Override
    public void paintComponent(Graphics g) {
     super.paintComponent(g);
     Graphics2D g2d = (Graphics2D) g  ; 
     RenderingHints rt = new RenderingHints(
                 RenderingHints.KEY_TEXT_ANTIALIASING,
                 RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        RenderingHints ra = new RenderingHints(
                 RenderingHints.KEY_ANTIALIASING,
                 RenderingHints.VALUE_ANTIALIAS_ON);
        
     g2d.setRenderingHints(ra);
     g2d.setRenderingHints(rt);

     //Create Header 
 
     //Create The Line which separates the map with statics
     g2d.drawLine(0,environment.getGPHeight()-50, environment.getWidth(), environment.getGPHeight()-50);
     
     
     
     //Create the statistic part 
     Font defaultFont = g2d.getFont() ; 
     Font newFont = new Font("Arial",Font.PLAIN,17) ; 
     FontMetrics fn = g2d.getFontMetrics();
     
     g2d.setFont(newFont);
     
     
     //first column of statistics 
     g2d.setColor(java.awt.Color.MAGENTA);
     g2d.drawString("Death Toll   :      "+environment.getDeathTool(), (float) ((environment.getWidth())/40.0), (float) ((environment.getHeight())/15.0));
     g2d.setColor(java.awt.Color.CYAN);
     g2d.drawString("Citizens     :      " + environment.getCitizens().size(), (float) ((environment.getWidth())/40.0), (float) ((environment.getHeight())/9.0));
     g2d.setColor(java.awt.Color.GREEN);
     g2d.drawString("Soldiers     :       " + environment.getSoldiers().size(), (float) ((environment.getWidth())/40.0), (float) ((environment.getHeight())/6.5));
     //Second column of statistics
     g2d.setColor(java.awt.Color.BLUE);
     g2d.drawString("Agents     :      " + environment.getAgents().size(), (float) ((environment.getWidth())/3.5), (float) ((environment.getHeight())/9.0));
     g2d.setColor(java.awt.Color.GREEN);
     g2d.drawString("Terrorists :      "+environment.getTerrorists().size(), (float) ((environment.getWidth())/3.5),(float) ((environment.getHeight())/6.5));
     //Third column of statistics
     g2d.setColor(java.awt.Color.BLACK);
     g2d.drawString("Step                        :"+environment.getStep(), (float) ((environment.getWidth())/(1.75)), (float) ((environment.getHeight())/15.0));
     g2d.setColor(java.awt.Color.RED);
     g2d.drawString("Caught by Agents    :" + environment.getCaughtAgents(), (float) ((environment.getWidth())/(1.75)), (float) ((environment.getHeight())/9.0));
     g2d.setColor(java.awt.Color.RED);
     g2d.drawString("Caught by Soldier    :"+environment.getCaughtSoldiers(), (float) ((environment.getWidth())/(1.75)), (float) ((environment.getHeight())/6.5));
     
     
     //Create the Logo which shows the tv channels
     logo = environment.getlogo() ; 
     if(logo!=null){
         int ew = environment.getWidth() ; 
         int eh = environment.getHeight();
         int lw = logo.getWidth() ; 
         int lh = logo.getHeight() ; 
         g2d.drawImage(logo, ew-lw, -25 , lw, lh, null) ; 
     }
     turkeyMap = environment.getMap() ; 
     if(turkeyMap!=null){
         int ew = environment.getWidth() ; 
         int eh = environment.getHeight();
         int lh = environment.getGPHeight() ; 
         g2d.drawImage(turkeyMap, 0, lh-50, ew, eh-200,  null);
     }
    
     for(Entity e : environment.getCamps()) {
         AffineTransform old = g2d.getTransform();
         e.draw(g2d);
         g2d.setTransform(old);
     }
     for(Entity e : environment.getStorages()) {
         AffineTransform old = g2d.getTransform();
         e.draw(g2d);
         g2d.setTransform(old);
     }
     for(Entity e : environment.getCitizens()) {
         AffineTransform old = g2d.getTransform();
         e.draw(g2d);
         g2d.setTransform(old);
     }
     for(Entity e : environment.getAgents()) {
         AffineTransform old = g2d.getTransform();
         e.draw(g2d);
         g2d.setTransform(old);
     }
     for(Entity e : environment.getSoldiers()) {
         AffineTransform old = g2d.getTransform();
         e.draw(g2d);
         g2d.setTransform(old);
     }
      for(Entity e : environment.getUntouchables()) {
         AffineTransform old = g2d.getTransform();
         e.draw(g2d);
         g2d.setTransform(old);
     }
      for(Entity e : environment.getTerrorists()) {
         AffineTransform old = g2d.getTransform();
         e.draw(g2d);
         g2d.setTransform(old);
     }
       
    }
}