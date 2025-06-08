import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
  * JetUpgrade is the place where play can upgrade it's jet
  * 
  * @author Kung, Lin
  * @version 2025/6/8
*/
public class JetUpgrade extends World
{
    //private reference to JetUpgrade
    private static JetUpgrade _instance=null;
    
    public JetUpgrade()
    {    
        super(400, 750, 1); 
        _instance=this;
        
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
    public static boolean allowUpdate()
    {   
        return GameWorld.money>=50000;
    }
    public static JetUpgrade instance()
    {
      if(_instance==null)
      {
          _instance=new JetUpgrade();
      }
      return _instance;
    }
}
