import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

    /**
     * HealthBar shows how much health a player has
     */
public class HealthBar extends Actor
{
    private int maxHealth =100;
    private int currentHealth =100;
    
    private int barWidth =100;
    private int barHeight = 10;
    
    /**
     * constructer to customize health bar
     * depending on what maxHealth is set 
     */
    public HealthBar(int maxHealth, int barWidth, int barHeight)
    {
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.barWidth = barWidth;
        this.barHeight = barHeight;
        updateBar();
    }
    
    /**
     * update health bar
     */
    public void updateBar()
    {
        GreenfootImage image = new GreenfootImage(barWidth, barHeight);
        image.setColor(Color.RED);
        image.fillRect(0, 0, barWidth, barHeight); // Fill it fully with Red
        
        image.setColor(Color.GREEN);
        int healthWidth = (int)((double) currentHealth / maxHealth * barWidth);
        image.fillRect(0, 0, healthWidth, barHeight); //Fill green health
        
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
