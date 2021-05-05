// ID : 318574712
package selection;
/**
 * the class represent a selection.
 * @author Sapir David <sapirdavid5220@gmail.com>
 * @version 1.0
 * @since 20-06-13
 */
public class Selection {
    private String key;
    private String message;
    private Object returnVal;
    /**
     * constructor of selection.
     * @param key       - the key to wait for.
     * @param message   - line to print.
     * @param returnVal - what to return.
     */
    public Selection(String key, String message, Object returnVal) {
        this.key = key;
        this.message = message;
        this.returnVal = returnVal;
    }
    /**
     * the function return the key of this selection.
     * @return key - the key to wait for.
     */
    public String getKey() {
        return this.key;
    }
    /**
     * the function return the message of this selection.
     * @return message - line to print.
     */
    public String getMessage() {
        return this.message;
    }
    /**
     * the function return the return value of this selection.
     * @return returnVal -what to return.
     */
    public Object getreturnVal() {
        return this.returnVal;
    }
}
