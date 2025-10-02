import java.awt.Graphics;

/**
 * StarPoly2D draws a star polygon, can rotate
 *
 * @author Noel Abastillas, Abbie Finnimore, Tess Erickson
 * @version 11/20/24
 */
public class StarPoly2D extends Shape2D
{
    private int[] xCoords = {0, 2, 10, 2, 0, -2, -10, -2};
    private int[] yCoords = {-10, -2, 0, 2, 10, 2, 0, -2};
    private int[] txCoords = null;
    private int[] tyCoords = null;

    /**
     * Constructor for StarPoly2D object
     *
     * @param colorIndex    The color index for color array
     * @param xPos          The x-position
     * @param yPos          The y-position
     */
    public StarPoly2D(int colorIndex, int xPos, int yPos)
    {
        super(colorIndex, xPos, yPos);

        this.txCoords = new int[xCoords.length]; // construct (allocate memory)
        this.tyCoords = new int[yCoords.length]; // construct (allocate memory)
        
        for(int i = 0; i < xCoords.length; i++)
        {
            this.xCoords[i] = xCoords[i];
            this.txCoords[i] = xCoords[i] + xPos; // coordinates for rotation
        }
        
        for(int i = 0; i < yCoords.length; i++)
        {
            this.yCoords[i] = yCoords[i];
            this.tyCoords[i] = yCoords[i] + yPos;
        }
        
    }
    
    /**
     * Transforms StarPoly
     */
    private void Transform()
    {
        double degs = super.getZRotate(); // Get degrees rotated
        double rads = Math.toRadians(degs); // Convert dgrees to radians
        double Sx = super.getScaleX(); // Get scale component in the x direction
        double Sy = super.getScaleY(); // Get scale component int the y direction
        for (int i = 0; i < xCoords.length; i++)
        {
            double x = Sx * this.xCoords[i]; // scale in x
            double y = Sy * this.yCoords[i]; // scale in y
            // Rotate and then translate
            this.txCoords[i] = (int)(((x * Math.cos(rads) - y * Math.sin(rads)) + super.getXPos()) + 0.5);
            this.tyCoords[i] = (int)(((x * Math.sin(rads) + y * Math.cos(rads)) + super.getYPos()) + 0.5);
        }
    }
    
    /**
     * Draws StarPoly
     * 
     * @param   g   The shape to draw
     */
    public void Draw(Graphics g)
    {
        Transform();
        
        if(super.getIsFill())
        {
            g.setColor(super.getFill());
            g.fillPolygon(txCoords, tyCoords, xCoords.length);
        }
        
        if(super.getIsOutline())
        {
            g.setColor(super.getOutline());
            g.drawPolygon(txCoords, tyCoords, xCoords.length);
        }
    }
}
