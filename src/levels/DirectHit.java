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
 * the class describe a level - Direct Hit.
 * @author Sapir David <sapirdavid5220@gmail.com>
 * @version 1.0
 * @since 20-06-05
 */
public class DirectHit implements LevelInformation {
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
    public static final int PADDLE_SPEED = 20;
    public static final int PADDLE_WEIGHT = 100;
    public static final int BALLS_AMOUNT = 1;
    public static final int LEVEL_NUMBER = 1;
    public static final int BALL_SPEED = 8;
    public static final int BALL_ANGLE = 0;
    /**
     * constructor of the direct hit level.
     */
    public DirectHit() {
        this.numberOfBalls = BALLS_AMOUNT;
        this.velocities = new ArrayList<>();
        this.paddleSpeed = PADDLE_SPEED;
        this.paddleWidth = PADDLE_WEIGHT;
        this.levelName =  "Direct Hit";
        this.backGround = new BackGround(new Rectangle(new Point(0, 0), WIDTH, HEIGHT),
                Color.BLACK, LEVEL_NUMBER);
        this.blocks = this.createBlocks();
        this.numberOfBlocksToRemove = 1;
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
        double angle = BALL_ANGLE;
        double speed = BALL_SPEED;
        Velocity vel = Velocity.fromAngleAndSpeed(angle, speed);
        this.velocities.add(vel);
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
     * @return list of blocks - each block contains its size, color and location.
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
        //create a block, add him to list and return the list.
        List<Block> blocksList = new ArrayList<>();
        Rectangle rect = new Rectangle(new Point(385, 150), 30, 30);
        List<HitListener> hitListenersEmpty = new ArrayList<HitListener>();
        Block block = new Block(rect, Color.red, hitListenersEmpty);
        blocksList.add(block);
        return blocksList;
    }
}
