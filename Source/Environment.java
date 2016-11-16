 
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
/**
 * 
 */
public class Environment {

    /**
     * Default constructor
     */
    public Environment() {
    }

    /**
     * 
     */
    private ArrayList<Entity> citizens = new ArrayList<>(); 
    private ArrayList<Entity> terrorists= new ArrayList<>() ; 
    private ArrayList<Entity> agents = new ArrayList<>(); 
    private ArrayList<Entity> camps = new ArrayList<>(); 
    private ArrayList<Entity> storages = new ArrayList<>(); 
    private ArrayList<Entity> untouchables= new ArrayList<>() ; 
    private ArrayList<Entity> soldiers= new ArrayList<>() ;   
    /**
     * 
     */
    private int windowWidth;

    /**
     * 
     */
    private int windowHeight;

    /**
     * 
     */
    private int gamePlayHeight; 
    
    
    private int topPanelHeight , numberOfSteps=0 , deathTool =0 , caughtAgents =0 , caughtSoldiers=0;
    
    private AudioStream boom , bombPlanted,bombDefused ; 
    
    private BufferedImage tvChannels ;
    
    private BufferedImage turkeyMap ;
    
    private BufferedImage soldierImg ,agentImage ,terroristImage ,equipped , brain;

    public 

    Environment(int height, int width , int gpHeight , int nTerror ,String tvChan) {
        
        
            
        /*try
        {
            InputStream stream = new FileInputStream("countdown.mp3");
            countdown = new AudioStream(stream);
           
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        
        try
        {
            InputStream stream = new FileInputStream("f16.wav");
            f16 = new AudioStream(stream);
           
        }
        catch(Exception ex){
            ex.printStackTrace();
        }*/
        
        try
        {
            this.tvChannels = ImageIO.read(new File("src/Logo.gif"));
        }
        catch(IOException e)
        {
            this.tvChannels = null;
        }
        
        try
        {
            this.turkeyMap = ImageIO.read(new File("src/Map.gif"));
        }
        catch(IOException e)
        {
            this.turkeyMap = null;
        }
        try
        {
            this.soldierImg = ImageIO.read(new File("src/Soldier.gif"));
        }
        catch(IOException e)
        {
            this.soldierImg = null;
        }
        try
        {
            this.agentImage = ImageIO.read(new File("src/Agent.gif"));
        }
        catch(IOException e)
        {
            this.agentImage = null;
        }
        try
        {
            this.terroristImage = ImageIO.read(new File("src/Terrorist.gif"));
        }
        catch(IOException e)
        {
            this.terroristImage = null;
        }
        try
        {
            this.brain = ImageIO.read(new File("src/Brain.gif"));
        }
        catch(IOException e)
        {
            this.brain = null;
        }
        try
        {
            this.equipped = ImageIO.read(new File("src/Bomb.gif"));
        }
        catch(IOException e)
        {
            this.equipped = null;
        }
        windowWidth = turkeyMap.getWidth() ; 
        gamePlayHeight = tvChannels.getHeight() ; 
        windowHeight = turkeyMap.getHeight() + gamePlayHeight  ; 
        EntityFactory citizenFactory = new CitizenFactory() ;
        EntityFactory agentFactory = new AgentFactory() ;
        EntityFactory soldierFactory = new SoldierFactory() ; 
        EntityFactory terroristFactory = new TerroristFactory() ; 
        Random random = new Random()  ; 
        for(int i=0;i<15;i++) {
           this.citizens.add(createEntity(citizenFactory));
        }
        for(int i=0;i<3;i++) {
            this.agents.add(createEntity(agentFactory));
        }
        for(int i=0;i<3;i++) {
            this.soldiers.add(createEntity(soldierFactory));
        }
        for(int i=0;i<4;i++) {
            this.terrorists.add(terroristFactory.createEntity(this));
            //this.terrorists.add(createTerrorist());
        }
        for(int i=0;i<3;i++) {
            this.camps.add(new Camp(this));
            this.storages.add(new SupplyStorage(this));
        }
        for(int i=0;i<2;i++) {
            Position pos = new Position() ; 
           int min = this.getGPHeight(); 
           int max = this.getHeight(); 
           pos.setY(random.nextInt((max - min) -59) + min) ;
           pos.setX(random.nextInt(this.getWidth()-60)) ; 
           String fl = "src/Untouchable" + String.valueOf(i+1) + ".gif" ; 
           untouchables.add(new Untouchable(this,fl));
        }
        
        
        
    }
    
