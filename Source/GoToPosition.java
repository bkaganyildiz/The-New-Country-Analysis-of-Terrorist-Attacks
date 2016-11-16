 
import java.util.*;

/**
 * 
 */
public class GoToPosition extends StepStrategy {

    /**
     * Default constructor
     */
    private Position target ; 
    private Position direction ; 

    public GoToPosition(Environment env) {
        setEnvironment(env);
    }

    /**
     * 
     */


    /**
     * @param ...
     */
    public void goToPosition(Environment env ) {
        setEnvironment(env);
        setNumberOfTurns(0);
        // TODO implement here
    }

    @Override
    public String getName() {
        return "GP" ; 
    }

    @Override
    public boolean isFinished() {
        return (getNumberOfTurns()>90) ; 
    }

    @Override
    public void step(Entity e, double deltaTime) {
         ArrayList<Entity> camps = new ArrayList<>() ; 
         camps = getEnvironment().getCamps() ; 
         ArrayList<Entity> storages = new ArrayList<>() ; 
         storages = getEnvironment().getStorages();
         double min = Double.MAX_VALUE; 
         // Burda eğer beyni yıkandıysa case i koy 
         Terrorist terror = (Terrorist) e ; 
        Entity tempKamp = new Camp(getEnvironment()) ; 
        Entity tempStore = new SupplyStorage(getEnvironment()) ;
         if(!terror.isIsBrainWashed()) {
            for(Entity kamp : camps) {
                double x1 = kamp.getPosition().getX() ; 
                double x2 = e.getPosition().getX() ;
                double y1 = kamp.getPosition().getY() ; 
                double y2 = e.getPosition().getY() ; 
                double a = Math.sqrt(x1*x2 + y1*y2) ;
                if(a<min){
                    min = a ;
                    tempKamp = kamp ; 
                }
            }
            target = tempKamp.getPosition() ; 
         }
         // buraya eğer bomba aldıysa case i 
         else {
            for(Entity storage : storages) {
                double x1 = storage.getPosition().getX() ; 
                double x2 = e.getPosition().getX() ;
                double y1 = storage.getPosition().getY() ; 
                double y2 = e.getPosition().getY() ; 
                double a = Math.sqrt(x1*x2 + y1*y2) ;
                if(a<min) {
                    min = a ;
                    tempStore = storage ; 
                } 
            }
            target = tempStore.getPosition() ; 
         }
        
        if(getNumberOfTurns()== 0){
            direction = new Position(target.getX()-e.getPosition().getX(), target.getY()-e.getPosition().getY());

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