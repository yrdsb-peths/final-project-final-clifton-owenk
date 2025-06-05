import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
* DefeatBanner appears in the defeat screen
* @version 2025/6/4
*/
public class DefeatBanner extends Actor
{
    public DefeatBanner()
    {
        GreenfootImage banner = new GreenfootImage("defeat_banner.png");
        banner.scale(612, 408); //set banner size
        setImage(banner);
    }
    
    public void act()
    {
        
    }
}
