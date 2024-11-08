import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class TestButton extends Button
{
    private GreenfootImage base, base2, base3;
    private int animTimer;
    
    public TestButton(){
        super(1);
        
        base = new GreenfootImage(120, 50);
        base.setColor(Color.RED);
        base.fill();

        base2 = new GreenfootImage(120, 50);
        base2.setColor(Color.BLUE);
        base2.fill();
        
        base3 = new GreenfootImage(120, 50);
        base3.setColor(Color.BLACK);
        base3.fill();
        
        setImage(base);
        
        animTimer = -1;
    }
    public void act()
    {
        super.act();
        
        
        if(animTimer > 0){
            animTimer--;
        }
        else if(animTimer == 0){
            //reset animation
            animTimer = -1;
            setImage(base2);
        }
        
        
        if (Greenfoot.mouseMoved(this)){
            setImage(base2);
        }
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this)){
            setImage(base);
        }
        
        if(isClicked()){
            animTimer = 5;
            setImage(base3);
        }
    }
}
