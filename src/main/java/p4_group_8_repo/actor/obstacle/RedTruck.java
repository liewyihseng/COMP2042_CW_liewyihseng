package p4_group_8_repo.actor.obstacle;

import javafx.scene.image.Image;

/**
 * A class that represents the red truck within the game play.
 * This class extends the {@link Obstacle} and implements the
 * interface {@link TruckVehicle}.
 * @author Liew Yih Seng
 *
 */
public class RedTruck extends Obstacle implements TruckVehicle{
	
	/**
	 * Initializes the red truck object that exist within the game play and
	 * sets the image of this {@link RedTruck} and its desired X-Coordinate and Y-Coordinate.
	 * @param xpos An integer representing the X-Coordinate of this {@link RedTruck}.
	 * @param ypos An integer representing the Y-Coordinate of this {@link RedTruck}.
	 * @param s A double that represents the speed of movement of this {@link RedTruck} during game play.
	 */
	public RedTruck(int xpos, int ypos, double s) {
		super(xpos, ypos, s);
		setImage(new Image("file:src/main/resources/images/Actor/TruckRed.png", WIDTH, HEIGHT, true, true));
	}
	
	@Override
	public void act(long now) {
		move(speed , 0);
		loopEnterScreenLeft(-200, 600, speed);
	}
}