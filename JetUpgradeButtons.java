import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * JetUpgradeButtons is a base class for all upgrade buttons in the upgrade screen.
 *
 * When clicked
 *   -Checks if the player has enough money to perform the upgrade.
 *      - If upgrade is allowed
 *           -Shows ConfirmationPopup with OKButton and CancelButton
 *      - If upgrade is not allowed
 *           -Shows ErrorPopup with OkButton to close the popup
 * 
 * @author Kung, Lin
 * @version 2025/6/7
 */

public class JetUpgradeButtons extends Actor
{

    private CancelButton cancelButton;
    private OkButton okButton;

     /**
     * Called when the player clicks an upgrade button like:
     *  -AttackUpgradeButton
     *  -BulletReloadUpgradeButton
     *  -HealthUpgradeButton
     * -JetSpeedUpgradeButton
     *
     * Checks if the upgrade is allowed (enough money).
     *    -If allowed, shows a confirmation popup. 
     *    -If not, shows an error popup.
     */
    public  void askUpgrade() 
    {
        
       if(JetUpgrade.allowUpdate())
       {
           showConfirmation();
       }
       else
       {
           showError();
       }
    }
    /**
     * Displays a confirmation popup with OK and Cancel buttons.
     * 
     * The popup appears in the center of the screen.
     */
    public void showConfirmation()
    {
        //center
        Actor confirmPopup = new ConfirmationPopup();
        cancelButton=new CancelButton(confirmPopup);
        okButton=new OkButton(confirmPopup);
        cancelButton.add(okButton);//when cancel button is clicked, okButton will be removed together with the popup and cancelButton
        okButton.add(cancelButton);//when okBbutton is clicked, cancelButton will be removed together with the popup and oklButton
        
        //draws the popup on the screen with ok and cancel buttons
        getWorld().addObject(confirmPopup, getWorld().getWidth()/2, getWorld().getHeight()/2);
        getWorld().addObject(cancelButton, getWorld().getWidth()/2 -70, getWorld().getHeight()/2+75);
        getWorld().addObject(okButton, getWorld().getWidth()/2+80, getWorld().getHeight()/2+75);
    }
    /**
     * Displays an error popup with only an OK button.
     * 
     * Used when the player doesn't have enough money to upgrade.
     */
    public void showError()
    {
        //center
        Actor errPopup=new ErrorPopup();
        okButton=new OkButton(errPopup);
    
        getWorld().addObject(errPopup,getWorld().getWidth()/2, getWorld().getHeight()/2); 
        getWorld().addObject(okButton, getWorld().getWidth()/2, getWorld().getHeight()/2+ 80);
         
    }

}
