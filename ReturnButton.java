import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @version 2025/6/4
 */

public class ReturnButton extends Actor
{
    public ReturnButton(){
        setImage("images/ReturnButton.png"); //Sets the image for the return to home button
        getImage().scale(100, 100); //resize the image
    }
    
    public void act()
    {
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.playSound("sounds/buttonPress2.mp3");
            Greenfoot.setWorld(new MainScreen()); // when the button is pressed, it returns to the home screen
        }
    }
}
