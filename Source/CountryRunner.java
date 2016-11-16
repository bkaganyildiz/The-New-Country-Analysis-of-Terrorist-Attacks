/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.* ;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


/**
 *
 * @author kagan
 */
public class CountryRunner {

    /**
     * @param args the command line arguments
     */
    public static Environment environment;
    public static Display display;
    public static JFrame frame;
    
    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame() ; 
        Dimension asd = Toolkit.getDefaultToolkit().getScreenSize();
        Environment environment= new Environment((int)asd.getHeight(),(int)asd.getWidth(),150,3,"Logo.gif") ; // main'edn gelen args a göre yap  
        Display display = new Display(environment) ;  
        frame = new JFrame("Terrorist Attacks") ;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(display);
        frame.setSize(environment.getWidth(),environment.getHeight())  ; 
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("src/cs_icon.gif"));
        } catch (IOException ex) {
            System.out.println("CountryRunner.main()");
        }
        frame.setIconImage(image);
        frame.setVisible(true);
        
        while (true) {
            if(!display.getPaused())
                environment.stepAll(50d);
            
            display.repaint();
            Thread.sleep(50);
        }  
    }

    private static void setIconImage(Image image) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
