import greenfoot.*;

/**
 * @version 2025/6/4
 */
public class RankBar extends Actor
{
    private int current;
    private int max;
    private int width;
    private int height;

    public RankBar(int current, int max, int width, int height) {
        this.current = current;
        this.max = max;
        this.width = width;
        this.height = height;
        updateImage();
    }

    public void updateImage() {
        GreenfootImage img = new GreenfootImage(width, height);
        img.setColor(Color.GRAY);
        img.fillRect(0, 0, width, height);
        img.setColor(Color.YELLOW);
        img.fillRect(0, 0, (int)((double)current / max * width), height);
        setImage(img);
    }
}

