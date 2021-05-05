// ID : 318574712
package animation;
import biuoop.DrawSurface;
import hit.Counter;
import java.awt.Color;
/**
 * the class represent a high score animation.
 * @author Sapir David <sapirdavid5220@gmail.com>
 * @version 1.0
 * @since 20-06-13
 */
public class HighScoreAnimation implements Animation {
    private Counter highScore;
    /**
     * constructor of high score animation.
     * @param highScore - the hig score.
     */
    public HighScoreAnimation(Counter highScore) {
        this.highScore = highScore;
    }
    /**
     * the function do one frame.
     * @param d -  the draw surface of the game.
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.blue);
        d.drawText(10, d.getHeight() / 5, "the high score is: " + this.highScore.getValue(), 32);
    }
    /**
     * this function inform the game should stop.
     * @return true- if the game should stop, false-otherwise.
     */
    @Override
    public boolean shouldStop() {
        return false;
    }
}
