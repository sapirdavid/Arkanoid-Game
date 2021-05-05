// ID : 318574712
package collision;
import geometry.Point;
/**
 * the class represent a Collision info.
 * @author Sapir David <sapirdavid5220@gmail.com>
 * @version 1.0
 * @since 20-04-23
 */
public class CollisionInfo {
    private Point collisionPoint;
    private Collidable collisionObject;
    /**
     * constructor collision.CollisionInfo from collision point and collision object.
     * @param collisionPoint - the point at which the collision occurs.
     * @param collisionObject - the collidable object involved in the collision.
     */
    public CollisionInfo(Point collisionPoint, Collidable collisionObject) {
       this.collisionObject = collisionObject;
       this.collisionPoint = collisionPoint;
    }
    /**
     * the function return the point at which the collision occurs.
     * @return collision point.
     */
    public Point collisionPoint() {
        return this.collisionPoint;
    }
    /**
     * the function return the collidable object involved in the collision.
     * @return collision object
     */
    public Collidable collisionObject() {
        return this.collisionObject;
    }
}
