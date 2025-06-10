import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * DefeatBanner appears on the defeat screen to after player fails to take down the MiniBoss
 * The banner image is scaled to fit the design layout 
 * 
 * @author Kung, Lin
 * @version 2025/6/4
 */

public class DefeatBanner extends Actor
{
    /**
     * Constructs DefeatBanner
     * Sets and scales the banner
     */
    public DefeatBanner()
    {
        GreenfootImage banner = new GreenfootImage("defeat_banner.png");
        banner.scale(612, 408); //set banner size
        setImage(banner);
    }
}
