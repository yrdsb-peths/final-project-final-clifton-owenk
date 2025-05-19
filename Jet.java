import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Jet here.
 * 
 * @author Kung
 * @version (a version number or a date)
 */
public class Jet extends Actor
{
    private int autoShootTimer =0; //space between each bullet
    /**
     * Constructor: jet object
     */
    public Jet()
    {
        GreenfootImage image = new GreenfootImage("jet.png"); //load image
        image.scale(100,100); //make jet size 100x100
        setImage(image);  //apply the size to the jet
    }
    
    public void act()
    {
        moveWithKeys(); 
        autoShoot(); //Automatically shoots bullets at fixed rate
    }
    
    /**
     * player control the jet by using up down left right keys
     */
    public void moveWithKeys()
    {
        if(Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(), getY()-5);
        }
        
        if (Greenfoot.isKeyDown("down")) 
        {
            setLocation(getX(), getY() + 5);
        }

        if (Greenfoot.isKeyDown("left")) 
        {
            setLocation(getX() - 5, getY());
        }
        
        if (Greenfoot.isKeyDown("right")) 
        {
            setLocation(getX() + 5, getY());
        }
    }
    /**
     * The position of the bullet, and the rate it shoot
    */
    public void autoShoot()
    {
        if(autoShootTimer==0)
        {
            Bullet bullet = new Bullet();  // Create a new bullet bullet
            getWorld().addObject(bullet, getX(), getY() - 50);  // bullet position above jet
            autoShootTimer = 20; // Delay between shots 20 frames betwen
        }
        
        if(autoShootTimer>0)
        {
            autoShootTimer--; //start 20 when hits 0 shoot again
        }
    }
}
