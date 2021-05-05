// ID : 318574712
package animation;
/**
 * the class represent a interface of menu.
 * @author Sapir David <sapirdavid5220@gmail.com>
 * @version 1.0
 * @since 20-06-13
 */
/**
 * interface of menu.
 * @param <T> - the type of the object in the menu.
 */
public interface Menu<T> extends Animation {
    /**
     * the function add a selection to the menu.
     * @param key - the key to wait for.
     * @param message - line to print.
     * @param returnVal - what to return.
     */
    void addSelection(String key, String message, T returnVal);
    /**
     * the function return the status of this menu.
     * @return status - of this menu.
     */
    T getStatus();
}
