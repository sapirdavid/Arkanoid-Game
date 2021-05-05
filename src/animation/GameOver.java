// ID : 318574712
package animation;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import hit.Counter;
/**
 * the class describe animation of end - EndScreen.
 * @author Sapir David <sapirdavid5220@gmail.com>
 * @version 1.0
 * @since 20-06-05
 */
public class GameOver implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    private Counter score;
    private AnimationRunner animationRunner;
    /**
     * constructor of end screen.
     * @param k - key board sensor.
     * @param score - the score of the player in the game.
     * @param animationRunner - the current animation runner.
     */
    public GameOver(KeyboardSensor k, Counter score, AnimationRunner animationRunner) {
        this.keyboard = k;
        this.stop = false;
        this.score = score;
        this.animationRunner = animationRunner;
    }
    /**
     * the function do one frame.
     * @param d -  the draw surface of the game.
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "Game Over. Your score is " + this.score.getValue(), 32);
    }
    /**
     * this function inform the game should stop.
     * @return true- if the game should stop, false-otherwise.
     */
    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
