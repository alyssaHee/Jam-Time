import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Home here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Home extends Actor
{
    // Array for animating the streetlight
    private GreenfootImage[] lights;
    
    // Variables to control rate of animation and image to show
    private int slowDownLight;
    private int currIndex;
    
    // A random number to make the light flicker more naturally
    private int rand;
    public Home()
    {
        // Initialize variables
        lights = new GreenfootImage[2];
        currIndex = 0;
        slowDownLight = 0;
        rand = 20; 
        
        // Fill lights array with Greenfoot images
        lights[0] = new GreenfootImage("backgroundLight.png");
        lights[1] = new GreenfootImage("background Dark.png");
    }
    /**
     * Act - do whatever the Home wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        animate();
    }    
    
    // Animate the street light
    public void animate()
    {
        slowDownLight++;
        if(slowDownLight%rand==0)
        {
            currIndex++;
            rand = Greenfoot.getRandomNumber(30)+15;
            slowDownLight = 0;
        }
        
        // if the index goes out of the range of array length
        if(currIndex == lights.length)
        {
            currIndex = 0;
        }
        setImage(lights[currIndex]);
    }
}
