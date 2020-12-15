package p4_group_8_repo.actor.obstacle;

import p4_group_8_repo.actor.Actor;

/**
 * A class that extends the {#link p4_group_8_repo.actor.Actor} that represents
 * objects that will cause death to the frog when it hits the frog during game play.
 * @author Liew Yih Seng
 *
 */
public class Obstacle extends Actor {
	private double speed;
	
	/**
	 * A method that sets determines the direction of the Obstacle will enter and keeps looping in the game play.
	 * It calls the method {@link p4_group_8_repo.actor.Actor#loopEnterScreen(int, int, int, int, double)}
	 * to decide the direction of the entering and manages the looping in the game scene.This method will invoke 
	 * another method {@link p4_group_8_repo.actor.Actor#move(double, double)} to set the movement speed of the obstacles.
	 * 
	 */
	@Override
	public void act(long now) {
		move(speed , 0);
		loopEnterScreen(-200, 600, 600, -50, speed);
	}
	
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
