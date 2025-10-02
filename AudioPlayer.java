import javax.sound.sampled.*;
import java.io.*;

/**
 * AudioPlayer class plays sound files. Can loop sounds and stop sounds.
 *
 * @author Noel Abastillas, Abbie Finnimore, Tess Erickson
 * @version 11/20/24
 */
public class AudioPlayer implements Runnable {
    private String soundFilePath;
    private boolean isLoop;

    /**
     * Constructor for AudioPlayer class object.
     *
     * @param soundFilePath     The file path of sound file
     * @param isLoop            If sound file should loop
     */
    public AudioPlayer(String soundFilePath, boolean isLoop)
    {
        this.soundFilePath = soundFilePath;
        this.isLoop = isLoop;
    }

    /**
     * Concrete implementation of run method.
     */
    @Override
    public void run()
    {
        playSound(soundFilePath, isLoop);
    }

    /**
     * Concrete implementation of run method, plays sound of filePath and can loop sound.
     *
     * @param filePath      The file path of the sound file
     * @param isLoop        If sound file should loop
     */
    private void playSound(String filePath, boolean isLoop)
    {
        try
        {
            File soundFile = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            if(!isLoop)
            {
                clip.start();
                clip.addLineListener(event -> {
                    if (event.getType() == LineEvent.Type.STOP)
                    {
                        clip.close();
                    }
                });
            }
            if(isLoop)
            {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                clip.start( );
            }
            while (clip.isOpen())
            {
                if (Thread.currentThread().isInterrupted())
                {
                    clip.close();
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}