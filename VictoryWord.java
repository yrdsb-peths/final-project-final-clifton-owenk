import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Word(Victory) that is shown on the banner in the Defeat screen
 */

public class VictoryWord extends Actor
{
    public VictoryWord()
    {
        GreenfootImage word = new GreenfootImage("victory_word.png");
        word.scale(300, 200); // word size
        setImage(word);
    }
}
