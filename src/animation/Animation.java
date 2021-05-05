// ID : 318574712
package animation;
import biuoop.DrawSurface;
/**
 * the class describe interface of animation.
 * @author Sapir David <sapirdavid5220@gmail.com>
 * @version 1.0
 * @since 20-06-05
 */
public interface Animation {
    /**
     * the function do one frame.
     * @param d -  the draw surface of the game.
     */
    void doOneFrame(DrawSurface d);
    /**
     * this function inform the game should stop.
     * @return true- if the game should stop, false-otherwise.
     */
    boolean shouldStop();
}