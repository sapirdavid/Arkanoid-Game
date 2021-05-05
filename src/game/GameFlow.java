// ID : 318574712
package game;
import animation.AnimationRunner;
import animation.HighScoreAnimation;
import animation.Menu;
import animation.KeyPressStoppableAnimation;
import animation.YouWin;
import animation.GameOver;
import animation.MenuAnimation;
import animation.Animation;
import biuoop.KeyboardSensor;
import geometry.Point;
import geometry.Rectangle;
import hit.Counter;
import levels.LevelInformation;
import sprites.BackGround;
import tasks.ShowHiScoresTask;
import tasks.Task;
import java.awt.Color;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.io.File;
/**
 * the class represent a Game Flow.
 * @author Sapir David <sapirdavid5220@gmail.com>
 * @version 1.0
 * @since 20-06-05
 */
public class GameFlow {
    private AnimationRunner animationRunner;
    private KeyboardSensor keyboardSensor;
    private Counter score;
    private Counter highScore;
    /**
     * constructor of game flow.
     * @param ar - the animation Runner.
     * @param ks - the keyboard Sensors.
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks) {
        this.animationRunner = ar;
        this.keyboardSensor = ks;
        this.score = new Counter();
        this.highScore = new Counter();
    }
    /**
     * the function save the high score to a file.
     */
    public void saveScore() {
        try {
            File highScoresFile = new File("highscores.txt");
            // check if file with previous score is already exist.
            if (highScoresFile.exists()) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(highScoresFile));
                String scoreLine = bufferedReader.readLine();
                bufferedReader.close();
                // check if the line on this file is exist.
                if (scoreLine != null) {
                    // find the previous high score.
                    int highPrevScore = Integer.parseInt(scoreLine.split(": ")[1]);
                    this.highScore.setValue(highPrevScore);
                    //compare the new score with the highest score stored in the file and
                    // update the file only if you reach a highest score
                    if (highPrevScore < this.score.getValue()) {
                        highScoresFile.delete();
                        File highScoresNewFile = new File("highscores.txt");
                        FileWriter highScores = new FileWriter(highScoresNewFile);
                        highScores.write("The highest score so far is: " + this.score.getValue());
                        this.highScore = this.score;
                        System.out.println("Successfully update the file.");
                        highScores.close();
                    }
                }
                //the first time run the game, create the file with the current score.
            } else {
                File highScoresNewFile = new File("highscores.txt");
                FileWriter highScores = new FileWriter(highScoresNewFile);
                highScores.write("The highest score so far is: " + this.score.getValue());
                this.highScore = this.score;
                System.out.println("Successfully wrote to the file.");
                highScores.close();
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    /**
     * the function run the menu of the game.
     * @param levels - the levels in the game.
     */
    public void runMenu(List<LevelInformation> levels) {
        BackGround backGroundMenu = new BackGround(new Rectangle(new Point(0, 0), 800, 600),
                Color.magenta, 0);
        // create a new menu for this game.
        Menu<Task<Void>> menu = new MenuAnimation<Task<Void>>("opening menu", backGroundMenu, keyboardSensor);
        Animation highScoreAnimation = new KeyPressStoppableAnimation(keyboardSensor, keyboardSensor.SPACE_KEY,
                new HighScoreAnimation(this.highScore));
        Task<Void> highScoreTask = new ShowHiScoresTask(animationRunner, highScoreAnimation);
        //add selections to the menu.
        menu.addSelection("h", "see the highest score", highScoreTask);
        menu.addSelection("s", "start a new game", new Task<Void>() {
            @Override
            public Void run() {
                // run the levels of the game.
                runLevels(levels);
                // after loosing or winning if the user press "h"' move to the high score task.
                highScoreTask.run();
                return null;
            }
        });
        menu.addSelection("q", "quit", new Task<Void>() {
            @Override
            public Void run() {
                // if the user press s, close this game.
                animationRunner.getGui().close();
                return null;
            }
        });
        // run the menu.
        animationRunner.run(menu);
        // check and run the task that chose.
        Task<Void> task = menu.getStatus();
        task.run();
        runMenu(levels);
    }
    /**
     * the function run the levels in the game.
     * @param levels - the levels in the game.
     */
    public void runLevels(List<LevelInformation> levels) {
        this.score = new Counter();
        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(levelInfo, keyboardSensor,
                    this.animationRunner, score);
            level.initialize();
            // if level has more blocks and balls run the level.
            //while (level.getblockCount() > 0 && level.getballCount() > 0) {
                level.run();
            //}
            // if there is no more balls, the game is over.
            if (level.getballCount() == 0) {
                GameOver gameOver = new GameOver(this.keyboardSensor, this.score, this.animationRunner);
                this.animationRunner.run(new KeyPressStoppableAnimation(this.keyboardSensor,
                        keyboardSensor.SPACE_KEY, gameOver));
                //if the game is over and the user press space, close the gui.
                this.saveScore();
                //this.animationRunner.getGui().close();
                //this.runMenu(levels);
                return;
            }
        }
        YouWin youWin = new YouWin(this.keyboardSensor, this.score, this.animationRunner);
        this.animationRunner.run(new KeyPressStoppableAnimation(this.keyboardSensor,
                keyboardSensor.SPACE_KEY, youWin));
        this.saveScore();
        //if the game is over and the user press space, close the gui.
        //this.animationRunner.getGui().close();
        //this.runMenu(levels);
        return;
    }
}

