import greenfoot.*;

/**
 * GuideButton takes the player to the GuideScreen.
 *  -Plays a sound when pressed
 *  -Changes its appearance to indicate interaction.
 *
 * This button is shown on upper right corner of MainScreen to help players learn how to play.
 * 
 * @author Kung, Lin
 * @version 2025/6/8
 */

public class GuideButton extends Actor
{
    private GreenfootImage defaultImage = new GreenfootImage("guideButton1.png");
    private GreenfootImage pressedImage = new GreenfootImage("guideButton2.png");
    private boolean buttonPressed = false;
    
    /**
     * Constructs a GuideButton and sets its initial image and size.
     */
    public GuideButton()
    {
        // Resize 
        defaultImage.scale(73, 80);
        pressedImage.scale(73, 80);

        setImage(defaultImage);
    }
    /**
     *  On press: changes image and flags as pressed
     *  Plays a sound once per click
     *  On click: switches the world to the GuideScreen
     */
    public void act()
    {
        if (Greenfoot.mousePressed(this))
        {
            setImage(pressedImage);
            buttonPressed = true;
        }
        
        if(buttonPressed == true){
            Greenfoot.playSound("sounds/buttonPress.mp3");
            buttonPressed = false;
        }

        if (Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new GuideScreen());
            buttonPressed = true;
        }
    }
}
