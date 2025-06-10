import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * ReturnButton sends the player back to the MainScreen when clicked..
 * 
 * @author Kung, Lin
 * @version 2025/6/9
 */
public class ReturnButton extends Actor
{
    /**
     * Constructor that sets and scales the return button image.
     */
    public ReturnButton(){
        setImage("images/ReturnButton.png"); //Sets the image for the return to home button
        getImage().scale(100, 100); //resize the image
    }
    /**
     * When clicked:
     *  -switch to MainScreen
     */
    public void act()
    {
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.playSound("sounds/buttonPress2.mp3");
            Greenfoot.setWorld(new MainScreen()); // when the button is pressed, it returns to the home screen    
            //MainScreen.getInstance().prepare();
            //Greenfoot.setWorld(MainScreen.getInstance());   
      }
    }
}
