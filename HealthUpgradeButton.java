import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
  * When this button is pressed
  * it will ask user to confirm if player would like to proceed with the upgrade
  * depends on the moeny the player has in the GameWorld
  * Confirm - dedcut money from GamewWorld.money and upgrade Jet's health
  * 
  * @author (Kung, Lin)
  * @version (2025/6/7)
*/

public class HealthUpgradeButton extends JetUpgradeButtons
{
    private GreenfootImage defaultImage = new GreenfootImage("HealthUpgrade.png");
    private GreenfootImage pressedImage = new GreenfootImage("UpgradeButtonPressed.png");
    
    //indicator that will later help to identiy which button is pressed
    public static boolean pressed = false; 
    
    public HealthUpgradeButton ()
    {
        //Resize image
        defaultImage.scale(220,55);
        pressedImage.scale(220, 55);
        
        setImage(defaultImage);
    }
    
    public void act()
    {
        if(Greenfoot.mousePressed(this)) //when clicked
        {
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