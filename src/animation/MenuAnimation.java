// ID : 318574712
package animation;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import selection.Selection;
import sprites.BackGround;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * the class represent a menu animation.
 * @author Sapir David <sapirdavid5220@gmail.com>
 * @version 1.0
 * @since 20-06-13
 */
public class MenuAnimation<T> implements Menu {
    private String menuTitle;
    private BackGround backGround;
    private List<Selection> selectionList;
    private KeyboardSensor keyboard;
    private boolean stop;
    private Object status;
    /**
     * constructor of menu animation.
     * @param menuTitle - the title of the menu.
     * @param backGround - the background of the menu.
     * @param k - key board sensor.
     */
    public MenuAnimation(String menuTitle, BackGround backGround, KeyboardSensor k) {
        this.menuTitle = menuTitle;
        this.backGround = backGround;
        this.selectionList = new ArrayList<Selection>();
        this.keyboard = k;
        this.stop = false;
    }
    /**
     * the function add a selection to the menu.
     * @param key       - the key to wait for.
     * @param message   - line to print.
     * @param returnVal - what to return.
     */
    @Override
    public void addSelection(String key, String message, Object returnVal) {
        Selection selection = new Selection(key, message, returnVal);
        selectionList.add(selection);
    }
    /**
     * the function return the status of this menu.
     * @return status - of this menu.
     */
    @Override
    public Object getStatus() {
        return this.status;
    }
    /**
     * the function do one frame.
     * @param d -  the draw surface of the game.
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        this.backGround.drawOnMenu(d);
        d.setColor(Color.white);
        d.drawText(10, d.getHeight() / 5, this.menuTitle, 32);
        int selectionCount = this.selectionList.size();
        for (int i = 0; i < selectionCount; i++) {
            Selection selection = selectionList.get(i);
            d.drawText(10, d.getHeight() / 2 + i * 40, "press " + selection.getKey()
                    +  " to " + selection.getMessage(), 32);
        }
        for (int i = 0; i < selectionCount; i++) {
            Selection selection = selectionList.get(i);
            if (this.keyboard.isPressed(selection.getKey())) {
                this.status = selection.getreturnVal();
                this.stop = true;
            }
        }
    }
    /**
     * this function inform the game should stop.
     * @return true- if the game should stop, false-otherwise.
     */
    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
