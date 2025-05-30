import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * VictoryBanne is a short animation to show the player that she/he wins
 */

public class VictoryBanner extends Actor
{
    private GreenfootImage[] frames = new GreenfootImage[21]; // 21 frames 
    private int currentFrame = 0;
    private int animationDelay = 3; //delay 
    private int delayCounter=0;
    
    public VictoryBanner()
    {
        for(int i=0; i<frames.length; i++)
        {
            frames[i] = new GreenfootImage("images/victoryBanner/v" + i + ".png");
            frames[i].scale(450, 200); //size of banner
        }
        setImage(frames[0]);
    }
    
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
