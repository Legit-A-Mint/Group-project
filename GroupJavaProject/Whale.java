import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bass here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Whale extends Enemy
{
    public Whale(){
        maxSpeed = 0.2; //Changed the max speed to 0.2
        speed = 0.1; //Changed the speed to 0.1
        hp = 6; //Changed the hp to 6
        damageToPlayer = 5; //Changed the damage to 5
    }
    
    public void attack(){
        if((Player) getOneIntersectingObject(Player.class) != null){
            
        }
    }
    
    public void damaged(){
        
    }
}
