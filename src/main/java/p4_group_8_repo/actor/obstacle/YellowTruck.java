package p4_group_8_repo.actor.obstacle;

import javafx.scene.image.Image;

/**
 * A class that represents the yellow truck within the game play.
 * This class extends class {@link Obstacle} and implements the
 * interface {@link TruckVehicle}.
 * @author Liew Yih Seng
 *
 */
public class YellowTruck extends Obstacle implements TruckVehicle{
	
	/**
	 * Initializes the yellow truck object that exist within the game play and 
	 * sets the image of this {@link YellowTruck} and its desired X-Coordinate and Y-Coordinate.
	 * @param xpos An integer representing the X-Coordinate of this {@link YellowTruck}.
	 * @param ypos An integer representing the Y-Coordinate of this {@link YellowTruck}.
	 * @param s A double that represents the speed of movement of this {@link YellowTruck} during game play.
	 */
	public YellowTruck(int xpos, int ypos, double s) {
		super(xpos, ypos, s);
		setImage(new Image("file:src/main/resources/images/Actor/TruckYellow.png", WIDTH, HEIGHT, true, true));
	}
	
	@Override
	public void act(long now) {
		move(speed , 0);
		loopEnterScreenLeft(-200, 600, speed);
	}
}
