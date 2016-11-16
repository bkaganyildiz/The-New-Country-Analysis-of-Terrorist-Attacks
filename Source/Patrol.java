 
import java.util.*;

/**
 * 
 */
public class Patrol extends StepStrategy {

    /**
     * Default constructor
     */
    private Position target , pos , direction ; 
    public Patrol(Environment env ) {
        target = new Position() ; 
        setEnvironment(env);
        setNumberOfTurns(0);
        Random random = new Random()  ; 
        int min = env.getGPHeight(); 
        int max = env.getHeight(); 
        target.setY(random.nextInt((max - min) -19) + min) ;
        target.setX(random.nextInt(env.getWidth()-20)) ; 
    }



    /**
     * @param ...
     */
    public void patrol() {
        // TODO implement here
    }

    @Override
    public String getName() {
      return "P" ;
    }

    @Override
    public boolean isFinished() {
        return (getNumberOfTurns()>60) ; 
    }

    @Override
    public void step(Entity e, double deltaTime) 
    {
        pos = e.getPosition() ; 
        if(getNumberOfTurns() == 0 ) {
            direction = new Position(target.getX()-e.getPosition().getX(), target.getY()-e.getPosition().getY());

            direction.normalize();
            
            direction.multiplyPosition(deltaTime/20);
        }
        else if(target.distanceTo(pos)<30) { 
            direction.multiplyPosition(-1); 

            direction.normalize();
            
            direction.multiplyPosition(deltaTime/20);
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