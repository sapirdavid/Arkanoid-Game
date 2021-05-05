// ID : 318574712
package sprites;
import biuoop.DrawSurface;
import collision.Collidable;
import game.GameLevel;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import hit.Velocity;
import java.awt.Color;
/**
 * the class represent a paddle - rectangle with color and velocity.
 * @author Sapir David <sapirdavid5220@gmail.com>
 * @version 1.0
 * @since 20-04-23
 */
public class Paddle implements Sprite, Collidable {
    private Rectangle rectangle;
    private biuoop.KeyboardSensor keyboard;
    private java.awt.Color color;
    private Velocity velocity;
    public static final int LEFT_BORDER = 20;
    public static final int RIGHT_BORDER = 780;
    public static final int ANGLE1 = 300;
    public static final int ANGLE2 = 330;
    public static final int ANGLE4 = 30;
    public static final int ANGLE5 = 60;
    public static final int NUM_OF_REGION = 5;
    /**
     * constructor paddle from rectangle, key board sensor,color and velocity.
     * @param rect - rectangle that represent this paddle.
     * @param keyboardSensor - key board sensor of the paddle.
     * @param colorPaddle - the color of the paddle.
     * @param paddleSpeed - the speed of the paddle.
     */
    public Paddle(Rectangle rect, biuoop.KeyboardSensor keyboardSensor, java.awt.Color colorPaddle, int paddleSpeed) {
        this.rectangle = rect;
        this.keyboard = keyboardSensor;
        this.color = colorPaddle;
        this.velocity = new Velocity(paddleSpeed, 0);
    }
    /**
     * the function move the peddle to the left.
     */
    public void moveLeft() {
        //if after one step the paddle will be out from the left border.
        if ((this.rectangle.getUpperLeft().getX()) - this.velocity.getDx() < LEFT_BORDER) {
            Point newPaddlePoint = new Point(LEFT_BORDER, this.rectangle.getUpperLeft().getY());
            this.rectangle.setUpperLeft(newPaddlePoint);
        } else {
            Point newPaddlePoint = new Point((this.rectangle.getUpperLeft().getX() - this.velocity.getDx()),
                    this.rectangle.getUpperLeft().getY());
            this.rectangle.setUpperLeft(newPaddlePoint);
        }
    }
    /**
     * the function move the peddle to the right.
     */
    public void moveRight() {
        //if after one step the paddle will be out from the right border.
        if ((this.rectangle.getUpperLeft().getX() + this.velocity.getDx()
                + this.rectangle.getWidth() > RIGHT_BORDER)) {
            Point newPaddlePoint = new Point(RIGHT_BORDER - this.rectangle.getWidth(),
                    this.rectangle.getUpperLeft().getY());
            this.rectangle.setUpperLeft(newPaddlePoint);
        } else {
            Point newPaddlePoint = new Point((this.rectangle.getUpperLeft().getX() + this.velocity.getDx()),
                    this.rectangle.getUpperLeft().getY());
            this.rectangle.setUpperLeft(newPaddlePoint);
        }
    }
    // sprites.Sprite
    /**
     * the function move the paddle depends on the keyboard press.
     */
    @Override
    public void timePassed() {
        if (this.keyboard.isPressed(this.keyboard.LEFT_KEY)) {
            this.moveLeft();
        }
        if (this.keyboard.isPressed(this.keyboard.RIGHT_KEY)) {
            this.moveRight();
        }
    }
    /**
     * the function draw the paddle on the given DrawSurface.
     * @param surface to draw on him.
     */
    @Override
    public void drawOn(DrawSurface surface) {
        //set the color of this paddle.
        surface.setColor(this.color);
        //draw the paddle on the surface.
        surface.fillRectangle((int) this.rectangle.getUpperLeft().getX(),
                (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());
        //draw the frame of the paddle.
        surface.setColor(Color.black);
        surface.drawRectangle((int) this.rectangle.getUpperLeft().getX(),
                (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());
    }
    // collision.Collidable
    /**
     * the function return the rectangle of this paddle.
     * @return rectangle - of this paddle.
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }
    /**
     * the function notify the object that we collided with it at collisionPoint with a given velocity.
     * @param hitter - the ball that hit.
     * @param collisionPoint - the collision point of the paddle with the collided object.
     * @param currentVelocity - the current velocity of the collided object.
     * @return velocity - the new velocity expected after the hit
     * (based on the force the object inflicted on us).
     */
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        Velocity newVelocity;
        //the right edge of the rectangle is line from the upper left point to the lower left point.
        Line rightEdge = new Line(this.rectangle.getUpperRight(), this.rectangle.getLowerRight());
        //the left edge of the rectangle is line from the upper left point to the lower left point.
        Line leftEdge = new Line(this.rectangle.getUpperLeft(), this.rectangle.getLowerLeft());
        double y = this.rectangle.getUpperLeft().getY();
        //length of region is the length of 1/5 from the rectangle`s width.
        double lengthOfRegion = this.rectangle.getWidth() / NUM_OF_REGION;
        Point startRegion1 = this.rectangle.getUpperLeft();
        Point endRegion1 = new Point(this.rectangle.getUpperLeft().getX() + lengthOfRegion, y);
        /*
        paddle as having 5 equally-spaced regions- region 1-5.
        the behavior of the ball's bounce depends on where it hits the paddle,
         so we have 5 lines that represent the 5 region of the paddle.
        */
        Line region1 = new Line(startRegion1, endRegion1);
        Point startRegion2 = endRegion1;
        Point endRegion2 = new Point(endRegion1.getX() + lengthOfRegion, y);
        Line region2 = new Line(startRegion2, endRegion2);
        Point startRegion3 = endRegion2;
        Point endRegion3 = new Point(endRegion2.getX() + lengthOfRegion, y);
        Line region3 = new Line(startRegion3, endRegion3);
        Point startRegion4 = endRegion3;
        Point endRegion4 = new Point(endRegion3.getX() + lengthOfRegion, y);
        Line region4 = new Line(startRegion4, endRegion4);
        Point startRegion5 = endRegion4;
        Point endRegion5 = new Point(endRegion4.getX() + lengthOfRegion, y);
        Line region5 = new Line(startRegion5, endRegion5);
        //the current speed from the current velocity.
        double speed = currentVelocity.fromVelocityToSpeed();
        //if the collision point is on the region1.
        if (region1.pointOnLine(collisionPoint)) {
            newVelocity = this.velocity.fromAngleAndSpeed(ANGLE1, speed);
            return newVelocity;
        }
        //if the collision point is on the region1.
        if (region2.pointOnLine(collisionPoint)) {
            newVelocity = this.velocity.fromAngleAndSpeed(ANGLE2, speed);
            return newVelocity;
        }
        //if the collision point is on the region1.
        if (region3.pointOnLine(collisionPoint)) {
            newVelocity = new Velocity(currentVelocity.getDx(), -currentVelocity.getDy());
            return newVelocity;
        }
        //if the collision point is on the region1.
        if (region4.pointOnLine(collisionPoint)) {
            newVelocity = this.velocity.fromAngleAndSpeed(ANGLE4, speed);
            return newVelocity;
        }
        //if the collision point is on the region1.
        if (region5.pointOnLine(collisionPoint)) {
            newVelocity = this.velocity.fromAngleAndSpeed(ANGLE5, speed);
            return newVelocity;
        }
        //if the collision is in left or right edge of the block.
        if ((leftEdge.pointOnLine(collisionPoint)) || (rightEdge.pointOnLine(collisionPoint))) {
            newVelocity = new Velocity(-currentVelocity.getDx(), currentVelocity.getDy());
            return newVelocity;
        }
        return currentVelocity;
    }
    /**
     * the function add this paddle to the game.
     * @param g - game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
}
