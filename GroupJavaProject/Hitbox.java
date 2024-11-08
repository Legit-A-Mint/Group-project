import greenfoot.*;
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
    public Hitbox(int h, int w, int xOffset, int yOffset){
        box = new GreenfootImage(h, w);
        box.setColor(Color.RED);
        box.setTransparency(100); //less distracting when turned on
        if(visible){
            box.fill();
        }
        setImage(box);
        
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        
        isPlayer = false;
    }
    
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
    
    public Hitbox(int h, int w, int xOffset, int yOffset, Actor a, boolean player){
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
        
        isPlayer = player;
    }

    public void act()
    {
        //checkCollision();
        if(actor != null){
            moveWithActor();
        }
        else{
            moveWithRelativeWorld();
        }
    }  

    private void moveWithActor(){
        setLocation(actor.getX() + xOffset, actor.getY() + yOffset);
    }

    private void moveWithRelativeWorld(){
        ScrollableWorld w = ((MyWorld)(getWorld())).getObjects(ScrollableWorld.class).get(0);
        setLocation(w.getX() + xOffset, w.getY() + yOffset);
    }

    public boolean checkCollision(){
        return(this.isTouching(Hitbox.class));
    }
    
    public boolean returnPlayer(){
        return isPlayer;
    }
}
