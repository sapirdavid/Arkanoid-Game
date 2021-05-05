// ID : 318574712
package animation;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;
/**
 * the class describe animation runner.
 * @author Sapir David <sapirdavid5220@gmail.com>
 * @version 1.0
 * @since 20-06-05
 */
public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;
    private Sleeper sleeper;
    //const numbers
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final int FRAME_PER_SECOND = 60;
    /**
     * constructor of animation runner.
     */
    public AnimationRunner() {
        this.gui = new GUI("Arkanoid", WIDTH, HEIGHT);
        this.framesPerSecond = FRAME_PER_SECOND;
        this.sleeper = new biuoop.Sleeper();
    }
    /**
     * the function return the gui of this animation.
     * @return gui - the gui of this animation.
     */
    public GUI getGui() {
        return this.gui;
    }
    /**
     * the function run the animation of the game.
     * @param animation - the animation of the game.
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / this.framesPerSecond;
        //while this animation should not stopped.
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();
            //do one frame of the animation.
            animation.doOneFrame(d);
            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}