    public int getGPHeight() {
        return gamePlayHeight ; 
    }
    public void setGPHeight(int gph) {
        this.gamePlayHeight = gph ;
    }
    public int getHeight(){
        return windowHeight ; 
    }
    
    public void setHeight(int h) {
        windowHeight = h ; 
    }
    
    public int getWidth(){
        return windowWidth ; 
    }
    public void setWidth(int w) {
        windowWidth = w ; 
    }
    public ArrayList<Entity> getCitizens(){
        return citizens ; 
    }
    public ArrayList<Entity> getStorages(){
        return storages ; 
    }
    public ArrayList<Entity> getAgents(){
        return agents ; 
    }
    public ArrayList<Entity> getTerrorists(){
        return terrorists ; 
    }
    public void addTerrorists(Terrorist t){
        terrorists.add(t) ; 
    }
    public ArrayList<Entity> getSoldiers(){
        return soldiers ; 
    }
     public ArrayList<Entity> getUntouchables(){
        return untouchables ; 
    }
     public Terrorist createTerrorist() {
         Random random = new Random()  ; 
         Position pos = new Position() ;
         int min = this.getGPHeight(); 
         int max = this.getHeight(); 
         pos.setY(random.nextInt((max - min) -19) + min) ;
         pos.setX(random.nextInt(this.getWidth()-20)) ; 
         
         Terrorist newTerror = new RecentlyDeceived(pos,false,false,generateTerrorStrategy(),this) ; 
         return newTerror ;          
     }
   /* public int getNTerror(){
        return numberOfTerrorists ; 
    }
    public void setNTerror(int not) {
        numberOfTerrorists = not ; 
    }*/
    
    public BufferedImage getlogo(){
        return this.tvChannels ; 
    }
    public BufferedImage getMap(){
        return this.turkeyMap ; 
    }
    public BufferedImage getSoldierImage(){
        return this.soldierImg ; 
    }
    public BufferedImage getAgentImage(){
        return this.agentImage ; 
    }
    public BufferedImage getTerroristImage(){
        return this.terroristImage ; 
    }
    public void setLogo(BufferedImage tc) {
        tvChannels = tc ; 
    }
    public ArrayList<Entity> getCamps() {
        return camps ;
    }
    public void addCamps(Camp camp) {
        camps.add(camp) ; 
        
    }
        
    /**
     * @param f 
     * @return
     */
    
    public Entity createEntity(EntityFactory f) {
        return f.createEntity(this);
    }

    /**
     * @param e 
     * @return
     */
    public StepStrategy generateTerrorStrategy() {
        Random random = new Random() ;
        switch(random.nextInt(4))
        {
           case 0:
               return new StandStill(this);
           case 1:
               return new MoveRandom(this);
           case 2:
               return new MoveLinear(this) ;
           default:
               return new GoToPosition(this);
       }
    }
    public StepStrategy generateStrategy(Entity e) {
        Random random = new Random() ; 
        
        if(e instanceof Citizen){
            switch(random.nextInt(3))
             {
                case 0:
                    return new StandStill(this);
                case 1:
                    return new MoveLinear(this);
                default:
                    return new MoveRandom(this);
            }             
            
        }
        if(e instanceof Untouchable) {
            switch(random.nextInt(2))
             {
                case 0:
                    return new StandStill(this);
                default:
                    return new MoveLinear(this);
            }  
        } 
        if(e instanceof Soldier) {
            switch(random.nextInt(3))
             {
                case 0:
                    return new StandStill(this);
                case 1:
                    return new MoveLinear(this);
                default:
                    return new Patrol(this);
            }
        } 
        if(e instanceof Agent) {
            switch(random.nextInt(2))
             {
                case 0:
                    return new StandStill(this);
                default:
                    return new MoveRandom(this);
            }
        }
        
        return null;
    }

