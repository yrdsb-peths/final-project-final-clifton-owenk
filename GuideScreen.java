import greenfoot.*;

/**
 * The GuideScreen class displays a series of instructional or tutorial images to the player.
 * 
 * Players can navigate through guide images using the left and right arrow keys.
 * A return button is provided to allow users to go back to the main screen.
 * 
 * Images are scaled to fit the full world size (400x750), optimized for vertical display.
 * 
 * @author Kung, Lin
 * @version 2025/6/8
 */
public class GuideScreen extends World
{
    private int currentIndex = 0;
    private String[] guideImages = {"images/guide/guide1.png","images/guide/guide2.png","images/guide/guide3.png", "images/guide/guide4.png"};

    /**
     * Constructs the GuideScreen world.
     * 
     * Initializes the world with the first guide image and adds a return button to the screen.
     */
    public GuideScreen()
    {    
        super(400, 750, 1);
        updateImage(); // load first guide image
        //add return to main screen button
        addObject(new ReturnButton(), getWidth() / 2+130, getHeight() / 2-320);
        GameWorld.gamePlay=false; //indicates player is not in GameWorld
    }
    /**
     * Listens for left and right arrow key presses to navigate through guide images.
     */
    public void act()
    {
        if (Greenfoot.isKeyDown("right")) 
        {
            if (currentIndex < guideImages.length - 1) 
            {
                currentIndex++;
                updateImage();
                Greenfoot.delay(10); // to avoid fast skipping
            }
        } 
        else if (Greenfoot.isKeyDown("left")) 
        {
            if (currentIndex > 0) 
            {
                currentIndex--;
                updateImage();
                Greenfoot.delay(10);
            }
        }
    }
     /**
     * Updates the background image based on the current index.
     * Scales the selected guide image to fit the screen.
     */
    private void updateImage()
    {
        GreenfootImage img = new GreenfootImage(guideImages[currentIndex]);
        img.scale(getWidth(), getHeight()); // scale to screen size
        setBackground(img);
    }
}
