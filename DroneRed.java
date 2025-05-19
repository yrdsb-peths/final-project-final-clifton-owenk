import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DroneRed here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

/**
 * DroneRed is one form of a BasicEnemy
 */
public class DroneRed extends BasicEnemy
{
    public DroneRed()
    {
        setImage("drone_red.png");
        getImage().scale(60,60); // Adjest drone size
    }
    public void act()
    {
        super.act();
    }
}
