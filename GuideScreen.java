import greenfoot.*;

public class GuideScreen extends World
{
    private int currentIndex = 0;
    private String[] guideImages = {"images/guide/guide1.png","images/guide/guide2.png","images/guide/guide3.png"};

    public GuideScreen()
    {    
        super(400, 750, 1);
        updateImage(); // load first guide image
        //add return to main screen button
        addObject(new ReturnButton(), getWidth() / 2+130, getHeight() / 2-335);
    }

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

    private void updateImage()
    {
        GreenfootImage img = new GreenfootImage(guideImages[currentIndex]);
        img.scale(getWidth(), getHeight()); // scale to screen size
        setBackground(img);
    }
}
