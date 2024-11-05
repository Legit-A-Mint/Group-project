import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScrollableWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScrollableWorld extends Effects
{
    protected GreenfootImage worldImage;
    protected int moveSpeed;
    protected static final double WORLDSIZE = 2;
    public ScrollableWorld(){
        worldImage = new GreenfootImage((int)(1024 * WORLDSIZE), (int)(576 * WORLDSIZE));
        //worldImage.setColor(Color.GREEN);
        //worldImage.fill();
        worldImage = new GreenfootImage("bgtemp.png");
        setImage(worldImage);
        
        //set Movespeed (varies)
        moveSpeed = 5;
    }
    
    
    public void act()
    {
       if(Greenfoot.isKeyDown("w")){
           this.setLocation(this.getX(), this.getY() +1 * moveSpeed);  
       }
       if(Greenfoot.isKeyDown("a")){
           this.setLocation(this.getX() +1 * moveSpeed, this.getY());
       }
       if(Greenfoot.isKeyDown("s")){
           this.setLocation(this.getX(), this.getY() -1 * moveSpeed);
       }
       if(Greenfoot.isKeyDown("d")){
           this.setLocation(this.getX() -1 * moveSpeed, this.getY());
       }
    }
}
