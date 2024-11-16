import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Base class for all projectiles.
 */
public class Projectile extends Actor {
    protected int damage;           // Damage dealt by the projectile
    protected int speed;            // Speed of the projectile
    protected int flightDuration;   // Lifetime of the projectile (in acts)
    private int flightTimeElapsed;  // Counter to track the projectile's flight duration

    public Projectile() {
        flightTimeElapsed = 0;
    }

    /**
     * Initialize projectile properties.
     */
    public void initialize(int damage, int speed, int flightDuration) {
        this.damage = damage;
        this.speed = speed;
        this.flightDuration = flightDuration;
    }

    public void act() {
        move(speed);
        flightTimeElapsed++;

        // Remove projectile if it exceeds its flight duration
        if (flightTimeElapsed >= flightDuration) {
            getWorld().removeObject(this);
        }
    }
}
