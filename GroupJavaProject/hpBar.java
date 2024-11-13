import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * hpBar class to display and manage player's health points.
 * Contains methods to set and get HP, as well as display heart images.
 * 
 * @version 1.0.0
 */
public class hpBar extends Actor {
    private int hp;
    private GreenfootImage[] hearts;

    public hpBar(int initialHp) {
        hp = initialHp;
        hearts = new GreenfootImage[initialHp];
        
        // Load heart images into the array
        for (int i = 0; i < hearts.length; i++) {
            hearts[i] = new GreenfootImage("");
        }
        
        updateDisplay();
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int newHp) {
        hp = newHp;
        updateDisplay();
    }

    // Method to visually update the hpBar with hearts based on current hp
    private void updateDisplay() {
        GreenfootImage display = new GreenfootImage(hearts.length * 20, 20); // Adjust width as needed
        
        // Display hearts up to current HP
        for (int i = 0; i < hp; i++) {
            display.drawImage(hearts[i], i * 20, 0); // Space hearts horizontally
        }
        
        setImage(display);
    }

    public void act() {
        // Additional functionality for updating hp bar during gameplay if needed
    }
}
