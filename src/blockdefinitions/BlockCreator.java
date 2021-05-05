// ID : 318574712
package blockdefinitions;
import sprites.Block;
/**
 * the class represent a interface of Block Creator.
 * @author Sapir David <sapirdavid5220@gmail.com>
 * @version 1.0
 * @since 20-06-13
 */
public interface BlockCreator {
    /**
     * the function Create a block at the specified location.
     * @param xpos - x position of the block.
     * @param ypos - y position of the block.
     * @return block - with specified location.
     */
    Block create(int xpos, int ypos);
}