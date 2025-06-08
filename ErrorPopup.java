import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
  * 
  * @author Kung, Lin
  * @version 2025/6/7
*/

public class ErrorPopup extends Actor
{
    private GreenfootImage error = new GreenfootImage("Error.png");
    
    public ErrorPopup()
    {
        error.scale(350,250); 
        setImage(error);
    }
}
