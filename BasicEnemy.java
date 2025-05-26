import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class BasicEnemy extends Actor
{
    private int speed = 2;
    private int health = 100; //drone health
    
    /**
     * BasicEnemy is the parent class for all first-level drone enemies.
     * They move downward and disappear when hit or pass the screen.
     */
    public void act()
    {

        if(getWorld()== null) 
        {
            return; //Stop here if removed, and wont checkCollisionWithJet
        }
        setLocation(getX(), getY() + speed);
        checkCollisionWithJet();
        if (getWorld() == null) 
        {
            return; //Stop here if removed, and wont checkOffScreen
        }
        checkOffScreen();
    }
    
    /**
     * if enemy moves off the bottom of the screen
     * get removed
     */
    public void checkOffScreen()
    {
        if(isAtEdge())
        {
            getWorld().removeObject(this);
        }
    }
    
    public void checkCollisionWithJet()
    {
        if(isTouching(Jet.class))
        {
            Jet jet = (Jet)getOneIntersectingObject(Jet.class);
            if(jet != null)
            {
                jet.takeDamage(50); // Deal 50 damage
            }
            
            Explosion explosion = new Explosion();
            getWorld().addObject(explosion, getX(), getY());
            getWorld().removeObject(this); //Remove drone after contacting player(jet)
            
        }
    }
    /**
     * reduce health
     * if health is 0
     * get removed
     */
    public void takeDamage(int damage)
    {
        health = health - damage;
        if(health <= 0)
        {
            Coin coin = new Coin();
            getWorld().addObject(coin, getX(), getY());
            
            Explosion explosion = new Explosion();
            getWorld().addObject(explosion, getX(), getY());
            
            GameWorld.killCount++; // add 1 to the kill counter
            GameWorld.money += 1000;
            getWorld().removeObject(this);
        }
    }
}
