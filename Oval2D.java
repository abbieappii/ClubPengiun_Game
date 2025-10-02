import java.awt.*;

/**
 * Oval2D Class objects have diameter along x-axis and diameter along y-axis
 *
 * @author Noel Abastillas, Abbie Finnimore, Tess Erickson
 * @version 11/13/24
 */
public class Oval2D extends Shape2D
{
    private int diameter1;
    private int diameter2;
    
    /**
     * Constructor for objects of class Oval
     * Creates oval class with set color, coordinate, and size.
     */
    public Oval2D()
    {
        super(13, 100, 100); // xPos, yPos, fillColorIndex
        this.diameter1 = 40;
        this.diameter2 = 60;
    }
    
    /**
     * Constructor for objects of class Oval
     * 
     * @param   fillColorIndex  The color fill of oval.
     * @param   xPos            The x-coordinate of oval.
     * @param   yPos            The y-coordinate of oval
     * @param   diameter1       The diameter on x-coordinate of oval
     * @param   diameter2       The diameter on y-coordinate of oval
     */
    public Oval2D(int fillColorIndex, int xPos, int yPos,  int diameter1, int diameter2)
    {
        super(fillColorIndex, xPos, yPos);
        this.diameter1 = diameter1;
        this.diameter2 = diameter2;
    }
    
    /**
     * Gets diameter of oval.
     * 
     * @return  The diameter of the oval object.
     */
    public int getDiameter1()
    {
        return diameter1;
    }
    
    /**
     * Gets diameter2 of oval.
     * 
     * @return  The diameter2 of the oval object.
     */
    public int getDiameter2()
    {
        return diameter2;
    }
    
    /**
     * Sets the diameter of the oval.
     * 
     * @param   diameter1    The diameter of the oval.
     */
    public void setDiameter1(int diameter1)
    {
        this.diameter1 = diameter1;
    }
    
    /**
     * Sets the diameter2 of the oval.
     * 
     * @param   diameter2    The diameter2 of the oval.
     */
    public void setDiameter2(int diameter2)
    {
        this.diameter2 = diameter2;
    }

    /**
     * Concrete Implementation - render the oval for both filled and outlined according to the states
     *
     * @param   g is the graphics context
     */
    @Override
    public void Draw(Graphics g)
    {
        if(super.getIsFill())
        {
            g.setColor(super.getFill());
            g.fillOval(getXPos(), getYPos(), diameter1, diameter2);
        }
        
        if(super.getIsOutline())
        {
            g.setColor(super.getOutline());
            g.drawOval(getXPos(), getYPos(), diameter1, diameter2);
        }
        
    }
}
