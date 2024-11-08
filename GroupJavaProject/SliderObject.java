import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SliderObject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SliderObject extends Interface
{
    private int maxOffset;
    private int refX, refY; //refers to the reference point of Slider
 
    public SliderObject(int max, int refX, String image){
        setImage(new GreenfootImage(image));
        maxOffset = max;
        this.refX = refX;
    }
    public void act(){
        if (Greenfoot.mouseDragged(this)){
            MouseInfo m = Greenfoot.getMouseInfo();
            
            //Set a boundary for the slider, x position cannot exceed the maxOffset
            if(this.getX() <= refX + maxOffset && this.getX() >= refX - maxOffset){
                setLocation(m.getX(), this.getY());   
            }
            //If user goes too far above, set it down
            if(this.getX() >= refX + maxOffset){
                setLocation(refX + maxOffset - 1, this.getY());
            }
            else if(this.getX() <= refX - maxOffset){
                setLocation(refX - maxOffset + 1, this.getY());
            }
        }
    }
    
    
}
