import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DroneGreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DroneGreen extends BasicEnemy
{
    /**
     * Act - do whatever the DroneGreen wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public DroneGreen()
    {
        setImage("drone_green.png");
        getImage().scale(60,60); // Adjest drone size
    }
    public void act()
    {
        super.act();
    }
}
