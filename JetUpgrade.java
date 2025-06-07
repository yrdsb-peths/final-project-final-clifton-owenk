import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class JetUpgrade extends World
{
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
        
        //show money on top
        showText("" + GameWorld.money, 250, 45); //show current money
        
    }
}
