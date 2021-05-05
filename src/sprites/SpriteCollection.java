// ID : 318574712
package sprites;
import biuoop.DrawSurface;
import java.util.ArrayList;
import java.util.List;
/**
 * the class represent a sprites.Sprite Collection.
 * @author Sapir David <sapirdavid5220@gmail.com>
 * @version 1.0
 * @since 20-04-23
*/
public class SpriteCollection {
    private List<Sprite> spriteList;
    /**
     * constructor sprites.Sprite Collection.
     */
    public SpriteCollection() {
        this.spriteList = new ArrayList<Sprite>();
    }
    /**
     * the function add the given sprite to the environment.
     * @param s - sprite to add.
     */
    public void addSprite(Sprite s) {
        this.spriteList.add(s);
    }
    /**
     * the function remove sprite from the game.
     * @param s - sprite to remove.
     */
    public void removeSprite(Sprite s) {
        this.spriteList.remove(s);
    }
    /**
     * the function call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        List<Sprite> sprites = new ArrayList<Sprite>(this.spriteList);
        for (Sprite sp : sprites) {
            sp.timePassed();
        }
    }
    /**
     * the function call drawOn(d) on all sprites.
     * @param d - the Draw Surface.
     */
    public void drawAllOn(DrawSurface d) {
        int spriteAmount = this.spriteList.size();
        for (int i = 0; i < spriteAmount; i++) {
           this.spriteList.get(i).drawOn(d);
        }
    }
}
