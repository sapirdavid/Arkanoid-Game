// ID : 318574712
package game;
import animation.Animation;
import animation.CountdownAnimation;
import animation.PauseScreen;
import animation.AnimationRunner;
import animation.KeyPressStoppableAnimation;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import collision.Collidable;
import geometry.Point;
import geometry.Rectangle;
import hit.Counter;
import levels.LevelInformation;
import listeners.BallRemover;
import listeners.BlockRemover;
import listeners.HitListener;
import listeners.ScoreTrackingListener;
import sprites.LevelNameIndicator;
import sprites.Sprite;
import sprites.Ball;
import sprites.Block;
import sprites.SpriteCollection;
import sprites.Paddle;
import sprites.ScoreIndicator;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * the class describe a game level.
 * @author Sapir David <sapirdavid5220@gmail.com>
 * @version 2.0
 * @since 20-05-23
 */
public class GameLevel implements Animation {
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private KeyboardSensor keyboard;
    private Counter blockCounter;
    private Counter ballCounter;
    private Counter score;
    private AnimationRunner runner;
    private boolean running;
    private LevelInformation  levelInfo;
    //const numbers
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final int RADIUS1 = 5;
    public static final int WIDTH_CORNER_BLOCK = 20;
    public static final int PADDLE_POINT_VALUE = 560;
    public static final int HEIGHT_PADDLE = 20;
    /**
     * constructor of game.
     * @param levelInformation - the information of the level in the game.
     * @param keyboard - the Keyboard Sensor.
     * @param runner - the animation runner.
     * @param score - the score of the game.
     */
    public GameLevel(LevelInformation levelInformation, KeyboardSensor keyboard, AnimationRunner runner,
                     Counter score) {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.runner = runner;
        this.keyboard = keyboard;
        this.blockCounter = new Counter();
        this.ballCounter = new Counter();
        this.score = score;
        this.running = true;
        this.levelInfo = levelInformation;
    }
    /**
     * the function add a collidable to the game environment of the game.
     * @param c - collidable.
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }
    /**
     * the function add a sprite to the sprite collection of the game.
     * @param s - sprite.
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }
    /**
     * the function remove collidable from the game.
     * @param c - colliadble to remove.
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }
    /**
     * the function remove sprite from the game.
     * @param s - sprite to remove.
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }
    /**
     * the function return the count of the block in the game.
     * @return count - of block.
     */
    public int getblockCount() {
        return this.blockCounter.getValue();
    }
    /**
     * the function return the count of the ball in the game.
     * @return count - of ball.
     */
    public int getballCount() {
        return this.ballCounter.getValue();
    }
    /**
     * the function initialize the balls in the game.
     */
    public void initializeBall() {
        int numberOfBalls = this.levelInfo.numberOfBalls();
        //this.ballCounter.setValue(numberOfBalls);
        //xBall for x location of the ball on the middle of the paddle.
        int xBall = (WIDTH / 2);
        //initialize each ball and add them to the game.
        for (int i = 0; i < numberOfBalls; i++) {
            Ball ball = new Ball(xBall, PADDLE_POINT_VALUE - RADIUS1 - 5,
                    RADIUS1, Color.white, this.environment);
            ball.setVelocity(this.levelInfo.initialBallVelocities().get(i));
            ball.addToGame(this);
            this.ballCounter.increase(1);
        }
    }
    /**
     * the function initialize the colors blocks in the game.
     */
    public void initializeColorsBlocks() {
        // blockRemover - hit listener to remove block after hit.
        BlockRemover blockRemover = new BlockRemover(this, this.blockCounter);
        // scoreTrackingListener - hit listener to update the score of the game.
        ScoreTrackingListener scoreTrackingListener = new ScoreTrackingListener(this.score);
        //this.blockCounter.setValue(this.levelInfo.numberOfBlocksToRemove());
        for (Block block: this.levelInfo.blocks()) {
            block.addToGame(this);
            // add a listener to this block.
            block.addHitListener(blockRemover);
            block.addHitListener(scoreTrackingListener);
            // increase the count of the blocks.
            this.blockCounter.increase(1);
        }
    }
    /**
     * the function initialize the border blocks in the game.
     */
    public void initializeBorderBlocks() {
        //hit listeners empty for the border blocks.
        List<HitListener> hitListenersEmpty = new ArrayList<HitListener>();
        // ballRemover -  hit listener to remove ball after hit.
        BallRemover ballRemover = new BallRemover(this, this.ballCounter);
        // list of hit listener to the ball.
        List<HitListener> hitListenersBall = new ArrayList<HitListener>();
        hitListenersBall.add(ballRemover);
        Block leftBorder = new Block((new Point(0, 0)), WIDTH_CORNER_BLOCK,
                HEIGHT, Color.GRAY, hitListenersEmpty);
        Block topBorder = new Block((new Point(0, 0)), WIDTH,
                WIDTH_CORNER_BLOCK + 40, Color.gray, hitListenersEmpty);
        Block bottomBorder = new Block((new Point(0, HEIGHT + 20)),
                WIDTH, WIDTH_CORNER_BLOCK, Color.GRAY, hitListenersBall);
        //HEIGHT - WIDTH_CORNER_BLOCK
        Block rightBorder = new Block(new Point(WIDTH - WIDTH_CORNER_BLOCK, 0),
                WIDTH_CORNER_BLOCK, HEIGHT, Color.GRAY, hitListenersEmpty);
        Block[] blocks = new Block[] {topBorder, bottomBorder, leftBorder, rightBorder};
        //add the border blocks to the game.
        for (Block block : blocks) {
            block.addToGame(this);
        }
    }
    /**
     * the function initialize the paddle.
     */
    public void initializePaddle() {
        this.keyboard = this.runner.getGui().getKeyboardSensor();
        biuoop.KeyboardSensor keyboardSensor = this.runner.getGui().getKeyboardSensor();
        int paddleWidth = this.levelInfo.paddleWidth();
        int paddleSpeed = this.levelInfo.paddleSpeed();
        //the x-start location of the paddle.
        int xPaddle = (WIDTH / 2) - (paddleWidth / 2);
        //initialize the paddle and add him to the game.
        Rectangle rect = new Rectangle(new Point(xPaddle, PADDLE_POINT_VALUE), paddleWidth, HEIGHT_PADDLE);
        Paddle paddle = new Paddle(rect, keyboardSensor, Color.blue, paddleSpeed);
        paddle.addToGame(this);
    }
    /**
     * the function Initialize a new game: create the Blocks , sprites.Ball and sprites.Paddle
     *  and add them to the game.
     */
    public void initialize() {
        Sprite backGround = this.levelInfo.getBackground();
        sprites.addSprite(backGround);
        // initialize the balls in the game.
        initializeBall();
        // initialize the colors blocks in the game.
        initializeColorsBlocks();
        //create the border blocks.
        initializeBorderBlocks();
        //initialize the paddle.
        initializePaddle();
        // sprite to show the score in the game.
        ScoreIndicator scoreIndicator = new ScoreIndicator(new Rectangle(new Point(0, 0), WIDTH,
                WIDTH_CORNER_BLOCK + 20), Color.LIGHT_GRAY, this.score);
        scoreIndicator.addToGame(this);
        // sprite to show the level name in the game.
        LevelNameIndicator levelNameIndicator = new LevelNameIndicator(this.levelInfo.levelName());
        levelNameIndicator.addToGame(this);
    }
    /**
     * the function Run the game - start the animation loop.
     */
    public void run() {
        // countdown before turn starts.
        this.runner.run(new CountdownAnimation(2, 3, this.sprites));
        this.running = true;
        // use our runner to run the current animation -- which is one turn of
        // the game.
        this.runner.run(this);
    }
    /**
     * the function do one frame.
     * @param d -  the draw surface of the game.
     */
    public void doOneFrame(DrawSurface d) {
        //if the user press on "p" is time to pause the game.
        if (this.keyboard.isPressed("p")) {
                this.runner.run(new KeyPressStoppableAnimation(this.keyboard,
                        this.keyboard.SPACE_KEY, new PauseScreen(this.keyboard)));
        }
        //draw the background og this level.
        this.levelInfo.getBackground().drawOn(d);
        //draw the sprites of this game.
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
        //check if there is no balls in the game.
        if (this.ballCounter.getValue() == 0) {
            this.running = false;
        }
        //check if there is no block in the game.
        if (this.blockCounter.getValue() == 0) {
            //if the user remove all blocks from the game he get more 100 points.
            this.score.increase(100);
            this.running = false;
        }
    }
    /**
     * this function inform the game should stop.
     * @return true- if the game should stop, false-otherwise.
     */
    @Override
    public boolean shouldStop() {
        return !this.running;
    }
}
