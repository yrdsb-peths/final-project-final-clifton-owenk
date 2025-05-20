import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Jet class is an object that player is controlling in the game
 * The jet can move up, down, left, and right using the arrow keys.
 */
public class Jet extends Actor
{
    private int autoShootTimer = 0;  // Countdown to control the gap between bullets
    private HealthBar bar;
    /**
     * Constructor: Sets the image of the Jet to the provided jet.png file.
     */
    public Jet()
    {
        GreenfootImage image = new GreenfootImage("jet.png"); // Load the image
        image.scale(100, 100); // Resize the image to 100x100 
        setImage(image); // Apply the resized image to Jet
        
        bar = new HealthBar(); //add healthbar
    }

    public void act()
    {
        moveWithKeys(); 
        autoShoot(); // automatically shoots bullet at fix rate
        updateHealthBarPosition();
    }
    
    /**
     * Checks which arrow keys are being pressed
     * Jet moves in that direction
     */
    public void moveWithKeys()
    {
        //Move the jet up if the "up" key is pressed
        if (Greenfoot.isKeyDown("w")) 
        {
            setLocation(getX(), getY() - 5);
        }
        
        // Move the jet down if the "down" key is pressed
        if (Greenfoot.isKeyDown("s")) 
        {
            setLocation(getX(), getY() + 5);
        }

        // Move the jet left if the "left" key is pressed
        if (Greenfoot.isKeyDown("d")) 
        {
            setLocation(getX() - 5, getY());
        }

        // Move the jet right if the "right" key is pressed
        if (Greenfoot.isKeyDown("a")) 
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
    
    public void addedToWorld(World world)
    {
        world.addObject(bar, getX(), getY() + 70); //Add health bar under jet
    }
    
    public void updateHealthBarPosition()
    {
        bar.setLocation(getX(), getY() +70);
    }
    
    public void takeDamage(int amount)
    {
        bar.loseHealth(amount);
    }
}
