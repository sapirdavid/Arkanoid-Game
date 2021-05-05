import animation.*;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import geometry.Point;
import geometry.Rectangle;
import hit.Counter;
import sprites.BackGround;
import tasks.ShowHiScoresTask;
import tasks.Task;

import java.awt.Color;

public class Test {
        public static void main(String[] args) {
            BackGround backGround = new BackGround(new Rectangle(new Point(0, 0), 800, 600),
                    Color.magenta, 0);
            AnimationRunner runner = new AnimationRunner();
            KeyboardSensor keyboardSensor = runner.getGui().getKeyboardSensor();
            HighScoreAnimation score = new HighScoreAnimation(new Counter());
            //Menu<Task<Void>> menu = new MenuAnimation("opening Menu", backGround, keyboardSensor);
            Menu<Task<Void>> menu = new MenuAnimation<Task<Void>>("opening menu", backGround, keyboardSensor);
            menu.addSelection("h", "Hi score", new ShowHiScoresTask(runner, score));
// the parameters to addSelection are:
// key to wait for, line to print, what to return
            //menu.addSelection("s", "start a new game", "option a");
            //menu.addSelection("h", "see the highest score", "option b");
            //menu.addSelection("q", "quit", "option c");
            while (true) {
                runner.run(menu);
                if (keyboardSensor.isPressed("h")) {
                    Task<Void> task = new ShowHiScoresTask(runner, score);
                    //Task<Void> task = menu.getStatus();
                    task.run();
                }
            }



    }
}
