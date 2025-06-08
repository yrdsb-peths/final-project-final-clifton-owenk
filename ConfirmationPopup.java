import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
  * 
  * @author Kung, Lin
  * @version 2025/6/6
*/

public class ConfirmationPopup extends Actor
{
    private GreenfootImage confirmation = new GreenfootImage("Confirmation.png");
    
    public ConfirmationPopup()
    {
        confirmation.scale(350, 250); 
        setImage(confirmation);

    }
}
