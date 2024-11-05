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
        maxSpeed = 0.9; //Changed the max speed to 0.9
        speed = 0.5; //Changed the speed to 0.5
        hp = 2; //Changed the hp to 2
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
