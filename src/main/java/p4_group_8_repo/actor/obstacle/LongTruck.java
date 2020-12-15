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
	 * A Constructor that initializes the Long Truck object and setting the image of the long truck
	 * and its desired X-Coordinate and Y-Coordinate.
	 * @param xpos An integer that represents the X-coordinate of the Long Truck.
	 * @param ypos An integer that represents the Y-coordinate of the Long Truck.
	 * @param s A double that represents the speed of the Long Truck during game play.
	 */
	public LongTruck(int xpos, int ypos, double s) {
		super(xpos, ypos, s);
		setImage(new Image("file:src/main/resources/images/Actor/TruckLong.png", WIDTH, HEIGHT, true, true));
	}
}
