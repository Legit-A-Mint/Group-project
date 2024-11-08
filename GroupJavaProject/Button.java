import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Interface
{
    private int buttonType;
    
    public Button(int type){
    }
    public void act()
    {
        isClicked();
    }
    
    public boolean isClicked(){
        if(Greenfoot.mouseClicked(this)){
            System.out.println("Clicked Button");
            return true;
        }
        else{ 
            return false;
        }
    }
   
}
