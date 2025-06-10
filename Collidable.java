import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Collidable class defines any Actor 
 * that may collide with each other
 * or touching each other
 * 
 * Collidable Actors:
 *  -BasicEnemy
 *  -BossMissle
 *  -Bullet
 *  -Coin
 *  -Jet
 *  -MiniBoss 
 * 
 * @author Kung, Lin
 * @version 2025/6/10
 */
public class Collidable extends Actor  
{
    /**
     * Checks for pixel-perfect collision with another Actor.
     * It makes collision more precise.
     * 
     * Compares the overlapping regions of the two actors' images,
     * 
     * Returns true only if there is at least one pair of overlapping
     * non-transparent pixels.
     * 
     * This advanced code is snippet from Greenfoot Scenario by user Bush2207
     * 
     * @paramother: the other Actor to check for collision with
     * @return true if there is a visible pixel collision
     */
    
    protected boolean isPixelTouching(Actor a_big)
    {
        Actor a_small;
        if(getImage().getWidth()*getImage().getHeight()>a_big.getImage().getHeight()*a_big.getImage().getWidth())
        {
            a_small=a_big;
            a_big=this;
        }
        else
            a_small=this;

        int i_hypot=(int)Math.hypot(a_small.getImage().getWidth(),a_small.getImage().getHeight());

        GreenfootImage i=new GreenfootImage(i_hypot,i_hypot);
        i.drawImage(a_small.getImage(),i_hypot/2-a_small.getImage().getWidth()/2,i_hypot/2-a_small.getImage().getHeight()/2);
        i.rotate(a_small.getRotation());
        int w=i_hypot;

        GreenfootImage Ai = a_big.getImage(),
        i2=new GreenfootImage(i_hypot=(int)Math.hypot(Ai.getWidth(),Ai.getHeight()),i_hypot);
        i2.drawImage(Ai,i2.getWidth()/2-Ai.getWidth()/2,i2.getHeight()/2-Ai.getHeight()/2);
        i2.rotate(a_big.getRotation());
        Ai=i2;

        int
        x_Offset=a_big.getX()-a_small.getX()-(Ai.getWidth()/2-w/2),
        y_Offset=a_big.getY()-a_small.getY()-(Ai.getHeight()/2-w/2);

        boolean b = true;
        for(int yi =Math.max(0,y_Offset); yi<w && yi<i_hypot+y_Offset && b; yi++)
            for(int xi =Math.max(0,x_Offset); xi<w && xi<i_hypot+x_Offset && b; xi++)
                if(Ai.getColorAt(xi-x_Offset,yi-y_Offset).getAlpha()>0 && i.getColorAt(xi,yi).getAlpha()>0)
                    b=false;
        return !b;
    }
}
