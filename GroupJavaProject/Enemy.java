import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Enemy extends Effects
{
    private double relativeX, relativeY;
    protected double maxSpeed, speed;
    protected int hp, damageToPlayer;
    protected Player player;
    protected int dir;
    
    private boolean removeMe;
    private double speedX, speedY;
    
    private static final int MAX_SPAWN_DISTANCE = 350;
    private static final int MIN_SPAWN_DISTANCE = 100;
    
    protected int spawnX, spawnY;
    
    protected abstract boolean checkForCollision();
    public Enemy(){
        if(Greenfoot.getRandomNumber (2) % 2 == 0){
            spawnX  = Greenfoot.getRandomNumber (MAX_SPAWN_DISTANCE) + MIN_SPAWN_DISTANCE;
            spawnY = Greenfoot.getRandomNumber (MAX_SPAWN_DISTANCE) + MIN_SPAWN_DISTANCE;
        }else{
            spawnX  = Greenfoot.getRandomNumber (MAX_SPAWN_DISTANCE) + MIN_SPAWN_DISTANCE;
            spawnY = Greenfoot.getRandomNumber (MAX_SPAWN_DISTANCE) + MIN_SPAWN_DISTANCE;
            spawnX = -spawnX;
            spawnY = -spawnY;
        }
        removeMe = false;
        
        
        
        //enableStaticRotation();
    }
    
    public void act()
    {   
        dir = 1;
        speedX = speed;
        speedY = speed;
        
        lookForTarget();
        
        moveWithWorld();
        
        if(this.hp <= 0 ){
            removeMe = true;
        }
        
        if(removeMe){
            getWorld().removeObject(this);
        }
    }
    
    public abstract void damaged();
    
    public abstract void attack();
    
    public void lookForTarget(){
        if(!getWorld().getObjects(Player.class).isEmpty()){
            player = getWorld().getObjects(Player.class).get(0);
            turnTowards(player.getX(), player.getY());
            
            if(player.getX() < this.getX()){
                speedX = -speed;
                dir = -1;
            }
            if(player.getY() < this.getY()){
                speedY = -speed;
            }
        }
    }
   
   
    public void moveWithWorld(){
        ScrollableWorld sw = getWorld().getObjects(ScrollableWorld.class).get(0);
        
        relativeX += speedX;
        relativeY += speedY;
        
        //Sets the location of object based on the relative position in ScrollableWorld
        //SpawnX and SpawnY handles spawn location
        setLocation(sw.getX() + relativeX + spawnX, sw.getY() + relativeY + spawnY);
    }
    
    public void spawn(){
        
    }
    
    public void moveIndependantly(){
        
    }
}