import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author Kung
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    public int speed = 10; 
    
    public Bullet()
    {
        GreenfootImage image = new GreenfootImage("jet_bullet.png"); 
        image.scale(20, 40); //bullet size
        setImage(image); 
    }
    public void act()
    {
        // Move bullet up
        setLocation(getX(), getY() - speed);
        
        //Remove bullet if it goes to the edge of screen
        if(isAtEdge())
        {
            getWorld().removeObject(this);
        }
    }
}
