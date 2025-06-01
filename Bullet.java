import greenfoot.*;

/**
 * Bullet class for the jet's automatic shooting.
 * The bullet travels upward and disappears when off-screen.
 */
public class Bullet extends Actor
{
    private int speed = 10;

    public Bullet() 
    {
        GreenfootImage image = new GreenfootImage("jet_bullet.png"); 
        image.scale(20, 40);
        setImage(image);
    }

    public void act()
    {
        setLocation(getX(), getY() - speed);

        // Check if bullet hits a drone, get removed and does damage when contact basicEnemy
        BasicEnemy enemy = (BasicEnemy)getOneIntersectingObject(BasicEnemy.class);
        if (enemy != null)
        {
            enemy.takeDamage(100); // Deal 100 damage
            getWorld().removeObject(this); // Remove bullet
            return;
        }
        
        //check if bullet hit MiniBoss, get removed and does damage when contact miniBoss
        MiniBoss boss = (MiniBoss)getOneIntersectingObject(MiniBoss.class);
        if(boss!=null)
        {
            boss.takeDamage(100);
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
