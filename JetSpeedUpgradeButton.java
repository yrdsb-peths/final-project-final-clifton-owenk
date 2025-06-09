import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
  * When this button is pressed
  * it will ask user to confirm if player would like to proceed with the upgrade
  * depends on the moeny the player has in the GameWorldd
  * Confirm - dedcut money from GamewWorld.money and upgrade Jet's speed
  * 
  * @author (Kung, Lin)
  * @version (2025/6/7)
*/

public class JetSpeedUpgradeButton extends JetUpgradeButtons
{
    private GreenfootImage defaultImage = new GreenfootImage("JetSpeedUpgrade.png");
    private GreenfootImage pressedImage = new GreenfootImage("UpgradeButtonPressed.png");
    public static boolean pressed = false; 
    
    public JetSpeedUpgradeButton()
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
