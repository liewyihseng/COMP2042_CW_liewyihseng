package p4_group_8_repo.actor;

import javafx.scene.image.Image;

public class SinkingTurtle extends Actor implements Turtle{
	Image turtle1 = new Image("file:src/main/resources/images/Actor/WetTurtleAnimation2.png", WIDTH, HEIGHT, true, true);
	Image turtle2 = new Image("file:src/main/resources/images/Actor/WetTurtleAnimation1.png", WIDTH, HEIGHT, true, true);
	Image turtle3 = new Image("file:src/main/resources/images/Actor/WetTurtleAnimation3.png", WIDTH, HEIGHT, true, true);
	Image turtle4 = new Image("file:src/main/resources/images/Actor/WetTurtleAnimation4.png", WIDTH, HEIGHT, true, true);
	private double speed;
	private boolean sunk = false;
	
	/**
	 * A method that determines the direction of how the sinking turtle will enter
	 * and keeps looping in the game play. It uses an if else statement to determine
	 * the current phase of the sinking turtle, either the sinking turtle is currently sinking or not sinking.
	 * It invokes the method {@link Actor#loopEnterScreenRight(int, int, double)}
	 * to manage the looping are always in the manner from right to left and always reenter the screen once it exited.
	 * It will also invoke another method {@link Actor#move(double, double)} to set the movement speed of the sinking turtle.
	 * 
	 */
	@Override
	public void act(long now) {

				if (now/TICK  % 4 ==0) {
					setImage(turtle2);
					sunk = false;
				}
				else if (now/TICK % 4 == 1) {
					setImage(turtle1);
					sunk = false;
				}
				else if (now/TICK %4 == 2) {
					setImage(turtle3);
					sunk = false;
				}
				else if (now/TICK %4 == 3) {
					setImage(turtle4);
					sunk = true;
				}
			
		move(speed , 0);
		loopEnterScreenRight(600, -130, speed);
	}
	
	/**
	 * A constructor that initiates the sinking turtle within the game scene.
	 * It invokes the method {@link #setCoordinate(int, int)} that handles the setting of
	 * the position of the sinking turtle within the game scene then invokes the method
	 * {@link #setImage(Image)} to set the image of the sinking turtle.
	 * @param xpos An integer representing the X-Coordinate of the sinking turtle.
	 * @param ypos An integer representing the Y-Coordinate of the sinking turtle.
	 * @param s A double that represents the speed of the sinking turtle.
	 */
	public SinkingTurtle(int xpos, int ypos, double s) {
		setCoordinate(xpos, ypos);
		speed = s;
		setImage(turtle2);
	}
	
	/**
	 * Gets if the sinking turtle is currently sinking.
	 * As this sinking phase of the sinking turtle will cause death to the frog
	 * if the frog lands on the sinking turtle when sunk is true.
	 * @return A boolean stating if the sinking turtle is currently sinking.
	 */
	public boolean isSunk() {
		return sunk;
	}
}
