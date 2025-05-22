import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

    /**
     * HealthBar shows how much health a player has
     */
public class HealthBar extends Actor
{
    private int maxHealth =100;
    private int currentHealth =100;
    
    /**
     * constructer to customize health bar
     * depending on what maxHealth is set 
     */
    public HealthBar(int maxHealth)
    {
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        updateBar();
    }
    
    /**
     * update health bar
     */
    public void updateBar()
    {
        GreenfootImage image = new GreenfootImage(100, 10);
        image.setColor(Color.RED);
        image.fillRect(0, 0, 100, 10);
        image.setColor(Color.GREEN);
        int healthWidth = (int)((double) currentHealth/ maxHealth * 50);
        image.fillRect(0, 0, healthWidth, 10);
        setImage(image);
    }
    /**
     * Reduce health
     * update bar
     */
    public void loseHealth(int amount)
    {
        currentHealth -= amount;
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
