package p4_group_8_repo.actor;

/**
 * An abstract class that represents both the ends available in game scene.
 * This class is being extended by {@link Crocodile} class and {@link Lilypad} class.
 * @author Liew Yih Seng
 *
 */
public abstract class End extends Actor{
	protected boolean activated = false;
	static final int CROCSIZE = 90;
	static final int LILYPADSIZE = 70;
	
	/**
	 * Sets the coordinate of the end in game scene by invoking the method
	 * {@link #setCoordinate(int, int)}.
	 * @param x An integer representing the X-coordinate of the end
	 * @param y An integer representing the Y-coordinate of the end
	 */
	public End(int x, int y) {
		setCoordinate(x, y);
	}
	
	/**
	 * Represents the inherited method from abstract class {@link Actor}.
	 */
	public abstract void act(long now);
}
 