import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * DefeatWord is the large text image that appears on the Defeat screen.
 * 
 * @author Kung, Lin
 * @version 2025/6/4
 */
public class DefeatWord extends Actor
{
    /**
     * Constructs the DefeatWord and sets its scaled image.
     */
    public DefeatWord()
    {
        GreenfootImage word = new GreenfootImage("defeat_word.png");
        word.scale(400, 300); // word size
        setImage(word);
    }
}
