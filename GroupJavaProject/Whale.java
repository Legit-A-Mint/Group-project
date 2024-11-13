import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bass here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Whale extends Enemy
{
    private GreenfootImage[] img = new GreenfootImage[1];
    
    
    public Whale(){
        maxSpeed = 0.7; // Has a max speed of 0.2
        speed = 0.7; // Has a regular speed of 0.1
        hp = 200; // Has an hp of 200
        damageToPlayer = 75; // Does 75 damage to the player
        
        img[0] = new GreenfootImage("idlewhale.png");
        
        setImage(img[0]);
    }
    
    public void act(){
        super.act();
        // takes dir from super class
        animate(this, img, img[0].getWidth(), img[0].getHeight(), 16, dir);
    }
    /* Whale has no other unique perks other then doing damage */
    public void attack(){
        if((Player) getOneIntersectingObject(Player.class) != null){
            
        }
    }
    
    public void damaged(){
        
    }
    
    public boolean checkForCollision(){
       return false; 
    }
}
