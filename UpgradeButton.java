import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * UpgradeButton is a button on MainScreen
 *   -Allows player to do upgrade on the Jet
 *  - When clicked
 *         -Plays a sound
 *         -Switches to JetUpgrade world.
 * 
 * @author Kung, Lin
 * @version 2025/6/8
 */

public class UpgradeButton extends Actor
{
    private GreenfootImage defaultImage = new GreenfootImage("upgradeButton1.png");
    private GreenfootImage pressedImage = new GreenfootImage("upgradeButton2.png");
    private boolean buttonPressed = false;
    
    /**
     * Constructs an and sets its visual appearance.
     *.
     */
    public UpgradeButton()
    {
        //Resize image
        defaultImage.scale(115,80);
        pressedImage.scale(115, 80);
        
        setImage(defaultImage);
    }
    /**
     * On click: Switch to JetUpgrade World
     */
    public void act()
    {
        if(Greenfoot.mousePressed(this)) //when clicked
        {
            setImage(pressedImage);
            buttonPressed = true;
        }
        
        if(buttonPressed == true){
            Greenfoot.playSound("sounds/buttonPress.mp3");
            buttonPressed = false;
        }
        
        if(Greenfoot.mouseClicked(this)) // mouse release
        {
            Greenfoot.setWorld(new JetUpgrade());
            buttonPressed = true;
        }
    }
}
