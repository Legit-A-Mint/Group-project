import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Enemy extends Effects
{
    protected double maxSpeed, speed;
    protected int hp, damageToPlayer;
    protected Player player;
    
    private int x;
    private boolean removeMe;
    
    public Enemy(){
        removeMe = false;
    }
    
    public void act()
    {
        lookForTarget();
        setLocation(getX() + speed, getY() + speed);
        
        
        if(this.hp <= 0 ){
            removeMe = true;
        }
        
        if(removeMe){
            getWorld().removeObject(this);
        }
    }
    
    protected abstract void damaged();
    
    protected abstract void attack();
    
    
    
    public void lookForTarget(){
        if(!getWorld().getObjects(Player.class).isEmpty()){
            player = getWorld().getObjects(Player.class).get(0);
            turnTowards(player.getX(), player.getY());
        }
    }
    
    public void moveToTarget(){
        
    }
    
    /*
    public void attack(){
        if((Player) getIntersectingObjects(Player.class) != null){
            
        }
    }
    */
}
