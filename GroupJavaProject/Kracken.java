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
        maxSpeed = 0.3; //Changed the max speed to 0.2
        speed = 0.2; //Changed the speed to 0.1
        hp = 4; //Changed the hp to 4
        damageToPlayer = 3; //Changed the damage to 3
    }
    
    public void attack(){
        if((Player) getOneIntersectingObject(Player.class) != null){
            
        }
    }
    
    public void damaged(){
        
    }
}
