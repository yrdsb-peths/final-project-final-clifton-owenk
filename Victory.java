import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Victory class displays a screen when the player defeats the MiniBoss.
 *
 * Shows a victory banner
 * Plays a sound effect
 * Awards 100 rank points
 * Updates GameWorld.victory to true
 * Displays ReturnButton to go back to the MainScreen
 * 
 * @author Kung, Lin
 * @version 2025/6/4
 */
public class Victory extends World
{
    private int frameCounter =0;
    private boolean bannerAdded = false;
    private boolean buttonAdded = false;
    
    /**
     * Constructs the Victory screen.
     * 
     * Sets the background
     * Plays the victory sound
     * Adds 100 rank points
     * Marks the game as won by GameWorld.victory=true
     */
    public Victory()
    {    
        super(400, 750, 1); 
        setBackground("background_blur.png");
        Greenfoot.playSound("sounds/victory.mp3");
        GameWorld.rankPoints += 100; // add 100 points when this screen shown
        GameWorld.victory = true; //if is true, can increase difficulty
        GameWorld.gamePlay=false; //indicates player is not in GameWorld
    }
    /**
     * Displays the victory banner after a short delay
     * Adds the ReturnButton to MainScreen after a longer delay.
     */
    public void act()
    {
        frameCounter++;
        
        if(!bannerAdded && frameCounter >= 2) //delay 60 frames
        {
            VictoryBanner banner = new VictoryBanner();
            
            //place banner near center, slight right
            addObject(banner, getWidth()/2, getHeight()/2); 
            bannerAdded = true;
        }
        
        if(!buttonAdded && frameCounter >= 120){
            addObject(new ReturnButton(), getWidth() / 2, getHeight() / 2 + 300); //Adds the return to home screen after the victory sound plays (approx: 2 seconds)
        }
    }
}