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
    protected int moveSpeed;
    protected final double WORLDSIZEFACTOR = 2;
    private int lastDir;
    private int relativeX, relativeY;

    private long getIntersectingObjectsTime;

    //test delete ltr
    private int testCounter;

    public ScrollableWorld(){
        //worldImage = new GreenfootImage((int)
        //(1024 * WORLDSIZEFACTOR), (int)(576 * WORLDSIZEFACTOR));
        //worldImage.setColor(Color.GREEN);
        //worldImage.fill();
        worldImage = new GreenfootImage("bgtemp.png");
        //worldImage.scale(worldImage.getWidth() * 2, worldImage.getHeight()* 2);
        setImage(worldImage);
        //set Movespeed (varies)
        moveSpeed = 3;
    }

    public void act()
    {
        testCounter++; 

        moveWorld("MANUAL");

        handleCollision();
    }

    //will have direction parameters
    public void moveWorld(String direction){
        //manual movement mode, for debugging
        if(direction.toUpperCase().equals("MANUAL")){
            if(Greenfoot.isKeyDown("w")){
                this.setLocation(this.getX(), this.getY() + moveSpeed);  
                lastDir = 1;
            }
            if(Greenfoot.isKeyDown("a")){
                this.setLocation(this.getX() + moveSpeed, this.getY());
                lastDir = 2;
            }
            if(Greenfoot.isKeyDown("s")){
                this.setLocation(this.getX(), this.getY() - moveSpeed);
                lastDir = 3;
            }
            if(Greenfoot.isKeyDown("d")){
                this.setLocation(this.getX() - moveSpeed, this.getY());
                lastDir = 4;
            } 
        }

        if(direction.toUpperCase().equals("UP")){
            this.setLocation(this.getX(), this.getY() + moveSpeed);  
            lastDir = 1;
        }
        if(direction.toUpperCase().equals("LEFT")){
            this.setLocation(this.getX() + moveSpeed, this.getY());
            //set direction in player class
            (getWorld().getObjects(Player.class).get(0)).setDirection(-1);
            lastDir = 2; 
        }
        if(direction.toUpperCase().equals("DOWN")){
            this.setLocation(this.getX(), this.getY() - moveSpeed);
            lastDir = 3;
        }
        if(direction.toUpperCase().equals("RIGHT")){
            this.setLocation(this.getX() - moveSpeed, this.getY());
            //set direction in player class
            (getWorld().getObjects(Player.class).get(0)).setDirection(1);
            lastDir = 4;
        }
    }

    public void handleCollision(){
        //handle barriers for x direction
        //if location is too far from origin, move back
        if(this.getX() > worldImage.getWidth() - getWorld().getWidth()/2){
            this.setLocation(this.getX() - moveSpeed, this.getY());  
        }
        if(this.getX() < - (getWorld().getWidth()/2)){
            this.setLocation(this.getX() + moveSpeed, this.getY());  
        }
        if(this.getY() > worldImage.getHeight() - getWorld().getHeight()/2){
            this.setLocation(this.getX(), this.getY() - moveSpeed);
        }
        if(this.getY() < - (getWorld().getHeight()/2)){
            this.setLocation(this.getX(), this.getY() + moveSpeed);  
        }
    }

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
        ArrayList<Actor> playerHitboxes = new ArrayList<Actor>();
        
        hitboxes = (ArrayList<Hitbox>) getWorld().getObjects(Hitbox.class);

        for(Hitbox i : hitboxes){
            if(i.returnPlayer()){
                playerHitboxes.add(i);
            }else{
                nonPlayerHitboxes.add(i);
            }
        }

        //
        for(Actor a : nonPlayerHitboxes){
            GreenfootImage imgSizeObject = a.getImage();
            GreenfootImage imgSizeOfPlayer = nonPlayerHitboxes.get(0).getImage();
            
            Actor p = playerHitboxes.get(0);

            if(p.getX() - imgSizeOfPlayer.getWidth()/2 < a.getX() + imgSizeObject.getWidth()/2){
                System.out.println("left");

                this.setLocation(this.getX() - moveSpeed, this.getY());  
            }

            if(p.getX() + imgSizeOfPlayer.getWidth()/2 < a.getX() - imgSizeObject.getWidth()/2){
                System.out.println("right");
                this.setLocation(this.getX() + moveSpeed, this.getY());  
            }

            if(p.getY() - imgSizeOfPlayer.getWidth()/2 > a.getY() + imgSizeObject.getWidth()/2){
                System.out.println("up");
                this.setLocation(this.getX(), this.getY() + moveSpeed);
            }

            if(p.getY() + imgSizeOfPlayer.getWidth()/2 < a.getY() - imgSizeObject.getWidth()/2){
                System.out.println("down");
                this.setLocation(this.getX(), this.getY() - moveSpeed);  
            }

        }
    }

}
