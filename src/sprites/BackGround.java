// ID : 318574712
package sprites;
import biuoop.DrawSurface;
import geometry.Rectangle;
import java.awt.Color;
/**
 * the class describe background of level.
 * @author Sapir David <sapirdavid5220@gmail.com>
 * @version 1.0
 * @since 20-06-05
 */
public class BackGround implements Sprite {
    private Rectangle rectangle;
    private java.awt.Color color;
    private int levelNumber;

    /**
     * the constructor of the score indicator.
     * @param rect - rectangle of the score indicator.
     * @param color - the color of the rectangle.
     * @param levelNumber - the number of this level.
     */
    public BackGround(Rectangle rect, java.awt.Color color, int levelNumber) {
        this.rectangle = rect;
        this.color = color;
        this.levelNumber = levelNumber;
    }
    /**
     * the function draw the sprite to the screen.
     * @param d - the draw surface.
     */
    @Override
    public void drawOn(DrawSurface d) {
        //check which level to draw.
       if (this.levelNumber == 1) {
           drawOnLevel1(d);
       }
        if (this.levelNumber == 2) {
            drawOnLevel2(d);
        }
        if (this.levelNumber == 3) {
            drawOnLevel3(d);
        }
        if (this.levelNumber == 4) {
            drawOnLevel4(d);
        }
        if (this.levelNumber == 0) {
            drawOnMenu(d);
        }
    }
    /**
     * the function draw the background of level 1 on the screen.
     * @param d - the draw surface.
     */
    public void drawOnLevel1(DrawSurface d) {
        //set the color of this background.
        d.setColor(this.color);
        //draw the rectangle on the surface.
        d.fillRectangle((int) this.rectangle.getUpperLeft().getX(), (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());
        d.setColor(Color.blue);
        // draw the figures on the surface.
        d.drawCircle(400, 165, 50);
        d.drawCircle(400, 165, 80);
        d.drawCircle(400, 165, 110);
        d.drawLine(400, 4, 400, 140);
        d.drawLine(400, 190, 400, 290);
        d.drawLine(275, 165, 375, 165);
        d.drawLine(425, 165, 525, 165);
    }
    /**
     * the function draw the background of level 2 on the screen.
     * @param d - the draw surface.
     */
    public void drawOnLevel2(DrawSurface d) {
        //set the color of this background.
        d.setColor(this.color);
        //draw the rectangle on the surface.
        d.fillRectangle((int) this.rectangle.getUpperLeft().getX(), (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());
        d.setColor(Color.yellow);
        // draw the figures on the surface.
        for (int i = 0; i < 100; i++) {
            d.drawLine(150, 150, 0 + i * 8, 260);
        }
        d.fillCircle(150, 150, 60);
        d.setColor(Color.orange);
        d.fillCircle(150, 150, 50);
        d.setColor(Color.yellow);
        d.fillCircle(150, 150, 45);
        d.setColor(Color.orange);
        d.fillCircle(150, 150, 40);
    }
    /**
     * the function draw the background of level 3 on the screen.
     * @param d - the draw surface.
     */
    public void drawOnLevel3(DrawSurface d) {
        //set the color of this background.
        d.setColor(this.color);
        //draw the rectangle on the surface.
        d.fillRectangle((int) this.rectangle.getUpperLeft().getX(), (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());
        d.setColor(Color.black);
        // draw the figures on the surface.
        d.fillRectangle(50, 385, 120, 220);
        d.setColor(Color.white);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                d.fillRectangle(60 + (i * 22), 560 - (j * 40), 10, 30);
            }
        }
        d.setColor(Color.darkGray);
        d.fillRectangle(95, 340, 30, 45);
        d.setColor(Color.darkGray);
        d.fillRectangle(105, 200, 10, 150);
        d.setColor(Color.YELLOW);
        d.fillCircle(110, 200, 10);
        d.setColor(Color.red);
        d.fillCircle(110, 200, 6);
        d.setColor(Color.white);
        d.fillCircle(110, 200, 2);
    }
    /**
     * the function draw the background of level 4 on the screen.
     * @param d - the draw surface.
     */
    public void drawOnLevel4(DrawSurface d) {
        //set the color of this background.
        d.setColor(this.color);
        //draw the rectangle on the surface.
        d.fillRectangle((int) this.rectangle.getUpperLeft().getX(), (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());
        d.setColor(Color.white);
        // draw the figures on the surface.
        for (int i = 0; i < 10; i++) {
            d.drawLine(100 + (i * 10), 400, 65 + (i * 10), 600);
        }
        for (int i = 0; i < 10; i++) {
            d.drawLine(600 + (i * 10), 500, 565 + (i * 10), 600);
        }
        for (int i = 0; i < 5; i++) {
            if (i % 2 == 0) {
                d.setColor(Color.LIGHT_GRAY);
            } else {
                d.setColor(Color.gray.brighter());
            }
            d.fillCircle(100 + (i * 20), 400, 25 + ((i % 2) * 5));
        }
        for (int i = 0; i < 5; i++) {
            if (i % 2 == 0) {
                d.setColor(Color.LIGHT_GRAY);
            } else {
                d.setColor(Color.gray.brighter());
            }
            d.fillCircle(600 + (i * 20), 500, 25 + ((i % 2) * 5));
        }
    }
    /**
     * the function draw the background of menu the screen.
     * @param d - the draw surface.
     */
    public void drawOnMenu(DrawSurface d) {
        //set the color of this background.
        d.setColor(this.color);
        //draw the rectangle on the surface.
        d.fillRectangle((int) this.rectangle.getUpperLeft().getX(), (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());
        d.setColor(Color.white);
    }
    /**
     * the function notify the sprite that time has passed.
     */
    @Override
    public void timePassed() {
        return;
    }
}
