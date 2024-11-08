import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * me
 * Version 1.0.0
 */
public class MyWorld extends World
{   
    private GreenfootImage img;
    private Player player;
    
    public MyWorld(){  
        //create an unbounded world 
        super(1024, 576, 1, false);
        img = new GreenfootImage(getWidth(), getHeight());
        img.setColor(Color.BLUE);
        img.fill();
        setBackground(img);
        player = new Player();
        
        addObject(new ScrollableWorld(), getWidth()/2, getHeight()/2); 
        addObject(player, getWidth()/2, getHeight()/2);
        drawShopItems();
    }
    
    public void drawShopItems()
    {
        // will make arraylist soon
        addObject(new Bandage(60,60), getWidth()/2, getHeight()-50);
        addObject(new FishingNet(60,60), getWidth()/2 - 100, getHeight()-50);
        addObject(new Harpoon(60,60), getWidth()/2 - 200, getHeight()-50);
    }
    
    public void act(){
        //debug System out prints out non inspectables
        
        // System.out.print(....);
        
        
    }
    
    public Player getPlayer(){
        return player; 
    }
}
