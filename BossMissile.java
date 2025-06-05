import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * used by miniBoss damage players jet
 * It moves downward, damages jet when contact, and can be destoryed by bullet
 * @version 2025/6/5
 */
public class BossMissile extends Actor
{
<<<<<<< Updated upstream
    //public int speed = 1; // missile speed
    private HealthBar bar; //health bar for missile
    
    private static int baseSpeed = 1;
    private static int baseHealth = 200;
    public static int damagePower=50; //public access for testing, change back to privae after testing
    
=======
    int baseSpeed = 1;
    int baseHealth = 200;
    int level = RankManager.getDifficultyLevel();

    public int speed = baseSpeed + level;
    private HealthBar bar = new HealthBar(baseHealth + level * 20, 40, 5);

>>>>>>> Stashed changes
    public BossMissile()
    {
        setImage("boss_missile.png"); 
        getImage().scale(30,60); //set size
        bar = new HealthBar(baseHealth, 40, 5); // 200 health, health bar size 40x5
    }
    
    public void addedToWorld(World world)
    {
        getWorld().addObject(bar, getX(), getY()-35); //place bar above missile
    }

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
    
    public void updateHealthBarPosition()
    {
        if (bar != null && getWorld() != null) 
        {
            bar.setLocation(getX(), getY() -35); //follow bossMissile above
        }
    }
    
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
     * Update difficulty when rank points change
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
