import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * ConfirmationPopup appears to confirm if player intention to upgrade 
 * when certain amount of  money will be deducted
 *
 * On the Confirmation Popup:
 *   -Displays message: 
 *        -Certain amount of GameWorld.money will be deducted if jet’s upgrade is confirmed     
 *   -Displays The OkButton 
 *        -Confirms the upgrade and close the popup.
 *        -(added to screen when JetUpgradeButtons.showConfirmation() is called)
 *   -Displays CancelButon
 *        -Will not perform the upgrade and close the popup.
 *        -(added to screen when JetUpgradeButtons.showConfirmation() is called)
 *
 * The popup image is scaled to fit the screen layout.
 * 
 * @author Kung, Lin
 * @version 2025/6/6
 */

public class ConfirmationPopup extends Actor
{
    private GreenfootImage confirmation = new GreenfootImage("Confirmation.png");
    
    /**
     * Constructs a ConfirmationPopup and scales the image to fit its designated size.
     */
    public ConfirmationPopup()
    {
        confirmation.scale(350, 250); 
        setImage(confirmation);

    }
}
