import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Enemy extends Effects
{
    protected int relativeX, relativeY;
    protected double maxSpeed, speed;
    protected int hp, damageToPlayer;
    protected Player player;
    
    private boolean removeMe;
    
    public Enemy(){
        removeMe = false;
    }
    
    public void act()
    {
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
        }
    }
    public void moveWithWorld(){
        ScrollableWorld sw = ((MyWorld)getWorld()).getScrollWorld();
        
        setLocation(sw.getX() + 100, sw.getY() + 100);
    }
    
    public void spawn(){
        
    }
}