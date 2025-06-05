import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class UpgradeButton extends Actor
{
    private GreenfootImage defaultImage = new GreenfootImage("upgradeButton1.png");
    private GreenfootImage pressedImage = new GreenfootImage("upgradeButton2.png");
    
    public UpgradeButton()
    {
        //Resize image
        defaultImage.scale(115,80);
        pressedImage.scale(115, 80);
        
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
            Greenfoot.setWorld(new JetUpgrade());
        }
    }
}
