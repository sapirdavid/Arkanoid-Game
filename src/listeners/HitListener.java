// ID : 318574712
package listeners;
import sprites.Ball;
import sprites.Block;
/**
 * the class describe a interface of hit-listener.
 * @author Sapir David <sapirdavid5220@gmail.com>
 * @version 1.0
 * @since 20-05-23
 */
public interface HitListener {
    /**
     * This funcrion is called whenever the beingHit object is hit.
     * @param beingHit - the block to be hit.
     * @param hitter -  the Ball that's doing the hitting
     */
    void hitEvent(Block beingHit, Ball hitter);
}