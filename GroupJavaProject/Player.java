import greenfoot.*;
import greenfoot.GreenfootImage;
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Effects
{
    protected GreenfootImage playerImage, reflectedPlayerImage;
    protected int direction;
    public Player(){
        playerImage = new GreenfootImage("shark.png");
        reflectedPlayerImage = new GreenfootImage("shark.png");
        reflectedPlayerImage.mirrorHorizontally();
        
        setImage(playerImage);
        direction = 1;
    }
    public void act(){
        if(direction == -1){
            setImage(reflectedPlayerImage);
        }
        else if (direction == 1){
            setImage(playerImage);
        }
        if(Greenfoot.isKeyDown("a")){
            direction = -1;
        }
        if(Greenfoot.isKeyDown("d")){
            direction = 1;
        }
    }
}
