import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bass here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Piranha extends Enemy
{
    public Piranha(){
        maxSpeed = 0.6; // Has a max speed of 0.4
        speed = 0.4; // Has a regular speed of 0.2
        hp = 30; // Has an hp of 30
        damageToPlayer = 15; // Does 15 damage to the player
    }
    
    /* Piranha has no other unique perks other then doing damage */
    public void attack(){
        if((Player) getOneIntersectingObject(Player.class) != null){
            
        }
    }
    
    public void damaged(){
        
    }
}
