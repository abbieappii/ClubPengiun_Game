import java.awt.Graphics;

/**
 * Polygon2D class can be transformed
 *
 * @author Noel Abastillas, Abbie Finnimore, Tess Erickson
 * @version 11/20/24
 */
public class Polygon2D extends Shape2D
{
    private int[] xCoords;
    private int[] yCoords;
    private int[] txCoords;
    private int[] tyCoords;

    /**
     * Constructor for objects of class Polygon2D
     *
     * @param colorIndex    The color chosen from color array
     * @param xPos          The x-coordinate position
     * @param yPos          The y-coordinate position
     * @param xCoords       Array of x-coordinates to draw polygon
     * @param yCoords       Array of y-coordinates to draw polygon
     */
    public Polygon2D(int colorIndex, int xPos, int yPos, int[] xCoords, int[] yCoords)
    {
        super(colorIndex, xPos, yPos);
        
        this.xCoords = new int[xCoords.length]; // construct (allocate memory)
        this.yCoords = new int[yCoords.length]; // construct (allocate memory)
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
     * Transform polygon
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
     * Draws Polygon
     * 
     * @param   g   The shape to draw
     */
    @Override
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
