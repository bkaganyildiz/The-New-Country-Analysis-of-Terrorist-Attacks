 
import java.util.*;

/**
 * 
 */
public class Position {

    /**
     * Default constructor
     */
    public Position() {
    }

    /**
     * 
     */
    private double x;

    /**
     * 
     */
    private double y;

    Position(double screenX, double screenY) {
         this.x = screenX; 
         this.y = screenY ; //To change body of generated methods, choose Tools | Templates.
    }
    public void Position(double screenX, double screenY) {
         this.x = screenX; 
         this.y = screenY ; //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * @param ...
     */
    public void Position() {
        // TODO implement here
    }

    

    /**
     * @return
     */
    
    public  int getX() {
        return (int) this.x ; 
    }
    public  int getY() {
        return (int) this.y ; 
    }
    public void setX(double x) {
        this.x = x ;
    }
    public void setY(double x ) {
        this.y = x ; 
    }
    public void normalize() {
        // TODO implement here
        double length = Math.sqrt(x*x + y*y);
        y = y / length;
        x = x / length;
    }
    public void addPosition(Position pos) {
        x += pos.getX() ; 
        y += pos.getY() ; 
    }
    public void multiplyPosition(double asd) {
        x *= asd ; 
        y *= asd ; 
    }
    /**
     * @param other 
     * @return
     */
    public double distanceTo(Position other) {
        // TODO implement here
        double distY = this.y - other.y;
        double distX = this.x - other.x;
        return Math.sqrt(distX*distX + distY*distY);
    }

    public boolean isClose(Position pos) {
        if(this.distanceTo(pos)<30)
           return true ; 
        else 
            return false ; 
    }
    

}