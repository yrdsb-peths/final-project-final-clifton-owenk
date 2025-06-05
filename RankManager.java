/**
 * RankManager control rank point, rank badge image, and difficulty level.
 * It also says when to increase or decrease dificulty
 */
public class RankManager  
{
    private static int rankPoints =0;
    private static int difficultyLevel = 0;
    
    public static void addPoints(int amount)
    {
        int before = rankPoints; //initial point
        rankPoints += amount;
        
        //Rank points can not decrease down over 0
        if(rankPoints <0)
        {
            rankPoints =0;
        }
        
        //Check if dificulty changed
        updateDifficulty(before);
    }
    
    public static void subtractPoints(int amount)
    {
        addPoints(-amount); 
    }
    
    private static void updateDifficulty(int before)
    {
        int beforeLevel = before / 100;
        int afterLevel = rankPoints / 100;

        if (afterLevel != beforeLevel)
        {
            difficultyLevel = afterLevel;
        }
    }

    public static int getDifficultyLevel()
    {
        return difficultyLevel;
    }

    public static int getRankPoints()
    {
        return rankPoints;
    }

    public static String getRankBadgeFile()
    {
        if (rankPoints < 200)
        {
            return "badge_beginner.png";
        }
        else if (rankPoints < 500)
        {
            return "badge_gold.png";
        }
        else if (rankPoints < 1000)
        {
            return "badge_platinum.png";
        }
        else if (rankPoints < 1500)
        {
            return "badge_diamond.png";
        }
        else if (rankPoints < 2000)
        {
            return "badge_legendary.png";
        }
        else
        {
            return "badge_elitelegend.png";
        }
    }
} 
