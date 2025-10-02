import javax.swing.*;
/**
 * HomeFrame object opens the opening game screen
 *
 * @author Noel Abastillas, Abbie Finnimore, Tess Erickson
 * @version 11/13/24
 */
public class HomeFrame extends JPanel
{
    private final JFrame frame; // the actual frame(window) we'll be showing
    private Thread musicThread; // Home Screen Music

    /**
     * Constructor for new CanvasFrame object.
     *
     */
    public HomeFrame()
    {
        frame = new JFrame("Ice Fishing Home Screen"); //make the JFrame, and set the window bar title
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon homeIcon = new ImageIcon("sprites/titleScreen.png");
        JLabel homeLabel = new JLabel(homeIcon);
        frame.add(homeLabel);

        JButton playButton = new JButton("Click to play!");
        playButton.setBounds(495, 170, 220, 50);
        frame.add(playButton);

        // Use the canvasPanel size & borders to define window size
        frame.getContentPane().add(homeLabel); //put the canvas (JPanel) in the frame
        frame.pack();                       //make everything the preferred size
        frame.setVisible(true);             //show the frame

        playMusic();
        // actionListener stops music and opens game window
        playButton.addActionListener(e -> {
            new CanvasFrame();
            stopMusic();
            frame.setVisible(false);
        });
    }

    /**
     * Plays sound file
     */
    public void playMusic()
    {
        AudioPlayer musicPlayer = new AudioPlayer("sounds/yoshiStory2.wav", true);
        musicThread = new Thread(musicPlayer);
        musicThread.start();
    }

    /**
     *  Stops sound file
     */
    public void stopMusic()
    {
        if (musicThread != null)
        {
            musicThread.interrupt();
            musicThread = null;
        }
    }
}