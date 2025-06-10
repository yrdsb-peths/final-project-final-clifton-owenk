import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * BulletReloadUpgradeButton allows the player to reduce the Jet’s shooting interval.
 * 
 * When clicked:
 *  -If the player has enough money
 *     -Shows a confirmation popup  
 *             -If confirmed,
 *                -Deducts money
 *                -Reduced Jet’s shooting interval (faster bullet)
 *  -If the player does not have  enough money 
 *     -Shows an Error popup 
 * 
 * The button changes its appearance when pressed for feedback.
 * 
 * The pop logic is handled in the parent class 
 *
 * @author Kung, Lin
 * @version 2025/6/9
 */

public class BulletReloadUpgradeButton extends JetUpgradeButtons
{
    private GreenfootImage defaultImage = new GreenfootImage("BulletReloadUpgrade.png");
    private GreenfootImage pressedImage = new GreenfootImage("UpgradeButtonPressed.png");
    public static boolean pressed = false; 
    
    /**
     * Constructs the BulletReloadUpgradeButton and sets up scaled images.
     */
    public BulletReloadUpgradeButton()
    {
        //Resize image
        defaultImage.scale(220,55);
        pressedImage.scale(220, 55);
        
        setImage(defaultImage);
    }
    /**
     * On press
     *   -Changes image
     *   -Changes pressed to true, later used to indicator what upgrade is requested 
     *     (used in OkButton.upgrade())
     * On click:
     *   -Resets image 
     *  -Triggers upgrade confirmation logic
     * 
     */
    public void act()
    {
        if(Greenfoot.mousePressed(this)) //when clicked
        {
            Greenfoot.playSound("sounds/buttonPress2.mp3");
            setImage(pressedImage);
            pressed = true;
        }
        
        if(Greenfoot.mouseClicked(this)) // mouse release
        {
            setImage(defaultImage);
            askUpgrade();
        }
    }
}
