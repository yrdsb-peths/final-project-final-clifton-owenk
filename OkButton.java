import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * OkButton handles confirming an upgrade.
 * When clicked
 *   -Checks which upgrade button was pressed,
 *   -Applies the corresponding upgrade
 *   -Deducts money.
 *   -Removes the popup
 *  - Remove the CancelButton from the world if on the confirmation popup.
 * 
 * @author Kung, Lin
 * @version 2025/6/10
 */

public class OkButton extends Actor
{
    private GreenfootImage defaultImage = new GreenfootImage("OkButton.png");
    private GreenfootImage pressedImage = new GreenfootImage("OkButton_pressed.png");
    private Actor popScreen = null; //tells the ok button, which popScreen it responses to
    private Actor cancelButton = null; //tells the ok button, which popScreen it responses to
    
    public static boolean pressed = false;
    
     /**
     * Constructor to set image and link to popup screen.
     * @param popScreen: The popup screen this button is related to
     */
    public OkButton(Actor popScreen)
    {
        //resize image
        defaultImage.scale(100,50);
        pressedImage.scale(100,50);
        
        setImage(defaultImage);
        
        this.popScreen=popScreen;
    }
    /**
     * On click
     *   -Performs upgrade
     *   -Removes popup, cancel button if there’s one and itself from the screen
     */
    public void act()
    {
        if(Greenfoot.mousePressed(this)) //when clicked
        {
            setImage(pressedImage);
            Greenfoot.playSound("sounds/buttonPress2.mp3");
        }
        if(Greenfoot.mouseClicked(this)) // mouse release
        {
            setImage(defaultImage);
            upgrade();
            getWorld().removeObject(popScreen);
            if(cancelButton!=null)
            {
                getWorld().removeObject(cancelButton);
            }
            getWorld().removeObject(this);  
        }
    }
    /**
     * If there’s a CancelButton on the popup
     * @param cancelButton The CancelButton to remove on confirm
     */
    public void add(CancelButton cancelButton)
    {
        this.cancelButton=cancelButton;
    }
    /**
     * Applies the selected upgrade based on which upgrade button was pressed.
     * Deducts money and resets the pressed state to false for that button.
     */
    private void upgrade()
    {
        if(HealthUpgradeButton.pressed && JetUpgrade.allowUpdate() )
        {
            Jet.baseHealth+=100;
            GameWorld.money=Math.max(0,GameWorld.money-=50000);
            
            //reset button pressed to false
            HealthUpgradeButton.pressed=false;
        }
        if(AttackUpgradeButton.pressed && JetUpgrade.allowUpdate())
        {
            Bullet.baseDamage +=100;
            GameWorld.money=Math.max(0, GameWorld.money-= 50000);
            
            //reset button pressed to false
            AttackUpgradeButton.pressed= false; 
        }
        if(BulletReloadUpgradeButton.pressed && JetUpgrade.allowUpdate())
        {
            Jet.shootInterval=Math.max(10,Jet.shootInterval -= 2);
            GameWorld.money=Math.max(0, GameWorld.money-=50000);
            
            //reset button pressed to false
            BulletReloadUpgradeButton.pressed = false; 
        }
        if(JetSpeedUpgradeButton.pressed && JetUpgrade.allowUpdate())
        {
            Jet.baseSpeed =Math.min(10,Jet.baseSpeed+=1);
            GameWorld.money = Math.max(0, GameWorld.money-=50000);
            
            //reset button pressed to false
            JetSpeedUpgradeButton.pressed = false; 
        }
    }
}
