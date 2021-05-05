// ID : 318574712
package hit;
import geometry.Point;
/**
 * the class describe velocity - an entity that has speed and direction.
 * @author Sapir David <sapirdavid5220@gmail.com>
 * @version 2.0
 * @since 20-04-23
 */
// hit.Velocity specifies the change in position on the `x` and the `y` axes.
public class Velocity {
    private double dx;
    private double dy;
    /**
     * constructor of velocity.
     * @param dx is the change in position on the `x` axis.
     * @param dy is the change in position on the `y` axis.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }
    /**
     * the function Take a point with position (x,y) and return a new point with position (x+dx, y+dy).
     * @param p is the point we get.
     * @return new point with new position (x+dx, y+dy)
     */
    public Point applyToPoint(Point p) {
        return new Point(this.dx + p.getX(), this.dy + p.getY());
    }
    /**
     * the function create velocity from angle and speed.
     * @param angle .
     * @param speed .
     * @return velocity.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = speed * Math.sin(Math.toRadians(angle));
        double dy = -speed * Math.cos(Math.toRadians(angle));
        return new Velocity(dx, dy);
    }
    /**
     * this function return the dx value of this velocity.
     * @return dx .
     */
    public double getDx() {
        return this.dx;
    }
    /**
     * this function return the dy value of this velocity.
     * @return dy.
     */
    public double getDy() {
        return this.dy;
    }
    /**
     * this function return the speed of this velocity.
     * @return speed - the speed from the velocity.
     */
    public double fromVelocityToSpeed() {
        return Math.sqrt(Math.pow(this.getDx(), 2) + Math.pow(this.getDy(), 2));
    }
}
