// ID : 318574712
package listeners;
import game.GameLevel;
import hit.Counter;
import sprites.Ball;
import sprites.Block;
/**
 * the class describe block remover activity.
 * @author Sapir David <sapirdavid5220@gmail.com>
 * @version 1.0
 * @since 20-05-23
 **/
public class BlockRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBlocks;
    /**
     * constructor of block-remover.
     * @param gameLevel - the game.
     * @param removedBlocks - count of the number of blocks that remain.
     */
    public BlockRemover(GameLevel gameLevel, Counter removedBlocks) {
        this.gameLevel = gameLevel;
        this.remainingBlocks = removedBlocks;
    }
    /**
     * the function removed the block that hit from the game.
     * @param beingHit - the block to be hit.
     * @param hitter -  the Ball that's doing the hitting
     */
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        // remove the block from the game.
        beingHit.removeFromGame(gameLevel);
        // remove this listener from the block that removed.
        beingHit.removeHitListener(this);
        // decrease the number of blocks.
        this.remainingBlocks.decrease(1);
    }
}
