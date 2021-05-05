// ID : 318574712
package hit;
import listeners.HitListener;
/**
 * the class describe a interface of hit-notifier.
 * @author Sapir David <sapirdavid5220@gmail.com>
 * @version 1.0
 * @since 20-05-23
 */
public interface HitNotifier {
    /**
     * the function Add hl as a listener to hit events.
     * @param hl - hit listener to be added.
     */
    void addHitListener(HitListener hl);
    /**
     * the function remove hl from the list of listeners to hit events.
     * @param hl - hit listener to be removed.
     */
    void removeHitListener(HitListener hl);
}