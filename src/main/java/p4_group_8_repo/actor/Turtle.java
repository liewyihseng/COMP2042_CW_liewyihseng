package p4_group_8_repo.actor;

/**
 * An interface containing method and constants that should
 * be implemented by classes implementing the Turtle interface.
 * @author Liew Yih Seng
 *
 */
public interface Turtle {
		/**
		 * The constant representing horizontal width of the turtle.
		 */
		final int WIDTH = 140;
		
		/**
		 * The constant representing vertical height of the turtle.
		 */
		final int HEIGHT = 140;

		/**
		 * The constant representing the clock tick.
		 */
		static final int TICK = 900000000;
		
		/**
		 * A method that determines how the object should act correspondingly to the clock tick.
		 * @param now A long integer that represents the clock tick.
		 */
		void act(long now);

}
