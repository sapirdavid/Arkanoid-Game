// ID : 318574712
package levels;
import hit.Velocity;
import sprites.Block;
import sprites.Sprite;
import java.util.List;
/**
 * the class describe a level information.
 * @author Sapir David <sapirdavid5220@gmail.com>
 * @version 1.0
 * @since 20-06-05
 */
public interface LevelInformation {
    /**
     * the function return the number of balls in this level.
     * @return number - of balls in this level.
     */
    int numberOfBalls();
    /**
     * the function return the initial velocity of each ball.
     * @return list of velocities - the velocity of each ball.
     */
    List<Velocity> initialBallVelocities();
    /**
     * the function return the speed of the paddle in this level.
     * @return speed - the speed of the paddle.
     */
    int paddleSpeed();
    /**
     * the function return the width of the paddle in this level.
     * @return width - the width of the paddle.
     */
    int paddleWidth();
    /**
     * the function return the level name will be displayed at the top of the screen.
     * @return level name - the name of this level.
     */
    String levelName();
    /**
     * the function returns a sprite with the background of the level.
     * @return sprite - the background of the level.
     */
    Sprite getBackground();
    /**
     * the function return a list of block that will be in this level.
     * @return list of blocks - each block contains its size, color and location.
     */
    List<Block> blocks();
    /**
     * the function return the number of blocks that should be removed
     *  before the level is considered to be "cleared".
     * @return number of blocks.
     */
    int numberOfBlocksToRemove();
    /**
     * the function create the blocks to remove and return a list of them.
     * @return list - of blocks.
     */
    List<Block> createBlocks();
}