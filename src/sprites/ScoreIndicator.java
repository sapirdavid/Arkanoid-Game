// ID : 318574712
package sprites;
import biuoop.DrawSurface;
import game.GameLevel;
import geometry.Rectangle;
import hit.Counter;
import java.awt.Color;
/**
 * the class represent a Score Indicator.
 * @author Sapir David <sapirdavid5220@gmail.com>
 * @version 2.0
 * @since 20-05-23
 */
public class ScoreIndicator implements Sprite {
    private Rectangle rectangle;
    private java.awt.Color color;
    private Counter score;
    /**
     * the constructor of the score indicator.
     * @param rect - rectangle of the score indicator.
     * @param color - the color of the rectangle.
     * @param score - the current score.
     */
   public ScoreIndicator(Rectangle rect, java.awt.Color color, Counter score) {
       this.rectangle = rect;
       this.color = color;
       this.score = score;
   }
    /**
     * the function draw the Score Indicator to the screen.
     * @param d - the draw surface.
     */
    @Override
    public void drawOn(DrawSurface d) {
        //set the color of this block.
        d.setColor(this.color);
        //draw the block on the surface.
        d.fillRectangle((int) this.rectangle.getUpperLeft().getX(), (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());
        //frame to the block.
        d.setColor(Color.black);
        d.drawRectangle((int) this.rectangle.getUpperLeft().getX(), (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());
        d.drawText(375, 20, "Score: " + this.score.getValue(), 15);
    }
    /**
     * the function notify the sprite that time has passed.
     */
    @Override
    public void timePassed() {
        return;
    }
    /**
     * the function add this score indicator to the game.
     * @param g - game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
