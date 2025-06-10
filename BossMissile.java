import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * BossMissile is launched by the MiniBoos to damage the player's jet.
 * 
 * The missile:
 *   -Moves downward
 *   -Deals damage to the Jet on contact
 *   -Can be destroyed by bullets
 *   -Displays a health bar
 * 
 * Following factors adjusted based on player's rank.
 *  -Speed
 *  -Health
 *  -Damage power
 * 
 * @author Kung, Lin
 * @version 2025/6/5
 */

public class BossMissile extends Actor
{
    //public int speed = 1; // missile speed
    private HealthBar bar; //health bar for missile
    
    private static int baseSpeed = 1;
    private static int baseHealth = 200;
    private static int damagePower=50; 
    
    /**
     * Constructs a BossMissile with its image, size, and health bar.
     */
    public BossMissile()
    {
        setImage("boss_missile.png"); 
        getImage().scale(30,60); //set size
        bar = new HealthBar(baseHealth, 40, 5); // 200 health, health bar size 40x5
    }
    /**
     * Places healthbar above the missile
     *
     * @param world the world the missile was added to
     */
    public void addedToWorld(World world)
    {
        getWorld().addObject(bar, getX(), getY()-35); //place bar above missile
    }
    /**
     * Moves the missile downward
     * Updates the health bar,
     * Checks for collision with Jet or bullets
     * Removes itself 
     *   -when hit 
     *   -or when it reaches the screen edge.
     */
    public void act()
    {
        if(getWorld() ==null)
        {
            return; 
        }
        
        setLocation(getX(), getY() + baseSpeed); //Move downward
        
        if (bar != null && bar.getWorld() != null) 
        {
            updateHealthBarPosition(); // Only update position if bar is in the world
        }
        
        //ifhits the Jet, deal dameg
        if(isTouching(Jet.class))
        {
            Jet jet = (Jet) getOneIntersectingObject(Jet.class);
            if(jet != null)
            {
                jet.takeDamage(damagePower); //jet damaged by missel by amount of damage Power
            }
            removeSelf();
            return; //code wont run after missile removed
        }
        
        // If gets contact a bullet
        Bullet bullet = (Bullet)getOneIntersectingObject(Bullet.class);
        if (bullet != null) 
        {
            if(bullet.getWorld() != null)
            {
                getWorld().removeObject(bullet); //only remove when still n world
            }
            takeDamage(100); // bullet deals 100
            return;
        }
        
        //Remove missle if touch edge of screen
        if(isAtEdge())
        {
            removeSelf();
            return;
        }
    }
    /**
     * Updates the position of the missile's health bar so it follows the missile.
     */
    public void updateHealthBarPosition()
    {
        if (bar != null && getWorld() != null) 
        {
            bar.setLocation(getX(), getY() -35); //follow bossMissile above
        }
    }
    /**
     * Reduces the missile's health by a given amount.
     * If health reaches 0
     *   -Spawns an explosion
     *   -Removes itself.
     *
     * @param amount the amount of damage to take
     */
    public void takeDamage(int amount)
    {
        bar.loseHealth(amount);
        if(bar.getHealth() <= 0)
        {
            Explosion explosion = new Explosion();
            getWorld().addObject(explosion, getX(), getY());
            
            removeSelf(); // remove when health is 0, remove both bullet and missile
            return;
        }
    }
    /**
     * Safely removes the missile and its health bar from the world.
     */
    public void removeSelf()
    {
        if(getWorld() != null)
        {
            if(bar != null && bar.getWorld() != null)
            {
                getWorld().removeObject(bar);
            }
            getWorld().removeObject(this); //only run if still in world
        }
    }
    /**
     * Adjusts missile power based on previous battle result.
     *  -speed
     *  -health
     *  -damage
     * 
     * If the player won, difficulty increases.
     * If the player lost, difficulty decreases (but never below minimum thresholds).
     */
    public static void adjust() 
    {
        if(GameWorld.victory==true) 
        {
            baseSpeed += 1;
            baseHealth += 200;
            damagePower+=50;
        }
        else if(GameWorld.victory == false)
        {
            baseSpeed = Math.max(1, baseSpeed -= 1);
            baseHealth = Math.max(200, baseHealth -=200); 
            damagePower=Math.max(50, damagePower -=50); 
        }
    }
}
