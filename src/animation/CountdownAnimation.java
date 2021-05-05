// ID : 318574712
package animation;
import biuoop.DrawSurface;
import biuoop.Sleeper;
import sprites.SpriteCollection;
import java.awt.Color;
/**
 * the class describe animation of Count-down.
 * @author Sapir David <sapirdavid5220@gmail.com>
 * @version 1.0
 * @since 20-06-05
 */
// The CountdownAnimation will display the given gameScreen,
// for numOfSeconds seconds, and on top of them it will show
// a countdown from countFrom back to 1, where each number will
// appear on the screen for (numOfSeconds / countFrom) seconds, before
// it is replaced with the next one.
public class CountdownAnimation implements Animation {
    private double numOfSecond;
    private int countFrom;
    private SpriteCollection gameScreen;
    private int count;
    /**
     * constructor of count down animation.
     * @param numOfSeconds - the number of seconds.
     * @param countFrom - the count from him down to 1.
     * @param gameScreen - the game screen - include all the sprites of the game.
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.numOfSecond = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.count = countFrom;
    }
    /**
     * the function do one frame.
     * @param d -  the draw surface of the game.
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        Sleeper sleeper = new biuoop.Sleeper();
        this.gameScreen.drawAllOn(d);
        d.setColor(Color.magenta);
        d.drawText(80, d.getHeight() / 5, "the game will start in " + countFrom + " seconds", 40);
        //each number will appear on the screen for (numOfSeconds / countFrom) seconds.
        if (countFrom != count) {
            sleeper.sleepFor((long) ((numOfSecond / count) * 1000));
        }
        this.countFrom = this.countFrom - 1;
    }
    /**
     * this function inform the game should stop.
     * @return true- if the game should stop, false-otherwise.
     */
    @Override
    public boolean shouldStop() {
        // show the numbers on the screen until 0.
        if (this.countFrom != -1) {
            return false;
        }
        return true;
    }
}