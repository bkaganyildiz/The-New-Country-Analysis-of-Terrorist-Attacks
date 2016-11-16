 
import java.util.*;

/**
 * 
 */
public class MoveRandom extends StepStrategy {

    /**
     * Default constructor
     */
    private Environment env ; 
    private Position direction ; 
    public MoveRandom(Environment env) {
        setEnvironment(env); 
        setNumberOfTurns(0);
    }



    /**
     * @param ...
     */
    public void moveRandom() {
        // TODO implement here
    }

    @Override
    public String getName() {
        return "MR" ;
    }

    @Override
    public boolean isFinished() {
        return (getNumberOfTurns()>35) ;
    }

    @Override
    public void step(Entity e, double deltaTime) {
        Random random = new Random()  ; 
        int smooth =  random.nextInt(5) +3 ; 
        if(getNumberOfTurns() % smooth == 0){

            Position target= new Position() ;

            int x = e.getPosition().getX() ; 
            int y = e.getPosition().getY() ; 

            int min = getEnvironment().getGPHeight(); 
            int max = getEnvironment().getHeight(); 

            target.setY(random.nextInt((max - min) -19) + min) ;
            target.setX(random.nextInt(getEnvironment().getWidth()-20)) ; 

             
            if(target.getX()-e.getPosition().getX()>0 && target.getY()-e.getPosition().getY() >0){
                direction = new Position(target.getX()-e.getPosition().getX(), target.getY()-e.getPosition().getY());
                direction.normalize();
                direction.multiplyPosition(deltaTime/35);


            }
            else {
                direction = new Position(-target.getX()+e.getPosition().getX(), -target.getY()+e.getPosition().getY());
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
        }
        else {
            Position newPosition = new Position(direction.getX()+ e.getPosition().getX(), direction.getY() + e.getPosition().getY());
                if(newPosition.getX()>=0 && newPosition.getY()>=getEnvironment().getGPHeight()&& newPosition.getX()<=getEnvironment().getWidth() && newPosition.getY()<=getEnvironment().getHeight()){
                    e.setPosition(newPosition); 
            }
            else{
                setNumberOfTurns(getNumberOfTurns()+100);
            }
        }
        setNumberOfTurns(getNumberOfTurns() + 1); 
    }

}