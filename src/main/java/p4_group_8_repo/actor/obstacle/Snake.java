package p4_group_8_repo.actor.obstacle;

import javafx.scene.image.Image;

/**
 * A clas that represents the snake object within the game play.
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
	 * A constructor that initializes the snake object within game play.
	 * It sets the image of the snake and its X-Coordinate and Y-Coordinate
	 * of its occurrence in game play.
	 * @param xpos An integer representing the X-Coordinate of the Snake.
	 * @param ypos An integer representing the Y-Coordinate of the Snake.
	 * @param s A double that represents the speed of the Snake during game play.
	 */
	public Snake(int xpos, int ypos, double s) {
		super(xpos, ypos, s);
		speed = s;
		setImage(Snake4);
	}
	
	/**
	 * A method that handles the action of the snake object.
	 * It serves as a method that sets the animation of the snake
	 * when the clock ticks.
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
		loopEnterScreen(-200, 600, 600, -50, speed);
	}
}
