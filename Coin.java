import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Coin extends Actor
{
    public Coin(){
        setImage("images/coin.png");
    }
    
    public void act()
    {
        checkCollision();
    }
    
    public void checkCollision(){
        if(isTouching(Jet.class)){
            getWorld().removeObject(this);
        }
    }
}
