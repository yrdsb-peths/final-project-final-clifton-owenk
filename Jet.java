import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Jet class is an object that player is controlling in the game
 * The jet can move up, down, left, and right using the arrow keys.
 */
public class Jet extends Actor
{
    private int autoShootTimer = 0;  // Countdown to control the gap between bullets
    
    /**
     * Constructor: Sets the image of the Jet to the provided jet.png file.
     */
    public Jet()
    {
        GreenfootImage image = new GreenfootImage("jet.png"); // Load the image
        image.scale(100, 100); // Resize the image to 100x100 
        setImage(image); // Apply the resized image to Jet
    }

    public void act()
    {
        moveWithKeys(); 
        autoShoot(); // automatically shoots bullet at fix rate
    }
    
    /**
     * Checks which arrow keys are being pressed
     * Jet moves in that direction
     */
    public void moveWithKeys()
    {
        //Move the jet up if the "up" key is pressed
        if (Greenfoot.isKeyDown("up")) 
        {
            setLocation(getX(), getY() - 5);
        }
        
        // Move the jet down if the "down" key is pressed
        if (Greenfoot.isKeyDown("down")) 
        {
            setLocation(getX(), getY() + 5);
        }

        // Move the jet left if the "left" key is pressed
        if (Greenfoot.isKeyDown("left")) 
        {
            setLocation(getX() - 5, getY());
        }

        // Move the jet right if the "right" key is pressed
        if (Greenfoot.isKeyDown("right")) 
        {
            setLocation(getX() + 5, getY());
        }
    }
    
    /**
    * Automatically shoot bullets every few frames.
    */
    public void autoShoot()
    {
        if (autoShootTimer == 0) 
        {
            Bullet bullet = new Bullet();  // Create a new bullet
            getWorld().addObject(bullet, getX(), getY() - 50);  // bullet position above jet
            autoShootTimer = 20;  // Delay between shots 20 frames (3 per second)
        }

        if (autoShootTimer > 0) 
        {
            autoShootTimer--; // count down 20 frames
        }
    }
}
