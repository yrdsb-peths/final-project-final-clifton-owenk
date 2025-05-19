import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Jet here.
 * 
 * @author Kung
 * @version (a version number or a date)
 */
public class Jet extends Actor
{
    /**
     * Constructor: sets the image of the jet to "jet.png"
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
}
