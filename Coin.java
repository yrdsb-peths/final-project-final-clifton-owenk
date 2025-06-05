import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @version 2025/6/4
 */
public class Coin extends Actor
{
    private int speed = 1;
    
    public Coin(){
        GreenfootImage image = new GreenfootImage("images/coin.png");
        image.scale(30,30);
        setImage(image);
    }
    
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
