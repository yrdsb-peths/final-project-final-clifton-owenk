    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
    
  /**
   * The GameWorld class represents the main game environment where the gameplay occurs.
   * This game is designed for mobile devices, so the world size is optimized for vertical screens  
   * (400x750).
   *
   * It manages:
   *   -Jet 
   *   -Enemy spawning
   *   -Background music
   *   -Game progression
   *   -Rank tracking
   *   -Dsplays information like kill count and money.
   * 
   * Public static variables are used for game  state tracking across other classes
   *   -killCount
   *   -money
   *   -rankPoints
   *   -victory
   * 
   * 
   * @author Kung, Lin
   * @version 2025/6/4
   */
    public class GameWorld extends World
    {
       private int spawnTimer = 0;
       private int timePassed = 0;
       private boolean bossSpawned = false;
       
       public static int killCount =0; 
       public static int money = 0; //can change value to test upgrade
       public GreenfootSound bgm;
        
       public static int rankPoints = 0; 
        //check if victory or defeat, to add difficulty, or decrease difficulty
       public static boolean victory = false;  
        
       /**
        * Constructs a new GameWorld.
        *
        * Initializes the world dimensions  (400x750) for phone use
        * Adds the player (Jet), 
        * Displays killCount and money on the top
        * Displays background image 
        * Starts background music.
        */
        public GameWorld()
        {    
            super(400, 750, 1); //create a world 400x750
            Jet jet = new Jet(); //Create a Jet object
            
            //add jet in centre, slightly lower vertically
            addObject(jet, getWidth()/2, getHeight()/2 + 80); 
            //add killCounterBanner, at top
            addObject(new KillCounterBanner(), getWidth() / 2, 40); 
            setBackground("images/background.png");
            
            bgm = new GreenfootSound("sounds/bgm1.mp3");
            bgm.playLoop();
           
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
            showText("" + killCount, 300, 20);
            showText("" + money, 300, 60);
            //showText("MiniBoss speed: " + MiniBoss.baseXSpeed, 300, 100); //test
            //showText("BM DmgPower:"+BossMissile.damagePower, 300, 120);// test
            //showText("rankPoints:"+rankPoints, 300, 140);// test
            
             
            if(spawnTimer >= BasicEnemy.spawnDelay && !bossSpawned)
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
       /**
         * Spawns a random drone enemy (red, green, or purple) at a random horizontal position.
         */
       public void spawnDrone()
       {
            int randomX = Greenfoot.getRandomNumber(getWidth()); // random drone spawn point x axis
            
            int randomType = Greenfoot.getRandomNumber(3); // random between red, purple, green drones
            
            if(randomType == 0)
            {
                addObject(new DroneRed(), randomX, 80);
            }
            else if(randomType ==1)
            {
                addObject(new DroneGreen(), randomX, 80);
            }
            else
            {
                addObject(new DronePurple(), randomX, 80);
            }
       }
       /**
        * Spawns the mini-boss enemy in the center of the screen.
        */
       public void spawnMiniBoss()
       {
            addObject(new MiniBoss(), getWidth()/ 2, 0);
       } 
       /**
        * Get the background music for the gameworld
        */
        public GreenfootSound getBGM()
        {
            return bgm; //Returns the background music for the gameworld
        }
    }