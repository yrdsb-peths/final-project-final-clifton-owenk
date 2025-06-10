import greenfoot.*;

/**
 * It renders the given string in white text with a transparent background,
 * Useful for displaying information such as scores, health, or status messages in the game.
 *
 * @author Kung, Lin
 * @version 2025/6/4
 */
public class TextImage extends Actor
{
    /**
     * Sets and scales images fir TextImage
     */
    public TextImage(String text)
    {
        GreenfootImage img = new GreenfootImage(text, 24, Color.WHITE, new Color(0,0,0,0));
        setImage(img);
    }
    /**
     * Updates the text displayed by this actor with new content.
     *
     * @param newText The new string to replace the existing text.
     */
    public void updateText(String newText)
    {
        setImage(new GreenfootImage(newText, 24, Color.WHITE, new Color(0,0,0,0)));
    }
}
