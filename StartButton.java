import greenfoot.*;

/**
 * StartButton is button on main screen
 * If clicked by mouse then jump to gameworld 
 * It also adjust difficulties for all enimies, each time pressed 
 * either increasing or decreasing value
 * @version 2025/6/5
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

    public void act() 
    {
        if (Greenfoot.mousePressed(this)) 
        {
            setImage(pressedImage); // Change to pressed version
        }

        if (Greenfoot.mouseClicked(this)) 
        {
            Greenfoot.playSound("start.mp3"); //play sound when clicked
            BasicEnemy.adjust(); //adjust dificulty for basic enemy
            MiniBoss.adjust(); //adjust dificulty for basic enemy
            BossMissile.adjust(); //adjust dificulty for BossMissile
            Greenfoot.setWorld(new GameWorld()); // Start the game
        }
    }
}
