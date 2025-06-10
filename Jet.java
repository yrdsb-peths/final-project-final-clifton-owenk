import greenfoot.*;  

/**
 * The Jet class represents the player-controlled aircraft.
 * 
 * The jet:
 *   -Moves using W/A/S/D keys
 *   -Automatically shoots bullets at a fixed interval
 *   -Has a health bar displayed below it
 *   -Triggers a defeat screen when health reaches zero
 * 
 * @author Kung, Lin
 * @version 2025/6/10
 */
public class Jet extends Collidable
{
    
    private int autoShootTimer = 0;  // Countdown to control the gap between bullets
    private HealthBar bar;
    
    public static int baseHealth = 100;
    public static int baseSpeed = 3;
    public static int shootInterval = 20;
    
    /**
     * Constructor: Sets the image of the Jet to the provided jet.png file.
     */
    public Jet()
    {
        GreenfootImage image = new GreenfootImage("jet.png"); // Load the image
        image.scale(100, 100); // Resize the image to 100x100 
        setImage(image); // Apply the resized image to Jet
        
        bar = new HealthBar(baseHealth, 100, 5);//add healthbar, and set maxHealth to 100
    }
     /**
     * Handles how jet moves, shoots, and health bar updates.
     */
    public void act()
    {
        moveWithKeys(); 
        autoShoot(); // automatically shoots bullet at fix rate
        updateHealthBarPosition();
    }
    
    /**
     * Checks which WSAD keys are being pressed
     * Jet moves accordingly
     */
    public void moveWithKeys()
    {
        //Move the jet up if the "up" key is pressed
        if (Greenfoot.isKeyDown("w")) 
        {
            setLocation(getX(), getY() - baseSpeed);
        }
        
        // Move the jet down if the "down" key is pressed
        if (Greenfoot.isKeyDown("s")) 
        {
            setLocation(getX(), getY() + baseSpeed);
        }

        // Move the jet left if the "left" key is pressed
        if (Greenfoot.isKeyDown("a")) 
        {
            setLocation(getX() - baseSpeed, getY());
        }

        // Move the jet right if the "right" key is pressed
        if (Greenfoot.isKeyDown("d")) 
        {
            setLocation(getX() + baseSpeed, getY());
        }
    }
    
    /**
     * Automatically shoots bullets at shootInteval
     * Bullets appear above the jet.
     */
    public void autoShoot()
    {
        if (autoShootTimer == 0) 
        {
            Bullet bullet = new Bullet();  // Create a new bullet
            getWorld().addObject(bullet, getX(), getY() - 50);  // bullet position above jet
            autoShootTimer = shootInterval;  // Delay between shots 20 frames (3 per second)
        }

        if (autoShootTimer > 0) 
        {
            autoShootTimer--; // count down 20 frames
        }
    }
      /**
     * Adds the health bar just below the jet.
     *
     * @param world the world this Jet is added to
     */
    public void addedToWorld(World world)
    {
        world.addObject(bar, getX(), getY() + 70); //Add health bar under jet
    }
    /**
     * Keeps the health bar aligned with the jet's position.
     */
    public void updateHealthBarPosition()
    {
        bar.setLocation(getX(), getY() +70);
    }
    /**
     * Reduces the jet's health by the specified amount.
     * If health reaches zero
     *   -The background music is stopped
     *   -The Defeat screen is shown.
     *
     * @param amount: the amount of damage taken
     */
    public void takeDamage(int amount)
    {
        bar.loseHealth(amount); // lose health
        
        if(bar.getHealth() <= 0)
        {
            GameWorld gw = (GameWorld) getWorld();
            gw.getBGM().stop();
            Greenfoot.setWorld(new Defeat()); //swithch to game over screen when health is zero
        }
    }
}
