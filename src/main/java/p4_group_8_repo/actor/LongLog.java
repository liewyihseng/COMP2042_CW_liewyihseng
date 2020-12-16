package p4_group_8_repo.actor;

import javafx.scene.image.Image;

/**
 * A class representing the Long Logs within the game scene.
 * @author Liew Yih Seng
 *
 */
public class LongLog extends Log{
	final int SIZE = 300;
	Image LongLog = new Image("file:src/main/resources/images/Actor/LogLong.png", SIZE, SIZE, true, true);
	
	/**
	 * A constructor that initializes the long log within the game scene.
	 * It triggers the super class constructor in {@link Log} that handles the setting of
	 * the log's position and its speed. Then this method will invoke method
	 * {@link #setImage(Image)} to set the image of the long log.
	 * @param xpos An integer representing the X-Coordinate of the long log.
	 * @param ypos An integer representing the Y-Coordinate of the long log.
	 * @param s A double representing the speed of the long log.
	 */
	public LongLog(int xpos, int ypos, double s) {
		super(xpos, ypos, s);
		setImage(LongLog);
	}

	/**
	 * A method that determines the direction of how the long log will enter and keeps looping in the game play.
	 * This method will invoke another method {@link Actor#move(double, double)} to set the movement speed 
	 * of the long log, then it uses method {@link #loopEnterScreenRight(int, int, double)} to ensure the long log
	 * will always reenter the game scene from the right once it exited the scene.
	 */
	@Override
	public void act(long now) {
		move(speed, 0);
		loopEnterScreenRight(700, -300, speed);
	}
}
