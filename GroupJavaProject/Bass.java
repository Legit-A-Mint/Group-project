import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bass here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bass extends Enemy
{
    public Bass(){
        maxSpeed = 0.5; // Has a max speed of 0.5
        speed = 0.3; // Has a regular speed of 0.3
        hp = 20; // Has 20 hitpoints
        damageToPlayer = 5; // Does 5 damage to the player
    }
    
    /* Bass has no other unique perks other then doing damage */
    public void attack(){
        if((Player) getOneIntersectingObject(Player.class) != null){
            
        }
    }
    
    public void damaged(){
        
    }
}
