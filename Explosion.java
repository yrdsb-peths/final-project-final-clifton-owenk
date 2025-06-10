import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
  * Explosion is a short animation that plays when an enemy is destroyed.
  *  -Cycles through a series of explosion images
  *  -Plays a sound effect once,
  *  -Automatically removes itself from the world.
  *  
  * @author King, Lin
  * @version 2025/6/4
*/
public class Explosion extends Actor
{
   
    private GreenfootImage [] explosion = new GreenfootImage[4];
    private int imageIndex = 0;
    private int delay = 5; 
    private int delayCounter = 0; 
    private boolean soundPlayed = false;
    
    /**
     * Constructs the Explosion object and loads its animation frames.
     * Sets the first image as the initial frame.
     */
    public Explosion(){
        for(int i = 0; i < 4; i++){
            explosion[i] = new GreenfootImage("images/explosion/explosion" + i + ".png");
        }
        setImage(explosion[0]);
    }
    
     /**
     * Animates the explosion frame-by-frame.
     * Once the animation completes, removes this object from the world.
     */
    public void animateExplosion(){
        delayCounter++;
        if(delayCounter >= delay){
            delayCounter = 0;
            imageIndex++;
            
            if(imageIndex < explosion.length){
                setImage(explosion[imageIndex]);
            } else {
                getWorld().removeObject(this);
            }
        }
    }
     /**
     * Unused volume control method placeholder.
     * This method currently does nothing.
     *
     * @param volume the volume level to set
     */
    public void setVolume(int volume){
        volume = 10;
    }
     /**
     * Plays the explosion sound once and continues animating until the sequence ends.
     */
    public void act()
    {
        if (!soundPlayed) {
            Greenfoot.playSound("explosion.mp3");  // no "sounds/" prefix here
            soundPlayed = true;
        }
        animateExplosion();
    }
}
