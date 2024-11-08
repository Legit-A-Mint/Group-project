import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FishingRod here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FishingRod extends Item
{
    public FishingRod (int x, int y)
    {
        itemImage = new GreenfootImage("FishingRod.png");
        itemImage.scale(x,y);
        setImage(itemImage);
    }
    public void act()
    {
        // Add your action code here.
    }
}
