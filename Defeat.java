import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Defeat class represents the Game Over screen 
 * when the player’s health reaches zero.
 *  
 * Feature:
 *  -Displays a Defeat Banner and Home return button.
 *  -Plays defeat sound upon creation.
 *  -Reduces the player’s rank points.
 *  -Signal to the GameWorld that the player has lost.  (victory==false)
 *  
 * @author: Kung, Lin
 * @version 2025/6/10
 */

public class Defeat extends World
{
    private int timer = 0; //delay showing defeat banner timer
    private boolean bannerShown = false;
    private boolean wordShown = false;
    private boolean buttonAdded = false; //checks if the button is added
    
    /**
     *Constructor for objects of class Defeat.
     * 
     * Initializes the defeat screen byy:
     * Setting background</li>
     * Playing defeat sound</li>
     * Reducing player rank</li>
     * Marking the defeat condition in GameWorld
     * 
     */
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
        GameWorld.gamePlay=false; //indicates player is not in GameWorld
    }
         
    /**
     * Act - Called repeatedly to manage screen display timing.
     * 
     * Showing the defeat banner after 30 frames
     * Displaying defeat text after 45 frames
     * Adding return button after 120 frames
     *
     */ 
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