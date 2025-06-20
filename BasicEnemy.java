import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * BasicEnemy represents a simple drone enemy that moves downward.
 * 
 * Damages the Jet on contact
 * Drops coin and creates an explosion when destroyed,
 * Disappears when it reaches the bottom of the screen. 
 * Has a health bar displayed above it.
 *
 * Its difficulty (spawn rate, health, damage) depends on player’s rank
 * 
 * @autho: Kung, Lin
 * @version 2025/6/10
 */
public class BasicEnemy extends Collidable
{  
    public static int spawnDelay = 60; //Delay between spawns, in frames
    public static int baseHealth = 100; //Base health for all BasicEnemy instances
    public static int baseDamage = 50; //Base damage dealt to the Jet on collision
    
    private int speed = 2;
    private int health;
    private int damage;
    private HealthBar bar;
    
    /**
     * Constructs a BasicEnemy with default base health and damage.
     * Creates health bar to display above the enemy.
     */
    public BasicEnemy()
    {
        health = baseHealth;
        damage = baseDamage;
        bar = new HealthBar(baseHealth, 40, 5); // 100 HP, bar width 40x5
    }
    /**
     * Adds enemy’s health bar slightly above its head.
     *
     * @param world the world the enemy is being added to
     */
    public void addedToWorld(World world)
    {
        getWorld().addObject(bar, getX(), getY() - 40); // bar above drone
    }
    /**
     * Moves downward
     * Updates the health bar position
     * Deals wtih:
     *  Collisions with the Jet
     *  Off-screen removal
     *  Hits from bullets
     * 
     */
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
                takeDamage(Bullet.baseDamage); 
            }
        }
    }
    /**
     * Checks for a collision with the Jet.
     * Deals damage to the Jet if touched
     *     -spawns an explosion
     *     -removes itself.
     */
    public void checkCollisionWithJet()
    {
        Jet jet = (Jet)getOneIntersectingObject(Jet.class);
        if (jet!=null && isPixelTouching(jet))
        {
            jet.takeDamage(baseDamage); // Deal  damage

            Explosion explosion = new Explosion();
            getWorld().addObject(explosion, getX(), getY());

            removeSelf();
        }
    }
    /**
     * Removes the enemy if it reaches the edge of the screen.
     */
    public void checkOffScreen()
    {
        if (isAtEdge())
        {
            removeSelf();
        }
    }

     /**
     * Reduces the enemy's health by the specified amount.
     * If health drops to 0 or below,
     *    -Drops a coin
     *    -Spawns an explosion
     *    -Removes itself.
     *
     * @param damage: the amount of damage taken
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
     * Safely removes the enemy and its health bar from the world.
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
     * Adjusts the following difficulty level of the base enemy 
     * based on the outcome of the previous battle.
     *  -spawn delay
     *  -base health
     *  -base damage
     * 
     * If GameWorld.victory=true: makes enemies harder.
     * If GameWorld.victory=false: makes enemies easier, with minimum limits.
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
            spawnDelay = Math.min(60, spawnDelay +2);
            baseHealth = Math.max(100, baseHealth -= 100);
            baseDamage = Math.max(50, baseDamage -=50);
        }
    }
      /**
     * Gets the current spawn delay value.
     * 
     * @return the number of frames between enemy spawns
     */
    public static int getSpawnDelay()
    {
        return spawnDelay;
    }
}
