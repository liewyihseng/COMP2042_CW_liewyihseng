package p4_group_8_repo.actor;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * Detects the keys pressed by the users
 * @author Liew Yih Seng
 *
 */
public class MovementKeys {

	/**
	 * Determines if the keyboard input is W
	 * @param event A key event that represents the user input's key
	 * @return A boolean stating whether the key input is W
	 */
	public boolean testKeyW(KeyEvent event) {
		return event.getCode() == KeyCode.W;
	}

	/**
	 * Determines if the keyboard input is A
	 * @param event A key event that represents the user input's key
	 * @return A boolean stating whether the key input is A
	 */
	public boolean testKeyA(KeyEvent event) {
		return event.getCode() == KeyCode.A;
	}

	/**
	 * Determines if the keyboard input is S
	 * @param event A key event that represents the user input's key
	 * @return A boolean stating whether the key input is S
	 */
	public boolean testKeyS(KeyEvent event) {
		return event.getCode() == KeyCode.S;
	}

	/**
	 * Determines if the keyboard input is D
	 * @param event A key event that represents the user input's key
	 * @return A boolean stating whether the key input is D
	 */
	public boolean testKeyD(KeyEvent event) {
		return event.getCode() == KeyCode.D;
	}

		
}
