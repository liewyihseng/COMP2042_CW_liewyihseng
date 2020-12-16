package p4_group_8_repo.actor;

/**
 * An abstract class that acts as the super class to both the ends available in game.
 * This class is being extended by {@link Crocodile} class and {@link Lilypad} class.
 * @author Liew Yih Seng
 *
 */
public abstract class End extends Actor{
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

	public abstract void act(long now);
}
 