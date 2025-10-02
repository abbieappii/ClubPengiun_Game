import java.awt.Color;
import java.awt.Graphics;

/**
 * Abstract class Shape2D has an x-position, a y-position, and color.
 *
 * @author Noel Abastillas, Abbie Finnimore, Tess Erickson
 * @version 11/13/24
 */
public abstract class Shape2D
{
    private int     colorIndex;     // the index of the color of the shape in the ChooseColor array
    private Color   fillColor;          // the color of the filled in shape
    private Color   outlineColor;       // the color of the outline of the shape
    private int     xPos;               // xPos
    private int     yPos;               // yPos
    private boolean isFill;
    private boolean isOutline;
    private int     zRotate;
    private int     xScale;
    private int     yScale;
    private int     xVel; 
    private int     yVel;
    
    public static final Color[] COLORS = 
    {
            new Color(255,   0,   0),   // Red           0
            new Color(  0, 255,   0),   // Green         1
            new Color(  0,   0, 255),   // Blue          2
            new Color(  0,   0,   0),   // Black         3
            new Color(128, 128, 128),   // Grey          4
            new Color(255, 255, 255),   // White         5
            new Color(255, 255,   0),   // Yellow        6
            new Color(  0, 255, 255),   // Cyan          7
            new Color(255,   0, 255),   // Magenta       8
            new Color(165,  42,  42),   // Brown         9
            new Color(227,  66,  52),   // Vermilion    10
            new Color(255, 168,  38),   // Orange       11
            new Color(212, 255,  38),   // Chartreuse   12
            new Color( 82, 255,  38),   // Lime         13
            new Color( 38, 255, 125),   // Foam         14
            new Color( 0, 128, 128),    // Teal         15
            new Color( 38, 125, 255),   // Sea          16
            new Color( 82,  38, 255),   // Violet       17
            new Color(212,  38, 255),   // Purple       18
            new Color(255,  38, 168),   // Pink         19
    }; 
        
    public final static int RED = 0;
    public final static int GREEN = 1;    
    public final static int BLUE = 2;    
    public final static int BLACK = 3;    
    public final static int GREY = 4;    
    public final static int WHITE = 5;    
    public final static int YELLOW = 6;    
    public final static int CYAN = 7;    
    public final static int MAGENTA = 8;    
    public final static int BROWN = 9;    
    public final static int VERMILION = 10;
    public final static int ORANGE = 11;    
    public final static int CHARTREUSE = 12;    
    public final static int LIME = 13;    
    public final static int FOAM = 14;    
    public final static int TEAL = 15;    
    public final static int SEA = 16;    
    public final static int VIOLET = 17;    
    public final static int PURPLE= 18;    
    public final static int PINK = 19;    
        
    /**
     * Constructor for objects of class Shape with color filled in
     * 
     * @param   colorIndex          The index of the color on the color ArrayList for shape fill.
     * @param   xPos                The x-position on the canvas.
     * @param   yPos                The y-position on the canvas.
     */
    public Shape2D(int colorIndex, int xPos, int yPos)
    {
        this.colorIndex = colorIndex;
        this.fillColor = COLORS[colorIndex];
        this.outlineColor = COLORS[BLACK];
        this.xPos = xPos;
        this.yPos = yPos;

        // Shape2D fill/draw
        isFill = true;
        isOutline = true;

        // Polygon transformation
        zRotate = 0;
        xScale = 1;
        yScale = 1;

        // Velocity
        xVel = 0;
        yVel = 0;
    }
    
    /**
     * Gets the color of the shape.
     *
     * @return  The color of the shape.
     */
    public Color getFill()
    {
        return fillColor;
    }
    
    /**
     * Gets the fill color index.
     *
     * @return  The fill color index.
     */
    public int getColorIndex()
    {
        return colorIndex;
    }
    
    /**
     * Gets the color of the shape.
     *
     * @return  The color of the shape.
     */
    public Color getOutline()
    {
        return outlineColor;
    }
    
    /**
     * Gets the x-position coordinate.
     *
     * @return  The x-position.
     */
    public int getXPos()
    {
        return xPos;
    }
    
    /**
     * Gets the y-position coordinate.
     *
     * @return  The y-position.
     */
    public int getYPos()
    {
        return yPos;
    }
    
    /**
     * If the shape is filled
     * 
     * @return  If the shape is filled
     */
    public boolean getIsFill()
    {
        return isFill;
    }
    
