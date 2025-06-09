import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class CancelButton extends Actor
{
    private GreenfootImage defaultImage = new GreenfootImage("CancelButton.png");
    private GreenfootImage pressedImage = new GreenfootImage("CancelButton_pressed.png");
    private Actor popScreen = null; //tells the ok button, which popScreen it responses to
    private Actor okButton=null;

    public CancelButton(Actor popScreen )
    {
        //resize image
        defaultImage.scale(100,50);
        pressedImage.scale(100,50);
        
        setImage(defaultImage);
        
        this.popScreen=popScreen;
    }
    
    public void act()
    {
        if(Greenfoot.mousePressed(this)) //when clicked
        {
            setImage(pressedImage);
        }
        if(Greenfoot.mouseClicked(this)) // mouse release
        {
            Greenfoot.playSound("sounds/buttonPress2.mp3");
            setImage(defaultImage);
            //pressed = true; 
            getWorld().removeObject(popScreen);
            if(okButton!=null)
            {
                getWorld().removeObject(okButton);
            }
            getWorld().removeObject(this);           
        }
    }
    public void add(OkButton okButton)
    {
        this.okButton=okButton;
    }
}
