import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScrollableWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScrollableWorld extends Effects
{
    protected GreenfootImage worldImage;
    protected int moveSpeed;
    protected final double WORLDSIZEFACTOR = 1;
    private int lastDir;
    private int relativeX, relativeY;
<<<<<<< HEAD

    private long getIntersectingObjectsTime;

=======
    
    //test delete ltr
    private int testCounter;
    private Player player;
    
    
>>>>>>> 9c89a9a7b6de298c8da53c7c85f8600a0e44ab06
    public ScrollableWorld(){
        //worldImage = new GreenfootImage((int)
        //(1024 * WORLDSIZEFACTOR), (int)(576 * WORLDSIZEFACTOR));
        //worldImage.setColor(Color.GREEN);
        //worldImage.fill();
        worldImage = new GreenfootImage("bgtemp.png");
<<<<<<< HEAD
        worldImage.scale((int)(worldImage.getWidth() * WORLDSIZEFACTOR), (int)(worldImage.getHeight() * WORLDSIZEFACTOR));
=======
>>>>>>> 9c89a9a7b6de298c8da53c7c85f8600a0e44ab06
        setImage(worldImage);
        
        //set Movespeed (varies)
<<<<<<< HEAD
        moveSpeed = 6;
=======
        moveSpeed = 5;
>>>>>>> 9c89a9a7b6de298c8da53c7c85f8600a0e44ab06
    }
    
    public void act()
    {
<<<<<<< HEAD
        moveWorld("DEBUG");
=======
        testCounter++; 
                
        //testing movement delete ltr
        if(testCounter < 100){
            moveWorld("UP");   
        }
        else if(testCounter > 100 && testCounter < 200){
            moveWorld("LEFT");
        }
        else if(testCounter > 200 && testCounter < 300){
            moveWorld("DOWN");
        }
        else if(testCounter > 300 && testCounter < 400){
            moveWorld("RIGHT");
        }
        else if(testCounter > 400){
            moveWorld("MANUAL");
        }
        handleCollision();
>>>>>>> 9c89a9a7b6de298c8da53c7c85f8600a0e44ab06
    }
    
    //will have direction parameters
    public void moveWorld(String direction){
        //manual movement mode, for debugging
        if(direction.toUpperCase().equals("DEBUG")){
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
            (((MyWorld)getWorld()).getPlayer()).setDirection(-1);
            lastDir = 2; 
        }
        if(direction.toUpperCase().equals("DOWN")){
            this.setLocation(this.getX(), this.getY() - moveSpeed);
            lastDir = 3;
        }
        if(direction.toUpperCase().equals("RIGHT")){
            this.setLocation(this.getX() - moveSpeed, this.getY());
            //set direction in player class
            (((MyWorld)getWorld()).getPlayer()).setDirection(1);
            lastDir = 4;
        }
    }
<<<<<<< HEAD

    
    /*
=======
    
>>>>>>> 9c89a9a7b6de298c8da53c7c85f8600a0e44ab06
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
<<<<<<< HEAD
    }*/

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

=======
    }
>>>>>>> 9c89a9a7b6de298c8da53c7c85f8600a0e44ab06
}
