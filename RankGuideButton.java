import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * RankGuideButton directs player to RankGuide
 * 
 * @author Kung, Lin
 * @version 2025/6/9
 */
public class RankGuideButton extends Actor
{
    private GreenfootImage defaultImage = new GreenfootImage("rankGuide1.png");
    private RankGuide rankGuide;
    
    /**
     * Sets and scales the images for the button
     */
    public RankGuideButton()
    {
        //Resize image
        defaultImage.scale(25,25);
        setImage(defaultImage);
    }
    /**
     * On press
     *   -Plays button pressed sounds
     *   -Shows RankGuide
     */
    public void act()
    {
        if(Greenfoot.mousePressed(this)) //when clicked
        {
            Greenfoot.playSound("sounds/buttonPress2.mp3");
            
            rankGuide=new RankGuide();
            getWorld().addObject(rankGuide, 200, 430);
        }
    }
}
