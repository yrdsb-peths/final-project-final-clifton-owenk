import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BasicEnemy here.
 * 
 * @author  Kung 
 * @version (a version number or a date)
 */
public class BasicEnemy extends Actor
{
    private int speed = 2;
    /**
     * BasicEnemy is the parent class for all first-level drone enemies.
     * They move downward and disappear when hit or pass the screen.
     */
    public void act()
    {
        setLocation(getX(), getY() + speed);
        checkOffScreen();
    }
    
    /**
     * if enemy moves off the bottom of the screen
     * get removed
     */
    public void checkOffScreen()
    {
        if(getY() >= getWorld().getHeight())
        {
            getWorld().removeObject(this);
        }
    }
}
