import java.awt.*;


/**
 * Circle Class object's diameter can be retrieved and changed. Implements
 * concrete body for draw method.
 *
 * @author Noel Abastillas, Abbie Finnimore, Tess Erickson
 * @version 11/13/24
 */
public class Circle2D extends Shape2D
{
    private int diameter;
    
    /**
     * Constructor for objects of class Circle
     * Creates circle class with set color, coordinate, and size.
     */
    public Circle2D()
    {
        super(0, 150, 300);
        this.diameter = 40;
    }
    
    /**
     * Constructor for objects of class Circle
     * 
     * @param   fillColorIndex  The color fill of circle.
     * @param   xPos            The x-coordinate of circle.
     * @param   yPos            The y-coordinate of circle
     * @param   diameter        The diameter of circle
     */
    public Circle2D(int fillColorIndex, int xPos, int yPos, int diameter)
    {
        super(fillColorIndex, xPos, yPos);
        this.diameter = diameter;
    }
    
    /**
     * Gets diameter of circle.
     * 
     * @return  The diameter of the circle object.
     */
    public int getDiameter()
    {
        return diameter;
    }
    
    /**
     * Sets the diameter of the circle.
     * 
     * @param   diameter    The diameter of the circle.
     */
    public void setDiameter(int diameter)
    {
        this.diameter = diameter;
    }

    /**
     * Concrete Implementation - render the circle for both filled and outlined according to the states
     *
     * @param   g   is the graphics context
     */
    @Override
    public void Draw(Graphics g)
    {
        if(super.getIsFill())
        {
            g.setColor(super.getFill());
            g.fillOval(getXPos(), getYPos(), diameter, diameter);
        }
        
        if(super.getIsOutline())
        {
            g.setColor(super.getOutline());
            g.drawOval(getXPos(), getYPos(), diameter, diameter);
        }
    }   
}
