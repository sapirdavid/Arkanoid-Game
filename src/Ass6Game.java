// ID : 318574712
import animation.AnimationRunner;
import biuoop.KeyboardSensor;
import game.GameFlow;
import levels.LevelInformation;
import levels.WideEasy;
import levels.DirectHit;
import levels.FinalFour;
import levels.Green3;
import java.util.ArrayList;
import java.util.List;
/**
 * the class initialize and run a real game.
 * @author Sapir David <sapirdavid5220@gmail.com>
 * @version 1.0
 * @since 20-06-05
 */
public class Ass6Game {
    /**
     * the function initialize the game and run it.
     *
     * @param args - command line arguments - if exist - represent the levels in this game.
     */
    public static void main(String[] args) {
        AnimationRunner animationRunner = new AnimationRunner();
        KeyboardSensor keyboardSensor = animationRunner.getGui().getKeyboardSensor();
        GameFlow gameLevel = new GameFlow(animationRunner, keyboardSensor);
        List<LevelInformation> levels = new ArrayList<LevelInformation>();
        // run the levels according to the arguments.
        //if argument is different from the numbers - 1,2,3,4 ,not do anything.
        if (args.length != 0) {
            int num = args.length;
            for (int i = 0; i < num; i++) {
                if (args[i].equals("1")) {
                    LevelInformation level1 = new DirectHit();
                    levels.add(level1);
                }
                if (args[i].equals("2")) {
                    LevelInformation level2 = new WideEasy();
                    levels.add(level2);
                }
                if (args[i].equals("3")) {
                    LevelInformation level3 = new Green3();
                    levels.add(level3);
                }
                if (args[i].equals("4")) {
                    LevelInformation level4 = new FinalFour();
                    levels.add(level4);
                }
            }
        }
        // When run without arguments, start a game with four levels that run one after the other.
        if (levels.isEmpty()) {
            LevelInformation level1 = new DirectHit();
            LevelInformation level2 = new WideEasy();
            LevelInformation level3 = new Green3();
            LevelInformation level4 = new FinalFour();
            levels.add(level1);
            levels.add(level2);
            levels.add(level3);
            levels.add(level4);
        }
        //gameLevel.runLevels(levels);
        gameLevel.runMenu(levels);
    }
}


