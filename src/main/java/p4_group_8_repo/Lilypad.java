package p4_group_8_repo;

import javafx.scene.image.Image;

/**
 * Represents the Lilypad in the game scene
 * @author Liew Yih Seng
 *
 */

public class Lilypad extends End{

	Image lilypad = new Image("file:src/main/resources/images/Actor/Lilypad.png", LILYPADSIZE, LILYPADSIZE, true, true);
	Image FrogEnd = new Image("file:src/main/resources/images/Actor/FrogEndFinal.png", LILYPADSIZE, LILYPADSIZE, true, true);
	@Override
	public void act(long now) {
		// TODO Auto-generated method stud
	}
	
	/**
	 * A constructor that instantiates the Lilypad class within the gamescene
	 * @param x An integer representing the X-coordinate of the lilypad
	 * @param y An integer representing the Y-coordinate of the lilypad
	 */
	public Lilypad(int x, int y) {
		super(x,y);
		setImage(lilypad);
	}
	
	/**
	 * Sets the state of the lilypad where true represents a frog has landed on the lilypad
	 */
	public void setEnd() {
		setImage(FrogEnd);
		setActivated(true);
	}
	
}
