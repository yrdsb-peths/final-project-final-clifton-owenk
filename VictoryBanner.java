import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * VictoryBanner is an animated banner that appears on the screen
 * when the player wins. It plays a short animation made of 21 frames.
 * 
 * Each frame is displayed with a delay to control the speed of the animation.
 * The banner scales each frame to a consistent size before displaying.
 * 
 * @author  Kung, Lin
 * @version 2025/6/4
 */
public class VictoryBanner extends Actor
{
    private GreenfootImage[] frames = new GreenfootImage[21]; // 21 frames 
    private int currentFrame = 0;
    private int animationDelay = 3; //delay 
    private int delayCounter=0;
    
    /**
     * Preloads the 21 animation frames.
     * Each frame is scaled to 450x200 pixels
     */
    public VictoryBanner()
    {
        for(int i=0; i<frames.length; i++)
        {
            frames[i] = new GreenfootImage("images/victoryBanner/v" + i + ".png");
            frames[i].scale(450, 200); //size of banner
        }
        setImage(frames[0]);
    }
    /**
     * Handles the timing and progression of the banner animation.
     */
    public void act()
    {
        delayCounter ++;
        if(delayCounter >= animationDelay)
        {
            delayCounter = 0;
            currentFrame ++;
            if(currentFrame < frames.length)
            {
                setImage(frames[currentFrame]);
            }
        }
    }
}
