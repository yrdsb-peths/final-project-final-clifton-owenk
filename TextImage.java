import greenfoot.*;

/**
 * @version 2025/6/4
 */
public class TextImage extends Actor
{
    public TextImage(String text)
    {
        GreenfootImage img = new GreenfootImage(text, 24, Color.WHITE, new Color(0,0,0,0));
        setImage(img);
    }

    public void updateText(String newText)
    {
        setImage(new GreenfootImage(newText, 24, Color.WHITE, new Color(0,0,0,0)));
    }
}
