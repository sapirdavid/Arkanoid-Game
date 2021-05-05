package geometry;
// ID : 318574712
/**
 * the class represent object of geometry.Point - an entity that has a location.
 * @author Sapir David <sapirdavid5220@gmail.com>
 * @version 2.0
 * @since 20-04-23
 */
public class Point {
    private double x;
    private double y;
    /**
     * constructor of point.
     * @param x is a X value of point.
     * @param y is a Y value of point.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    /**
     * the function calculate the distance of this point to the other point.
     * @param other -point.
     * @return distance between two points.
     */
    public double distance(Point other) {
        return Math.abs(Math.sqrt((Math.pow(this.getX() - other.getX(), 2))
                + (Math.pow(this.getY() - other.getY(), 2))));
    }
    /**
     * the function checks if points are equals.
     * @param other -point.
     * @return true if the points are equal, false otherwise.
     */
    public boolean equals(Point other) {
        return (((this.getX() == other.getX())) && (this.getY() == other.getY()));
    }
    /**
     * the function return the x value of this point.
     * @return x -of this point.
     */
    public double getX() {
        return this.x;
    }
    /**
     * the function return the y value of this point.
     * @return y -of this point.
     */
    public double getY() {
        return this.y;
    }
}

