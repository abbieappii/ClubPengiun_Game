import java.awt.*;

/**
 * Rectangle Class has length and width that can be set and retrieved, implements Draw method
 *
 * @author Noel Abastillas, Abbie Finnimore, Tess Erickson
 * @version 11/13/24
 */
public class Rectangle2D extends Shape2D
{
    private int length;
    private int width;
    
    /**
     * Constructor for objects of class Rectangle
     * 
     * @param   fillColorIndex      The color fill of rectangle.
     * @param   xPos                The x-coordinate of rectangle.
     * @param   yPos                The y-coordinate of rectangle
     * @param   length              The length of rectangle
     * @param   width               The width of rectangle
     */
    public Rectangle2D(int fillColorIndex, int xPos, int yPos,  int length, int width)
    {
        super(fillColorIndex, xPos, yPos);
        this.length = length;
        this.width = width;
    }
    
    /**
     * Gets length of rectangle.
     * 
     * @return  The length of the rectangle object.
     */
    public int getLength()
    {
        return length;
    }
    
    /**
     * Gets width of rectangle.
     * 
     * @return  The width of the rectangle object.
     */
    public int getWidth()
    {
        return width;
    }

    /**
     * Sets the length of the rectangle.
     * 
     * @param   length    The length of the rectangle.
     */
    public void setLength(int length)
    {
        this.length = length;
    }
    
    /**
     * Sets the width of the rectangle.
     * 
     * @param   width    The width of the rectangle.
     */
    public void setWidth(int width)
    {
        this.width = width;
    }

    /**
     * Concrete Implementation - render the rectangle for both filled and outlined according to the states
     *
     * @param   g   is the graphics context
     */
    @Override
    public void Draw(Graphics g)
    {
        if(super.getIsFill())
        {
            g.setColor(super.getFill());
            g.fillRect(getXPos(), getYPos(), length, width);
        }
        if(super.getIsOutline())
        {
            g.setColor(super.getOutline());
            g.drawRect(getXPos(), getYPos(), length, width);
        }
    }
}
