// ID : 318574712
package sprites;
import biuoop.DrawSurface;
/**
 * the class describe a sprite interface.
 * @author Sapir David <sapirdavid5220@gmail.com>
 * @version 1.0
 * @since 20-04-23
 */
public interface Sprite {
    /**
     * the function draw the sprite to the screen.
     * @param d - the draw surface.
     */
    void drawOn(DrawSurface d);
    /**
     * the function notify the sprite that time has passed.
     */
    void timePassed();
}
