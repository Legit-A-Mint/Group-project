import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * me
 * Version 1.0.4
 */
public class MyWorld extends World
{   
    private static int actCount;

    private GreenfootImage img;
    private Player player;
    private Bass bass;
    private ScrollableWorld sw;
    private Whale whale;

    private int waveCount;
    private boolean spawnOnce;
    private Slider slider;
    private Counter counter;

    private Button pauseButton;
    private static boolean acting;

    // https://pixabay.com/sound-effects/gentle-ocean-waves-fizzing-bubbles-64980/
    public static GreenfootSound ambientSound = new GreenfootSound("gentle_Ocean.mp3");

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

        acting = true;

        addObject(sw, this.getWidth()/2, this.getHeight()/2); 
        addObject(player, this.getWidth()/2, this.getHeight()/2);

        //addObject(new Button("test"), 600, 500);
        //addObject(new Button("test2", 100, 50, new Color[] {Color.BLACK, Color.RED, Color.BLUE}, true), 800, 500);
        pauseButton = new Button("PauseButton", new String[] {"db_1.png", "db_2.png", "db_3.png"}, true, 1);
        addObject(pauseButton, 55, 35);
        //addObject(new Button("test4", new String[] {"db_1.png", "db_2.png", "db_3.png"}, true, 1), 155, 470);
        //addObject(new Button("test5", new String[] {"db_1.png", "db_2.png", "db_3.png"}, true, 1), 255, 470);

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

        //temp islands
        addObject(new Island(300, -300), 0, 0);
        addObject(new Island(300, 300), 0, 0);
        addObject(new Island(-300, 300), 0, 0);
        addObject(new Island(-300, -300), 0, 0);
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

    public void started ()
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
        if (acting)
        {
            actCount++;

            if(actCount == 300){
                spawnOnce = true;
                waveCount++;
                actCount = 0;
            }

            //waveTracking();
            switch(waveCount) {
                case(0):

                // Manual wave simulator

            
                if(spawnOnce){
                    spawnOnce = false;
                    for(int i = 0; i < 2; i++){
                        addObject(new Bass(), -100, -100);
                    }

                    addObject(new Whale(), -100, -100);
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
        }

        if (Greenfoot.mouseClicked(pauseButton))
        {
            if (acting)
            {
                acting = false;
                ambientSound.pause();
            }
            else
            {
                acting = true;
                ambientSound.playLoop();
            }
        }
        //debug System out prints out non inspectables

        // System.out.print(....);
    }

    public Player getPlayer(){
        return player; 
    }

    public static int getActCount()
    {
        return actCount;
    }

    public static int getActNumber() {
        // return a number from 0 - 2
        return actCount % 3;
    }

    // Check if simulation is acting (false if "paused")
    public static boolean isActing()
    {
        return acting;
    }

    public static void setActing(boolean a)
    {
        acting = a;
    }
}
