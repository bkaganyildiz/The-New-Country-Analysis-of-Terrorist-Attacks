 
import java.util.*;

/**
 * 
 */
public class MoveLinear extends StepStrategy {
    
    
    private Position target ; 
    private Position direction ; 

    MoveLinear(Environment env) {
        Random random = new Random()  ; 
        this.target= new Position() ;
        int min = env.getGPHeight(); 
        int max = env.getHeight(); 
        this.target.setY(random.nextInt((max - min) -19) + min) ;
        this.target.setX(random.nextInt(env.getWidth()-20)) ; 
        setEnvironment(env);
        setNumberOfTurns(0);
    }

    /**
     * Default constructor
     */
 

    /**
     * @param ...
     */

    @Override
    public String getName() {
        return "ML" ;
    }

     @Override
    public boolean isFinished() {
        return (getNumberOfTurns()>40) ; 
    }

    @Override
    public void step(Entity e, double deltaTime) {
         
        
        if(getNumberOfTurns()== 0){
            direction = new Position(target.getX()-e.getPosition().getX(), target.getY()-e.getPosition().getY());

            direction.normalize();
            
            direction.multiplyPosition(deltaTime/35);
        }
        
       
        
        Position newPosition = new Position(direction.getX()+ e.getPosition().getX(), direction.getY() + e.getPosition().getY());
        if(newPosition.getX()>=0 && newPosition.getY()>=getEnvironment().getGPHeight()&& newPosition.getX()<=getEnvironment().getWidth() && newPosition.getY()<=getEnvironment().getHeight()){
            e.setPosition(newPosition); 
        }
        else{
            setNumberOfTurns(getNumberOfTurns()+100);
        }
           
        setNumberOfTurns(getNumberOfTurns() + 1);        
              
    }

}