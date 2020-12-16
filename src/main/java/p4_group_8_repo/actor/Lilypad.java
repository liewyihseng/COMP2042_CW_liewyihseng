package p4_group_8_repo.actor;

import javafx.scene.image.Image;

/**
 * Represents the Lilypad in the game play.
 * @author Liew Yih Seng
 *
 */

public class Lilypad extends End{
	/**
	 * A boolean that states whether if the lilypad has been activated.
	 * Activated means a frog has landed on it.
	 */
	protected boolean activated = false;
	Image lilypad = new Image("file:src/main/resources/images/Actor/Lilypad.png", LILYPADSIZE, LILYPADSIZE, true, true);
	Image FrogEnd = new Image("file:src/main/resources/images/Actor/FrogEndFinal.png", LILYPADSIZE, LILYPADSIZE, true, true);
	
	@Override
	public void act(long now) {
		// TODO Auto-generated method stud
	}

	
	/**
	 * A constructor that initializes the {@link Lilypad} class within the game scene.It triggers
	 * the super class {@link End} that handles the setting of its coordinate, then 
	 * invokes the method {@link #setImage(Image)} to set the image of the lilypad.
	 * @param x An integer representing the X-coordinate of the lilypad.
	 * @param y An integer representing the Y-coordinate of the lilypad.
	 */
	public Lilypad(int x, int y) {
		super(x,y);
		setImage(lilypad);
	}
	
	/**
	 * Sets the state of the lilypad where true represents a frog has landed on the lilypad.
	 * It invokes the method {@link #setImage(Image)} to set the image of the lilypad after the frog
	 * has landed on it, then invokes another method {@link #setActivated(boolean)} to state that the
	 * current lilypad has been occupied by the frog and it will no longer cause an increment in the number
	 * of points when users once again lands their frog onto it.
	 */
	public void setEnd() {
		setImage(FrogEnd);
		setActivated(true);
	}

	/**
	 * Gets if the Lilypad is being activated. True means a frog has landed on the lilypad.
	 * @return A boolean which determines the state of the end.
	 */
	public boolean isActivated() {
		return activated;
	}

	/**
	 * Sets the state of the lilypad, whether if is has been activated or not.
	 * @param activated A boolean representing the state of the frog.
	 */
	public void setActivated(boolean activated) {
		this.activated = activated;
	}
	
}
