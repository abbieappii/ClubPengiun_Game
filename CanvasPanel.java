import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.Random;
import java.util.ArrayList;

/**
 * OOPDA Final Project
 * 
 * @author Noel Abastillas, Abbie Finnimore, Tess Errickson
 * @version 11/13/24
 */
public class CanvasPanel extends JPanel
{
    // Window Borders
    private final static int X_CORNER = 25;
    private final static int Y_CORNER = 25;
    private final static int CANVAS_WIDTH = 800;
    private final static int CANVAS_HEIGHT = 800;
    // Game Elements
    private int frameNumber;
    private int score;
    private boolean isReel;
    // Fish Array
    private final ArrayList<Sprite2D> backgroundList;
    private ArrayList<Sprite2D> fishList;
    // Player Sprites
    private final Sprite2D penguin;
    private final Sprite2D penguinReel;
    private final Sprite2D hook;
    private final Sprite2D scoreFrame;
    private final Rectangle2D rod1;
    // Music Threads
    private Thread musicThread;
    /**
     * Constructor for CanvasPanel object. Creates subclass objects of superclass Shape2D, and adds shapes to Arraylist.
     * Declares callback methods. Creates a render loop to display gameplay and start in-game timer.
     */
    public CanvasPanel()
    {
        // Reading in all Sprites
        // background sprites
        // snow sprite
        BufferedImage[] SnowSprites = new BufferedImage[1];
        try{
            SnowSprites[0] = ImageIO.read(new File("sprites/backgroundSnow.png"));
        }
        catch (IOException ie) {
            System.out.println("Check file name");
        }

        // mountain sprite
        BufferedImage[] MountainSprites = new BufferedImage[1];
        try{
            MountainSprites[0] = ImageIO.read(new File("sprites/backgroundMountain.png"));
        }
        catch (IOException ie) {
            System.out.println("Check file name");
        }

        // ground sprite
        BufferedImage[] GroundSprites = new BufferedImage[1];
        try{
            GroundSprites[0] = ImageIO.read(new File("sprites/backgroundGround.png"));
        }
        catch (IOException ie) {
            System.out.println("Check file name");
        }

        // Player Sprites
        // Penguin
        BufferedImage[] Penguin_Sprites = new BufferedImage[1];
        try {
            Penguin_Sprites[0] = ImageIO.read(new File("sprites/pengL1.png"));
        }
        catch (IOException ie) {
            System.out.println("Check file name");
        }

        // Penguin Reeling
        BufferedImage[] PenguinReel_Sprites = new BufferedImage[1];
        try{
            PenguinReel_Sprites[0] = ImageIO.read(new File("sprites/pengL2.png"));
        }
        catch(IOException e) {
            System.out.println("Check file name");
        }

        // Hook
        BufferedImage[] HookSprites = new BufferedImage[1];
        try{
            HookSprites[0] = ImageIO.read(new File("sprites/hookWorm.png"));
        }
        catch (IOException ie) {
            System.out.println("Check file name");
        }

        // Score Frame
        BufferedImage[] ScoreSprites = new BufferedImage[1];
        try{
            ScoreSprites[0] = ImageIO.read(new File("sprites/scoreFrame.png"));
        }
        catch (IOException ie) {
            System.out.println("Check file name");
        }

        // Fish Sprites
        // Left-Facing Yellow Fish
        BufferedImage[] FishYL_Sprites = new BufferedImage[20];
        try {
            BufferedImage fishYL1File = ImageIO.read(new File("sprites/fishYL1.png"));
            BufferedImage fishYL2File = ImageIO.read(new File("sprites/fishYL2.png"));
            for(int i = 0; i < 10; i++)
            {
                FishYL_Sprites[i] = fishYL1File;
            }
            for(int i = 10; i < 20; i++)
            {
                FishYL_Sprites[i] = fishYL2File;
            }
        }
        catch (IOException ie) {
            System.out.println("Check file name");
        }

        // Left-Facing Purple Fish
        BufferedImage[] FishPL_Sprites = new BufferedImage[20];
        try {
            BufferedImage fishP1LFile = ImageIO.read(new File("sprites/fishPL1.png"));
            BufferedImage fishP2LFile = ImageIO.read(new File("sprites/fishPL2.png"));
            for(int i = 0; i < 10; i++)
            {
                FishPL_Sprites[i] = fishP1LFile;
            }
            for(int i = 10; i < 20; i++)
            {
                FishPL_Sprites[i] = fishP2LFile;
            }
        }
        catch (IOException ie) {
            System.out.println("Check file name");
        }

        // Right-Facing Yellow Fish
        BufferedImage[] FishYR_Sprites = new BufferedImage[20];
        try {
            BufferedImage fishYR1File = ImageIO.read(new File("sprites/fishYR1.png"));
            BufferedImage fishYR2File = ImageIO.read(new File("sprites/fishYR2.png"));
            for(int i = 0; i < 10; i++)
            {
                FishYR_Sprites[i] = fishYR1File;
            }
            for(int i = 10; i < 20; i++)
            {
                FishYR_Sprites[i] = fishYR2File;
            }
        }
        catch (IOException ie) {
            System.out.println("Check file name");
        }

        // Right-Facing Purple Fish
        BufferedImage[] FishPR_Sprites = new BufferedImage[20];
        try {
            BufferedImage fishP1RFile = ImageIO.read(new File("sprites/fishPR1.png"));
            BufferedImage fishP2RFile = ImageIO.read(new File("sprites/fishPR2.png"));
            for(int i = 0; i < 10; i++)
            {
                FishPR_Sprites[i] = fishP1RFile;
            }
            for(int i = 10; i < 20; i++)
            {
                FishPR_Sprites[i] = fishP2RFile;
            }
        }
        catch (IOException ie) {
            System.out.println("Check file name");
        }

        // Left-Facing Shark
        BufferedImage[] SharkL_Sprites = new BufferedImage[20];
        try {
            BufferedImage shark1LFile = ImageIO.read(new File("sprites/sharkL1.png"));
            BufferedImage shark2LFile = ImageIO.read(new File("sprites/sharkL2.png"));
            for(int i = 0; i < 10; i++)
            {
                SharkL_Sprites[i] = shark1LFile;
            }
            for(int i = 10; i < 20; i++)
            {
                SharkL_Sprites[i] = shark2LFile;
            }
        }
        catch (IOException ie) {
            System.out.println("Check file name");
        }

        // Right-Facing Shark
        BufferedImage[] SharkR_Sprites = new BufferedImage[20];
        try {
            BufferedImage shark1RFile = ImageIO.read(new File("sprites/sharkR1.png"));
            BufferedImage shark2RFile = ImageIO.read(new File("sprites/sharkR2.png"));
            for(int i = 0; i < 10; i++)
            {
                SharkR_Sprites[i] = shark1RFile;
            }
            for(int i = 10; i < 20; i++)
            {
                SharkR_Sprites[i] = shark2RFile;
            }
        }
        catch (IOException ie) {
            System.out.println("Check file name");
        }

        // Left-Facing Boot
        BufferedImage[] BootL_Sprites = new BufferedImage[20];
        try {
            BufferedImage bootL1File = ImageIO.read(new File("sprites/bootL1.png"));
            BufferedImage bootL2File = ImageIO.read(new File("sprites/bootL2.png"));
            for(int i = 0; i < 10; i++)
            {
                BootL_Sprites[i] = bootL1File;
            }
            for(int i = 10; i < 20; i++)
            {
                BootL_Sprites[i] = bootL2File;
            }
        }
        catch (IOException ie) {
            System.out.println("Check file name");
        }

        // Right-Facing Boot
        BufferedImage[] BootR_Sprites = new BufferedImage[20];
        try {
            BufferedImage bootR1File = ImageIO.read(new File("sprites/bootR1.png"));
            BufferedImage bootR2File = ImageIO.read(new File("sprites/bootR2.png"));
            for(int i = 0; i < 10; i++)
            {
                BootR_Sprites[i] = bootR1File;
            }
            for(int i = 10; i < 20; i++)
            {
                BootR_Sprites[i] = bootR2File;
            }
        }
        catch (IOException ie) {
            System.out.println("Check file name");
        }

        // Array Initialization
        backgroundList = new ArrayList<>();
        fishList = new ArrayList<>();

        // Object Initialization
        // Player Sprites
        penguin = new Sprite2D(238, 100, Penguin_Sprites);
        penguinReel = new Sprite2D(238, 100, PenguinReel_Sprites);
        hook = new Sprite2D(430, 250, HookSprites);
        rod1 = new Rectangle2D(3, 485, 160, 2, 150);
        scoreFrame = new Sprite2D(125, 125, ScoreSprites);

        // Background Array
        backgroundList.add(new Sprite2D( 25, 100, SnowSprites));
        backgroundList.add(new Sprite2D( 25, 25, MountainSprites));
        backgroundList.add(new Sprite2D( 25, 200, GroundSprites));

        // Fish ArrayList of all fish-able objects
        // Parameters: xPos, yPos, Sprite, isLeft, headPos, yRange, xPivot, yPivot, rotation, score
        fishList.add(new Sprite2D(950, 300, FishYL_Sprites, true, 30, 25,
                31, 81, 90, 200));
        fishList.add(new Sprite2D(1150, 400, FishPL_Sprites, true, 30, 40,
                35, 95, 90, 100));
        fishList.add(new Sprite2D(-150, 350, FishYR_Sprites, false, 130, 30,
                180, 76, 270, 200));
        fishList.add(new Sprite2D(-350, 450, FishPR_Sprites, false, 170, 40,
                223, 93, 270, 100));
        fishList.add(new Sprite2D(1550, 500, SharkL_Sprites, true, -60, 120,
                235, 65, 90, -200));
        fishList.add(new Sprite2D(-400, 550, SharkR_Sprites, false, 320, 120,
                275, 65, 270, -200));
        fishList.add(new Sprite2D(1200, 650, BootL_Sprites, true, 40, 50,
                30, 90, 90, -100));
        fishList.add(new Sprite2D(-300, 600, BootR_Sprites, false, 40, 50,
                75, 90, 270, -100));

        // Callback for keyboard events
        this.setFocusable(true); // sets window to be in focus
        this.addKeyListener(new myActionListener()); // sets action listener to the keyboard
        this.addMouseMotionListener(new myActionListener());
        System.out.println("keyboard event registered"); //

        // Create a render loop that invokes action listener 30 times a second
        Timer renderLoop = new Timer(30, (ActionEvent ev) ->
        {
            frameNumber++;
            Simulate();
            repaint();
        });
        renderLoop.start();

        // thread for music
        playMusic();
    }
    
