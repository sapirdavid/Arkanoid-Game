// ID : 318574712
package sprites;
import biuoop.DrawSurface;
import collision.Collidable;
import game.GameLevel;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import listeners.HitListener;
import hit.HitNotifier;
import hit.Velocity;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * the class represent a sprites.Block- rectangle with color.
 * @author Sapir David <sapirdavid5220@gmail.com>
 * @version 1.0
 * @since 20-04-23
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle rectangle;
    private java.awt.Color color;
    private List<HitListener> hitListeners;
    /**
     * constructor block from rectangle and color.
     * @param rect - rectangle that represent this block.
     * @param color - the color of the block.
     * @param hitListeners - list of hit listeners.
     */
    public Block(Rectangle rect, java.awt.Color color, List<HitListener> hitListeners) {
        this.rectangle = rect;
        this.color = color;
        this.hitListeners = hitListeners;
    }
    /**
     * constructor block from upper-Left point, width, height, and color.
     * @param upperLeft - the upper left point of rectangle.
     * @param width - the width of rectangle.
     * @param height - the height of rectangle.
     * @param color - the color of the block.
     * @param hitListeners - list of hit listeners.
     */
    public Block(Point upperLeft, double width, double height, java.awt.Color color, List<HitListener> hitListeners) {
        this.rectangle = new Rectangle(upperLeft, width, height);
        this.color = color;
        this.hitListeners = hitListeners;
    }
    /**
     * the function return the "collision shape" of the object.
     * @return rectangle - the shape of block.
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }
    /**
     * the function notify the object that we collided with it at collisionPoint with a given velocity.
     * @param hitter - the ball that hit.
     * @param collisionPoint - the collision point of the block with the ball.
     * @param currentVelocity - the current velocity of the collided object.
     * @return velocity - the new velocity expected after the hit
     * (based on the force the object inflicted on us).
     */
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        Velocity newVelocity;
        //the upper edge of the block is line from the upper left point to the upper right point.
        Line upperEdge = new Line(this.rectangle.getUpperLeft(), this.rectangle.getUpperRight());
        //the lower edge of the block is line from the lower left point to the lower right point.
        Line lowerEdge = new Line(this.rectangle.getLowerLeft(), this.rectangle.getLowerRight());
        //the right edge of the block is line from the upper right point to the lower right point.
        Line rightEdge = new Line(this.rectangle.getUpperRight(), this.rectangle.getLowerRight());
        //the left edge of the block is line from the upper left point to the lower left point.
        Line leftEdge = new Line(this.rectangle.getUpperLeft(), this.rectangle.getLowerLeft());
        // notifiers all of the registered HitListener objects about this hit.
        this.notifyHit(hitter);
        //if the collision is in the corner of block.
        if (((upperEdge.pointOnLine(collisionPoint)) || (lowerEdge.pointOnLine(collisionPoint)))
                && ((rightEdge.pointOnLine(collisionPoint)) || (leftEdge.pointOnLine(collisionPoint)))) {
            return cornerHit(collisionPoint, currentVelocity, upperEdge, lowerEdge, rightEdge, leftEdge);
        }
        //if the collision is in lower or upper edge of the block- change the horizontal direction.
        if (((upperEdge.pointOnLine(collisionPoint))) || ((lowerEdge.pointOnLine(collisionPoint)))) {
                newVelocity = new Velocity(currentVelocity.getDx(), -currentVelocity.getDy());
                return newVelocity;
        }
        //if the collision is in left or right edge of the block- change the vertical direction
        if ((leftEdge.pointOnLine(collisionPoint)) || (rightEdge.pointOnLine(collisionPoint))) {
            newVelocity = new Velocity(-currentVelocity.getDx(), currentVelocity.getDy());
            return newVelocity;
        }
        return currentVelocity;
    }
    /**
     * the function return the velocity after hit in corner.
     * @param collisionPoint - the collision point of the block with the ball.
     * @param currentVelocity - the current velocity of the collided object.
     * @param upperEdge - the upper edge of the block.
     * @param lowerEdge - the lower edge of the block.
     * @param rightEdge - the right edge of the block.
     * @param leftEdge - the left edge of the block.
     * @return velocity - the new velocity expected after the hit.
     */
    public Velocity cornerHit(Point collisionPoint, Velocity currentVelocity,
                              Line upperEdge, Line lowerEdge, Line rightEdge, Line leftEdge) {
        Velocity newVelocity = currentVelocity;
        // if the hit is in the upper-left corner.
        if ((upperEdge.pointOnLine(collisionPoint) && (leftEdge.pointOnLine(collisionPoint)))) {
            if ((currentVelocity.getDx() > 0 && currentVelocity.getDy() > 0)
                    ||  (currentVelocity.getDx() < 0 && currentVelocity.getDy() < 0)) {
                newVelocity = new Velocity((-currentVelocity.getDx()), (-currentVelocity.getDy()));
            }
            if (currentVelocity.getDx() > 0 && currentVelocity.getDy() < 0) {
                newVelocity = new Velocity((-currentVelocity.getDx()), (currentVelocity.getDy()));
            }
            if (currentVelocity.getDx() < 0 && currentVelocity.getDy() > 0) {
                newVelocity = new Velocity((currentVelocity.getDx()), (-currentVelocity.getDy()));
            }
            return newVelocity;
        }
        // if the hit is in the upper-right corner.
        if ((upperEdge.pointOnLine(collisionPoint) && (rightEdge.pointOnLine(collisionPoint)))) {
            if (currentVelocity.getDx() > 0 && currentVelocity.getDy() > 0) {
                newVelocity = new Velocity((currentVelocity.getDx()), (-currentVelocity.getDy()));
            }
            if (currentVelocity.getDx() < 0 && currentVelocity.getDy() < 0) {
                newVelocity = new Velocity((-currentVelocity.getDx()), (currentVelocity.getDy()));
            }
            if ((currentVelocity.getDx() < 0 && currentVelocity.getDy() > 0)
                    || (currentVelocity.getDx() > 0 && currentVelocity.getDy() < 0)) {
                newVelocity = new Velocity((-currentVelocity.getDx()), (-currentVelocity.getDy()));
            }
            return newVelocity;
        }
        // if the hit is in the lower-left corner.
        if ((lowerEdge.pointOnLine(collisionPoint) && (leftEdge.pointOnLine(collisionPoint)))) {
            if (currentVelocity.getDx() > 0 && currentVelocity.getDy() > 0) {
                newVelocity = new Velocity((-currentVelocity.getDx()), (currentVelocity.getDy()));
            }
            if (currentVelocity.getDx() < 0 && currentVelocity.getDy() < 0) {
                newVelocity = new Velocity((currentVelocity.getDx()), (-currentVelocity.getDy()));
            }
            if ((currentVelocity.getDx() < 0 && currentVelocity.getDy() > 0)
                    || (currentVelocity.getDx() > 0 && currentVelocity.getDy() < 0)) {
                newVelocity = new Velocity((-currentVelocity.getDx()), (-currentVelocity.getDy()));
            }
            return newVelocity;
        }
        // if the hit is in the upper-right corner.
            if ((lowerEdge.pointOnLine(collisionPoint) && (rightEdge.pointOnLine(collisionPoint)))) {
                if (currentVelocity.getDx() > 0 && currentVelocity.getDy() < 0) {
                    newVelocity = new Velocity((currentVelocity.getDx()), (-currentVelocity.getDy()));
                }
                if (currentVelocity.getDx() < 0 && currentVelocity.getDy() > 0) {
                    newVelocity = new Velocity((-currentVelocity.getDx()), (currentVelocity.getDy()));
                }
                if ((currentVelocity.getDx() > 0 && currentVelocity.getDy() > 0)
                        ||  (currentVelocity.getDx() < 0 && currentVelocity.getDy() < 0)) {
                    newVelocity = new Velocity((-currentVelocity.getDx()), (-currentVelocity.getDy()));
                }
                return newVelocity;
        }
           return newVelocity;
    }
    /**
     * the function draw the block on the given DrawSurface.
     * @param surface to draw on him.
     */
    public void drawOn(DrawSurface surface) {
        //set the color of this block.
        surface.setColor(this.color);
        //draw the block on the surface.
        surface.fillRectangle((int) this.rectangle.getUpperLeft().getX(), (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());
        //frame to the block.
        surface.setColor(Color.black);
        surface.drawRectangle((int) this.rectangle.getUpperLeft().getX(), (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());
    }
    /**
     * the function notify the sprite that time has passed.
     * currently we do nothing.
     */
    @Override
    public void timePassed() {
        return;
    }
    /**
     * the function add this block to the game.
     * @param g - game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
    /**
     * the function remove block from the game.
     * @param gameLevel - the game.
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeCollidable(this);
        gameLevel.removeSprite(this);
    }
    /**
     * the function notify about hit.
     * @param hitter - the Ball that's doing the hitting.
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
    /**
     * the function Add hl as a listener to hit events.
     * @param hl - hit listener to be added.
     */
    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }
    /**
     * the function remove hl from the list of listeners to hit events.
     * @param hl - hit listener to be removed.
     */
    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }
}
