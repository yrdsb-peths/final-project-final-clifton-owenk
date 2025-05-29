import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class VictoryBanner extends Actor
{
    GreenfootImage [] victoryBanner = new GreenfootImage[21];
    
    public VictoryBanner(){
        for(int i = 0; i < 21; i++){
            victoryBanner[i] = new GreenfootImage("images/victoryBanner/v" + i + ".png");
        }
        setImage(victoryBanner[0]);
    }
}
