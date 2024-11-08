import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Harpoon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spear extends Item
{
    public Spear (int x, int y)
    {
        itemImage = new GreenfootImage("Spear.png");
        itemImage.scale(x,y);
        setImage(itemImage);
    }
    public void act()
    {
        // Add your action code here.
    }
}
