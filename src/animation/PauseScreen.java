// ID : 318574712
package animation;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
/**
 * the class describe animation of break - PauseScreen.
 * @author Sapir David <sapirdavid5220@gmail.com>
 * @version 1.0
 * @since 20-06-05
 */
public class PauseScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    /**
     * constructor of pause screen.
     * @param k - key board sensor.
     */
    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;
    }
    /**
     * the function do one frame.
     * @param d -  the draw surface of the game.
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
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