// ID : 318574712
package geometry;
import java.util.List;
/**
 * the class represent line-segment that connects two points.
 * @author Sapir David <sapirdavid5220@gmail.com>
 * @version 2.0
 * @since 20-04-23
 */
public class Line {
    private Point start;
    private Point end;
    /**
     * constructor of line-from two points -start and end.
     * @param start - of line.
     * @param end   - of line.
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }
    /**
     * constructor of line-from four values- x,y of start point, x,y- of end point.
     * @param x1 is the x value of start point.
     * @param y1 is the y value of start point.
     * @param x2 is the x value of end point.
     * @param y2 is the y value of end point.
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }
    /**
     * the function return the length of the line.
     * @return length.
     */
    public double length() {
        //the length of line is the distance from the start point to the end point.
        return this.start.distance(this.end);
    }
    /**
     * the function return the middle point of the line.
     * @return middle point.
     */
    public Point middle() {
        //the middle point - xMiddle is the average of the xStart and xEnd,
        //yMiddle is the average of the yStart and yEnd.
        Point middle = new Point((this.start.getX() + this.end.getX()) / 2,
                (this.start.getY() + this.end.getY()) / 2);
        return middle;
    }
    /**
     * the function return the start point of the line.
     * @return start point.
     */
    public Point start() {
        return this.start;
    }
    /**
     * the function return the end point of the line.
     * @return end point.
     */
    public Point end() {
        return this.end;
    }
    /**
     * the function checks if lines intersect.
     * @param other - geometry.Line for comparison..
     * @return true if the lines intersect, false otherwise.
     */
    public boolean isIntersecting(Line other) {
        //check if to the lines have intersection point.
        Point intersect = this.intersectionWith(other);
        //if there is no intersection point - the lines are not intersect.
        if (intersect == null) {
            return false;
        }
        //check if the intersection point is on the segment of both of the lines, if yes-the lines intersect.
        if (onSegment(intersect, this.start, this.end)
                && (onSegment(intersect, other.start, other.end))) {
            return true;
        }
        //the intersection point is not on the segment of both of the lines -the lines are not intersect.
        return false;
    }
    /**
     * the function checks if point lies on line segment 'start-end'.
     * @param point - is the point to be check.
     * @param start - is the start point of the line.
     * @param end   - is the end point of the line.
     * @return true if point intersect lies on line segment 'start-end', false otherwise.
     */
    static boolean onSegment(Point point, Point start, Point end) {
        //check if the intersection point is in the range between start and end.
        double epsilon = Math.pow(10, -10);
        //if this line is vertical to X axis.
        if (start.getX() == end.getX()) {
            if (((Math.abs(point.getX() - start.getX())) < epsilon)
                    && (point.getY() <= Math.max(start.getY(), end.getY())
                    && point.getY() >= Math.min(start.getY(), end.getY()))) {
                return true;
            }
        }
        //if this line is vertical to Y axis.
        if (start.getY() == end.getY()) {
            if (((Math.abs(point.getY() - start.getY())) < epsilon)
                    && (point.getX() <= Math.max(start.getX(), end.getX())
                    && point.getX() >= Math.min(start.getX(), end.getX()))) {
                return true;
            }
        }
        //if this line with slope.
        if  (point.getX() - epsilon <= Math.max(start.getX(), end.getX())
                && point.getX() + epsilon >= Math.min(start.getX(), end.getX())
                &&  point.getY() - epsilon <= Math.max(start.getY(), end.getY())
                && point.getY() + epsilon >= Math.min(start.getY(), end.getY())) {
            return true;
        }
        return false;
    }
    /**
     * the function find the intersection point between lines-when both of them are vertical to the X axis.
     * @param other line.
     * @return the intersection point if the lines intersect and null otherwise.
     */
    public Point intersectionWithVerticalX(Line other) {
        //if the value of y of the start of the lines is the same.
        if (this.start.getY() == other.start.getY()) {
            //check if the end point of one of the line is on the other line-in this cases the lines come together.
            if ((onSegment(this.end, other.start, other.end)
                    || onSegment(other.end, this.start, this.end))) {
                return null;
            }
            return new Point(this.start.getX(), this.start.getY());
        }
        //if the value of y of the end of the lines is the same.
        if (this.end.getX() == other.end.getY()) {
            //check if the start point of one of the line is on the other line-in this cases the lines come together.
            if ((onSegment(this.start, other.start, other.end)
                    || onSegment(other.start, this.start, this.end))) {
                return null;
            }
            return new Point(this.end.getX(), this.end.getY());
        }
        //if the value of y of the start of this line and of the end of the other line is the same.
        if (this.start.getY() == other.end.getY()) {
            //check if the end point of this line is on the other line or
            // the start point of other line is on this line-in this cases the lines come together.
            if ((onSegment(this.end, other.start, other.end)
                    || onSegment(other.start, this.start, this.end))) {
                return null;
            }
            return new Point(this.start.getX(), this.start.getY());
        }
        //if the value of y of the end of this line and of the start of the other line is the same.
        if (this.end.getY() == other.start.getY()) {
            //check if the start point of this line is on the other line or
            // the end point of other line is on this line-in this cases the lines come together.
            if ((onSegment(this.start, other.start, other.end)
                    || onSegment(other.end, this.start, this.end))) {
                return null;
            }
            return new Point(this.end.getX(), this.end.getY());
        }
        return null;
    }
    /**
     * the function find the intersection point between lines-when both of them are vertical to the Y axis.
     * @param other line.
     * @return the intersection point if the lines intersect and null otherwise.
     */
    public Point intersectionWithVerticalY(Line other) {
        //if the value of x of the start of the lines is the same.
        if (this.start.getX() == other.start.getX()) {
            //check if the end point of one of the line is on the other line-in this cases the lines come together.
            if ((onSegment(this.end, other.start, other.end)
                    || onSegment(other.end, this.start, this.end))) {
                return null;
            }
            return new Point(this.start.getX(), this.start.getY());
        }
        //if the value of x of the end of the lines is the same.
        if (this.end.getX() == other.end.getX()) {
            //check if the start point of one of the line is on the other line-in this cases the lines come together.
            if ((onSegment(this.start, other.start, other.end)
                    || onSegment(other.start, this.start, this.end))) {
                return null;
            }
            return new Point(this.end.getX(), this.end.getY());
        }
        //if the value of x of the start of this line and of the end of the other line is the same.
        if (this.start.getX() == other.end.getX()) {
            //check if the end point of this line is on the other line or
            // the start point of other line is on this line-in this cases the lines come together.
            if ((onSegment(this.end, other.start, other.end)
                    || onSegment(other.start, this.start, this.end))) {
                return null;
            }
            return new Point(this.start.getX(), this.start.getY());
        }
        //if the value of x of the end of this line and of the start of the other line is the same.
        if (this.end.getX() == other.start.getX()) {
            //check if the start point of this line is on the other line or
            // the end point of other line is on this line-in this cases the lines come together.
            if ((onSegment(this.start, other.start, other.end)
                    || onSegment(other.end, this.start, this.end))) {
                return null;
            }
            return new Point(this.end.getX(), this.end.getY());
        }
        return null;
    }
    /**
     * the function find the slope of line.
     * @param xStart is the x value of start point.
     * @param yStart is the y value of start point.
     * @param xEnd   is the x value of end point.
     * @param yEnd   is the y value of end point.
     * @return the slope of the line.
     */
    public double findSlope(double xStart, double yStart, double xEnd, double yEnd) {
        //calculation of slope
        return ((yEnd - yStart) / (xEnd - xStart));
    }
    /**
     * the function find the intersection point between lines with the same slopes.
     * @param other line.
     * @return the intersection point if the lines intersect and null otherwise.
     */
    public Point parallelSlopesIntersection(Line other) {
        //if the start of this line equals to the start of other line.
        if (this.start.equals(other.start)) {
            //check if the equal point is the intersection point between them.
            if (!((onSegment(this.end, other.start, other.end)
                    && onSegment(other.end, this.start, this.end)))) {
                return this.start;
            }
        }
        //if the start of this line equals to the end of other line.
        if (this.start.equals(other.end)) {
            //check if the equal point is the intersection point between them.
            if (!((onSegment(this.end, other.start, other.end)
                    && onSegment(other.start, this.start, this.end)))) {
                return this.start;
            }
        }
        //if the end of this line equals to the end of other line.
        if (this.end.equals(other.end)) {
            //check if the equal point is the intersection point between them.
            if (!((onSegment(this.start, other.start, other.end)
                    && onSegment(other.start, this.start, this.end)))) {
                return this.end;
            }
        }
        //if the end of this line equals to the start of other line.
        if (this.end.equals(other.start)) {
            //check if the equal point is the intersection point between them.
            if (!((onSegment(this.start, other.start, other.end)
                    && onSegment(other.end, this.start, this.end)))) {
                return this.end;
            }
        }
        return null;
    }
    /**
     * the function find the intersection point between lines with slopes.
     * @param other line.
     * @return the intersection point if the lines intersect and null otherwise.
     */
    public Point slopeIntersectionWith(Line other) {
        //geometry.Line represented as y=m*x+n.
        //y-how far up, x-how far along, m-Slope (how steep the line is), n-point when the line crosses the Y axis.
        //m (slope) calculation : (Change in Y / Change in X)
        //m1 - the slope of this line.
        double m1 = findSlope(this.start.getX(), this.start.getY(), this.end.getX(), this.end.getY());
        //m2 - the slope of other line.
        double m2 = findSlope(other.start.getX(), other.start.getY(), other.end.getX(), other.end.getY());
        //if the slopes are equals-the lines are parallel.
        if (m1 == m2) {
            return this.parallelSlopesIntersection(other);
        }
        //n (point when the line crosses the Y axis) calculation : n=y-m*x.
        //n1 of this line, n2 of the other line.
        double n1 = (this.start.getY() - (m1 * this.start.getX()));
        double n2 = (other.start.getY() - (m2 * other.start.getX()));
        //calculate of x and y - the values of the intersection point.
        double x = (n2 - n1) / (m1 - m2);
        double y = (m1 * x) + n1;
        Point intersect = new Point(x, y);
        //check if the intersection point is on the segment of both of the lines, if yes-the lines intersect.
        if (onSegment(intersect, this.start, this.end)
                && (onSegment(intersect, other.start, other.end))) {
            return intersect;
        }
        return null;
    }
    /**
     * the function find the intersection point between lines.
     * @param other line.
     * @return Returns the intersection point if the lines intersect,and null otherwise.
     */
    public Point intersectionWith(Line other) {
        double xStart1 = this.start.getX();  //the x of start of this line.
        double xEnd1 = this.end.getX();      //the x of end of this line.
        double yStart1 = this.start.getY();  //the y of start of this line.
        double yEnd1 = this.end.getY();      //the y of end of this line.
        double xStart2 = other.start.getX(); //the x of start of other line.
        double xEnd2 = other.end.getX();     //the x of end of other line.
        double yStart2 = other.start.getY(); //the y of start of other line.
        double yEnd2 = other.end.getY();     //the y of end of other line.
        //if this line and other line are the same line.
        if (this.equals(other)) {
            return null;
        }
        //if the lines are vertical to Y axis (y1=a, y2=b).
        if ((yStart1 == yEnd1) && (yStart2 == yEnd2)) {
            if (yStart1 == yStart2) {
                return intersectionWithVerticalY(other);
            }
            return null;
        }
        //if the lines are vertical to X axis (x1=a, x2=b).
        if ((xStart1 == xEnd1) && (xStart2 == xEnd2)) {
            if (xStart1 == xStart2) {
                return intersectionWithVerticalX(other);
            }
            return null;
        }
        //if only this line is vertical to X axis (x1=a, y2=mx+n)
        if (xStart1 == xEnd1) {
            //find the slope of other line.
            double m2 = findSlope(xStart2, yStart2, xEnd2, yEnd2);
            //find the point when other line crosses the Y axis.
            double n2 = (yStart2 - (m2 * xStart2));
            //find the value of y of the intersection point- by placing in the line equation of other line.
            double y = m2 * xStart1 + n2;
            Point intersect = new Point(xStart1, y);
            //check if the intersection point is on the segment of both of the lines, if yes-the lines intersect.
            if (onSegment(intersect, this.start, this.end)
                    && (onSegment(intersect, other.start, other.end))) {
                return intersect;
            }
            return null;
        }
        //if only other line is vertical to X axis (y1=mx+n, x2=a)
        if (xStart2 == xEnd2) {
            //find the slope of this line.
            double m1 = findSlope(xStart1, yStart1, xEnd1, yEnd1);
            //find the point when this line crosses the Y axis.
            double n1 = (yStart1 - (m1 * xStart1));
            //find the value of y of the intersection point- by placing in the line equation of this line.
            double y = m1 * xStart2 + n1;
            Point intersect = new Point(xStart2, y);
            //check if the intersection point is on the segment of both of the lines, if yes-the lines intersect.
            if (onSegment(intersect, this.start, this.end)
                    && (onSegment(intersect, other.start, other.end))) {
                return intersect;
            }
            return null;
        }
        //else, to both of the lines have a slope(they are not vertical to axes).
        return slopeIntersectionWith(other);
    }
    /**
     * the function check if lines are equal.
     * @param other line.
     * @return return true is the lines are equal, false otherwise.
     */
    public boolean equals(Line other) {
        //lines are equal if they have the same start point and the same end point.
        return ((this.start.equals(other.start)) && (this.end.equals(other.end)));
    }
    /**
     * the function find the closest intersection point
     * (between the rectangle and this line) to the start of the line.
     * @param rect - rectangle.
     * @return if the line intersect with the rectangle return
     * the closest intersection point to the start of the line, Otherwise return null.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        //list of the intersection points.
        List<Point> intersectionPointsList = rect.intersectionPoints(this);
        double minDistance = Double.MAX_VALUE;
        Point closestIntersectionPoint = null;
        double distance;
        //if there is no intersection points between rect and this line.
        if (intersectionPointsList.isEmpty()) {
            return null;
        }
        int countIntersectionPoint = intersectionPointsList.size();
        //find the closest intersection point.
        for (int i = 0; i < countIntersectionPoint; i++) {
            Point intersect = intersectionPointsList.get(i);
            distance = this.start().distance(intersect);
            //if the distance is less then the current min distance, replace between them.
            if (distance < minDistance) {
                minDistance = distance;
                //save the point that her distance is the current minimum.
                closestIntersectionPoint = new Point(intersect.getX(), intersect.getY());
            }
        }
        return closestIntersectionPoint;
    }
    /**
     * the function check if specified point is on specified line.
     * @param point - point that will be checked.
     * @return true-if the point is on the line, false-otherwise.
     */
    public Boolean pointOnLine(Point point) {
        return onSegment(point, this.start, this.end);
    }
}





