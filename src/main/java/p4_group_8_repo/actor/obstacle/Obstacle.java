package p4_group_8_repo.actor.obstacle;

import p4_group_8_repo.actor.Actor;

/**
 * An abstract class that extends the {@link p4_group_8_repo.actor.Actor} and 
 * adheres the prototype design pattern. A prototype design pattern in this class
 * help us developers to hide the complexity of making new
 * instances out of this class. This class will represent
 * objects that will cause death to the frog when it hits the frog during game play.
 * @author Liew Yih Seng
 *
 */
public abstract class Obstacle extends Actor {
	/**
	 * A double that represents the speed of movement of the obstacle.
	 */
	protected double speed;
	
	/**
	 * A constructor that initializes the initial position of the obstacle by invoking the
	 * {@link p4_group_8_repo.actor.Actor#setCoordinate(int, int)} then setting the speed
	 * of movement of the obstacles during game play.
	 * @param xpos An integer representing the X-Coordinate of the obstacle.
	 * @param ypos An integer representing the Y-Coordinate of the obstacle.
	 * @param s A double representing the speed of the movement of the obstacle.
	 */
	public Obstacle(int xpos, int ypos, double s) {
		setCoordinate(xpos, ypos);
		speed = s;
	}

}
