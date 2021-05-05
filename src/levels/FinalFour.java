// ID : 318574712
package levels;
import geometry.Point;
import geometry.Rectangle;
import hit.Velocity;
import listeners.HitListener;
import sprites.BackGround;
import sprites.Block;
import sprites.Sprite;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * the class describe a level - Final Four.
 * @author Sapir David <sapirdavid5220@gmail.com>
 * @version 1.0
 * @since 20-06-05
 */
public class FinalFour implements LevelInformation {
    private int numberOfBalls;
    private List<Velocity> velocities;
    private int paddleSpeed;
    private int paddleWidth;
    private String levelName;
    private Sprite backGround;
    private List<Block> blocks;
    private  int numberOfBlocksToRemove;
    //const numbers
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final int UPPER_LEFT_Y = 230;
    public static final int UPPER_LEFT_X = 729;
    public static final int WIDTH_BLOCK = 51;
    public static final int HEIGHT_BLOCK = 20;
    public static final int PADDLE_SPEED = 20;
    public static final int PADDLE_WEIGHT = 100;
    public static final int BLOCKS_AMOUNT = 105;
    public static final int BALLS_AMOUNT = 3;
    public static final int LEVEL_NUMBER = 4;
    public static final int ANGLE_BASE = -40;
    public static final int BALL_SPEED = 8;
    /**
     * constructor of the direct hit level.
     */
    public FinalFour() {
        this.numberOfBalls = BALLS_AMOUNT;
        this.velocities = new ArrayList<>();
        this.paddleSpeed = PADDLE_SPEED;
        this.paddleWidth = PADDLE_WEIGHT;
        this.levelName =  "Final Four";
        this.backGround = new BackGround(new Rectangle(new Point(0, 0), WIDTH, HEIGHT),
                Color.CYAN, LEVEL_NUMBER);
        this.blocks = createBlocks();
        this.numberOfBlocksToRemove = BLOCKS_AMOUNT;
    }
    /**
     * the function return the number of balls in this level.
     * @return number - of balls in this level.
     */
    @Override
    public int numberOfBalls() {
        return this.numberOfBalls;
    }
    /**
     * the function return the initial velocity of each ball.
     * @return list of velocities - the velocity of each ball.
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        for (int i = 0; i < numberOfBalls; i++) {
            double speed = BALL_SPEED;
            double angle = (ANGLE_BASE * i) + 40;
            Velocity vel = Velocity.fromAngleAndSpeed(angle, speed);
            this.velocities.add(vel);
        }
        return velocities;
    }
    /**
     * the function return the speed of the paddle in this level.
     * @return speed - the speed of the paddle.
     */
    @Override
    public int paddleSpeed() {
        return this.paddleSpeed;
    }
    /**
     * the function return the width of the paddle in this level.
     * @return width - the width of the paddle.
     */
    @Override
    public int paddleWidth() {
        return this.paddleWidth;
    }
    /**
     * the function return the level name will be displayed at the top of the screen.
     * @return level name - the name of this level.
     */
    @Override
    public String levelName() {
        return this.levelName;
    }
    /**
     * the function returns a sprite with the background of the level.
     * @return sprite - the background of the level.
     */
    @Override
    public Sprite getBackground() {
        return this.backGround;
    }
    /**
     * the function return a list of block that will be in this level.
     * @return blocks - list of block - each block contains its size, color and location.
     */
    @Override
    public List<Block> blocks() {
        return this.blocks;
    }
    /**
     * the function return the number of blocks that should be removed
     * before the level is considered to be "cleared".
     * @return number of blocks.
     */
    @Override
    public int numberOfBlocksToRemove() {
        return this.numberOfBlocksToRemove;
    }
    /**
     * the function create the blocks to remove and return a list of them.
     * @return list - of blocks.
     */
    @Override
    public List<Block> createBlocks() {
        //create a blocks, add them to list and return the list.
        List<Block> blocksList = new ArrayList<>();
        double upperLeftY = UPPER_LEFT_Y;
        double widthBlock = WIDTH_BLOCK;
        double heightBlock = HEIGHT_BLOCK;
        int blockCount = this.numberOfBlocksToRemove;
        //the color of the blocks.
        Color[] colors = {Color.BLUE, Color.pink, Color.white, Color.green,
                Color.yellow, Color.red, Color.gray};
        //create the colors blocks.
        for (int i = 0; i < 7; i++) {
            double upperLeftX = UPPER_LEFT_X;
            int k = 15;
            Color colorBlock =  colors[i];
            while (k > 0) {
                // create a hit listener for this block.
                List<HitListener> hitListeners = new ArrayList<HitListener>();
                Block block = new Block((new Point(upperLeftX, upperLeftY)), widthBlock, heightBlock,
                        colorBlock, hitListeners);
                blocksList.add(block);
                upperLeftX = upperLeftX - widthBlock;
                k--;
            }
            upperLeftY = upperLeftY - heightBlock;
        }
        return blocksList;
    }
}


