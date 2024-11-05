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
        maxSpeed = 1.2; //Changed the max speed to 1.2
        speed = 0.7; //Changed the speed to 0.7
        hp = 3; //Changed the hp to 3
        damageToPlayer = 4; //Changed the damage to 4
    }
    
    public void attack(){
        if((Player) getOneIntersectingObject(Player.class) != null){
            
        }
    }
    
    public void damaged(){
        
    }
}
