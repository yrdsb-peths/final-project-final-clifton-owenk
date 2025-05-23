import greenfoot.*;

/**
 * MiniBoss is a stronger enemy that moves down to 1/3 of the screen,
 * then moves left and right horizontally.
 */
public class MiniBoss extends Actor 
{
    private int speedY = 2;      // Speed for moving down
    private int speedX = 2;      // Speed for moving sideways
    private boolean reachedTargetY = false; //1/3 of the screen
    private HealthBar bar;
    
    public MiniBoss()
    {
        setImage("miniBoss.png");
        getImage().scale(200,200); //resize image

        bar = new HealthBar(20000, 200, 20); // Boss health set to 20000
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
        setLocation(getX() + speedX, getY());

        // If at the left or right edge, reverse direction
        if (isAtEdge()) 
        {
            speedX = -speedX; //change direction
        }
    }
    
    public void takeDamage(int amount)
    {
        bar.loseHealth(amount);
        if(bar.getHealth() <=0)
        {
            Greenfoot.playSound("sounds/explosion-m.mp3");
            Greenfoot.delay(120);
            Explosion explosion = new Explosion();
            getWorld().addObject(explosion, getX(), getY());
            getWorld().removeObject(bar);
            getWorld().removeObject(this);
            
        }
    }
}
