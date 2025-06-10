import greenfoot.*;

/**
 * Bullet is fired by the player's jet and travels upward.
 *
 * It deals damage to enemies such as 
 *  -BasicEnemy
 *  -MiniBoss
 * 
 * It disappears after 
 *  -hitting an enemy 
 *  -or reaching the top of the screen.
 * 
 * @author Kung, Lin
 * @version 2025/6/8
 */

public class Bullet extends Collidable
{
    private int speed = 10;
    
    //public static, will be used in JetUpgrade
    public static int baseDamage = 100; 

    /**
     * Constructs a Bullet with its image scaled to fit the game.
     */
    public Bullet() 
    {
        GreenfootImage image = new GreenfootImage("jet_bullet.png"); 
        image.scale(20, 40);
        setImage(image);
    }
    /**
     * Moves the bullet upward
     * 
     * Checks for collisions with the following
     * ,deals wih damage and removes the bullet
     *  -BascEnemy
     *  -MiniBoss
     *  
     * Removes the bullet if it reaches the top of the screen
     */
    public void act()
    {
        setLocation(getX(), getY() - speed);

        // Check if bullet hits a drone, get removed and does damage when contact basicEnemy
        BasicEnemy enemy = (BasicEnemy)getOneIntersectingObject(BasicEnemy.class);
        if (enemy != null && isPixelTouching(enemy))
        {
            enemy.takeDamage(baseDamage); // Deal damage
            getWorld().removeObject(this); // Remove bullet
            return;
        }
        
        //check if bullet hit MiniBoss, get removed and does damage when contact miniBoss
        MiniBoss boss = (MiniBoss)getOneIntersectingObject(MiniBoss.class);
        if(boss!=null && isPixelTouching(boss))
        {
            boss.takeDamage(baseDamage);
            getWorld().removeObject(this);
            return;
        }

        // Remove if bullet reaches edge
        if (getY() <= 80) 
        {
            getWorld().removeObject(this);
        }
    }    
}
