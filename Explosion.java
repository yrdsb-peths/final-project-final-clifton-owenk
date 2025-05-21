import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Explosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explosion extends Actor
{
    /**
     * Act - do whatever the Explosion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    GreenfootImage [] explosion = new GreenfootImage[4];
    
    public Explosion(){
        for(int i = 0; i < 4; i++){
            explosion[i] = new GreenfootImage("images/explosion/explosion" + i + ".png");
        }
        setImage(explosion[0]);
    }
    
    /**
     * Animate the explosion
     */
    int imageIndex = 0;
    public void animateExplosion(){
        setImage(explosion[imageIndex]);
        imageIndex = (imageIndex + 1) % explosion.length;
    }
    
    public void act()
    {
        // Add your action code here.
        animateExplosion();
    }
}