    /**
     * If the shape is outlined
     * 
     * @return  If the shape is outlined.
     */
    public boolean getIsOutline()
    {
        return isOutline;
    }

    /**
     * Gets the rotation degrees
     *
     * @return  The degrees of rotation
     */
    public int getZRotate()
    {
        return zRotate;
    }

    /**
     * Gets the scale
     *
     * @return  Scale across the x-coordinate
     */
    public int getScaleX()
    {
        return xScale;
    }

    /**
     * Gets the scale
     *
     * @return  Scale across the y-axis
     */
    public int getScaleY()
    {
        return yScale;
    }

    /**
     * Gets the velocity along the x-axis
     *
     * @return  The velocity along the x-axis
     */
    public int getXVel()
    {
        return xVel;
    }

    /**
     * Gets the velocity along the y-axis
     *
     * @return  The velocity along the y-axis
     */
    public int getYVel()
    {
        return yVel;
    }
    
    /**
     * The index of the fill color chosen in the color array.
     * 
     * @param   index   The index chosen in the array.
     */
    public void setColorIndex(int index)
    {
        this.colorIndex = index;
    }
    
    /**
     * Sets the fill color to the color in the color array
     * 
     * @param   color   The color chosen
     * @return          none
     */
    public void setFill(Color color)
    {
        this.fillColor = color;
    }
    
    /**
     * Sets the outline color to the color in color array
     * 
     * @param   index     The color chosen
     */
    public void setOutlineColor(int index)
    {
        this.outlineColor = COLORS[index];
    }
    
    /**
     * If the shape is filled
     * 
     * @param   isFill  If the shape should be filled
     */
    public void setIsFill(boolean isFill)
    {
        this.isFill = isFill;
    }
    
    /**
     * If the shape is outlined
     * 
     * @param   isOutline   If the shape should be outlined
     */
    public void setIsOutline(boolean isOutline)
    {
        this.isOutline = isOutline;
    }
    
    /**
     * Sets the x-position coordinate.
     * 
     * @param   xPos    The x-position
     */
    public void setXPos(int xPos)
    {
        this.xPos = xPos;
    }
    
    /**
     * Sets the y-position coordinate.
     * 
     * @param   yPos    The y-position
     */
    public void setYPos(int yPos)
    {
        this.yPos = yPos;
    }
    
    /**
     * Sets the x-scale value
     * 
     * @param   xScale  The scale along x-axis
     */
    public void setXScale(int xScale)
    {
        this.xScale = xScale;
    }
    
    /**
     * Sets the y-scale value
     * 
     * @param   yScale    The scale along the y-axis
     */
    public void setYScale(int yScale)
    {
        this.yScale = yScale;
    }
    
    /**
     * Sets the rotation
     * 
     * @param   zRotate The degrees of rotation 
     */
    public void setZRotate(int zRotate)
    {
        this.zRotate = zRotate;
    }
    
    /**
     * Sets the velocity along x-axis
     * 
     * @param   xVel    The velocity along x-axis
     */
    public void setXVel(int xVel)
    {
        this.xVel = xVel;
    }
    
    /**
     * Sets the velocity along y-axis
     * 
     * @param yVel  The velocity along y-axis
     */
    public void setYVel(int yVel)
    {
        this.yVel = yVel;
    }
    
    /**
     * Sets the position for the x and y coordinate
     * 
     * @param   xPos    The position on the x-axis
     * @param   yPos    The position on the y-axis
     */
    public void setPos(int xPos, int yPos)
    {
        this.xPos = xPos;
        this.yPos = yPos;
    }
    
    /**
     * Moves the shape by an amount
     *
     * @param   xDelta  amount to translate along the x-axis
     * @param   yDelta  amount to translate along the y-axis
     */
    public void Move(int xDelta, int yDelta)
    {
        this.xPos += xDelta;
        this.yPos += yDelta;
    }
    
    /**
     * Sets the speed along the x and y axis
     * 
     * @param   xDelta  The speed along the x-axis
     * @param   yDelta  The speed along the y-axis
     */
    public void setSpeed(int xDelta, int yDelta)
    {
        this.xPos += xDelta;
        this.yPos += yDelta;
    }
    
    /**
     * Abstract method Draws the shape.
     *
     * @param  g  The shape drawn
     */
    public abstract void Draw(Graphics g);
}
