// ID : 318574712
package tasks;
import animation.Animation;
import animation.AnimationRunner;
/**
 * the class represent a show high scores task.
 * @author Sapir David <sapirdavid5220@gmail.com>
 * @version 1.0
 * @since 20-06-13
 */
public class ShowHiScoresTask implements Task<Void> {
    private AnimationRunner runner;
    private Animation highScoresAnimation;

    /**
     * constructor of show high scores task.
     * @param runner - the animation runner.
     * @param highScoresAnimation - the animation of high scores.
     */
    public ShowHiScoresTask(AnimationRunner runner, Animation highScoresAnimation) {
        this.runner = runner;
        this.highScoresAnimation = highScoresAnimation;
    }
    /**
     * the function run this task.
     * @return - null.
     */
    public Void run() {
        this.runner.run(this.highScoresAnimation);
        return null;
    }
}
