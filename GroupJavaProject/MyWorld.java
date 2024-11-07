import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * me
 * Version 1.0.0
 */
public class MyWorld extends World
{   
    private GreenfootImage img;
    private Player player;
    private Bass bass;
    private ScrollableWorld sw;
    
    private int waveCount, actCount;
    private boolean spawnOnce;
    
    public MyWorld(){  
        //create an unbounded world 
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
    }
    
    public void act(){
        actCount++;
        
        waveTracking();
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
                    for(int i = 0; i < 3; i++){
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
    
    public void spawning() {
        
    }
    
    public Player getPlayer(){
        return player; 
    }
    
    public ScrollableWorld getScrollWorld(){
        return sw;
    }
}
