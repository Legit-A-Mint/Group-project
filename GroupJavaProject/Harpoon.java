import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Harpoon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Harpoon extends Item
{
    public Harpoon (int x, int y)
    {
        /*
        itemImage = new GreenfootImage("Harpoon.png");
        itemImage.scale(x,y);
        setImage(itemImage);
        */
        itemImage = new GreenfootImage(x, y);
        itemImage.setColor(Color.BLUE);
        itemImage.fill();
        setImage(itemImage);
    }
    public void act()
    {
        // Add your action code here.
    }
}
