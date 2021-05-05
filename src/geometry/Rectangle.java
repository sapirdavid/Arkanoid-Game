// ID : 318574712
package geometry;
import java.util.ArrayList;
import java.util.List;
/**
 * the class represent a geometry.Rectangle.
 * @author Sapir David <sapirdavid5220@gmail.com>
 * @version 1.0
 * @since 20-04-23
 */
public class Rectangle {
    private Point upperLeft;
    private double width;
    private double height;
    /**
     * constructor rectangle from upper-left point(location),width and height.
     * @param upperLeft - the upper-Left point of the rectangle.
     * @param width - the width of the rectangle.
     * @param height  - the height of the rectangle.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }
    /**
     * constructor rectangle from upper-left (x,y) point(location),width and height.
     * @param upperLeftX - the X value of upper-Left point of the rectangle.
     * @param upperLeftY - the Y value of upper-Left point of the rectangle.
     * @param width - the width of the rectangle.
     * @param height  - the height of the rectangle.
     */
    public Rectangle(double upperLeftX, double upperLeftY, double width, double height) {
        this.upperLeft = new Point(upperLeftX, upperLeftY);
        this.width = width;
        this.height = height;
    }
    /**
     * the function find the intersection points between the rectangle and specified line.
     * @param line - line to check intersection.
     * @return list of intersection points (possibly empty).
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        //list of intersection points.
        List<Point> intersectionPointsList = new ArrayList<>();
        //the upper edge of the rectangle is line from the upper left point to the upper right point.
        Line upperEdge = new Line(this.getUpperLeft(), this.getUpperRight());
        //the lower edge of the rectangle is line from the lower left point to the lower right point.
        Line lowerEdge = new Line(this.getLowerLeft(), this.getLowerRight());
        //the right edge of the rectangle is line from the upper right point to the lower right point.
        Line rightEdge = new Line(this.getUpperRight(), this.getLowerRight());
        //the left edge of the rectangle is line from the upper left point to the lower left point.
        Line leftEdge = new Line(this.getUpperLeft(), this.getLowerLeft());
        //check if the upper edge is intersecting with the line.
        if (upperEdge.isIntersecting(line)) {
            intersectionPointsList.add(upperEdge.intersectionWith(line));
        }
        //check if the lower edge is intersecting with the line.
        if (lowerEdge.isIntersecting(line)) {
            intersectionPointsList.add(lowerEdge.intersectionWith(line));
        }
        //check if the right edge is intersecting with the line.
        if (rightEdge.isIntersecting(line)) {
            intersectionPointsList.add(rightEdge.intersectionWith(line));
        }
        //check if the left edge is intersecting with the line.
        if (leftEdge.isIntersecting(line)) {
            intersectionPointsList.add(leftEdge.intersectionWith(line));
        }
        return intersectionPointsList;
    }
    /**
     * the function return the width of the rectangle.
     * @return width.
     */
    public double getWidth() {
        return this.width;
    }
    /**
     * the function return the height of the rectangle.
     * @return height.
     */
    public double getHeight() {
        return this.height;
    }
    /**
     * the function return the upper-left point of the rectangle.
     * @return upper-left point.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }
    /**
     * the function set upper-left point to the rectangle.
     * @param point - upper left point to set.
     */
    public void setUpperLeft(Point point) {
        this.upperLeft = point;
    }
    /**
     * the function return the upper-right point of the rectangle.
     * @return upper-right point.
     */
    public Point getUpperRight() {
        return new Point((this.upperLeft.getX() + this.width), this.upperLeft.getY());
    }
    /**
     * the function return the lower-left point of the rectangle.
     * @return lower-left point.
     */
    public Point getLowerLeft() {
        return new Point(this.upperLeft.getX(), (this.upperLeft.getY() + this.height));
    }
    /**
     * the function return the lower-right point of the rectangle.
     * @return lower-right point.
     */
    public Point getLowerRight() {
        return new Point((this.upperLeft.getX() + this.width), (this.upperLeft.getY() + this.height));
    }
}