package p4_group_8_repo.actor.obstacle;

import javafx.scene.image.Image;

/**
 * A class that represents the snake object within the game play.
 * This class extends class {@link Obstacle}.
 * @author Liew Yih Seng
 *
 */
public class Snake extends Obstacle{
	private double speed;
	final int WIDTH = 60;
	final int HEIGHT = 60;
	static final int TICK = 900000000;
	Image Snake1 = new Image("file:src/main/resources/images/Actor/Snake1.png", WIDTH, HEIGHT, true, true);
	Image Snake2 = new Image("file:src/main/resources/images/Actor/Snake2.png", WIDTH, HEIGHT, true, true);
	Image Snake3 = new Image("file:src/main/resources/images/Actor/Snake3.png", WIDTH, HEIGHT, true, true);
	Image Snake4 = new Image("file:src/main/resources/images/Actor/Snake4.png", WIDTH, HEIGHT, true, true);

	/**
	 * A constructor that instantiates the snake object within game play.
	 * It sets the image of this {@link Snake} and its X-Coordinate and Y-Coordinate
	 * of its occurrence in game play.
	 * @param xpos An integer representing the X-Coordinate of this {@link Snake}.
	 * @param ypos An integer representing the Y-Coordinate of this {@link Snake}.
	 * @param s A double that represents the speed of movement of this {@link Snake} during game play.
	 */
	public Snake(int xpos, int ypos, double s) {
		super(xpos, ypos, s);
		speed = s;
		setImage(Snake4);
	}
	
	/**
	 * A method that handles the action of this {@link Snake} object.
	 * It serves as a method that sets the animation of this {@link Snake}
	 * when the clock ticks and reloops this {@link Snake} once it has exited the game scene
	 * in the manner of left to right.
	 */
	@Override
	public void act(long now) {

				if (now/TICK % 4 ==0) {
					setImage(Snake4);
					
				}
				else if (now/TICK % 4 == 1) {
					setImage(Snake1);
					
				}
				else if (now/TICK % 4 == 2) {
					setImage(Snake2);	
					
				}
				else if (now/TICK % 4 == 3) {
					setImage(Snake3);
					
				}
			
		move(speed , 0);
		loopEnterScreenLeft(-200, 600, speed);
	}
}
