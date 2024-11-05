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
        maxSpeed = 1; //Changed the max speed to 1
        speed = 0.5; //Changed the speed to 0.5
        hp = 1; //Changed the hp to 1
        damageToPlayer = 3; //Changed the damage to 3
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
