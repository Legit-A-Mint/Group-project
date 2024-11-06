import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bass here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pufferfish extends Enemy
{
    public Pufferfish(){
        maxSpeed = 1; // Has a max speed of 1
        speed = 0.5; // Has a regular speed of 0.5
        hp = 30; // Has an hp of 30
        damageToPlayer = 10; // Does 10 damage to the player
    }
    
    /* Pufferfish will do a total of 25 damage. 10 damage when it first hit the
       player, and another 15 damage over the span of 5 seconds.*/
    public void attack(){
        if((Player) getOneIntersectingObject(Player.class) != null){
            
        }
    }
    
    public void damaged(){
        
    }
}
