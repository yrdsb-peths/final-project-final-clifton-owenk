import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
    private int imageIndex = 0;
    private int delay = 5; 
    private int delayCounter = 0; 
    private boolean soundPlayed = false;
    
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
    
    public void setVolume(int volume){
        volume = 10;
    }
    
    public void act()
    {
        if (!soundPlayed) {
            Greenfoot.playSound("explosion.mp3");  // no "sounds/" prefix here
            soundPlayed = true;
        }
        animateExplosion();
    }
}
