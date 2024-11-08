import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bandage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bandage extends Item
{
    public Bandage (int x, int y)
    {
        /*
        itemImage = new GreenfootImage("Bandage.png");
        itemImage.scale(x,y);
        setImage(itemImage);
        */
        itemImage = new GreenfootImage(x, y);
        itemImage.setColor(Color.RED);
        itemImage.fill();
        setImage(itemImage);
    }

    public void act()
    {
        // Add your action code here.
    }
}
