// ID : 318574712
package blockdefinitions;
import sprites.Block;
import java.util.Map;
/**
 * the class represent a Blocks From Symbols Factory.
 * @author Sapir David <sapirdavid5220@gmail.com>
 * @version 1.0
 * @since 20-06-13
 */
public class BlocksFromSymbolsFactory {
    private Map<String, Integer> spacerWidths;
    private Map<String, BlockCreator> blockCreators;
    /**
     * constructor of  Blocks From Symbols Factory.
     * @param spacerWidths - the spacer width.
     * @param blockCreators - the block creators.
     */
    public BlocksFromSymbolsFactory (Map<String, Integer> spacerWidths, Map<String, BlockCreator> blockCreators) {
        this.blockCreators = blockCreators;
        this.spacerWidths = spacerWidths;
    }
    /**
     * the function returns true if 's' is a valid space symbol.
     * @param s - string.
     * @return true - if 's' is a valid space symbol, false - otherwise.
     */
    public boolean isSpaceSymbol(String s) {
        return false;
    }
    /**
     * the function returns true if 's' is a valid block symbol.
     * @param s - string.
     * @return true - if 's' is a valid block symbol, false - otherwise.
     */
    // returns true if 's' is a valid block symbol.
    public boolean isBlockSymbol(String s) {
        return false;
    }
    /**
     * the function returns the width in pixels associated with the given spacer-symbol.
     * @param s - string.
     * @return width in pixels associated with the given spacer-symbol.
     */
    public int getSpaceWidth(String s) {
        return this.spacerWidths.get(s);
    }
    /**
     * the function Return a block according to the definitions associatedwith symbol s.
     * The block will be located at position (x, y).
     * @param s - string.
     * @param x - x position.
     * @param y - y position.
     * @return block.
     */
    public Block getBlock(String s, int x, int y) {
        return this.blockCreators.get(s).create(x, y);
    }
}
