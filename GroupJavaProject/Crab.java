import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bass here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Crab extends Enemy
{
    public Crab(){
        maxSpeed = 0.6; //Changed the max speed to 0.4
        speed = 0.3; //Changed the speed to 0.2
        hp = 3; //Changed the hp to 3
        damageToPlayer = 2; //Changed the damage to 2
    }
    
    public void attack(){
        if((Player) getOneIntersectingObject(Player.class) != null){
            
        }
    }
    
    public void damaged(){
        
    }
    public void attack(){
        
    }
    public void damaged(){
        
    }
}
