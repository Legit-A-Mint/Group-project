import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Full hitbox class
 * 
 * @lumilk
 * @1.0.0
 */
public class Hitbox extends SuperSmoothMover
{
    private GreenfootImage box;
    private Actor actor;
    private int xOffset, yOffset;
    private static final boolean visible = true;
    public Hitbox(int h, int w, int xOffset, int yOffset, Actor a){
        box = new GreenfootImage(h, w);
        box.setColor(Color.RED);
        box.setTransparency(100); //less distracting when turned on
        if(visible){
             box.fill();
        }
        setImage(box);
        
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        actor = a;
    }
    public void act()
    {
        checkCollision();
        moveWithActor();
    }
    private void moveWithActor(){
        setLocation(actor.getX() + xOffset, actor.getY() + yOffset);
    }
    public boolean checkCollision(){
        return(this.isTouching(Hitbox.class));
    }
}
