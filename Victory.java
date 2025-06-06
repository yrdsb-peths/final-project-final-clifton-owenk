import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * show screen when miniBoss defeated
 * @version 2025/6/4
 */
public class Victory extends World
{
    private int frameCounter =0;
    private boolean bannerAdded = false;
    private boolean buttonAdded = false;
    
    public Victory()
    {    
        super(400, 750, 1); 
        setBackground("background_blur.png");
        Greenfoot.playSound("sounds/victory.mp3");
        GameWorld.rankPoints += 100; // add 100 points when this screen shown
        GameWorld.victory = true; //if is true, can increase difficulty
    }
    
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