    /**
     * Simulates movement of shapes and sprites drawn on canvas
     */
    public void Simulate()
    {
        int xBoundsL = -550;        // once left-facing fish meet this x-coordinate, they spawn off-screen
        int xBoundsR = 1350;        // once right-facing fish meet this x-coordinate, they spawn off-screen
        int yBoundsCaught = 185;    // once reeled in fish meets this y-coordinate, they spawn off-screen

        randomTest randHeight = () ->   // function to generate random height
        {
            Random rand = new Random();
            return 320 + rand.nextInt(400);
        };
        // Fish movement if not caught
        for (Sprite2D fish : fishList) {
            if (fish.getIsLeft() && !fish.getIsCaught()) {
                fish.Move(-5, 0);
            }
            if (!fish.getIsLeft() && !fish.getIsCaught()) {
                fish.Move(5, 0);
            }
        }
        // fish spawn at starting location once bounds reached
        for (Sprite2D fish : fishList) {
            if (fish.getIsLeft() && fish.getXPos() < xBoundsL) {
                fish.setPos(xBoundsR, randHeight.computeRand());
            }
            if (!fish.getIsLeft() && fish.getXPos() > xBoundsR) {
                fish.setPos(xBoundsL, randHeight.computeRand());
            }
        }
        // hook deetection for fish
        for(Sprite2D fish : fishList)
        {
            if(hookCatchBounds(fish, fish.getHeadPos(), fish.getYRange()) && !isReel)
            {
                fish.setIsCaught(true);
                fish.Move(0,0);
                isReel = true;
                playEffect("whoaEffect");
            }
        }
        // If fish are reeled in to the top, they spawn out of bounds and score is updated
        for(Sprite2D fish: fishList) {
            if(fish.getYPos() < yBoundsCaught) {
                if(fish.getIsLeft())
                {
                    fish.setPos(xBoundsR, randHeight.computeRand());
                    fish.Move(-5, 0);
                }
                if(!fish.getIsLeft())
                {
                    fish.setPos(xBoundsL, randHeight.computeRand());
                    fish.Move(5, 0);
                }
                isReel = false;
                fish.setIsCaught(false);
                score = score + fish.getScore();
                // Play Sound Effects
                if(fish == fishList.get(4) || fish == fishList.get(5))
                {
                    playEffect("painEffect");
                }
                else if(fish == fishList.get(6) || fish == fishList.get(7))
                {
                    playEffect("damageEffect");
                }
                else
                {
                    playEffect("eatEffect");
                }
            }
        }
    }
    /**
     * Sets color of window and canvas. Draws shapes.
     *
     * @param   g   The shape to draw.
     */
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Define the start and end points for the gradient
        Point2D start = new Point2D.Float(425, 260);
        Point2D end = new Point2D.Float(425, 800);
        // Define the colors for the gradient new Color
        Color startColor = new Color( 182, 210, 219);
        Color endColor = new Color(  92, 136, 202);
        // Create a GradientPaint object
        GradientPaint gradient = new GradientPaint(start, startColor, end, endColor);
        // Set the paint to the Graphics2D object
        g2.setPaint(gradient);
        // Fill a rectangle with the gradient
        g2.fillRect(X_CORNER, 260, CANVAS_WIDTH, 565);

