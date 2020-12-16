package p4_group_8_repo.actor.obstacle;

import javafx.scene.image.Image;

/**
 * A class that represents the taxi car within the game play.
 * This class extends class{@link Obstacle} and implements
 * the interface {@link SedanVehicle}.
 * @author Liew Yih Seng
 *
 */
public class TaxiCar extends Obstacle implements SedanVehicle{
	
	/**
	 * Initializes the taxi car object that exist within the game play and
	 * sets the image of this {@link TaxiCar} and it desired X-Coordinate and Y-Coordinate.
	 * @param xpos An integer that represents the X-Coordinate of this {@link TaxiCar}.
	 * @param ypos An integer that represents the Y-Coordinate of this {@link TaxiCar}.
	 * @param s A double representing the speed of movement of this {@link TaxiCar} during game play.
	 */
	public TaxiCar(int xpos, int ypos, double s) {
		super(xpos, ypos, s);
		setImage(new Image("file:src/main/resources/images/Actor/Taxi.png", WIDTH, HEIGHT, true, true));
	}
	
	@Override
	public void act(long now) {
		move(speed , 0);
		loopEnterScreenRight(600, -50, speed);
	}
}
