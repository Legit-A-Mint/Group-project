import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bass here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shark extends Enemy
{
    public Shark(){
        maxSpeed = 1.2; // Has a max speed of 1.2
        speed = 0.7; // Has a regular speed of 0.7
        hp = 50; // Has an hp of 50
        damageToPlayer = 30; // Does 30 damage to the player
    }
    
    /* Shark ahs no other unique perks other then doing damage */
    public void attack(){
        if((Player) getOneIntersectingObject(Player.class) != null){
            
        }
    }
    
    public void damaged(){
        
    }
}
