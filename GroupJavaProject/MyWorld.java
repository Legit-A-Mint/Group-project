import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * me
 * Version 1.0.3
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
<<<<<<< HEAD
    private Slider slider;
    private Counter counter;
=======
>>>>>>> 9c89a9a7b6de298c8da53c7c85f8600a0e44ab06
    
    public MyWorld(){  
        //create an unbounded world 
        //width and height create the viewport
        super(1024, 576, 1, false);
        img = new GreenfootImage(this.getWidth(), this.getHeight());
        img.setColor(Color.BLUE);
        img.fill();
        setBackground(img);
        player = new Player();
        sw = new ScrollableWorld();
<<<<<<< HEAD
        
        waveCount = -1;
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
                
        
        //temp islands
        addObject(new Island(300, -300), 0, 0);
        addObject(new Island(300, 300), 0, 0);
        addObject(new Island(-300, 300), 0, 0);
        addObject(new Island(-300, -300), 0, 0);
        
        //always have ui elements above the simulation
        setPaintOrder(Interface.class, Hitbox.class);
        
        //addObject(new ScrollableWorld(), getWidth()/2, getHeight()/2); 
        //addObject(player, getWidth()/2, getHeight()/2);
        //drawShopItems();
    }
    
    public void drawShopItems()
    {
        // will make arraylist soon
        addObject(new Bandage(60,60), getWidth()/2, getHeight()-50);
        addObject(new FishingNet(60,60), getWidth()/2 - 100, getHeight()-50);
        addObject(new Harpoon(60,60), getWidth()/2 - 200, getHeight()-50);
=======
        
        waveCount = -1;
        actCount = 0;
        spawnOnce = true;
        
        
        addObject(sw, this.getWidth()/2, this.getHeight()/2); 
        addObject(player, this.getWidth()/2, this.getHeight()/2);
        
        //addObject(new Button("test"), 600, 500);
        //addObject(new Button("test2", 100, 50, new Color[] {Color.BLACK, Color.RED, Color.BLUE}, true), 800, 500);
        addObject(new Button("test3", new String[] {"pb_1.png", "pb_2.png", "pb_3.png"}, true, 1), 55, 470);
        addObject(new Button("test4", new String[] {"pb_1.png", "pb_2.png", "pb_3.png"}, true, 1), 155, 470);
        addObject(new Button("test5", new String[] {"pb_1.png", "pb_2.png", "pb_3.png"}, false, 1), 255, 470);
        addObject(new Slider("TestSlider", "rail.png", "circle.png", 1, 130), 155, 540);
        
        //temp islands
        addObject(new Island(300, -300), 0, 0);
        addObject(new Island(300, 300), 0, 0);
        addObject(new Island(-300, 300), 0, 0);
        addObject(new Island(-300, -300), 0, 0);
        // addObject(new Hitbox(200, 200, 200, 340), 0, 0);
        
        //always have ui elements above the simulation
        setPaintOrder(Interface.class, Hitbox.class);
        
>>>>>>> 9c89a9a7b6de298c8da53c7c85f8600a0e44ab06
    }
    
     
    public void act(){
        actCount++;
<<<<<<< HEAD
=======
        // System.out.println(getObjects(Hitbox.class).size());
>>>>>>> 9c89a9a7b6de298c8da53c7c85f8600a0e44ab06
        
        //waveTracking();
        switch(waveCount) {
            case(0):
            
                // Manual wave simulator
<<<<<<< HEAD
                
=======
                /**
>>>>>>> 9c89a9a7b6de298c8da53c7c85f8600a0e44ab06
                if(actCount == 300){
                    spawnOnce = true;
                    actCount = 0;
                }
<<<<<<< HEAD
                
=======
                */
>>>>>>> 9c89a9a7b6de298c8da53c7c85f8600a0e44ab06
                
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
<<<<<<< HEAD

        //debug System out prints out non inspectables
        
        // System.out.print(....);
=======
        //debug System out prints out non inspectables
        
        
>>>>>>> 9c89a9a7b6de298c8da53c7c85f8600a0e44ab06
    }
    
    public void waveTracking(){
        if(actCount >= 1500 || waveClear()){
            spawnOnce = true;
            waveCount++;
            actCount = 0;
        }
    }    
    
    public boolean waveClear()
    {
        if(getObjects(Enemy.class).size() == 0){
            return true;
        }else{
            return false;
        }
    }
    
}
