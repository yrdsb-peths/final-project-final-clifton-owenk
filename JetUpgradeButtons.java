import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Buttons that do upgrade for Jets will prompt user to confirm.
 * 
 * @author (Kung, Lin) 
 * @version (2025/6/7)
 */
public class JetUpgradeButtons extends Actor
{

    private CancelButton cancelButton;
    private OkButton okButton;
    
    public void act()
    {
        // Add your action code here.
    }

    public  void askUpgrade() 
    {
        
       if(JetUpgrade.allowUpdate())
       {
           showConfirmation();
       }
       else
       {
           showError();
       }
    }
    public void showConfirmation()
    {
        //center
        Actor confirmPopup = new ConfirmationPopup();
        cancelButton=new CancelButton(confirmPopup);
        okButton=new OkButton(confirmPopup);
        cancelButton.add(okButton);
        okButton.add(cancelButton);
        
        getWorld().addObject(confirmPopup, getWorld().getWidth()/2, getWorld().getHeight()/2);
        getWorld().addObject(cancelButton, getWorld().getWidth()/2 -70, getWorld().getHeight()/2+75);
        getWorld().addObject(okButton, getWorld().getWidth()/2+80, getWorld().getHeight()/2+75);
    }
    public void showError()
    {
        //center
        Actor errPopup=new ErrorPopup();
        okButton=new OkButton(errPopup);
    
        getWorld().addObject(errPopup,getWorld().getWidth()/2, getWorld().getHeight()/2); 
        getWorld().addObject(okButton, getWorld().getWidth()/2, getWorld().getHeight()/2+ 80);
         
    }

}
