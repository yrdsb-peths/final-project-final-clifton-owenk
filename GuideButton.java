import greenfoot.*;

public class GuideButton extends Actor
{
    private GreenfootImage defaultImage = new GreenfootImage("guideButton1.png");
    private GreenfootImage pressedImage = new GreenfootImage("guideButton2.png");

    public GuideButton()
    {
        // Resize 
        defaultImage.scale(73, 80);
        pressedImage.scale(73, 80);

        setImage(defaultImage);
    }

    public void act()
    {
        if (Greenfoot.mousePressed(this))
        {
            setImage(pressedImage);
        }

        if (Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new GuideScreen());
        }
    }
}