    /**
     * @param deltaTime 
     * @return
     */
    public int getStep() {
        return numberOfSteps;
    }
    public void getCaught() {
        Position temp = new Position() ; 
        Position temp2 = new Position() ;
        
        for(int i =0;i<agents.size();i++) {
            for(int j=0;j<terrorists.size();j++) {
                temp.setX(30+agents.get(i).getPosition().getX()); 
                temp.setY(30+agents.get(i).getPosition().getY());
                temp2.setX(60+terrorists.get(j).getPosition().getX()); 
                temp2.setY(60+terrorists.get(j).getPosition().getY());
                if(temp.distanceTo(temp2)<60) {
                    terrorists.remove(j);
                    j--;
                    caughtAgents++ ; 
                    try
                    {
                        SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {

                                try
                                {
                                    InputStream stream = new FileInputStream("src/BombDefused.wav");
                                    bombDefused = new AudioStream(stream);

                                }
                                catch(Exception ex){
                                    ex.printStackTrace();
                                }

                                AudioPlayer.player.start(bombDefused);

                        }
                        });

                    }
                    catch(Exception ex){
                        ex.printStackTrace();
                    }
                }
            }
        }
        for(int i =0;i<soldiers.size();i++) {
            for(int j=0;j<terrorists.size();j++) {
                temp.setX(30+soldiers.get(i).getPosition().getX()); 
                temp.setY(30+soldiers.get(i).getPosition().getY());
                temp2.setX(60+terrorists.get(j).getPosition().getX()); 
                temp2.setY(60+terrorists.get(j).getPosition().getY());
                if(temp.distanceTo(temp2)<60) {
                    terrorists.remove(j);
                    j--;
                    caughtSoldiers++ ; 
                    try
                    {
                        SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {

                                try
                                {
                                    InputStream stream = new FileInputStream("src/BombDefused.wav");
                                    bombDefused = new AudioStream(stream);

                                }
                                catch(Exception ex){
                                    ex.printStackTrace();
                                }

                                AudioPlayer.player.start(bombDefused);

                        }
                        });

                    }
                    catch(Exception ex){
                        ex.printStackTrace();
                    }
                }
            }
        }
    }
    
    public void checkRemoveEntities(Entity e) {
        
        if(e==null)
            return ; 
        double x1 = e.getPosition().getX() +60 ;
        double y1 = e.getPosition().getY() +60 ;
        double checker  ; 
        
        for(int i=0;i<this.agents.size();i++) {
            Entity k = agents.get(i) ; 
            checker = Math.sqrt((k.getPosition().getX()-x1)*(k.getPosition().getX()-x1) + (k.getPosition().getY()-y1)*(k.getPosition().getY()-y1)) ; 
            if(checker<60) {
                agents.remove(i);
                i--;
                deathTool++ ; 
            } 
        }
        for(int i=0;i<this.soldiers.size();i++) {
            Entity k = soldiers.get(i) ; 
            checker = Math.sqrt((k.getPosition().getX()+20-x1)*(k.getPosition().getX()+20-x1) + (k.getPosition().getY()+20-y1)*(k.getPosition().getY()+20-y1)) ; 
            if(checker<60) {
                soldiers.remove(i);
                i--;
                deathTool++ ;
            } 
        }
        for(int i=0;i<this.citizens.size();i++) {
            Entity k = citizens.get(i) ; 
            checker = Math.sqrt((k.getPosition().getX()-x1)*(k.getPosition().getX()-x1) + (k.getPosition().getY()-y1)*(k.getPosition().getY()-y1)) ; 
            if(checker<60) {
                citizens.remove(i);
                i--;
                deathTool++ ;
            } 
        }
        
        for(int i=0;i<this.terrorists.size();i++) {
            Entity k = terrorists.get(i) ; 
            checker = Math.sqrt((k.getPosition().getX()+60-x1)*(k.getPosition().getX()+60-x1) + (k.getPosition().getY()+60-y1)*(k.getPosition().getY()+60-y1)) ; 
            if(checker<60) {
                terrorists.remove(i);
                i--;
                deathTool++ ;
            } 
        }   
    } 
    public void stepAll(double deltaTime) {
        // TODO implement here
        numberOfSteps++ ; 
        Entity patlamisTerror = null ;
        for(Entity e : citizens ){
            if(e.getStrategy()==null || e.getStrategy().isFinished())
                e.setStrategy(generateStrategy(e)) ; 
            else 
                e.step(deltaTime);
        }
        for(Entity e : agents ){
            if(e.getStrategy()==null || e.getStrategy().isFinished())
                e.setStrategy(generateStrategy(e)) ; 
            else 
                e.step(deltaTime);
        }
        for(Entity e : terrorists ){
            if(e.getStrategy()==null || e.getStrategy().isFinished())
                e.setStrategy(generateTerrorStrategy()) ; 
            else 
                e.step(deltaTime);
            
            
            for(Entity kamp : this.camps) {
                double distanceDifference = Math.abs(e.getPosition().distanceTo(kamp.getPosition())) ;
                        
                if(e instanceof RecentlyDeceived && distanceDifference<100) {
                    int index = terrorists.indexOf(e);
                    Entity bw = (Entity) new BrainWashed((Terrorist)e) ;
                    System.out.println(((BrainWashed)bw).getDecoratedTerrorist() == null);
                    bw.setStrategy(generateTerrorStrategy());
                    terrorists.set(index,bw);
                 }
            }
            
            for(Entity kamp : this.storages) {
                double distanceDifference = Math.abs(e.getPosition().distanceTo(kamp.getPosition())) ;
                     
                if(e instanceof BrainWashed && (distanceDifference<100)) {
                    int index = terrorists.indexOf(e);
                    terrorists.set(index,(Entity) new Equipped((Terrorist)e));
                    try
                    {
                        SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {

                                try
                                {
                                    InputStream stream = new FileInputStream("src/BombPlanted.wav");
                                    bombPlanted = new AudioStream(stream);

                                }
                                catch(Exception ex){
                                    ex.printStackTrace();
                                }

                                AudioPlayer.player.start(bombPlanted);

                        }
                        });

                    }
                    catch(Exception ex){
                        ex.printStackTrace();
                    }
                      
                    
                }
            }
            Random random = new Random() ; 
            if(e instanceof Equipped && (random.nextInt(10)==1)) {
                patlamisTerror = e ; 
                System.out.println("Environment.stepAll()");
                try
                {
                    SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {

                            try
                            {
                                InputStream stream = new FileInputStream("src/Explode.wav");
                                boom = new AudioStream(stream);

                            }
                            catch(Exception ex){
                                ex.printStackTrace();
                            }

                            AudioPlayer.player.start(boom);

                    }
                    });

                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
                
                }
            
            
        }
        for(Entity e : untouchables ){
            if(e.getStrategy()==null || e.getStrategy().isFinished() )
                e.setStrategy(generateStrategy(e)) ; 
            else 
                e.step(deltaTime);
        }
        for(Entity e : soldiers ){
            if(e.getStrategy()==null || e.getStrategy().isFinished())
                e.setStrategy(generateStrategy(e)) ; 
            else 
                e.step(deltaTime);
        }
        checkRemoveEntities(patlamisTerror);
        getCaught();
    }

    /**
     * @return the equipped
     */
    public BufferedImage getEquipped() {
        return equipped;
    }

    /**
     * @return the brain
     */
    public BufferedImage getBrain() {
        return brain;
    }

    /**
     * @return the deathTool
     */
    public int getDeathTool() {
        return deathTool;
    }

    /**
     * @return the caughtAgents
     */
    public int getCaughtAgents() {
        return caughtAgents;
    }

    /**
     * @return the caughtSoldiers
     */
    public int getCaughtSoldiers() {
        return caughtSoldiers;
    }

}