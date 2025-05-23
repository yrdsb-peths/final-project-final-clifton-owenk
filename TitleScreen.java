import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class TitleScreen extends World
{
    Label titleLabel = new Label("1946", 75);
    Label titleLabel2 = new Label("Air Force", 75);
    Label press = new Label("Press <space> to start playing", 30);
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 400x750 cells with a cell size of 1x1 pixels.
        super(400, 750, 1); 
        
        addObject(titleLabel, getWidth()/2, getHeight()/3);
        addObject(titleLabel2, getWidth()/2, getHeight()/2);
        addObject(press, getWidth()/2, getHeight()/3*2);
    }
    
    /**
     * The main world act loop
     */
    public void act(){
        //start the game if user press the space bar
        if(Greenfoot.isKeyDown("space")){
            GameWorld gameworld = new GameWorld();
            Greenfoot.setWorld(gameworld);
        }
    }
}
