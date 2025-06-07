import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class BulletReloadUpgradeButton extends Actor
{
    private GreenfootImage defaultImage = new GreenfootImage("BulletReloadUpgrade.png");
    private GreenfootImage pressedImage = new GreenfootImage("UpgradeButtonPressed.png");
    
    public BulletReloadUpgradeButton()
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
