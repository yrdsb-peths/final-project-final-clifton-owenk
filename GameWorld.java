import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * GameWorld is the place where the game is played
 * This game is meant to be a mobile game, so world size set to phone size (veticle)
 * 
 * @author Kung 
 * @version May - June 2025
 */
public class GameWorld extends World
{

    /**
     * Constructor for objects of class GameWorld.
     * Set the world size to 360 x 640 (phone verticle size)
     */
    public GameWorld()
    {    
        super(400, 750, 1); //Create a world size 360 x 640
        Jet jet = new Jet(); // Create a new Jet Object
        
        addObject(jet, getWidth()/2, getHeight()/2 +80); // jet initial position, centere slightly down
    }
}
