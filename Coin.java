import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Coin is a collectible item dropped by defeated enemies.
 *
 * The coin falls slowly and can be collected by the player's Jet.
 * When collected
 *   -It increases the player's money
 *   -Plays a coin sound.
 *
 * If the coin reaches the bottom of the screen without being collected, it disappears.
 * 
 * @author Kung, Lin
 * @version 2025/6/4
 */
public class Coin extends Actor
{
    private int speed = 1;
    
     /**
     * Constructs a Coin object and sets its image and size.
     */
    public Coin(){
        GreenfootImage image = new GreenfootImage("images/coin.png");
        image.scale(30,30);
        setImage(image);
    }
    /**
     * Checks for:
     *   -Collision with the Jet 
     *       -Adds money
     *       -Removes the coin
     *   -Falling motion if not yet collected
     *  - Bottom of the screen
     *      -Removes itself
     */
    public void act()
    {
        if (isTouching(Jet.class)) {
            Greenfoot.playSound("sounds/coin.mp3");
            getWorld().removeObject(this);
            GameWorld.money += 1000;
        }
        else if (getY() < getWorld().getHeight() - getImage().getHeight() / 2) {
            setLocation(getX(), getY() + speed);
        }
        else {
            // Remove if reached or passed bottom edge
            getWorld().removeObject(this);
        }
    }
}
