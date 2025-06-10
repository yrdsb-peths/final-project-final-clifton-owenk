import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * JetSpeedUpgradeButton allows the player to upgrade Jet’s moving speed
 * 
 * When clicked:
 *  -If the player has enough money
 *     -Shows a confirmation popup  
 *             -If confirmed,
 *                -Deducts money
 *                -Upgrade Jet’s Speed
 *  -If the player does not have enough money 
 *     -Shows an Error popup 
 * 
 * The button changes its appearance when pressed for feedback.
 * 
 * The pop logic is handled in the parent class 
 *
 * @author Kung, Lin
 * @version 2025/6/7
 */
public class JetSpeedUpgradeButton extends JetUpgradeButtons
{
    private GreenfootImage defaultImage = new GreenfootImage("JetSpeedUpgrade.png");
    private GreenfootImage pressedImage = new GreenfootImage("UpgradeButtonPressed.png");
    public static boolean pressed = false; 
    
    /**
     * Constructs a JetSpeedUpgradeButton with scaled images.
     */  
    public JetSpeedUpgradeButton()
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
     *   -Triggers upgrade confirmation logic
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
