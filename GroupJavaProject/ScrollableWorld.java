import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class ScrollableWorld here.
 * 
 * @lumilk and Andrew
 * @1.0.0
 */
public class ScrollableWorld extends Effects
{
    protected GreenfootImage worldImage;
    protected int moveSpeedX, moveSpeedY;
    protected final double WORLDSIZEFACTOR = 1;
    private int lastDir;
    private int relativeX, relativeY;
    private int tolerance;

    private long getIntersectingObjectsTime;
    private boolean stopJittering;

    //test delete ltr
    private int testCounter;

    public ScrollableWorld(){
        //worldImage = new GreenfootImage((int)
        //(1024 * WORLDSIZEFACTOR), (int)(576 * WORLDSIZEFACTOR));
        //worldImage.setColor(Color.GREEN);
        //worldImage.fill();
        worldImage = new GreenfootImage("bgtemp.png");
        worldImage.scale((int)(worldImage.getWidth() * WORLDSIZEFACTOR), (int)(worldImage.getHeight() * WORLDSIZEFACTOR));
        setImage(worldImage);
        tolerance = 6;
        //set Movespeed (varies)
        moveSpeedX = 3;
        moveSpeedY = 3;
        stopJittering = false;
    }

    public void act()
    {
        testCounter++; 
        if(!stopJittering){
            
        }
    }

    public void moveWorld(String direction){
        if (MyWorld.isActing())
        {
            if(direction.toUpperCase().equals("UP")){
                this.setLocation(this.getX(), this.getY() + moveSpeedY);
            }
            if(direction.toUpperCase().equals("LEFT")){
                this.setLocation(this.getX() + moveSpeedX, this.getY());
                //set direction in player class
                (getWorld().getObjects(Player.class).get(0)).setDirection(-1);
            }
            if(direction.toUpperCase().equals("DOWN")){
                this.setLocation(this.getX(), this.getY() - moveSpeedY);
            }
            if(direction.toUpperCase().equals("RIGHT")){
                this.setLocation(this.getX() - moveSpeedX, this.getY());
                //set direction in player class
                (getWorld().getObjects(Player.class).get(0)).setDirection(1);
            }
        }
        
    }
    
