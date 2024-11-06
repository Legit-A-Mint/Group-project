import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bass here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Kracken extends Enemy
{
    public Kracken(){
        maxSpeed = 0.7; // Has a max speed to 0.7
        speed = 0.5; // Has a regular speed to 0.5
        hp = 40; // Has an hp of 40
        damageToPlayer = 10; // Does 10 damage to the player
    }
    
    /* Kracken will stun the player reducing the fire rate and movement speed by
       half.*/
    public void attack(){
        if((Player) getOneIntersectingObject(Player.class) != null){
            
        }
    }
    
    public void damaged(){
        
    }
}