        // Draw snow, mountains, ground
        for(Sprite2D background : backgroundList)
        {
            background.Draw(g);
        }
        rod1.Draw(g);
        hook.Draw(g);
        scoreFrame.Draw(g);
        // Set game clock font
        Font myFont = new Font("Arial", Font.PLAIN, 24);
        g.setFont(myFont);
        g.setColor(Color.BLACK);
        // g.drawString( String.valueOf(score), 225, 255);
        g.drawString(String.valueOf(frameNumber), 200, 50);

        // Rotate Score
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform oldForm = g2d.getTransform();
        int pivotX = 225;
        int pivotY = 255;
        g2d.translate(pivotX, pivotY);
        g2d.rotate(Math.toRadians(345));
        g2d.translate(-pivotX, -pivotY);
        g2d.drawString( String.valueOf(score), 225, 255);
        g2d.setTransform(oldForm);

        // Changes Penguin animation when fish is being reeled in
        if(!isReel)
        {
            penguin.Draw(g);
        }
        else
        {
            penguinReel.Draw(g);
        }

        // Draws all fish
        for(Sprite2D fish : fishList)
        {
            if(!fish.getIsCaught())
            {
                fish.Draw(g);
            }
        }
        // Drawing Fish Sideways if caught
        for(Sprite2D fish : fishList)
        {
            if(fish.getIsCaught())
            {
                transform(fish, g, fish.getXPivot(), fish.getYPivot(), fish.getRotation());
            }
        }
        // Window borders
        g.setColor(Color.BLACK);
        g.fillRect(0,0, X_CORNER, X_CORNER * 2 + CANVAS_HEIGHT); // Left Border
        g.fillRect(825,0, X_CORNER, X_CORNER * 2 + CANVAS_HEIGHT); // Right Border
        g.fillRect(X_CORNER, 0, CANVAS_WIDTH, Y_CORNER); // Top Border
        g.fillRect(X_CORNER, 825, CANVAS_WIDTH, Y_CORNER); // Bottom Border
    }

    /**
     * Hook catches fish if within range of fish's head
     *
     * @param   fish    The fish sprite
     * @param   headPos The fish's head position
     * @param   range   The range of the sprite
     * @return          If the hook is within range of fish's head
     */
    public boolean hookCatchBounds(Sprite2D fish, int headPos, int range) {
        if (fish.getIsLeft()) {
            return hook.getXPos() == fish.getXPos() - headPos &&
                    hook.getYPos() > fish.getYPos() - range &&
                    hook.getYPos() < fish.getYPos() + range;
        } else {
            return hook.getXPos() == fish.getXPos() + headPos &&
                    hook.getYPos() > fish.getYPos() - range &&
                    hook.getYPos() < fish.getYPos() + range;
        }
    }

    /**
     * Plays sound file on loop
     */
    public void playMusic()
    {
        AudioPlayer musicPlayer = new AudioPlayer("sounds/yoshiStory1.wav", true);
        musicThread = new Thread(musicPlayer);
        musicThread.start();
    }

    /**
     * Stops playing sound file
     */
    public void stopMusic()
    {
        if (musicThread != null)
        {
            musicThread.interrupt();
            musicThread = null;
        }
    }

    /**
     * Plays sound effect, not looped
     *
     * @param effect    The sound effect
     */
    public void playEffect(String effect)
    {
        AudioPlayer musicPlayer = new AudioPlayer("sounds/" + effect + ".wav", false);
        Thread musicThread = new Thread(musicPlayer);
        musicThread.start();
    }

    /**
     * Transform method to draw fish if reeled in
     *
     * @param fish      The fish object to draw vertically
     * @param g         The graphics object
     * @param xPos      The xPosition to add to the pivot point
     * @param yPos      The yPosition to add to the pivot point
     * @param degrees   The degree of rotation
     */
    public void transform(Sprite2D fish, Graphics g, int xPos, int yPos, int degrees)
    {
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform oldForm = g2d.getTransform();
        // pivot points
        int pivotX = fish.getXPos() + xPos;
        int pivotY = fish.getYPos() + yPos;
        // translate to pivot point
        g2d.translate(pivotX, pivotY);
        // rotate around pivot point
        g2d.rotate(Math.toRadians(degrees));
        // translate back
        g2d.translate(-pivotX, -pivotY);
        fish.Draw(g);
        g2d.setTransform(oldForm);
    }

    /**
     * Returns the canvas width.
     *
     * @return  The canvas width.
     */
    public static int getCanvasWidth()
    {
        return CANVAS_WIDTH;
    }
    
    /**
     * Returns the canvas height.
     *
     * @return  The canvas height.
     */
    public static int getCanvasHeight()
    {
        return CANVAS_HEIGHT;
    }
    
    /**
     * Returns the canvas x border.
     *
     * @return  The canvas x border.
     */
    public static int getCanvasXBorder()
    {
        return X_CORNER;
    }
    
    /**
     * Returns the canvas y border
     *
     * @return  The canvas y border
     */
    public static int getCanvasYBorder()
    {
        return Y_CORNER;
    }

    /**
     * myActionListener Class listens to keyboard to trigger events.
     */
    public class myActionListener extends KeyAdapter implements MouseListener, MouseMotionListener
    {
        /**
         * Listens to keyboard to trigger events.
         * 
         * @param   e   The keyboard event.
         */
        public void keyPressed(KeyEvent e)
        {
            switch (e.getKeyCode())
            {
                case KeyEvent.VK_UP:

                // break;
                case KeyEvent.VK_DOWN:

                break;
                default:
                    System.out.println("press some other key besides the arrow keys");
            }
        }
        /**
         * Listens to when a key is released.
         * 
         * @param   e   The key being released.
         */
        @Override
        public void mouseMoved(MouseEvent e) {
            if(e.getY() > 150 )
            {
                rod1.setWidth(e.getY() - 100);
            }
            if(e.getY() > 150 )
            {
                hook.setYPos(e.getY());
            }
            for(Sprite2D fish : fishList)
            {
                if(fish.getIsCaught() && e.getY() > 150)
                {
                    fish.setYPos(e.getY());
                }
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {}

        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {}

        @Override
        public void mouseDragged(MouseEvent e) {}
    }
}

/**
 * Methods using this Interface take an integer and returns a random integer of some value in concrete method
 */
@FunctionalInterface
interface randomTest
{
    int computeRand();
}

