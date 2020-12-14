package p4_group_8_repo.actor;

/**
 * An abstract class that represents both the ends available in game scene. This class is being extended by Crocodile class and Lilypad class
 * @author Liew Yih Seng
 *
 */
public abstract class End extends Actor{
	private boolean activated = false;
	static final int CROCSIZE = 90;
	static final int LILYPADSIZE = 70;
	
	/**
	 * Sets the coordinate of the end in game scene
	 * @param x An integer representing the X-coordinate of the end
	 * @param y An integer representing the Y-coordinate of the end
	 */
	public End(int x, int y) {
		setCoordinate(x, y);
	}
	
	/**
	 * Gets if the Lilypad is being activated. True means a frog has landed on the lilypad
	 * @return A boolean which determines the state of the end
	 */
	public boolean isActivated() {
		return activated;
	}
	
	public void setActivated(boolean activated) {
		this.activated = activated;
	}
	
	public abstract void act(long now);
}
 