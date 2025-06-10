import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * DroneGreen is a type of BasicEnemy that appears with a green color.
 * It inherits movement and behavior from the BasicEnemy class.
 * 
 * This class sets its image to "drone_green.png" and adjusts its size.
 * 
 * @author Kung, Lin
 * @version 2025/6/4
 */
public class DroneGreen extends BasicEnemy
{
    /**
     * Constructor: Initializes the drone with its green sprite and scales it.
     */
    public DroneGreen()
    {
        setImage("drone_green.png");
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
