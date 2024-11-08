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
        
    }
    
     
    public void act(){
        actCount++;
        // System.out.println(getObjects(Hitbox.class).size());
        
        //waveTracking();
        switch(waveCount) {
            case(0):
            
                // Manual wave simulator
                /**
                if(actCount == 300){
                    spawnOnce = true;
                    actCount = 0;
                }
                */
                
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
