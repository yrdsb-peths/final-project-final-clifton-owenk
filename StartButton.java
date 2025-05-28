import greenfoot.*;

/**
 * StartButton is button on main screen
 * If clicked by mouse then jump to gameworld 
 */
public class StartButton extends Actor {
    private GreenfootImage normalImage = new GreenfootImage("start.png");
    private GreenfootImage pressedImage = new GreenfootImage("start1.png");

    public StartButton() 
    {
        normalImage.scale(240, 110); //size of button
        pressedImage.scale(250, 350); 
        setImage(normalImage);
    }

    public void act() {
        if (Greenfoot.mousePressed(this)) 
        {
            setImage(pressedImage); // Change to pressed version
        }

        if (Greenfoot.mouseClicked(this)) 
        {
            Greenfoot.playSound("start.mp3"); //play sound when clicked
            Greenfoot.setWorld(new GameWorld()); // Start the game
        }
    }
}
