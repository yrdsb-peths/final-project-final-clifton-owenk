import greenfoot.*;

/**
 * Bullet class for the jet's automatic shooting.
 * The bullet travels upward and disappears when off-screen.
 */
public class Bullet extends Actor
{
    private int speed = 10;  // Speed ofthe bullet 

    public Bullet() 
    {
        GreenfootImage image = new GreenfootImage("jet_bullet.png"); 
        image.scale(20, 40);  // bullet size
        setImage(image);     
    }

    public void act()
    {
        setLocation(getX(), getY() - speed);  // Move the bullet up
        
        if (isAtEdge()) 
        {
            getWorld().removeObject(this); // Remove bullet if touches the edge of screen
        }
    }
}
