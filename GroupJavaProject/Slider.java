import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Slider class
 * Create a slider class by creating an object.
 * You may give the constructor image files in the form of a string or leave it
 * empty to use a default slider.
 * SliderObject is inherited from Slider
 * 
 * @lumilk
 * @version 1.0.0
 */
public class Slider extends Interface
{
    private GreenfootImage sliderBackground;
    private SliderObject slider;
    private String name;
    private String sliderImage;
    private double scale;
    private int offset;
<<<<<<< HEAD
    
    private boolean createdSlider;
    
=======

    private boolean createdSlider;

>>>>>>> 6789bd63d2134296070e345ed5c18ecf009cd364
    public Slider(String name, String image, String sliderImage, double scale, int offset){
        this.name = name;
        this.sliderImage = sliderImage;
        this.scale = scale;
        this.offset = offset;
        sliderBackground = new GreenfootImage(image);
        sliderBackground.scale((int)(sliderBackground.getWidth() * scale), 
        (int)(sliderBackground.getHeight() * scale));
        setImage(sliderBackground);
<<<<<<< HEAD
        
    }
=======
    }

>>>>>>> 6789bd63d2134296070e345ed5c18ecf009cd364
    public void act()
    {
        super.act();
        if(!createdSlider){
            //create slider with max offset
            slider = new SliderObject(offset, this.getX(), sliderImage, scale);
            getWorld().addObject(slider, this.getX(), this.getY());
            createdSlider = true;
        }
<<<<<<< HEAD
    }
    public void setTransparency(double t){
        sliderBackground.setTransparency((int)(255 * t));
    }
    @Override
    protected boolean isUserInteracting() {
=======
        getPercent();
    }

    public void setTransparency(double t){
        sliderBackground.setTransparency((int)(255 * t));
    }

    public double getPercent(){
        //get maximum and minimpoint based on x coordinants
        double pointAX = this.getX() - slider.getMaxOffset();
        double pointBX = this.getX() + slider.getMaxOffset();
        double range = pointBX - pointAX;
        //ensure no divide by 0 error
        if (range == 0) {
            return 0;
        }
        if (slider.getX() == pointAX + 1){
            return 0.0;
        } 
        else if (slider.getX() == pointBX - 1) {
            return 1.0; // Or return 1.0 if you want a range from 0 to 1
        }
        //return percent calculation based on x position of slider with respect to minimum offset
        return(slider.getX() - pointAX) / range;
    }

    @Override
    protected boolean isUserInteracting(){
>>>>>>> 6789bd63d2134296070e345ed5c18ecf009cd364
        return Greenfoot.mouseMoved(this);
    }
}
