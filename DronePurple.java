import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * DronePurple is a type of BasicEnemy that appears with a purple color.
 * It inherits movement and behavior from the BasicEnemy class.
 * 
 * This class sets its image to "drone_purple.png" and adjusts its size.
 * 
 * @author Kung, Lin
 * @version 2025/6/4
 */
public class DronePurple extends BasicEnemy
{
    /**
     * Constructor: Initializes the drone with its purple sprite and scales it.
     */
    public DronePurple()
    {
        setImage("drone_purple.png");
        getImage().scale(60,60); // Adjest drone size
    }
    /**
     *  Inherits movement and behavior from BasicEnemy.
     */
    public void act()
    {
        super.act();
    }
}

