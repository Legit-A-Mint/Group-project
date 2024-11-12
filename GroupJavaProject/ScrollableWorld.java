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
        tolerance = 7;
        //set Movespeed (varies)
        moveSpeedX = 6;
        moveSpeedY = 6;
        stopJittering = false;
    }

    public void act()
    {
        testCounter++; 
        stopJittering = false;

<<<<<<< Updated upstream
        moveWorld("DEBUG");

=======
        //handleCollision();
        
        if(!stopJittering){
            moveWorld("MANUAL");
            moveWorld("DEBUG");
        }
>>>>>>> Stashed changes
    }

    //will have direction parameters
    public void moveWorld(String direction){
        //manual movement mode, for debugging
        if(direction.toUpperCase().equals("DEBUG")){
            if(Greenfoot.isKeyDown("w")){
                this.setLocation(this.getX(), this.getY() + moveSpeedY);  
                lastDir = 1;
            }
            if(Greenfoot.isKeyDown("a")){
                this.setLocation(this.getX() + moveSpeedX, this.getY());
                lastDir = 2;
            }
            if(Greenfoot.isKeyDown("s")){
                this.setLocation(this.getX(), this.getY() - moveSpeedY);
                lastDir = 3;
            }
            if(Greenfoot.isKeyDown("d")){
                this.setLocation(this.getX() - moveSpeedX, this.getY());
                lastDir = 4;
            } 
        }

        if(direction.toUpperCase().equals("UP")){
            this.setLocation(this.getX(), this.getY() + moveSpeedY);  
            lastDir = 1;
        }
        if(direction.toUpperCase().equals("LEFT")){
            this.setLocation(this.getX() + moveSpeedX, this.getY());
            //set direction in player class
            (getWorld().getObjects(Player.class).get(0)).setDirection(-1);
            lastDir = 2; 
        }
        if(direction.toUpperCase().equals("DOWN")){
            this.setLocation(this.getX(), this.getY() - moveSpeedY);
            lastDir = 3;
        }
        if(direction.toUpperCase().equals("RIGHT")){
            this.setLocation(this.getX() - moveSpeedX, this.getY());
            //set direction in player class
            (getWorld().getObjects(Player.class).get(0)).setDirection(1);
            lastDir = 4;
        }
        
    }


    
<<<<<<< Updated upstream
=======
    
    public void handleCollision(){
        //handle barriers for x direction
        //if location is too far from origin, move back
        if(this.getX() > worldImage.getWidth() - getWorld().getWidth()/2){
            this.setLocation(this.getX() - moveSpeedX, this.getY());  
        }
        if(this.getX() < - (getWorld().getWidth()/2)){
            this.setLocation(this.getX() + moveSpeedX, this.getY());  
        }
        if(this.getY() > worldImage.getHeight() - getWorld().getHeight()/2){
            this.setLocation(this.getX(), this.getY() - moveSpeedY);
        }
        if(this.getY() < - (getWorld().getHeight()/2)){
            this.setLocation(this.getX(), this.getY() + moveSpeedY);  
        }

    }
>>>>>>> Stashed changes


    /**
    public void repel(){
    if(lastDir == 1){
    this.setLocation(this.getX(), this.getY() - moveSpeed);
    }
    else if(lastDir == 2){
    this.setLocation(this.getX() - moveSpeed, this.getY());
    }
    else if(lastDir == 3){
    this.setLocation(this.getX(), this.getY() + moveSpeed);
    }
    else if(lastDir == 4){
    this.setLocation(this.getX() + moveSpeed, this.getY()); 
    }
    }
     */
    
    public void repel(){
        ArrayList<Hitbox> hitboxes = new ArrayList<Hitbox>();

        ArrayList<Actor> nonPlayerHitboxes = new ArrayList<Actor>();
        ArrayList<Actor> playerHitBoxes = new ArrayList<Actor>();
        
        hitboxes = (ArrayList<Hitbox>) getWorld().getObjects(Hitbox.class);
        
        for(Hitbox i : hitboxes){
            if(i.getType() == "Player"){
                playerHitBoxes.add(i);
            }else{
                nonPlayerHitboxes.add(i);
            }
        }
        
        for(Actor a : nonPlayerHitboxes){
            GreenfootImage imgSizeObject = a.getImage();
            GreenfootImage imgSizeOfPlayer = playerHitBoxes.get(0).getImage();
            
            Actor p = playerHitBoxes.get(0);

            double xVectorToZero = p.getX() - p.getX();
            double yVectorToZero = p.getY() - p.getY();
            
            System.out.println(a.getX() - imgSizeObject.getWidth()/2 - p.getX() - imgSizeOfPlayer.getWidth()/2 + tolerance);
            

            if(xVectorToZero >= a.getX() - imgSizeObject.getWidth()/2 - p.getX() - imgSizeOfPlayer.getWidth()/2 - tolerance
                && xVectorToZero <= a.getX() - imgSizeObject.getWidth()/2 - p.getX() + moveSpeedX){
                // rebound = moveSpeedX;
                stopJittering = true;
                this.setLocation(this.getX() + moveSpeedX/2, this.getY()); 
            }
            
            
            if(xVectorToZero <= a.getX() + imgSizeObject.getWidth()/2 - p.getX() + imgSizeOfPlayer.getWidth()/2 + tolerance
                && xVectorToZero >= a.getX() + imgSizeObject.getWidth()/2 - p.getX() - moveSpeedX){
                // rebound = moveSpeedX;
                stopJittering = true;
                this.setLocation(this.getX() - moveSpeedX/2, this.getY()); 
            }
            
            if(yVectorToZero <= a.getY() + imgSizeObject.getHeight()/2 - p.getY() + imgSizeOfPlayer.getHeight()/2 + tolerance
                && yVectorToZero >= a.getY() + imgSizeObject.getHeight()/2 - p.getY() - moveSpeedY){
                // rebound = moveSpeedX;
                System.out.println("working3");
                stopJittering = true;
                this.setLocation(this.getX(), this.getY() - moveSpeedY/2); 
            }
            
            if(yVectorToZero >= a.getY() - imgSizeObject.getHeight()/2 - p.getY() - imgSizeOfPlayer.getHeight()/2 - tolerance
                && yVectorToZero <= a.getY() - imgSizeObject.getHeight()/2 - p.getY() + moveSpeedY){
                // rebound = moveSpeedX;
                System.out.println("working3");
                stopJittering = true;
                this.setLocation(this.getX(), this.getY() + moveSpeedY/2); 
            }
        }
    }

}
