import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
  * 
  * @author Kung, Lin
  * @version 2025/6/8
*/

public class OkButton extends Actor
{
    private GreenfootImage defaultImage = new GreenfootImage("OkButton.png");
    private GreenfootImage pressedImage = new GreenfootImage("OkButton_pressed.png");
    private Actor popScreen = null; //tells the ok button, which popScreen it responses to
    private Actor cancelButton = null; //tells the ok button, which popScreen it responses to
    
    public static boolean pressed = false;
    
    public OkButton(Actor popScreen)
    {
        //resize image
        defaultImage.scale(100,50);
        pressedImage.scale(100,50);
        
        setImage(defaultImage);
        
        this.popScreen=popScreen;
    }
    public void act()
    {
        if(Greenfoot.mousePressed(this)) //when clicked
        {
            setImage(pressedImage);
            Greenfoot.playSound("sounds/buttonPress2");
        }
        if(Greenfoot.mouseClicked(this)) // mouse release
        {
            setImage(defaultImage);
            upgrade();
            getWorld().removeObject(popScreen);
            if(cancelButton!=null)
            {
                getWorld().removeObject(cancelButton);
            }
            getWorld().removeObject(this);  
        }
    }
    public void add(CancelButton cancelButton)
    {
        this.cancelButton=cancelButton;
    }
    private void upgrade()
    {
        if(HealthUpgradeButton.pressed && JetUpgrade.allowUpdate() )
        {
            Jet.baseHealth+=100;
            GameWorld.money=Math.max(0,GameWorld.money-=50000);
            
            //reset button pressed to false
            HealthUpgradeButton.pressed=false;
        }
        if(AttackUpgradeButton.pressed && JetUpgrade.allowUpdate())
        {
            Bullet.baseDamage +=100;
            GameWorld.money=Math.max(0, GameWorld.money-= 50000);
            
            //reset button pressed to false
            AttackUpgradeButton.pressed= false; 
        }
        if(BulletReloadUpgradeButton.pressed && JetUpgrade.allowUpdate())
        {
            Jet.shootInterval -= 2;
            GameWorld.money=Math.max(0, GameWorld.money-=50000);
            
            //reset button pressed to false
            AttackUpgradeButton.pressed = false; 
        }
        if(JetSpeedUpgradeButton.pressed && JetUpgrade.allowUpdate())
        {
            Jet.baseSpeed +=1;
            GameWorld.money = Math.max(0, GameWorld.money-=50000);
            
            //reset button pressed to false
            JetSpeedUpgradeButton.pressed = false; 
        }
    }
}
