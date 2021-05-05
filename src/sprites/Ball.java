// ID : 318574712
package sprites;
import biuoop.DrawSurface;
import collision.CollisionInfo;
import game.GameLevel;
import game.GameEnvironment;
import geometry.Line;
import geometry.Point;
import hit.Velocity;
import java.awt.Color;
/**
 * the class describe a ball - is a round object.
 * @author Sapir David <sapirdavid5220@gmail.com>
 * @version 2.0
 * @since 20-04-23
 */
public class Ball implements Sprite {
    private Point center;
    private int radius;
    private java.awt.Color color;
    private Velocity velocity;
    private GameEnvironment gameEnvironment;
    /**
     * constructor ball from center,radius and color.
     * @param center is the center point of the ball.
     * @param r      is the radius of the ball.
     * @param color  is the color of the ball.
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.center = center;
        this.radius = r;
        this.color = color;
        this.velocity = new Velocity(0, 0);
    }
    /**
     * constructor ball from center,radius,color and game environment.
     * @param center is the center point of the ball.
     * @param r      is the radius of the ball.
     * @param color  is the color of the ball.
     * @param gameEnvironment  is the game environment of the ball.
     */
    public Ball(Point center, int r, java.awt.Color color, GameEnvironment gameEnvironment) {
        this.center = center;
        this.radius = r;
        this.color = color;
        this.velocity = new Velocity(0, 0);
        this.gameEnvironment = gameEnvironment;
    }
    /**
     * constructor ball from x value of center,y value of center,radius and color.
     * @param xCenter is the x value of center point of the ball.
     * @param yCenter is the y value of center point of the ball.
     * @param r       is the radius of the ball.
     * @param color   is the color of the ball.
     */
    public Ball(double xCenter, double yCenter, int r, java.awt.Color color) {
        this.center = new Point(xCenter, yCenter);
        this.radius = r;
        this.color = color;
        this.velocity = new Velocity(0, 0);
    }
    /**
     * constructor ball from x value of center,y value of center,radius,color and game environment.
     * @param xCenter is the x value of center point of the ball.
     * @param yCenter is the y value of center point of the ball.
     * @param r       is the radius of the ball.
     * @param color   is the color of the ball.
     * @param gameEnvironment  is the game environment of the ball.
     */
    public Ball(double xCenter, double yCenter, int r, java.awt.Color color, GameEnvironment gameEnvironment) {
        this.center = new Point(xCenter, yCenter);
        this.radius = r;
        this.color = color;
        this.velocity = new Velocity(0, 0);
        this.gameEnvironment = gameEnvironment;
    }
    /**
     * the function return the x value of the center point of the ball.
     * @return x of center.
     */
    public int getX() {
        return ((int) this.center.getX());
    }
    /**
     * the function return the y value of the center point of the ball.
     * @return y of center.
     */
    public int getY() {
        return ((int) this.center.getY());
    }
    /**
     * the function return the size(radius) of the ball.
     * @return radius of ball.
     */
    public int getSize() {
        return this.radius;
    }
    /**
     * the function return the color of the ball.
     * @return color of ball.
     */
    public java.awt.Color getColor() {
        return this.color;
    }
    /**
     * the function return the game environment of the ball.
     * @return game environment of ball.
     */
    public GameEnvironment getGameEnvironment() {
        return this.gameEnvironment;
    }
    /**
     * the function set the game environment of the ball.
     * @param newGameEnvironment - the game environment of the ball.
     */
    public void setGameEnvironment(GameEnvironment newGameEnvironment) {
       this.gameEnvironment = newGameEnvironment;
    }
    /**
     * the function draw the ball on the given DrawSurface.
     * @param surface - to draw on him.
     */
    @Override
    public void drawOn(DrawSurface surface) {
        //set the color of this ball.
        surface.setColor(this.color);
        //draw the ball on the surface.
        surface.fillCircle(this.getX(), this.getY(), this.radius);
        //frame to the ball.
        surface.setColor(Color.black);
        surface.drawCircle(this.getX(), this.getY(), this.radius);
        surface.fillCircle(this.getX(), this.getY(), 2);
    }
    /**
     * the function set velocity to the ball.
     * @param v is the velocity we get to set.
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }
    /**
     * the function set velocity to the ball- from dx,dy.
     * @param dx is the change in position on the `x` axis.
     * @param dy is the change in position on the `y` axis.
     */
    public void setVelocity(double dx, double dy) {
        //create a new velocity and set it to this ball.
        this.velocity = new Velocity(dx, dy);
    }
    /**
     * the function return the velocity of this ball.
     * @return velocity.
     */
    public Velocity getVelocity() {
        return this.velocity;
    }
    /**
     * the function move the ball one step.
     */
    public void moveOneStep() {
        //trajectory is a line starting at current location,
        //and ending where the velocity will take the ball if no collisions will occur.
        Line trajectory = new Line(this.center, this.getVelocity().applyToPoint(this.center));
        //the information about the closest collision.
        CollisionInfo collisionInfo = this.gameEnvironment.getClosestCollision(trajectory);
        //check if moving on this trajectory will hit anything -if the collision information exists.
        if (collisionInfo != null) {
            //move the ball to "almost" the hit point, but just slightly before it.
            double xCenter = collisionInfo.collisionPoint().getX();
            double yCenter = collisionInfo.collisionPoint().getY();
            if (this.getVelocity().getDx() > 0) {
                xCenter = xCenter - 0.2;
            } else if (this.getVelocity().getDx() < 0) {
                xCenter = xCenter + 0.2;
            }
            if (this.getVelocity().getDy() > 0) {
                yCenter = yCenter - 0.2;
            } else if (this.getVelocity().getDy() < 0) {
                yCenter = yCenter + 0.2;
            }
            this.center = new Point(xCenter, yCenter);
            //update the velocity to the new velocity returned by the hit() method.
            this.setVelocity(collisionInfo.collisionObject().hit(this, collisionInfo.collisionPoint(),
                    this.getVelocity()));
            //change the color of the ball when collision is occur.
            //this.changeColor(this.color);
        } else {
            //move the ball to the end of the trajectory.
            this.center = this.getVelocity().applyToPoint(this.center);
        }
    }
    @Override
    public void timePassed() {
        this.moveOneStep();
    }
    /**
     * the function add this ball to the game.
     * @param g - game.
     */
    public void addToGame(GameLevel g) {
       g.addSprite(this);
    }
    /**
     * the function change the color of the ball.
     * @param currentColor - the color of the ball.
     */
    public void changeColor(Color currentColor) {
        if (currentColor == Color.red) {
            this.color = Color.green;
        }
        if (currentColor == Color.magenta) {
            this.color = Color.cyan;
        }
        if (currentColor == Color.cyan) {
            this.color = Color.red;
        }
        if (currentColor == Color.green) {
            this.color = Color.magenta;
        }
    }
    /**
     * the function remove the ball from the game.
     * @param g - the game.
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
    }
}