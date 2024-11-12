import greenfoot.*;
import greenfoot.GreenfootImage;
import java.util.ArrayList;

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Effects
{
    protected GreenfootImage playerImage, reflectedPlayerImage;
    private int direction;

    private Enemy targetEnemy;
    private ArrayList<Enemy> enemies;

    private Backpack inventory;

    private int playerHealth, playerMaxHealth, gold, intelligence, actCount;
    private double maxSpeed, speed;
    private boolean attackReady;

    private double closestTargetDistance = 0;
    private double distanceToActor;

    private int relativeX, relativeY;
    private Hitbox h;
    private boolean createdHitbox;
    private boolean collided;
    public Player(){
        playerImage = new GreenfootImage("shark.png");
        reflectedPlayerImage = new GreenfootImage("shark.png");
        reflectedPlayerImage.mirrorHorizontally();

        setImage(playerImage);
        direction = 1;

        /*
        playerMaxHealth = 5 + moddedHp;
        playerHealth = playerMaxHealth;
        gold = 0;
        CPU = moddedCPU;
        maxSpeed = (1.25 + moddedSpeed) * CPU;
        speed = (maxSpeed) * CPU;
         */

        createdHitbox = false;
    }

    public void act(){
        //create hitbox
        if(!createdHitbox){
            h = new Hitbox(playerImage.getWidth() - 15, 
            playerImage.getHeight() - 60, 0, 0, this);

            getWorld().addObject(h, this.getX(), this.getY());
            createdHitbox = true;
        }

        checkCollision();
        repelMe();

        
        // init backpack here, not sure how
        if(direction == -1){}
        if(direction == -1){
            setImage(reflectedPlayerImage);
        }
        else if (direction == 1){
            setImage(playerImage);
        }

        if(Greenfoot.isKeyDown("a") && !Greenfoot.isKeyDown("d")){
            direction = -1;
        }
        if(Greenfoot.isKeyDown("d") && !Greenfoot.isKeyDown("a")){
            direction = 1;
        }

        actCount++;
        /*
        if(actCount % intelligence == 0){
        action();
        }*/

    
    }

    public void setDirection(int dir){
        direction = dir;
    }

    public void checkCollision(){
        if(h != null){
            collided = h.checkCollision();   
        }
    }

    public void repelMe(){
        if(collided == true){
            ((MyWorld)getWorld()).getObjects(ScrollableWorld.class).get(0).repel();
            collided = false;
        }
    }

    public Actor returnHitbox(){
        return h;
    }

    /*
    public void action(){

    targetClosestEnemy();
        
    if(!melee || !attackReady || distanceToActor < Backpack.getKiteRange()){
    move(-speed);
    }else{
    if(melee && attackReady){
    move(speed);
    }
    }

    if(attackReady && Backpack.getWithinRange()){
    initAttack();
    }

    move(speed);

    }

    public void initAttack(){
    if(!melee)
    getWorld.addObject();
    }

    public void targetClosestEnemy(){

    enemies = (ArrayList<Enemy>)getObjectsInRange(40, Enemy.class);
    if (enemies.size() == 0){

    enemies = (ArrayList<Enemy>)getObjectsInRange(150, Enemy.class);
    } 
    if (enemies.size() == 0){

    enemies = (ArrayList<Enemy>)getObjectsInRange(300, Enemy.class);
    } 
    if (enemies.size() == 0){
    //enemies = (ArrayList<Enemy>)getWorld().getObjects(Enemy.class);
    } 

    if (enemies.size() > 0)
    {
    // set the first one as my target
    targetEnemy = enemies.get(0);
    // Use method to get distance to target. This will be used
    // to check if any other targets are closer
    closestTargetDistance = MyWorld.getDistance (this, targetEnemy);

    // Loop through the objects in the ArrayList to find the closest target
    for (Enemy o : enemies)
    {
    // Cast for use in generic method
    //Actor a = (Actor) o;
    // Measure distance from me
    distanceToActor = MyWorld.getDistance(this, o);
    // If I find a Enemy closer than my current target, I will change
    // targets
    if (distanceToActor < closestTargetDistance)
    {
    targetEnemy = o;
    closestTargetDistance = distanceToActor;
    }
    }
    turnTowards(targetEnemy.getX(), targetEnemy.getY());
    }
    }

    public int getX(){
    return getX();
    }

    public int getY(){
    return getY();
    }
     */
}
