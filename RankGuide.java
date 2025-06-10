import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * RankGuide explain to player what does the rank system work
 * 
 * @author Kung, Lin
 * @version 2025/6/9
 */
public class RankGuide extends Actor
{
    private GreenfootImage rankGuide = new GreenfootImage("rankGuide.png");
    
    /**
     * Sets and scales the image
     */
    public RankGuide()
    {
        rankGuide.scale(354, 152);
        setImage(rankGuide);
        
    }
    /**
     * Mouse clicked:
     *  -Plays button sound
     *  -Remove itself from MainScreen
     */
    public void act()
    {
        if(Greenfoot.mouseClicked(this)) // mouse release
        {
            Greenfoot.playSound("sounds/buttonPress2.mp3");
            getWorld().removeObject(this); 
        }
    }
}
