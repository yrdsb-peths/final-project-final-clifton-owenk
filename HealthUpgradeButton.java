import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class HealthUpgradeButton extends Actor
{
    private GreenfootImage defaultImage = new GreenfootImage("HealthUpgrade.png");
    private GreenfootImage pressedImage = new GreenfootImage("UpgradeButtonPressed.png");
    
    public HealthUpgradeButton()
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
        }
        
        if(Greenfoot.mouseClicked(this)) // mouse release
        {
            setImage(defaultImage);
        }
    }
}
