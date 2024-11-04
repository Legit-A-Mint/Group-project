import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Enemy extends Effects
{
    protected double health, damage, attackSpeed, speed;
    
    public Enemy(double health, double damage, double attackSpeed, double speed){
        health = this.health;
        damage = this.damage;
        attackSpeed = this.attackSpeed;
        speed = this.speed;
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
