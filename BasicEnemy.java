import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * BasicEnemy is a drone that moves downward.
 * It damages the Jet on contact, drops a coin when destroyed,
 * and disappears when health reaches 0 or off-screen.
 * @version 2025/6/4
 */
public class BasicEnemy extends Actor
{  
    public static int spawnDelay = 60;
    public static int baseHealth = 100;
    public static int baseDamage = 50;
    
    private int speed = 2;
    private int health;
    private int damage;
    private HealthBar bar;

    public BasicEnemy()
    {
        health = baseHealth;
        damage = baseDamage;
        bar = new HealthBar(baseHealth, 40, 5); // 100 HP, bar width 40x5
    }

    public void addedToWorld(World world)
    {
        getWorld().addObject(bar, getX(), getY() - 40); // bar above drone
    }

    public void act()
    {
        if (getWorld() == null) 
        {
            return;
        }

        setLocation(getX(), getY() + speed);

        if (bar != null && bar.getWorld() != null)
        {
            bar.setLocation(getX(), getY() - 40); // update bar position
        }

        if(getWorld() != null)
        {
            checkCollisionWithJet();
        }

        if (getWorld() != null) 
        {
            checkOffScreen();
        }

        // Only check for bullets if still in the world
        if(getWorld() != null)
        {
            Bullet bullet = (Bullet)getOneIntersectingObject(Bullet.class);
            if(bullet != null && bullet.getWorld() != null)
            {
                getWorld().removeObject(bullet);
                takeDamage(100); 
            }
        }
    }

    /**
     * Check for collision with Jet and deal damage
     */
    public void checkCollisionWithJet()
    {
        if (isTouching(Jet.class))
        {
            Jet jet = (Jet)getOneIntersectingObject(Jet.class);
            if (jet != null)
            {
                jet.takeDamage(baseDamage); // Deal  damage
            }

            Explosion explosion = new Explosion();
            getWorld().addObject(explosion, getX(), getY());

            removeSelf();
        }
    }

    /**
     * Remove enemy if off the screen
     */
    public void checkOffScreen()
    {
        if (isAtEdge())
        {
            removeSelf();
        }
    }

    /**
     * Reduce health and remove if zero
     */
    public void takeDamage(int damage)
    {
        health -= damage;
        bar.loseHealth(damage);

        if (health <= 0)
        {
            Coin coin = new Coin();
            getWorld().addObject(coin, getX(), getY());

            Explosion explosion = new Explosion();
            getWorld().addObject(explosion, getX(), getY());

            GameWorld.killCount++;
            removeSelf();
            return; 
        }
    }

    /**
     * Safely remove enemy and health bar
     */
    public void removeSelf()
    {
        if (getWorld() != null)
        {
            if (bar != null && bar.getWorld() != null)
            {
                getWorld().removeObject(bar);
            }
            getWorld().removeObject(this);
        }
    }
    
    /**
     * Update difficulty when rank points change
     */
    public static void adjust() 
    {
        if(GameWorld.victory==true) 
        {
            spawnDelay = Math.max(10, spawnDelay -2); //never goes under 10
            baseHealth += 100;
            baseDamage += 50; 
        }
        else if(GameWorld.victory == false)
        {
            spawnDelay = Math.max(10, spawnDelay +2);
            baseHealth = Math.max(100, baseHealth -= 100);
            baseDamage = Math.max(50, baseDamage -=50);
        }
    }
    public static int getSpawnDelay()
    {
        return spawnDelay;
    }
}
