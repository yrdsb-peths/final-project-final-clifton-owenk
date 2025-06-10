import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * HealthBar represents an object's current health.
 * The bar is filled with red (background) and green (remaining health),
 * and it automatically scales based on the current/max health values.
 * 
 * Players that use HealthBar,
 *  -Enemies
 *  -Boss missiles
 *  -Jet
 * 
 * @author Kung, Lin
 * @version 2025/6/4
 */

public class HealthBar extends Actor
{
    private int maxHealth =100;
    private int currentHealth =100;
    
    private int barWidth =100;
    private int barHeight = 10;
    
    /**
     * Constructs a HealthBar with custom health, width, and height.
     *
     * @param maxHealth: the maximum health value
     * @param barWidth: the width of the health bar
     * @param barHeight: the height of the health bar
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
     * Updates the appearance of the health bar based on current health.
     * 
     * The red portion shows missing health
     * The green portion shows remaining health.
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
     * Reduces the current health by a specified amount and updates the bar.
     * 
     * Minimum value of health is zero
     *
     * @param amount: the amount of health to subtract
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
    /**
     * Returns the current health value.
     *
     * @return: current health
     */
    public int getHealth()
    {
        return currentHealth;
    }
}
