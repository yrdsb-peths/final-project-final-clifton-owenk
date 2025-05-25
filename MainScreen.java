import greenfoot.*;

/**
 * MainScreen is the screen is a place to 
 * start game
 * guide
 * upgrade
 */
public class MainScreen extends World {
    public MainScreen() {
        super(400, 750, 1); // size of main screen
        
        GreenfootImage bg = new GreenfootImage("mainScreen_background.png");
        bg.scale(getWidth(), getHeight()); //resize background to world size
        setBackground(bg);
    }

    public void act() {
        // Start game when user presses a key (e.g. space)
        if (Greenfoot.isKeyDown("space")) {
            Greenfoot.setWorld(new GameWorld()); // Change to your actual game world
        }
    }
}
