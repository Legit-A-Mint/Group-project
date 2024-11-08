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
    
    private boolean isPlayer;
    
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
        
        isPlayer = false;
    }
<<<<<<< Updated upstream

    public Hitbox(int h, int w, int xOffset, int yOffset){
=======
    
    public Hitbox(int h, int w, int xOffset, int yOffset, Actor a, boolean player){
>>>>>>> Stashed changes
        box = new GreenfootImage(h, w);
        box.setColor(Color.RED);
        box.setTransparency(100); //less distracting when turned on
        if(visible){
            box.fill();
        }
        setImage(box);

        this.xOffset = xOffset;
        this.yOffset = yOffset;
<<<<<<< Updated upstream
=======
        actor = a;
        
        isPlayer = player;
>>>>>>> Stashed changes
    }

    public void act()
    {
        checkCollision();
<<<<<<< Updated upstream

        if(actor != null){
            moveWithActor();
        }
        else{
            moveWithRelativeWorld();
        }
    }  
=======
        moveWithActor();
    }
>>>>>>> Stashed changes

    private void moveWithActor(){
        setLocation(actor.getX() + xOffset, actor.getY() + yOffset);
    }

<<<<<<< Updated upstream
    private void moveWithRelativeWorld(){
        ScrollableWorld w = ((MyWorld)(getWorld())).getObjects(ScrollableWorld.class).get(0);
        setLocation(w.getX() + xOffset, w.getY() + xOffset);
    }

=======
>>>>>>> Stashed changes
    public boolean checkCollision(){
        return(this.isTouching(Hitbox.class));
    }
    
    public boolean returnPlayer(){
        return isPlayer;
    }
}
