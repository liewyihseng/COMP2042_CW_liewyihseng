package p4_group_8_repo.actor;

import javafx.scene.image.Image;

/**
 * A class representing the Short Logs within the game scene.
 * @author Liew Yih Seng
 *
 */
public class ShortLog extends Log{
	final int SIZE = 150;
	Image ShortLog = new Image("file:src/main/resources/images/Actor/LogShort.png", SIZE, SIZE, true, true);
	
	/**
	 * A constructor that initializes the short log within the game scene.
	 * It triggers the super class constructor in {@link Log} that handles the setting of
	 * the log's position and its speed. Then this method will invoke method
	 * {@link #setImage(Image)} to set the image of the short log.
	 * @param xpos An integer representing the X-Coordinate of the short log.
	 * @param ypos An integer representing the Y-Coordinate of the short log
	 * @param s A double representing the speed of the short log.
	 */
	public ShortLog(int xpos, int ypos, double s) {
		super(xpos, ypos, s);
		setImage(ShortLog);
	}

	/**
	 * A method that determines the direction of how the short log will enter and keeps looping in the game play.
	 * This method will invoke another method {@link Actor#move(double, double)} to set the movement speed 
	 * of the short log, then it uses method {@link #loopEnterScreenLeft(int, int, double)} to ensure the short log
	 * will always reenter the game scene from the left once it exited the scene.
	 */
	@Override
	public void act(long now) {
		move(speed, 0);
		loopEnterScreenLeft(-180, 600, speed);
	}
}
