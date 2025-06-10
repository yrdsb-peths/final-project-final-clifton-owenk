import greenfoot.*;

/**
 * StartButton is displayed on the main screen.
 * 
 * When clicked
 *    - Plays a sound
 *    - Adjusts the difficulty for all enemies
 *    - Switches to the GameWorld
 * 
 * Each time it's clicked, it increases or decreases enemy difficulty
 * based on the current game status.
 * 
 * @author Kung, Lin
 * @version 2025/6/5
 */
public class StartButton extends Actor {
    private GreenfootImage normalImage = new GreenfootImage("start.png");
    private GreenfootImage pressedImage = new GreenfootImage("start1.png");

    /**
     * Constructs a StartButton with scaled default and pressed images.
     */
    public StartButton() 
    {
        normalImage.scale(240, 110); //size of button
        pressedImage.scale(250, 350); 
        setImage(normalImage);
    }
    /**
     * When pressed
     *   - Changes image for user feedback
     * When clicked
     *   - Starts the game.
     */
    public void act() 
    {
        if (Greenfoot.mousePressed(this)) 
        {
            setImage(pressedImage); // Change to pressed version
        }

        if (Greenfoot.mouseClicked(this)) 
        {
            //GameWorld.victory=true; //for test
            Greenfoot.playSound("start.mp3"); //play sound when clicked
            BasicEnemy.adjust(); //adjust difficulty for basic enemy
            MiniBoss.adjust(); //adjust difficulty for basic enemy
            BossMissile.adjust(); //adjust difficulty for BossMissile
            GameWorld.victory=false;  //for test
            if(MainScreen.bgm.isPlaying())
            {
                    MainScreen.bgm.stop();
            }   
            Greenfoot.setWorld(new GameWorld()); // Start the game
        }
    }
}
