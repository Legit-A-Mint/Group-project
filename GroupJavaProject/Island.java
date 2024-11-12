import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Island here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Island extends SuperSmoothMover
{
    private GreenfootImage img;
    private int relativeX, relativeY;
    private boolean createdHitBox;
    private Hitbox h;
    private boolean isBorder;
    
    public Island(int relX, int relY){
        relativeX = relX;
        relativeY = relY;

        img = new GreenfootImage(200, 200);     
        img.setColor(Color.GREEN);
        img.fill();
        setImage(img);
        createdHitBox = false;
    }
    
    public Island(int relX, int relY, int x){
        relativeX = relX;
        relativeY = relY;

        img = new GreenfootImage(200, 200);     
        img.setColor(Color.GREEN);
        img.fill();
        setImage(img);
        createdHitBox = false;
        
        isBorder = true;
    }

    public void act()
    {
        if(!createdHitBox && isBorder){
            h = new Hitbox(img.getWidth(), img.getHeight()-40, 0, 20, this, "Border");
            getWorld().addObject(h, this.getX(), this.getY());
            createdHitBox = true;
        }
        
        if(!createdHitBox){
            h = new Hitbox(img.getWidth(), img.getHeight()-40, 0, 20, this);
            getWorld().addObject(h, this.getX(), this.getY());
            createdHitBox = true;
        }
        moveWithWorld();
    }

    public void moveWithWorld(){
        ScrollableWorld sw = getWorld().getObjects(ScrollableWorld.class).get(0);

        //Sets the location of object based on the relative position in ScrollableWorld
        setLocation(sw.getX() + relativeX, sw.getY() + relativeY);
    }

    public Actor returnHitbox(){
        return h;
    }
}
