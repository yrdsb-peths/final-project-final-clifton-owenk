import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class TitleScreen extends World
{
    private GreenfootImage[] titleImages = new GreenfootImage[7];
    private int frame =0; //cur frame
    private int delay =60; //how long each image stays 
    private int timer = 0; 
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(400,750, 1); 
        
        //Load all title images into array
        for(int i=0; i<titleImages.length; i++)
        {
            titleImages[i] = new GreenfootImage("images/title/title" + (i+1)+ ".png");
            titleImages[i].scale(getWidth(), getHeight());
        }
        setBackground(titleImages[frame]);
    }
    public void act()
    {
        timer++;
        if(timer>=delay)
        {
            frame++;
            timer =0;
            
            if(frame<titleImages.length)
            {
                setBackground(titleImages[frame]);
            }
            else
            {
                Greenfoot.setWorld(new MainScreen());
            }
        }
    }
}
