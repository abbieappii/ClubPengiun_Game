
import javax.swing.*;
import java.awt.*;
/**
 * 2D Frame for 2D Graphics
 * CanvasFrame object has a frame to display, and a canvas to draw graphics on.
 *
 * @author Noel Abastillas, Abbie Finnimore, Tess Erickson
 * @version 11/13/24
 */
public class CanvasFrame 
{
    private JFrame frame;       // the actual frame(window) we'll be showing
    private CanvasPanel canvas; // the canvas we'll be drawing
    
    /**
     * Constructor for new CanvasFrame object.
     */
    public CanvasFrame()
    {
        frame = new JFrame("Ice Fishing Game Screen"); //make the JFrame, and set the window bar title
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        canvas = new CanvasPanel();  // CanvasPanel extends a JPanel
        // Use the canvasPanel size & borders to define window size
        canvas.setPreferredSize(new Dimension(2 * canvas.getCanvasXBorder() + canvas.getCanvasWidth(),
                                              2 * canvas.getCanvasYBorder() + canvas.getCanvasHeight()));
        frame.getContentPane().add(canvas); // put the canvas (JPanel) in the frame
        frame.pack();                       // make everything the preferred size
        frame.setVisible(true);             // show the frame
    }
}
