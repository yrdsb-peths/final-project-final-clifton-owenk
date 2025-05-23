import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * GameWorld is the place where the game is played
 * This game is meant to be a mobile game, so world size set to phone size (veticle)
 * 
 * @author Kung 
 * @version May - June 2025
 */
public class GameWorld extends World
{
    private int spawnTimer = 0;
    private int timePassed = 0;
    private boolean bossSpawned = false;
    public static int killCount =0; 
    
    /**
     * Constructor for objects of class GameWorld.
     * Set the world size to 360 x 640 (phone verticle size)
     */
    public GameWorld()
    {    
        super(400, 750, 1); //create a world 400x750
        Jet jet = new Jet(); //Create a Jet object
        addObject(jet, getWidth()/2, getHeight()/2 + 80); //position jet in centre, slightly lower vertically
        setBackground("images/background.png");
    }
    
    /**
     * The act method
     * spawn enimies, and a mini-boss at the end
     */
    public void act()
    {
        spawnTimer++;
        timePassed++;
        
        //shows the kill count number at the top left
        showText("" + killCount, 50, 30);
        
        if(spawnTimer >= 60 && !bossSpawned)
        {
            spawnDrone();
            spawnTimer = 0;
        }
        
        if(timePassed >= 1800 && !bossSpawned)
        {
            spawnMiniBoss();
            bossSpawned = true;
        }
    }
    
    public void spawnDrone()
    {
        int randomX = Greenfoot.getRandomNumber(getWidth()); // random drone spawn point x axis
        int randomType = Greenfoot.getRandomNumber(3); // random between red, purple, green drones
        
        if(randomType == 0)
        {
            addObject(new DroneRed(), randomX, 0);
        }
        else if(randomType ==1)
        {
            addObject(new DroneGreen(), randomX, 0);
        }
        else
        {
            addObject(new DronePurple(), randomX, 0);
        }
    }
    
    public void spawnMiniBoss()
    {
        addObject(new MiniBoss(), getWidth()/ 2, 0);
    }
}

