// ID : 318574712
package sprites;
import biuoop.DrawSurface;
import game.GameLevel;
import java.awt.Color;
/**
 * the class represent a Level Name Indicator.
 * @author Sapir David <sapirdavid5220@gmail.com>
 * @version 1.0
 * @since 20-05-23
 */
public class LevelNameIndicator implements Sprite {
    private java.awt.Color color;
    private String levelName;
    /**
     * the constructor of the level name indicator.
     * @param levelName - the name of the level.
     */
    public LevelNameIndicator(String levelName) {
        this.color = Color.black;
        this.levelName = levelName;
    }
    /**
     * the function draw the level name Indicator to the screen.
     * @param d - the draw surface.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.drawText(500, 20, "Level Name: " + this.levelName, 15);
    }
    /**
     * the function notify the sprite that time has passed.
     */
    @Override
    public void timePassed() {
        return;
    }
    /**
     * the function add this level name indicator to the game.
     * @param g - game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
