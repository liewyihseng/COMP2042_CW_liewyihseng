package p4_group_8_repo.actor;

import javafx.scene.image.Image;

/**
 * A class representing the Non Sinking Turtle within the game scene.
 * @author Liew Yih Seng
 *
 */
public class NonSinkingTurtle extends Actor implements Turtle{
	Image turtle1 = new Image("file:src/main/resources/images/Actor/TurtleAnimation1.png", WIDTH, HEIGHT, true, true);
	Image turtle2 = new Image("file:src/main/resources/images/Actor/TurtleAnimation2.png", WIDTH, HEIGHT, true, true);
	Image turtle3 = new Image("file:src/main/resources/images/Actor/TurtleAnimation3.png", WIDTH, HEIGHT, true, true);
	private double speed;
	
	/**
	 * A method that determines the direction of how the non sinking turtle will enter and keeps looping
	 * in the game play. It uses an if else statement to determine the suitable image of the non sinking
	 * turtle corresponding to the current clock tick. It invokes the method {@link Actor#loopEnterScreenRight(int, int, double)}
	 * to manage the looping are always in the manner from right to left and always
	 * reenter the screen once it exited. It will also invoke another method {@link Actor#move(double, double)} to
	 * set the movement speed of the non sinking turtle.
	 */
	@Override
	public void act(long now) {

				if (now/TICK % 3 ==0) {
					setImage(turtle2);
					
				}
				else if (now/TICK % 3 == 1) {
					setImage(turtle1);
					
				}
				else if (now/TICK %3 == 2) {
					setImage(turtle3);
					
				}
			
		move(speed , 0);
		loopEnterScreenRight(600, -130, speed);
	}
	
	/**
	 * A constructor that initializes the non sinking turtle within the game scene.
	 * It invokes the method {@link #setCoordinate(int, int)} that handles the setting of
	 * the position of the non sinking turtle within the game scene then invokes the method
	 * {@link #setImage(Image)} to set the image of the non sinking turtle.
	 * @param xpos An integer representing the X-Coordinate of the non sinking turtle.
	 * @param ypos An integer representing the Y-Coordinate of the non sinking turtle.
	 * @param s A double that represents the speed of movement of the non sinking turtle.
	 */
	public NonSinkingTurtle(int xpos, int ypos, double s) {
		setCoordinate(xpos, ypos);
		speed = s;
		setImage(turtle2);
	}
	
}
