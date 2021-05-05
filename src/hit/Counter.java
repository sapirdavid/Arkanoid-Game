// ID : 318574712
package hit;
/**
 * the class describe  a counter - for keeping count of the number of blocks that remain.
 * @author Sapir David <sapirdavid5220@gmail.com>
 * @version 1.0
 * @since 20-05-23
 */
public class Counter {
    private int count;
    /**
     * constructor of counter.
     */
    public Counter() {
        this.count = 0;
    }
    /**
     * the function add number to current count.
     * @param number - number be added to current count.
     */
    public void increase(int number) {
        this.count = this.count + number;
    }
    /**
     * the function subtract number from current count.
     * @param number - number be subtract from current count.
     */
    public void decrease(int number) {
        this.count = this.count - number;
    }
    /**
     * the function return the current count.
     * @return counter - cuurent count.
     */
    public int getValue() {
        return this.count;
    }
    /**
     * the function set count.
     * @return counte - count of this counter.
     */
    public void setValue(int count) {
        this.count = count;
    }
}