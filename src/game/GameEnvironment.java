// ID : 318574712
package game;
import collision.Collidable;
import collision.CollisionInfo;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import java.util.ArrayList;
import java.util.List;
/**
 * the class represent a game environment.
 * @author Sapir David <sapirdavid5220@gmail.com>
 * @version 1.0
 * @since 20-04-23
 */
public class GameEnvironment {
    private List<Collidable> collidables;
    /**
     * constructor game.GameEnvironment from list of collidable.
     */
    public GameEnvironment() {
        this.collidables = new ArrayList<Collidable>();
    }
    /**
     * the function add the given collidable to the environment.
     * @param c - collidable.
     */
    public void addCollidable(Collidable c) {
        this.collidables.add(c);
   }
    /**
     * the function remove collidable from the game.
     * @param c - colliadble to remove.
     */
    public void removeCollidable(Collidable c) {
        this.collidables.remove(c);
    }
    /**
     * the function return the information about the closest collision that is going to occur.
     * @param trajectory - line to collision.
     * @return if this object will not collide with any of the collidables in this collection, return null.
     * Else, return the collision info.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        Point closestIntersectionPoint;
        Point mostClosestPoint = null;
        Collidable closetCollisionObject = null;
        double distance;
        double minDistance = Double.MAX_VALUE;
        List<Collidable> collidables1 = new ArrayList<Collidable>();
        collidables1.addAll(this.collidables);
        //go over the collidables in this game environment.
        for (Collidable collidable : collidables1) {
            Rectangle rect = collidable.getCollisionRectangle();
            //find the closest intersection point with the trajectory and this collidable.
           closestIntersectionPoint = trajectory.closestIntersectionToStartOfLine(rect);
           //if the closest intersection point with the trajectory with this collidable is not exist,
           //continue to the next collidable.
           if (closestIntersectionPoint == null) {
               continue;
           } else {
               //find the distance between the start of trajectory to the point.
               distance = trajectory.start().distance(closestIntersectionPoint);
               //check if the distance is less then the min distance until now.
               if (distance < minDistance) {
                   //save this point, this distance and this collidable object.
                   mostClosestPoint = new Point(closestIntersectionPoint.getX(), closestIntersectionPoint.getY());
                   minDistance = distance;
                   closetCollisionObject = collidable;
               }
           }
        }
        //if this object will not collide with any of the collidables in this collection.
        if (mostClosestPoint == null) {
            return null;
        }
        return new CollisionInfo(mostClosestPoint, closetCollisionObject);
    }
}