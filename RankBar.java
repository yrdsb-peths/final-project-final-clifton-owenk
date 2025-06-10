import greenfoot.*;

/**
 * RankBar displays the player's progress toward the next rank.
 * It shows a progress bar with a filled portion based on current points.
 * 
 * @author Kung, Lin
 * @version 2025/6/4
 */

public class RankBar extends Actor
{
    private int current;
    private int max;
    private int width;
    private int height;

    /**
     * Constructor to create a RankBar.
     * 
     * @param current: Current progress value (e.g., current rank points)
     * @param max:     Maximum progress value (e.g., points needed for next rank)
     * @param width:   Width of the progress bar in pixels
     * @param height:  Height of the progress bar in pixels
     */
    public RankBar(int current, int max, int width, int height) {
        this.current = current;
        this.max = max;
        this.width = width;
        this.height = height;
        updateImage();
    }
    /**
     * Updates the appearance of the rank bar.
     * The background is gray, and the progress portion is yellow.
     */
    public void updateImage() {
        GreenfootImage img = new GreenfootImage(width, height);
        img.setColor(Color.GRAY);
        img.fillRect(0, 0, width, height);
        img.setColor(Color.YELLOW);
        img.fillRect(0, 0, (int)((double)current / max * width), height);
        setImage(img);
    }
}

