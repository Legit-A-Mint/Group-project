import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * me
 */
public class MyWorld extends World
{   
    private GreenfootImage img;
    
    public MyWorld(){  
        //create an unbounded world 
        super(1024, 576, 1, false);
        img = new GreenfootImage(this.getWidth(), this.getHeight());
        img.setColor(Color.BLUE);
        img.fill();
        setBackground(img);
    }
    
    public void act(){
        //debug System out prints out non inspectables
        
        // System.out.print(....);
        
        
    }
}
