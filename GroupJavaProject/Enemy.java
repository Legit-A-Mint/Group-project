import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Enemy extends Effects
{
    //Inherited variables
    protected double maxSpeed, speed;
    protected int hp, damageToPlayer;
    protected Player player;
    protected int dir;

    private boolean removeMe;
    protected int spawnX, spawnY;
    
    private double relativeX, relativeY;
    private double speedX, speedY, pushDistX, pushDistY;
    private boolean createdHitbox;
    private boolean collided;
    private Hitbox h;
    
    private int[] cordsVector = new int[2];

    private static final int MAX_SPAWN_DISTANCE = 350;
    private static final int MIN_SPAWN_DISTANCE = 100;

    private int repelPriority;
    private static int repelPrioTracker = 0;
    private int myActNumber;
    private static int nextActNumber;
    

    protected abstract boolean checkForCollision();

    public abstract void damaged();

    public abstract void attack();

    public Enemy(){
        if(Greenfoot.getRandomNumber (2) % 2 == 0){
            spawnX  = Greenfoot.getRandomNumber (MAX_SPAWN_DISTANCE) + MIN_SPAWN_DISTANCE;
            spawnY = Greenfoot.getRandomNumber (MAX_SPAWN_DISTANCE) + MIN_SPAWN_DISTANCE;
        }else{
            spawnX  = Greenfoot.getRandomNumber (MAX_SPAWN_DISTANCE) + MIN_SPAWN_DISTANCE;
            spawnY = Greenfoot.getRandomNumber (MAX_SPAWN_DISTANCE) + MIN_SPAWN_DISTANCE;
            spawnX = -spawnX;
            spawnY = -spawnY;
        }
        removeMe = false;

        cordsVector[0] = 0;
        cordsVector[1] = 1;

        repelPriority = 0 + repelPrioTracker;
        repelPrioTracker++;

        myActNumber = getNextActNumber();
        
        //speedX = speed;
        //speedY = speed;
        
        //enableStaticRotation();
    }

    public void act()
    {   
        //create hitbox for every object of enemy created
        if(!createdHitbox){
            //new hitbox object will be the size of image
            //(adjust with parameters soon)
            h = new Hitbox(getImage().getWidth() - 15, 
                getImage().getHeight() - 60, 0, 0, this);

            /** updated code later
            h = new Hitbox(getImage().getWidth() - percentWidth, 
            getImage().getHeight() - percentHeight, 0, 0, this);
             */

            //add hitbox to my position
            getWorld().addObject(h, this.getX(), this.getY());
            //created hit box is true, no longer need to create a hitbox
            createdHitbox = true;
        }
        
        if (MyWorld.isActing())
        {
            if (MyWorld.getActNumber() == myActNumber)
            {
                lookForTarget();
            }
            
            repelEnemies();

            moveWithWorld();
            
            if(this.hp <= 0 ){
                removeMe = true;
            }

            if(removeMe){
                getWorld().removeObject(this);
            }
        }
    }
    
    public void lookForTarget(){
        if(!getWorld().getObjects(Player.class).isEmpty()){
            player = getWorld().getObjects(Player.class).get(0);
            turnTowards(player.getX(), player.getY());

            if(player.getX() < this.getX() && player.getY() < this.getY()){
                // bottom right
                speedX = -speed;
                speedY = -speed;
                dir = -1;
            }else if (player.getX() > this.getX() && player.getY() < this.getY()){
                // bottom left
                speedX = speed;
                speedY = -speed;
                dir = 1;
            }else if(player.getX() < this.getX() && player.getY() > this.getY()){
                // top right
                speedX = -speed;
                speedY = speed;
                dir = -1;
            }else{
                // top left
                speedX = speed;
                speedY = speed;
                dir = 1;
            }
        }
    }

    public void moveWithWorld(){
        ScrollableWorld sw = getWorld().getObjects(ScrollableWorld.class).get(0);

        relativeX += speedX;
        relativeY += speedY;

        //pushDistX += cordsVector[0];
        //pushDistY += cordsVector[1];

        //Sets the location of object based on the relative position in ScrollableWorld
        //SpawnX and SpawnY handles spawn location
        setLocation(sw.getX() + relativeX + spawnX + pushDistX, sw.getY() + relativeY + spawnY + pushDistY);
    }

    public void repelEnemies() {
        ArrayList<Enemy> enemiesTouching = (ArrayList<Enemy>)getIntersectingObjects(Enemy.class);

        ArrayList<Enemy> actorsTouching = new ArrayList<Enemy>();

        ArrayList<Actor> subPriority = new ArrayList<Actor>();

        // this works, but doesn't ignore knocked down Enemies
        //actorsTouching.addAll(pedsTouching);
        for (Enemy e : enemiesTouching){
            actorsTouching.add(e);

        }

        for(Enemy e : actorsTouching){
            if(this.repelPriority > e.getRepelPriority()){
                subPriority.add(e);
            }
        }

        cordsVector[0] = 0;
        cordsVector[1] = 1;

        pushAwayFromObjects(subPriority, 2);

        /**
        if(this.repelPriority > getRepelPriority()){
        pushAwayFromObjects(subPriority, 1);
        }
         */
    }

    public int[] pushAwayFromObjects(ArrayList<Actor> nearbyObjects, double minDistance) {
        // Get the current position of this actor
        int currentX = getX();
        int currentY = getY();

        // Iterate through the nearby objects
        for (Actor object : nearbyObjects) {
            // Get the position and bounding box of the nearby object
            int objectX = object.getX();
            int objectY = object.getY();
            int objectWidth = object.getImage().getWidth()/2;
            int objectHeight = object.getImage().getHeight()/2 ;

            // Calculate the distance between this actor and the nearby object's bounding oval
            double distance = Math.sqrt(Math.pow(currentX - objectX, 2) + Math.pow(currentY - objectY, 2));

            // Calculate the effective radii of the bounding ovals
            double thisRadius = Math.max(getImage().getWidth() / 2.0, getImage().getHeight() / 2.0);
            double objectRadius = Math.max(objectWidth / 2.0, objectHeight / 2.0);

            // Check if the distance is less than the sum of the radii
            if (distance < (thisRadius + objectRadius + minDistance)) {
                // Calculate the direction vector from this actor to the nearby object
                int deltaX = objectX - currentX;
                int deltaY = objectY - currentY;

                // Calculate the unit vector in the direction of the nearby object
                double length = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
                double unitX = deltaX / length;
                double unitY = deltaY / length;

                // Calculate the amount by which to push the nearby object
                double pushAmount = (thisRadius + objectRadius + minDistance) - distance;

                // Update the position of the nearby object to push it away

                /**
                 * Seperate push direction based on vector of movement
                 * This is to prevent cats from pushing eachother off the world once they begin 
                 * walking to the boat
                 */
                if(objectX < currentX){
                    cordsVector[0] = -(int)(pushAmount * unitX);
                }else{
                    cordsVector[0] = (int)(pushAmount * unitX);
                }

                if(objectX < currentX){
                    cordsVector[1] = (int)(pushAmount * unitY);
                }else{
                    cordsVector[1] = -(int)(pushAmount * unitY);
                }

                // object.setLocation(objectX + (int)(pushAmount * unitX), objectY + (int)(pushAmount * unitY));
            }
        }

        return cordsVector;
    }

    public int getRepelPriority(){
        return repelPriority;
    }

    private static int getNextActNumber () {
        if (nextActNumber == -1){
            nextActNumber = 1;
        }
        if (nextActNumber > 2){
            nextActNumber = 1; // goes back to 1 - Zero (0) is reserved for UI refresh
        }
        return nextActNumber++;
    }
}