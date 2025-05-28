import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * used by miniBoss damage players jet
 */
public class BossMissile extends Actor
{
    public int speed = 1; // missile speed
    
    public BossMissile()
    {
        setImage("boss_missile.png"); 
        getImage().scale(30,60); //set size
    }

    public void act()
    {
        setLocation(getX(), getY() + speed); //Move downward
        
        //ifhits the Jet, deal dameg
        if(isTouching(Jet.class))
        {
            Jet jet = (Jet) getOneIntersectingObject(Jet.class);
            if(jet != null)
            {
                jet.takeDamage(50); //deal 50 damage to jet
            }
            getWorld().removeObject(this);
            return; //code wont run after missile removed
        }
        
        //Remove missle if touch edge of screen
        if(isAtEdge())
        {
            getWorld().removeObject(this);
        }
    }
}
