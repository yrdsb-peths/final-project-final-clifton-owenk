import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * CancelButton is used to close a pop-up screen when JetUpgradeButtons are clicked
 *
 * When clicked, it removes:
 *  -The pop-up screen that it belongs to
 *  -Itself
 *  -OkButton, if there’s one on the pop-up screen
 * 
 * It also changes its appearance when pressed for visual feedback.
 * 
 * @author Kung, Lin
 * @version 2025/6/8
 */

public class CancelButton extends Actor
{
    private GreenfootImage defaultImage = new GreenfootImage("CancelButton.png");
    private GreenfootImage pressedImage = new GreenfootImage("CancelButton_pressed.png");
    private Actor popScreen = null; //tells the ok button, which popScreen it responses to
    private Actor okButton=null;
    
    /**
     * Constructs CancelButton
     * 
     * Sets the default imags and pressed images for the button
     * Sets the associated popscreen
     */ 
    public CancelButton(Actor popScreen )
    {
        //resize image
        defaultImage.scale(100,50);
        pressedImage.scale(100,50);
        
        setImage(defaultImage);
        
        this.popScreen=popScreen;
    }
    /**
     * When pressed -changes to pressed image
     * When clicked
     *   -Restores default image
     *   -Removes associated actors such as
     *        -the pop-up screen associated with it
     *        -other buttons that are also on the pop-up screen, mainly the OkButton
     * 
     */ 
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
    /*
     * If OkButton also presents on the pop-up screen
     * It must also be removed when cancel button is clicked
     * 
     *
     * @param okButton the OkButton linked to the same pop-up
     */
    public void add(OkButton okButton)
    {
        this.okButton=okButton;
    }
}
