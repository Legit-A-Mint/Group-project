import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FishingNet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FishingNet extends Item
{
    public FishingNet (int x, int y)
    {
        itemImage = new GreenfootImage("FishingNet.png");
        itemImage.scale(x,y);
        setImage(itemImage);
    }
    public void act()
    {
        // Add your action code here.
    }
}
