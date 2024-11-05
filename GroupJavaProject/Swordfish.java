import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bass here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SwordFish extends Enemy
{
    public SwordFish(){
        maxSpeed = 1.4; // Has a max speed of 1.4
        speed = 0.9; // Has a regular speed of 0.9
        hp = 40; // Has an hp of 40
        damageToPlayer = 25; // Does 25 damage to the player
    }
    
    /* SwordFish has no other unique perks other then doing damage */
    public void attack(){
        if((Player) getOneIntersectingObject(Player.class) != null){
            
        }
    }
    
    public void damaged(){
        
    }
}
