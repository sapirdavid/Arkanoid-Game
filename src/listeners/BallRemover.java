// ID : 318574712
package listeners;
import game.GameLevel;
import hit.Counter;
import sprites.Ball;
import sprites.Block;
/**
 * the class describe ball remover activity.
 * @author Sapir David <sapirdavid5220@gmail.com>
 * @version 1.0
 * @since 20-05-23
 **/
public class BallRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBalls;
    /**
     * constructor of block-remover.
     * @param gameLevel - the game.
     * @param removedBlocks - count of the number of blocks that remain.
     */
    public BallRemover(GameLevel gameLevel, Counter removedBlocks) {
        this.gameLevel = gameLevel;
        this.remainingBalls = removedBlocks;
    }
    /**
     * the function removed the block that hit from the game.
     * @param beingHit - the block to be hit.
     * @param hitter -  the Ball that's doing the hitting
     */
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        // remove the all from the game.
        hitter.removeFromGame(gameLevel);
        // decrease the counter of the balls.
        this.remainingBalls.decrease(1);
    }
}
