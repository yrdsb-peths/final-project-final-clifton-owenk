import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The TitleScreen class displays a short animated slideshow
 * before transitioning to the main menu screen.
 *
 * It automatically switches to the MainScreen after showing all title frames.
 * Each image stays on the screen for a fixed delay (default 60 frames).
 * 
 * @author  Kung, Lin
 * @version 2025/6/8
 */
public class TitleScreen extends World
{
    private GreenfootImage[] titleImages = new GreenfootImage[7];
    private int frame =0; //cur frame
    private int delay =60; //how long each image stays 
    private int timer = 0; 
    private GreenfootSound bgm;
     
    /**
     * Constructs the title screen.
     * 
     * Loads and scales all the title images into memory and displays the first image.
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(400,750, 1); 
        
        //show images while player waiting for the game to start
        slideShow();
        
        GameWorld.gamePlay=false; //indicates player is not in GameWorld
    }
    /**
     * Stars music only after play button is pressed on the Greenfoot interface
     */
    public void started()
    {
           //playBGM();
    }
    /**
     *  Play BGM for Title Screen
     */
    private void playBGM()
    {
       bgm= new GreenfootSound("sounds/mainScreen.mp3");
       bgm.setVolume(20);
       bgm.play();
    }
    /**
     * Show images while player waiting for the game to start
     */
    private void slideShow()
    {
        //Load all title images into array
        for(int i=0; i<titleImages.length; i++)
        {
            titleImages[i] = new GreenfootImage("images/title/title" + (i+1)+ ".png");
            titleImages[i].scale(getWidth(), getHeight());
        }
        setBackground(titleImages[frame]);
    }
    /**
     * Displays each image for a short duration and moves to the next image until all are d.
     * Then it automatically switches to the MainScreen.
     */
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
                //stop the background music before switch world
                //bgm.setVolume(5);
                //bgm.stop();
                Greenfoot.setWorld(new MainScreen());
            }
        }
    }
}
