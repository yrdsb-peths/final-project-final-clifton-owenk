import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Defeat is a screen that shows up when the player's health bar reaches zero
 * This screen ends the game
 * shows defeat
 * @version 2025/6/4
 */
public class Defeat extends World
{
    private int timer = 0; //delay showing defeat banner timer
    private boolean bannerShown = false;
    private boolean wordShown = false;
    private boolean buttonAdded = false; //checks if the button is added
    
    public Defeat()
    {    
        super(400, 750, 1);  // Same size as game screen
        setBackground("background_blur.png"); //Set the background
        Greenfoot.playSound("sounds/defeat.mp3");
        
        // reduce rank points when this screen shown
        if(GameWorld.rankPoints >= 100)
        {
            GameWorld.rankPoints -= 100;
        }
        else
        {
            GameWorld.rankPoints = 0; 
        }
        
        GameWorld.victory = false; //if is false, can decrease difficulty
    }
    
    public void act()
    {
        timer++;
        
        //after 30 frames show banner
        if(timer == 30 && !bannerShown)
        {
            addObject(new DefeatBanner(), getWidth()/2 + 20, getHeight()/2);  // place in middle
            bannerShown = true;
        }
        
        //after 45 frames show word
        if(timer == 45 && !wordShown)
        {
            addObject(new DefeatWord(), getWidth()/2, getHeight()/2); // place in middle
            wordShown = true; 
        }
        
        if(!buttonAdded && timer >= 120){
            addObject(new ReturnButton(), getWidth() / 2, getHeight() / 2 + 300); //the return to home button shows on the defeat screen after playing the defeat sound (approx: 2 seconds)
        }
    }
}