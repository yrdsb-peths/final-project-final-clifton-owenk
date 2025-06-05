import greenfoot.*;

/**
 * MiniBoss is a stronger enemy that moves down to 1/3 of the screen,
 * then moves left and right horizontally.
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
    
<<<<<<< Updated upstream
    public static int baseXSpeed = 1;
    public static int baseHealth = 2000;
    public static int spawnDelay = 180;
=======
    int baseHealth =2000;
    int baseSideSpeed =1;
    int level = RankManager.getDifficultyLevel();
>>>>>>> Stashed changes
    
    public MiniBoss()
    {
        setImage("miniBoss.png");
        getImage().scale(200,200); //resize image
<<<<<<< Updated upstream

        bar = new HealthBar(baseHealth, 200, 5); // Boss health set to 2000
=======
        
        bar = new HealthBar(baseHealth + level * 200, 200, 5); //increase 200 each level
        speedX = baseSideSpeed + level; //gets faster with difficulty
>>>>>>> Stashed changes
    }
    
    public void addedToWorld(World world)
    {
        world.addObject(bar, getX(), getY() -120); // put health bar above boss
        bar.updateBar();
    }
    
    public void updateHealthBarPosition()
    {
        bar.setLocation(getX(), getY() -120); // healthbar always move with miniBoss
    }
    
    /**
     * move downward until 1/3 of the screen height,
     * then move left and right.
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
     * Move the mini-boss down 
     * until it reach 1/3 of the screen height.
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
     *turns around when touches the edge of the screen.
     */
    public void moveSideways() {
        setLocation(getX() + baseXSpeed, getY());

        // If at the left or right edge, reverse direction
        if (isAtEdge()) 
        {
            baseXSpeed = -baseXSpeed; //change direction
        }
    }
    
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
    
    public GreenfootSound getBGM()
    {
        return bgm;
    }
    
    /**
     * Update difficulty when rank points change
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
