import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * me
 * Version 1.0.4
 */
public class MyWorld extends World
{   
    private GreenfootImage img;
    private Player player;
    private Bass bass;
    private ScrollableWorld sw;
    private Whale whale;
    
    private int waveCount, actCount;
    private boolean spawnOnce;
    private Slider slider;
    private Counter counter;
    
    public static GreenfootSound ambientSound = new GreenfootSound("auughhh.mp3");
    
    public MyWorld(){  
        //create an unbounded world 
        super(1024, 576, 1, false);
        img = new GreenfootImage(getWidth(), getHeight());
        img.setColor(Color.BLUE);
        img.fill();
        setBackground(img);
        player = new Player();
        sw = new ScrollableWorld();
        
        waveCount = 0;
        actCount = 0;
        spawnOnce = true;
        
        
        addObject(sw, this.getWidth()/2, this.getHeight()/2); 
        addObject(player, this.getWidth()/2, this.getHeight()/2);
        
        //addObject(new Button("test"), 600, 500);
        //addObject(new Button("test2", 100, 50, new Color[] {Color.BLACK, Color.RED, Color.BLUE}, true), 800, 500);
        addObject(new Button("test3", new String[] {"db_1.png", "db_2.png", "db_3.png"}, true, 1), 55, 470);
        addObject(new Button("test4", new String[] {"db_1.png", "db_2.png", "db_3.png"}, true, 1), 155, 470);
        addObject(new Button("test5", new String[] {"db_1.png", "db_2.png", "db_3.png"}, true, 1), 255, 470);
        
        //slider and counter
        slider = new Slider("TestSlider", "rail.png", "circle.png", 1, 130);
        addObject(slider, 155, 540);
        counter = new Counter("Counter", "db_1.png", 1, true, 360, 540);
        //addObject(counter, 360, 540);
        
        //border hitboxes
        addObject(new Hitbox(getObjects(ScrollableWorld.class).get(0).getImage().getWidth(), 100, 0, -((getObjects(ScrollableWorld.class).get(0).getImage().getHeight())/2) - 50), 0, 0);
        addObject(new Hitbox(getObjects(ScrollableWorld.class).get(0).getImage().getWidth(), 100, 0, ((getObjects(ScrollableWorld.class).get(0).getImage().getHeight())/2) + 50), 0, 0);
        addObject(new Hitbox(100, getObjects(ScrollableWorld.class).get(0).getImage().getHeight(), (-(getObjects(ScrollableWorld.class).get(0).getImage().getWidth())/2) - 50, 0), 0, 0);
        addObject(new Hitbox(100, getObjects(ScrollableWorld.class).get(0).getImage().getHeight(), ((getObjects(ScrollableWorld.class).get(0).getImage().getWidth())/2) + 50, 0), 0, 0);
        
        /**
        addObject(new Hitbox(200, 200, 250, -250), 0, 0);
        addObject(new Hitbox(200, 200, -250, -250), 0, 0);
        addObject(new Hitbox(200, 200, 250, 250), 0, 0);
        addObject(new Hitbox(200, 200, -250, 250), 0, 0);
        */
        
        //always have ui elements above the simulation
        setPaintOrder(Interface.class, Hitbox.class);
        
        //addObject(new ScrollableWorld(), getWidth()/2, getHeight()/2); 
        //addObject(player, getWidth()/2, getHeight()/2);
        //drawShopItems();
    }
    
    public void addedToWorld ()
    {
        // Plays the ambient noise in a loop
        ambientSound.playLoop();
    }
    
    public void stopped ()
    {
        // Stops playing the ambient noises when simulation is paused
        ambientSound.pause();
    }
    
    public void act(){
        actCount++;
        
        //waveTracking();
        switch(waveCount) {
            case(0):
            
                // Manual wave simulator
                
                if(actCount == 300){
                    spawnOnce = true;
                    waveCount++;
                    actCount = 0;
                }
                
                
                if(spawnOnce){
                    spawnOnce = false;
                    for(int i = 0; i < 2; i++){
                        addObject(new Bass(), -100, -100);
                    }
                }
                break;
                
            case(1):
            
                if(spawnOnce){
                    spawnOnce = false;
                    for(int i = 0; i < 3; i++){
                        addObject(new Bass(), -100, -100);
                    }
                }
            
            
            case(2):
            
                if(spawnOnce){
                    spawnOnce = false;
                    for(int i = 0; i < 3; i++){
                        addObject(new Bass(), -100, -100);
                    }
                }
            
            
            case(3):
            
            
            case(4):
            
            
            case(5):
            
            
            case(6):
        }

        //debug System out prints out non inspectables
        
        // System.out.print(....);
    }
    
    public Player getPlayer(){
        return player; 
    }
}
