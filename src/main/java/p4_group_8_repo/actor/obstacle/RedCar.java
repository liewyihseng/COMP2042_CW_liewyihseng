package p4_group_8_repo.actor.obstacle;

import javafx.scene.image.Image;

/**
 * A class that represents the red sedan car within the game play.
 * This class extends class {@link Obstacle} and implements 
 * the interface {@link SedanVehicle}.
 * @author Liew Yih Seng
 *
 */
public class RedCar extends Obstacle implements SedanVehicle{
	
	/**
	 * Initializes the red car object that exist within the game play and
	 * sets the image of the red car and its desired X-Coordinate and Y-Coordinate.
	 * @param xpos An integer representing the X-Coordinate of the Red Car.
	 * @param ypos An integer representing the Y-Coordinate of the Red Car.
	 * @param s A double that represents the speed of the Red Car during game play.
	 */
	public RedCar(int xpos, int ypos, double s) {
		super(xpos, ypos, s);
		setImage(new Image("file:src/main/resources/images/Actor/CarRed.png", WIDTH, HEIGHT, true, true));
	}
}
