import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bass here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bass extends Enemy
{
    private GreenfootImage img;

    public Bass(){
        img = new GreenfootImage("shark.png");
        setImage(img);
        
        maxSpeed = 0.5; // Has a max speed of 0.5
        speed = 0.3; // Has a regular speed of 0.3
        hp = 20; // Has 20 hitpoints
        damageToPlayer = 5; // Does 5 damage to the player
        
    }
    public void act(){
        moveWithWorld();
    }
    /* Bass has no other unique perks other then doing damage */
    public void attack(){
        if((Player) getOneIntersectingObject(Player.class) != null){
            
        }
    }
    
    public void damaged(){
        
    }
    
    public void moveWithWorld(){
        ScrollableWorld sw = ((MyWorld)getWorld()).getScrollWorld();
        
        setLocation(sw.getX() + 100, sw.getY() + 100);
    }
}
