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

        // Check if bullet hits a drone
        BasicEnemy enemy = (BasicEnemy)getOneIntersectingObject(BasicEnemy.class);
        if (enemy != null)
        {
            enemy.takeDamage(100); // Deal 100 damage
            getWorld().removeObject(this); // Remove bullet
            return;
        }

        // Remove if bullet reaches edge
        if (isAtEdge()) 
        {
            getWorld().removeObject(this);
        }
    }
}
