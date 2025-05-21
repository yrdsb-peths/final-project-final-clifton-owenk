import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Deat is a screen that shows up when the player's health bar reaches zero
 * This screen ends the game
 * shows defeat
 */
public class Defeat extends World
{
    private int timer = 0; //delay showing defeat banner timer
    
    public Defeat()
    {    
        super(400, 750, 1);  // Same size as game screen
        setBackground("background_blur.png"); //Set the background
    }
    
    public void act()
    {
        timer++;
        
        //after 30 frames show banner
        if(timer == 30)
        {
            addObject(new DefeatBanner(), getWidth()/2 + 20, getHeight()/2);  // place in middle
        }
    }
}
