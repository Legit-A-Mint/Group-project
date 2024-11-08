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
    
    private boolean createdSlider;
    
    public Slider(String name, String image, String sliderImage){
        this.name = name;
        this.sliderImage = sliderImage;
        sliderBackground = new GreenfootImage(image);
        setImage(sliderBackground);
    }
    public void act()
    {
        if(!createdSlider){
            //create slider with max offset of 85
            slider = new SliderObject(129, this.getX(), sliderImage);
            getWorld().addObject(slider, this.getX(), this.getY());
            createdSlider = true;
        }
    }
}
