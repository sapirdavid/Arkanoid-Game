// ID : 318574712
package listeners;
import hit.Counter;
import sprites.Ball;
import sprites.Block;
/**
 * the class describe a Score Tracking Listener.
 * @author Sapir David <sapirdavid5220@gmail.com>
 * @version 1.0
 * @since 20-05-23
 **/
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;
    /**
     * constructor of score tracking listener.
     * @param scoreCounter - the score counter.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }
    /**
     * This funcrion is called whenever the beingHit object is hit.
     * @param beingHit - the block to be hit.
     * @param hitter -  the Ball that's doing the hitting
     */
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        // remove this listener from the block.
        beingHit.removeHitListener(this);
        // increase 5 points to the score.
        this.currentScore.increase(5);
    }
}