import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
        checkCollisionWithJet();
        if(getWorld()== null) 
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
            
            getWorld().removeObject(this); //Remove drone after contacting player(jet)
        }
    }
}
