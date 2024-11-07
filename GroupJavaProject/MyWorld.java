import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
        img = new GreenfootImage(this.getWidth(), this.getHeight());
        img.setColor(Color.BLUE);
        img.fill();
        setBackground(img);
        player = new Player();
        
        addObject(new ScrollableWorld(), this.getWidth()/2, this.getHeight()/2); 
        addObject(player, this.getWidth()/2, this.getHeight()/2);
    }
    
    public void act(){
        //debug System out prints out non inspectables
        
        // System.out.print(....);
        
        
    }
    
    public Player getPlayer(){
        return player; 
    }
}
