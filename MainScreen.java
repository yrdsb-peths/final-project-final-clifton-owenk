import greenfoot.*;

/**
 * MainScreen is the screen is a place to 
 * start game
 * guide
 * upgrade
 */
public class MainScreen extends World
{
    private boolean started = false; //check if game started
    public MainScreen() {
        super(400, 750, 1); // size of main screen
        
        GreenfootImage bg = new GreenfootImage("mainScreen_background.png");
        bg.scale(getWidth(), getHeight()); //resize background to world size
        setBackground(bg);
        
        // add start button, near buttom of main screen
        addObject(new StartButton(), getWidth() / 2, getHeight() - 100); 
    }

    public void act() 
    {

    }
}
