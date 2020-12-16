package p4_group_8_repo.actor.obstacle;

import javafx.scene.image.Image;

/**
 * A class that extends the class {@link Obstacle} and represents the Long Truck that
 * existed during the game play.
 * @author Liew Yih Seng
 *
 */
public class LongTruck extends Obstacle{
	
	final int WIDTH = 200;
	final int HEIGHT = 200;
	
	/**
	 * A Constructor that initializes the Long Truck object and sets the image of this {@link LongTruck}
	 * at its desired X-Coordinate and Y-Coordinate.
	 * @param xpos An integer that represents the X-coordinate of {@link LongTruck}.
	 * @param ypos An integer that represents the Y-coordinate of {@link LongTruck}.
	 * @param s A double that represents the speed of movement of {@link LongTruck} during game play.
	 */
	public LongTruck(int xpos, int ypos, double s) {
		super(xpos, ypos, s);
		setImage(new Image("file:src/main/resources/images/Actor/TruckLong.png", WIDTH, HEIGHT, true, true));
	}
	
	@Override
	public void act(long now) {
		move(speed , 0);
		loopEnterScreenLeft(-200, 600, speed);
	}
	
}
