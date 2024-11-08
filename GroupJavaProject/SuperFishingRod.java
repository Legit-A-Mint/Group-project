import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SuperFishingRod here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SuperFishingRod extends Item
{
    public SuperFishingRod (int x, int y)
    {
        itemImage = new GreenfootImage("SuperFishingRod.png");
        itemImage.scale(x,y);
        setImage(itemImage);
    }
    public void act()
    {
        // Add your action code here.
    }
}
