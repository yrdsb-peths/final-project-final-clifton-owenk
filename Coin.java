import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Coin extends Actor
{
    private int speed = 1;
    
    public Coin(){
        GreenfootImage image = new GreenfootImage("images/coin.png");
        image.scale(30,30);
        setImage(image);
    }
    
    public void act()
    {
        if(!isTouching(Jet.class)){
            setLocation(getX(), getY() + speed);
        }else{
            getWorld().removeObject(this);
        }
    }
}
