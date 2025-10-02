import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Sprite2D class implements Draw method to draw BufferedImages
 * Sprite2D objects can be caught, and face left or right,
 * have detection to be caught by hook, values for pivot points,
 * and value for score
 *
 * @author Noel Abastillas, Abbie Finnimore, Tess Erickson
 * @version 11/20/24
 */
public class Sprite2D extends Shape2D
{
    private BufferedImage[] imageFrames;
    private int frame;
    private boolean isCaught;
    private boolean isLeft;
    private int headPos;
    private int yRange;
    private int score;
    private int xPivot;
    private int yPivot;
    private int rotation;

    /**
     * Constructor for Sprite2D object
     *
     * @param xPos          The x-position
     * @param yPos          The y-position
     * @param imageFrames   The array of sprites
     */
    public Sprite2D(int xPos, int yPos, BufferedImage[] imageFrames)
    {
        super(0, xPos, yPos);
        this.imageFrames = new BufferedImage[imageFrames.length];
        for(int i = 0; i < imageFrames.length; i++)
        {
            this.imageFrames[i] = imageFrames[i];
        }
        frame = 0;
        isCaught = false;
    }

    /**
     * Constructor for Sprite2D objects for catchable objects that player fishes for
     *
     * @param xPos          The x-position
     * @param yPos          The y-position
     * @param imageFrames   The array of sprites
     * @param isLeft        If the sprite faces left or right
     * @param headPos       The position of the sprite's head
     * @param yRange        The y-range for hook detection
     * @param xPivot        The x-pivot point
     * @param yPivot        The y-pivot point
     * @param rotation      The degrees of rotation
     * @param score         The score value of the object
     */
    public Sprite2D(int xPos, int yPos, BufferedImage[] imageFrames, boolean isLeft, int headPos, int yRange,
                    int xPivot, int yPivot, int rotation, int score)
    {
        super(0, xPos, yPos);
        this.imageFrames = new BufferedImage[imageFrames.length];
        for(int i = 0; i < imageFrames.length; i++)
        {
            this.imageFrames[i] = imageFrames[i];
        }
        this.isLeft = isLeft;
        this.headPos = headPos;
        this.yRange = yRange;
        this.xPivot = xPivot;
        this.yPivot = yPivot;
        this.rotation = rotation;
        this.score = score;
        frame = 0;
        isCaught = false;
    }
    
    /**
     * Gets imageFrames
     *
     * @return  The image frames.
     */
    public BufferedImage[] getImageFrames()
    {
        return imageFrames;
    }

    /**
     * Gets the amount of frames
     *
     * @return  The amount of frames
     */
    public int getFrame()
    {
        return frame;
    }

    /**
     * If the object is caught
     *
     * @return  If the object is caught
     */
    public boolean getIsCaught()
    {
        return isCaught;
    }

    /**
     * If the object faces left.
     *
     * @return  If the object faces left
     */
    public boolean getIsLeft() {
        return isLeft;
    }

    /**
     * The head position of the object
     * @return  The head position of the object
     */
    public int getHeadPos(){
        return headPos;
    }

    /**
     * The y-range of the object for hook detection
     *
     * @return  The y-range of the object
     */
    public int getYRange()
    {
        return yRange;
    }

    /**
     * Gets the score of the sprite
     *
     * @return  The score of the sprite
     */
    public int getScore() {
        return score;
    }

    /**
     * Gets the x-pivot point
     *
     * @return  The x-pivot point
     */
    public int getXPivot() {
        return xPivot;
    }

    /**
     * Gets the y-pivot point
     *
     * @return  The y-pivot point
     */
    public int getYPivot()
    {
        return yPivot;
    }

    /**
     * Gets the degrees of rotation
     *
     * @return  The degrees of rotation
     */
    public int getRotation()
    {
        return rotation;
    }
    
    /**
     * Sets if the object is caught
     *
     * @param caught    If the object is caught
     */
    public void setIsCaught(boolean caught)
    {
        isCaught = caught;
    }

    /**
     * Sets the object is facing left
     *
     * @param left  if the object is facing left
     */
    public void setIsLeft(boolean left)
    {
        isLeft = left;
    }

    /**
     * Sets head position of the object
     *
     * @param headPos   The head position
     */
    public void setHeadPos(int headPos)
    {
        this.headPos = headPos;
    }

    /**
     * Sets the y-Range for detection
     *
     * @param yRange    The y-range
     */
    public void setYRange(int yRange)
    {
        this.yRange = yRange;
    }

    /**
     * The score of the object
     *
     * @param score The score
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Sets the xPivot point of the object
     *
     * @param xPivot The x-pivot point
     */
    public void setXPivot(int xPivot)
    {
        this.xPivot = xPivot;
    }

    /**
     * Sets the yPivot point of the object
     *
     * @param yPivot    The y-pivot point
     */
    public void setYPivot(int yPivot)
    {
        this.yPivot = yPivot;
    }

    /**
     * Sets the rotation of the object
     *
     * @param rotation  The degrees of rotation
     */
    public void setRotation(int rotation)
    {
        this.rotation = rotation;
    }

    /**
     * The concrete implementation of Draw
     *
     * @param g  The shape drawn
     */
    public void Draw(Graphics g)
    {
        g.drawImage(imageFrames[frame], getXPos(), getYPos(), null);
        frame++;
        if(frame == imageFrames.length)
        {
            frame = 0;
        }
    }
}
