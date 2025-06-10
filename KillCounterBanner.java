import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * KillCounterBanner displays a static banner image labeled "counter.png"
 * at the top of the GameWorld screen.
 * 
 * @author Kung, Lin
 * @version 2025/6/4
 */
public class KillCounterBanner extends Actor
{
    /**
     * Sets and scales image for the KillCounterBanner
     */
    public KillCounterBanner()
    {
        setImage("counter.png"); 
        getImage().scale(400,80); 
    }
}
