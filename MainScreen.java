import greenfoot.*;

/**
 * MainScreen is the screen is a place to 
 * start game
 * guide
 * upgrade
 * @version 2025/6/4
 */
public class MainScreen extends World
{
    private boolean started = false; //check if game started
    private RankBar rankBar; //bar showing rank points
    private GreenfootSound bgm;
    
    public MainScreen() 
    {
        super(400, 750, 1); // size of main screen
        
        GreenfootImage bg = new GreenfootImage("mainScreen_background.png");
        bg.scale(getWidth(), getHeight()); //resize background to world size
        setBackground(bg);
        
        // add start button, near buttom of main screen
        addObject(new StartButton(), getWidth() / 2, getHeight() - 110); 
        // add to upgrade jet button
        addObject(new UpgradeButton(), getWidth()-140, 65);
        //add to guideScreen button
        addObject(new GuideButton(), getWidth() - 58, 65); 

        
        //show the rank badge
        drawRankBadge();
        
        int points = GameWorld.rankPoints;
        int maxPoints = getMaxPoints(points);
        rankBar = new RankBar(points, maxPoints, 200, 20);
        addObject(rankBar, getWidth()/2, 470); //add bar below text
    }

    public void act() 
    {
        showText("" + GameWorld.money, 170, 120); //show current money
        
        bgm = new GreenfootSound("sounds/MainScreen.mp3");
        bgm.playLoop();
    }
    
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
    
    //for rank progress bar
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
    
    private GreenfootSound getBGM(){
        return bgm;
    }
}