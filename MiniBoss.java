import greenfoot.*;

/**
 * MiniBoss is a stronger enemy
 *  -First moves down to 1/3 of the screen,
 *  -Then moves left and right
 *  -It periodically fires missiles
 *  -Has a large health bar
 *  -Triggers the victory screen when defeated.
 * 
 * @author Kung, Lin
 * @version 2025/6/5
 */
public class MiniBoss extends Actor 
{
    private int speedY = 2;      // Speed for moving down
    private int speedX = 1;      // Speed for moving sideways
    private boolean reachedTargetY = false; //1/3 of the screen
    private HealthBar bar;
    private GreenfootSound bgm;
    private int missileTimer =0; //times the space between each missile
    
    public static int baseXSpeed = 1;
    public static int baseHealth = 2000;
    public static int spawnDelay = 180;
    
    /**
     * Constructor: initializes image, size, and health bar.
     */
    public MiniBoss()
    {
        setImage("miniBoss.png");
        getImage().scale(200,200); //resize image

        bar = new HealthBar(baseHealth, 200, 5); // Boss health set to 2000
    }
    /**
     * Place the health bar above it.
     */
    public void addedToWorld(World world)
    {
        world.addObject(bar, getX(), getY() -120); // put health bar above boss
        bar.updateBar();
    }
    /**
     * Updates the health bar's position to stay above the boss.
     */
    public void updateHealthBarPosition()
    {
        bar.setLocation(getX(), getY() -120); // healthbar always move with miniBoss
    }
    
    /**
     * Move downward until 1/3 of the screen height
     * Then move left and right
     */
    public void act() 
    {
        if (!reachedTargetY) 
        {
            moveDown();
        } 
        else 
        {
            moveSideways();
        }
        updateHealthBarPosition();
        
        missileTimer++;
        if(missileTimer>= spawnDelay) //180 frames 5second each time
        {
            fireMissiles();
            missileTimer =0;
        }
    }

    /**
     * Moves the boss downward until it reaches 1/3 of the screen height.
     */
    public void moveDown() 
    {
        setLocation(getX(), getY() + speedY);
        if (getY() >= getWorld().getHeight() / 3) 
        {
            reachedTargetY = true;   // 1/3 of screen
        }
    }

     /**
     * Moves the mini-boss left and right.
     * Turns around when it touches the edge of the screen.
     */
    public void moveSideways() {
        setLocation(getX() + baseXSpeed, getY());

        // If at the left or right edge, reverse direction
        if (isAtEdge()) 
        {
            baseXSpeed = -baseXSpeed; //change direction
        }
    }
    /**
     * Applies damage to the boss and checks for if player wins the game
     * @param amount The amount of damage to apply
     */
    public void takeDamage(int amount)
    {
        bar.loseHealth(amount);
        if(bar.getHealth() <=0)
        {
            GameWorld gw = (GameWorld) getWorld();
            gw.getBGM().stop();
            
            Greenfoot.playSound("sounds/explosion-m.mp3");
            GameWorld.money += 5000; // add money 5000 if dead
            GameWorld.killCount++; // add one to killCount
            Greenfoot.delay(120);
            Explosion explosion = new Explosion();
            getWorld().addObject(explosion, getX(), getY());
            getWorld().removeObject(bar);
            getWorld().removeObject(this);
            Greenfoot.setWorld(new Victory()); // go to victory world when boss dead
            
        }
    }
    /**
     * Fires two missiles from the left and right sides of the boss.
     */
    public void fireMissiles()
    {
        if(getWorld() == null)
        {
            return;
        }
        
        int xLeft = getX()-70; //position from left wing
        int xRight = getY()+60; // position from right wing
        int y = getY() + 60; //from below the boss
        
        getWorld().addObject(new BossMissile(), xLeft, y);
        getWorld().addObject(new BossMissile(), xRight, y);
        
    }
    /**
     * Getter for background music
     */
    public GreenfootSound getBGM()
    {
        return bgm;
    }
    
     /**
     * Adjusts MiniBoss difficulty based on rankPoints.
     */
    public static void adjust() 
    {
        if(GameWorld.victory==true) 
        {
            baseXSpeed = Math.min (5, baseXSpeed += 1); 
            baseHealth += 2000;
            spawnDelay = Math.min(10, spawnDelay -= 10);
        }
        else if(GameWorld.victory == false)
        {
            baseHealth = Math.max(2000, baseHealth -=2000);
            baseXSpeed = Math.max(1, baseXSpeed -=1);
            spawnDelay = Math.max(180, spawnDelay += 10);
        }
    }
    
}