    public void repel(){
        ArrayList<Hitbox> hitboxes = new ArrayList<Hitbox>();

        ArrayList<Hitbox> islandHitboxes = new ArrayList<Hitbox>();
        ArrayList<Actor> playerHitBoxes = new ArrayList<Actor>();
        // ArrayList<Hitbox> borderHitboxes = new ArrayList<Hitbox>();
        
        
        hitboxes = (ArrayList<Hitbox>) getWorld().getObjects(Hitbox.class);
        
        for(Hitbox i : hitboxes){
            if(i.getType() == "Player"){
                playerHitBoxes.add(i);
            }else{
                islandHitboxes.add(i);
            }
        }
        
        for(Hitbox a : islandHitboxes){
            GreenfootImage imgSizeObject = a.getImage();
            GreenfootImage imgSizeOfPlayer = playerHitBoxes.get(0).getImage();
            
            Actor p = playerHitBoxes.get(0);

            double xVectorToZero = p.getX() - p.getX();
            double yVectorToZero = p.getY() - p.getY();
            
            // System.out.println(a.getX() - imgSizeObject.getWidth()/2 - p.getX() - imgSizeOfPlayer.getWidth()/2 + tolerance);
            

            if(xVectorToZero >= a.getX() - imgSizeObject.getWidth()/2 - p.getX() - imgSizeOfPlayer.getWidth()/2 - tolerance
                && xVectorToZero <= a.getX() - imgSizeObject.getWidth()/2 - p.getX() + moveSpeedX
                    && yVectorToZero <= a.getY() + imgSizeObject.getHeight()/2 - p.getY() + imgSizeOfPlayer.getHeight()/2 + tolerance
                        && yVectorToZero >= a.getY() - imgSizeObject.getHeight()/2 - p.getY() - imgSizeOfPlayer.getHeight()/2 - tolerance){
                // rebound = moveSpeedX;
                System.out.println("moving right: " + (a.getX() - imgSizeObject.getWidth()/2 - p.getX() - imgSizeOfPlayer.getWidth()/2 - tolerance) 
                    + " : " + (a.getX() - imgSizeObject.getWidth()/2 - p.getX() + moveSpeedX));
                //stopJittering = true;
                
                this.setLocation(this.getX() + moveSpeedX, this.getY()); 
            }
            
            if(xVectorToZero <= a.getX() + imgSizeObject.getWidth()/2 - p.getX() + imgSizeOfPlayer.getWidth()/2 + tolerance
                && xVectorToZero >= a.getX() + imgSizeObject.getWidth()/2 - p.getX() - moveSpeedX
                    && yVectorToZero <= a.getY() + imgSizeObject.getHeight()/2 - p.getY() + imgSizeOfPlayer.getHeight()/2 + tolerance
                        && yVectorToZero >= a.getY() - imgSizeObject.getHeight()/2 - p.getY() - imgSizeOfPlayer.getHeight()/2 - tolerance){
                // rebound = moveSpeedX;
                System.out.println("moving left: " + (a.getX() + imgSizeObject.getWidth()/2 - p.getX() + imgSizeOfPlayer.getWidth()/2 + tolerance) 
                    + " : " + (a.getX() + imgSizeObject.getWidth()/2 - p.getX() - moveSpeedX));
                //stopJittering = true;

                this.setLocation(this.getX() - moveSpeedX, this.getY()); 
            }
            
            if(yVectorToZero <= a.getY() + imgSizeObject.getHeight()/2 - p.getY() + imgSizeOfPlayer.getHeight()/2 + tolerance
                && yVectorToZero >= a.getY() + imgSizeObject.getHeight()/2 - p.getY() - moveSpeedY
                    && xVectorToZero <= a.getX() + imgSizeObject.getWidth()/2 - p.getX() + imgSizeOfPlayer.getWidth()/2 + tolerance
                        && xVectorToZero >= a.getX() - imgSizeObject.getWidth()/2 - p.getX() - imgSizeOfPlayer.getWidth()/2 - tolerance){
                // rebound = moveSpeedX;
                //stopJittering = true;
                
                this.setLocation(this.getX(), this.getY() - moveSpeedY); 
            }
            
            if(yVectorToZero >= a.getY() - imgSizeObject.getHeight()/2 - p.getY() - imgSizeOfPlayer.getHeight()/2 - tolerance
                && yVectorToZero <= a.getY() - imgSizeObject.getHeight()/2 - p.getY() + moveSpeedY
                    && xVectorToZero <= a.getX() + imgSizeObject.getWidth()/2 - p.getX() + imgSizeOfPlayer.getWidth()/2 + tolerance
                        && xVectorToZero >= a.getX() - imgSizeObject.getWidth()/2 - p.getX() - imgSizeOfPlayer.getWidth()/2 - tolerance){
                // rebound = moveSpeedX;
                // stopJittering = true;
                
                this.setLocation(this.getX(), this.getY() + moveSpeedY); 
            }
            
            //
            
            if(xVectorToZero >= a.getX() - imgSizeObject.getWidth()/2 - p.getX() - imgSizeOfPlayer.getWidth()/2 - tolerance
                && xVectorToZero <= a.getX() - imgSizeObject.getWidth()/2 - p.getX() + moveSpeedX
                    && a.getType() == "Border"){
                // rebound = moveSpeedX;
                System.out.println("moving right: " + (a.getX() - imgSizeObject.getWidth()/2 - p.getX() - imgSizeOfPlayer.getWidth()/2 - tolerance) 
                    + " : " + (a.getX() - imgSizeObject.getWidth()/2 - p.getX() + moveSpeedX));
                //stopJittering = true;
                
                this.setLocation(this.getX() + moveSpeedX, this.getY()); 
            }
            
            if(xVectorToZero >= a.getX() - imgSizeObject.getWidth()/2 - p.getX() - imgSizeOfPlayer.getWidth()/2 - tolerance
                && xVectorToZero <= a.getX() - imgSizeObject.getWidth()/2 - p.getX() + moveSpeedX
                    && a.getType() == "Border"){
                // rebound = moveSpeedX;
                System.out.println("moving right: " + (a.getX() - imgSizeObject.getWidth()/2 - p.getX() - imgSizeOfPlayer.getWidth()/2 - tolerance) 
                    + " : " + (a.getX() - imgSizeObject.getWidth()/2 - p.getX() + moveSpeedX));
                //stopJittering = true;
                
                this.setLocation(this.getX() + moveSpeedX, this.getY()); 
            }
            
            if(xVectorToZero >= a.getX() - imgSizeObject.getWidth()/2 - p.getX() - imgSizeOfPlayer.getWidth()/2 - tolerance
                && xVectorToZero <= a.getX() - imgSizeObject.getWidth()/2 - p.getX() + moveSpeedX
                    && a.getType() == "Border"){
                // rebound = moveSpeedX;
                System.out.println("moving right: " + (a.getX() - imgSizeObject.getWidth()/2 - p.getX() - imgSizeOfPlayer.getWidth()/2 - tolerance) 
                    + " : " + (a.getX() - imgSizeObject.getWidth()/2 - p.getX() + moveSpeedX));
                //stopJittering = true;
                
                this.setLocation(this.getX() + moveSpeedX, this.getY()); 
            }
            
            if(xVectorToZero >= a.getX() - imgSizeObject.getWidth()/2 - p.getX() - imgSizeOfPlayer.getWidth()/2 - tolerance
                && xVectorToZero <= a.getX() - imgSizeObject.getWidth()/2 - p.getX() + moveSpeedX
                    && a.getType() == "Border"){
                // rebound = moveSpeedX;
                System.out.println("moving right: " + (a.getX() - imgSizeObject.getWidth()/2 - p.getX() - imgSizeOfPlayer.getWidth()/2 - tolerance) 
                    + " : " + (a.getX() - imgSizeObject.getWidth()/2 - p.getX() + moveSpeedX));
                //stopJittering = true;
                
                this.setLocation(this.getX() + moveSpeedX, this.getY()); 
            }
        }
    }
}
