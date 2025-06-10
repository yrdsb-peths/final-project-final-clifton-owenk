import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The JetUpgrade class is a special screen   
 * where the player can upgrade different aspects of their jet.
 * 
 * This screen includes buttons to upgrade:
 *  -Jet attack power
 *  -Jet health
 *  -Jet speed
 *  -Jet’s bullet reload speed
 * 
 * It also shows real-time values for each stat and the player's current money.
 * A return button allows players to return to the previous screen.
 * 
 * @author Kung, Lin
 * @version 2025/6/8
 */
public class JetUpgrade extends World
{
    private static int upgradeMinimum=50000;
    
    /**
     * Constructs the JetUpgrade screen.
     * 
     * Sets the background
     * Adds upgrade buttons
     * Adds a ReturnButton to  MainScreen
     */
    public JetUpgrade()
    {    
        super(400, 750, 1); 

        GreenfootImage bg = new GreenfootImage("jetUpgrade_background.png");
        bg.scale(getWidth(), getHeight()); //resize background to world size
        setBackground(bg);
    
        //Add button
        addObject(new AttackUpgradeButton(), getWidth() - 140, 565); 
        //Add button
        addObject(new HealthUpgradeButton(), getWidth() -140, 500);
        //Add button
        addObject(new JetSpeedUpgradeButton(), getWidth() -140, 630);
        //Add button
        addObject(new BulletReloadUpgradeButton(), getWidth() -140, 700);
        //AddReturnButton
        addObject(new ReturnButton(), getWidth() / 2, getHeight() / 2 + 55); 
        
        
    }
    /**
     * Updates the display to show current values of 
     * -Player’s money
     * -Jet’s health
     * -Bullet damage power
     * -Jet speed
     * -Jet’s shoot interval.
     */
    public void act()
    {
        //show real time value after each upgrade
        //show money on top
        showText("" + GameWorld.money, 250, 45); //show current money
        showText(""+ Jet.baseHealth,120, 125);
        showText(""+ Bullet.baseDamage,120, 155); 
        showText(""+ Jet.baseSpeed,250, 125);
        showText(""+ Jet.shootInterval, 250,155);
      
    }
    /**
     * Checks if the player is allowed to upgrade when requested.
     * Requires at least 50,000 money.
     * 
     * @return true if player has at least 50,000 money, false otherwise
     */
    public static boolean allowUpdate()
    {   
        return GameWorld.money>=upgradeMinimum;
    }
}
