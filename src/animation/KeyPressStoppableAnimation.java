// ID : 318574712
package animation;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
/**
 * the class describe animation of Key Press Stoppable Animation.
 * @author Sapir David <sapirdavid5220@gmail.com>
 * @version 1.0
 * @since 20-06-05
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor sensor;
    private String key;
    private Animation animation;
    private boolean isAlreadyPressed;
    private boolean stop;
    /**
     * constructor of Key Press Stoppable Animation.
     * @param sensor - the key board sensor.
     * @param key - the key that pressed.
     * @param animation - the animation of the game.
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.sensor = sensor;
        this.key = key;
        this.animation = animation;
        this.isAlreadyPressed = true;
        this.stop = false;
    }
    /**
     * the function do one frame.
     * @param d -  the draw surface of the game.
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        this.animation.doOneFrame(d);
        //if the key pressed, and not pressed before.
        if ((this.sensor.isPressed(key)) && !isAlreadyPressed) {
            this.stop = true;
        }
        // if the key not pressed.
        if (!(this.sensor.isPressed(key))) {
            this.isAlreadyPressed = false;
        }
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
