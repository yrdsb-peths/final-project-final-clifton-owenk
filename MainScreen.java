import greenfoot.*;

/**
 * The MainScreen class is the title screen where the player can:
 *  -Start the game 
 *  -Access the jet upgrade screen
 *  -Open the guide/tutorial screen
 * 
 * It also displays the player's 
 *  -Current money
 *  -Rank badge
 *  -Progress bar for rank points.
 * 
 * The layout and dimensions are optimized for vertical mobile screens.
 * 
 * @author Kung, Lin
 * @version 2025/6/4
 */
public class MainScreen extends World
{
    private boolean started = false; //check if game started
    private RankBar rankBar; //bar showing rank points
    
    public static GreenfootSound bgm= new GreenfootSound("sounds/bgm2.mp3");
    
    /**
     * Constructs the main title screen.
     * 
     * Initializes the background
     * Adds UI buttons (start, upgrade, guide), 
     * Shows the player's current rank and progress.
     */
    public MainScreen() 
    {
        super(400, 750, 1); // size of main screen  
        GreenfootImage bg = new GreenfootImage("mainScreen_background.png");
        bg.scale(getWidth(), getHeight()); //resize background to world size
        setBackground(bg);
        prepare();
        GameWorld.gamePlay=false; //indicates player is not in GameWorld
    }
    /**
     * Prepare UI elements of MainScreen
     */
    public void prepare()
    {
        // add start button, near buttom of main screen
        addObject(new StartButton(), getWidth() / 2, getHeight() - 110); 
        // add to upgrade jet button
        addObject(new UpgradeButton(), getWidth()-140, 65);
        //add to guideScreen button
        addObject(new GuideButton(), getWidth() - 58, 65); 
        //add rankGuideButton
        addObject(new RankGuideButton(), getWidth()-200, 430);

        
        //show the rank badge
        drawRankBadge();
        
        int points = GameWorld.rankPoints;
        int maxPoints = getMaxPoints(points);
        rankBar = new RankBar(points, maxPoints, 200, 20);
        addObject(rankBar, getWidth()/2, 470); //add bar below text
        
        //playBGM(); 
              
    }
    /**
     * Play background music
     */
    private void playBGM()
    {
         //bgm = new GreenfootSound("sounds/mainScreen.mp3");
        if(!bgm.isPlaying())
        {
           bgm.setVolume(20);
           bgm.playLoop(); 
        }
    }
    /**
     * Update the money that the plaeyer's earned for every frane
     */
    public void act() 
    {
        showText("" + GameWorld.money, 170, 120); //show current money
        
    }
    /**
     * Draws the correct rank badge and rank label based on the player's current rank points.
     * Displays rank progress as text, e.g. "Gold 320/500 pts".
     */
    private void drawRankBadge()
    {
        int points = GameWorld.rankPoints;
        String badgeFile = "beginner.png"; //default
        String rankName = "Beginner"; //default
        int maxPoints = 200; // Beginner rank max points
        
        //pick correct badge to display
        if (points < 200) 
        {
            badgeFile = "beginner.png";
            rankName = "Beginner";
            maxPoints = 200;
        } 
        else if (points < 500) 
        {
            badgeFile = "gold.png";
            rankName = "Gold";
            maxPoints =500;
        } 
        else if (points < 1000) 
        {
            badgeFile = "platinum.png";
            rankName = "Platinum";
            maxPoints = 1000;
        } 
        else if (points < 1500) 
        {
            badgeFile = "diamond.png";
            rankName = "Diamond";
            maxPoints = 1500;
        } 
        else if (points < 2000) 
        {
            badgeFile = "legendary.png";
            rankName = "Legendary";
            maxPoints = 2000;
        } 
        else 
        {
            badgeFile = "elitelegend.png";
            rankName = "Elite Legend";
            maxPoints = 2200; 
        }   
        
        GreenfootImage bg = getBackground();
        GreenfootImage badge = new GreenfootImage(badgeFile);
        badge.scale(200, 200); //badge size)
        
        int x = getWidth()/2 - badge.getWidth()/2;
        int y = 180;
        bg.drawImage(badge, x, y); 
        
        //Add rank label below badge
        String labelText = rankName + " " + points + "/" + maxPoints + " pts";
        showText(labelText, getWidth()/2, y + 220); 
     
    }
    /**
     * Returns the maximum rank point threshold for the current level.
     * 
     * Used to determine how much progress is needed to reach the next rank.
     * 
     * @param points the current rank points
     * @return the maximum points for the current rank tier
     */
    private int getMaxPoints(int points)
    {
        if(points <200)
        {
            return 200;
        }
        else if (points < 500) 
        {
            return 500;
        } 
        else if (points < 1000) 
        {
            return 1000;
        } 
        else if (points < 1500) 
        {
            return 1500;
        } 
        else if (points < 2000) 
        {
            return 2000;
        } 
        else 
        {
            return 2200;
        }
    }
}