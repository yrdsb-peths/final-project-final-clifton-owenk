import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Coin extends Actor
{
    public Coin(){
        GreenfootImage image = new GreenfootImage("images/coin.png");
        image.scale(30,30);
        setImage(image);
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
