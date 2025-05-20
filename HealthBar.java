import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

    /**
     * HealthBar shows how much health a player has
     */
public class HealthBar extends Actor
{
    private int maxHealth =100;
    private int currentHealth =100;
    
    public HealthBar()
    {
        updateBar();
    }
    
    /**
     * update health bar
     */
    public void updateBar()
    {
        GreenfootImage image = new GreenfootImage(50, 6);
        image.setColor(Color.RED);
        image.fillRect(0, 0,50, 6);
        image.setColor(Color.GREEN);
        int healthWidth = (int)((double) currentHealth/ maxHealth * 50);
        image.fillRect(0, 0, healthWidth, 6);
        setImage(image);
    }
    /**
     * Reduce health
     * update bar
     */
    public void loseHealth(int amount)
    {
        currentHealth = currentHealth - amount;
        if(currentHealth<0) 
        {
            currentHealth =0;
        }
        updateBar();
    }
    
    public int getHealth()
    {
        return currentHealth;
    }
}
