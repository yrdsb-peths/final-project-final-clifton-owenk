import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @version 2025/6/4
 */

public class ReturnButton extends Actor
{
    public ReturnButton(){
        setImage("images/ReturnButton.png");
        getImage().scale(100, 100);
    }
    
    public void act()
    {
        
        
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new MainScreen());
        }
    }
}
