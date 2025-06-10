import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * ErrorPopup is a popup screen that will appear on JetUpgrade World
 * when GameWorld.money is below a certain amount and player attempts to upgrade the jet
 *
 * On the ErrprPopup:
 *   -Displays message: 
 *        -  Not enough money in GameWorld to upgrade  
 *   -Displays The OkButton 
 *        -Closes the popup.
 *        -(added to screen when JetUpgradeButtons.showError() is called)
 * 
 * @author Kung, Lin
 * @version 2025/6/7 
 */
public class ErrorPopup extends Actor
{
    private GreenfootImage error = new GreenfootImage("Error.png");
    
    /*
     * Sets and scales the image for ErrorPopup
     * The ErrorPopup loads image with prewritten text.
     */
    public ErrorPopup()
    {
        error.scale(350,250); 
        setImage(error);
    }
}
