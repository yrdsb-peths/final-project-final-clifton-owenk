import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Word(DEFEAT) that is shown on the banner in the Defeat screen
 * @version 2025/6/4
 */

public class DefeatWord extends Actor
{
    public DefeatWord()
    {
        GreenfootImage word = new GreenfootImage("defeat_word.png");
        word.scale(400, 300); // word size
        setImage(word);
    }
}
