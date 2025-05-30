import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * show screen when miniBoss defeated
 */
public class Victory extends World
{
    private int frameCounter =0;
    private boolean bannerAdded = false;
    
    public Victory()
    {    
        super(400, 750, 1); 
        setBackground("background_blur.png");
        Greenfoot.playSound("sounds/victory.mp3");
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
        
        
    }
}
