import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * show screen when miniBoss defeated
 */
public class Victory extends World
{
    private int timer = 0;
    private boolean bannerShown = false;
    private boolean wordShown = false;
    
    public Victory()
    {    
        super(400, 750, 1); 
        setBackground("background_blur.png");
    }
    
    public void act()
    {
        timer++;
        
        if(timer ==30 &&!bannerShown)
        {
            // Slightly to the right
            addObject(new VictoryBanner(), getWidth()/2 +10, getHeight()/2);
            bannerShown = true; 
        }
        
        //after 45 frames show word
        if(timer == 45 && !wordShown)
        {
            addObject(new VictoryWord(), getWidth()/2, getHeight()/2); // place in middle
            wordShown = true; 
        }
    }
}
