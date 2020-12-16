package p4_group_8_repo.actor;

/**
 * An abstract class that represents the super class for logs that existed within the game scene.
 * This class is being extended by {@link LongLog} class and {@link ShortLog} class.
 * @author user
 *
 */
public abstract class Log extends Actor {

	protected double speed;
	
	/**
	 * A constructor that initializes the initial position of the Log by invoking
	 * {@link Actor#setCoordinate(int, int)} then setting the speed of movement of
	 * the log during game play.
	 * @param xpos An integer representing the X-Coordinate of the log.
	 * @param ypos An integer representing the Y-Coordinate of the log.
	 * @param s A double representing the speed of the log.
	 */
	public Log(int xpos, int ypos, double s) {
		setCoordinate(xpos, ypos);
		speed = s;
		
	}
	
	/**
	 * This method compare the speed and determine if the speed of
	 * the log is smaller than 0. If it is smaller than 0, it will return
	 * a true representing the log is actually moving towards the left side.
	 * @return A boolean stating if the log is moving towards the left.
	 */
	public boolean getLeft() {
		return speed < 0;
	}
	
	
}
