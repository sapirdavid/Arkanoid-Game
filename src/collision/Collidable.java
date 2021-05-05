// ID : 318574712
package collision;
import geometry.Point;
import geometry.Rectangle;
import hit.Velocity;
import sprites.Ball;
/**
 * the class represent a interface of Collid-able.
 * @author Sapir David <sapirdavid5220@gmail.com>
 * @version 1.0
 * @since 20-04-23
 */
public interface Collidable {
    /**
     * the function return the "collision shape" of the object.
     * @return rectangle.
     */
    Rectangle getCollisionRectangle();
    /**
     *the function find the velocity after the hit.
     * @param collisionPoint - the collision point.
     * @param currentVelocity - the current velocity of the object that we collided with it.
     * @param hitter - the Ball that's doing the hitting.
     * @return velocity - the new velocity expected after the hit.
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}