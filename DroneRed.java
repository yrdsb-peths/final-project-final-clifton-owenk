import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * DroneRed is a type of BasicEnemy that appears with a red color.
 * It inherits movement and behavior from the BasicEnemy class.
 * 
 * This class sets its image to "drone_red.png" and adjusts its size.
 * 
 * @author Kung, Lin
 * @version 2025/6/4
 */

public class DroneRed extends BasicEnemy
{
    /**
     * Constructor: Initializes the drone with its red sprite and scales it.
     */
    public DroneRed()
    {
        setImage("drone_red.png");
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
