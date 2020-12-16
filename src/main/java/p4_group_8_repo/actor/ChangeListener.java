package p4_group_8_repo.actor;

import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

/**
 * Represents the textfield that has a limit in the number of character it listens to.
 * @author Liew Yih Seng
 *
 */
public class ChangeListener implements javafx.beans.value.ChangeListener<String>{
	
	private int maxLength;
	private TextField textField;
	
	/**
	 * Construct an instance of {@link ChangeListener}, where it listens to a limited number of characters.
	 * @param textField A TextField that allows user to input.
	 * @param maxLength An integer that represents the maximum number of characters allowed to be input.
	 */
	public ChangeListener(TextField textField, int maxLength) {
		this.textField = textField;
		this.maxLength = maxLength;
	}
	
	/**
	 * Gets the max length of the characters user allowed to input.
	 * @return An integer representing the max length of characters.
	 */
	public int getMaxLength() {
		return maxLength;
	}
	
	/**
	 * Sets the text to be displayed in the textfield created.
	 */
	@Override
	public void changed(ObservableValue<? extends String> ov, String oldValue, String newValue) {
		if(newValue == null) {
			return;
		}
		
		if(newValue.length() > maxLength) {
			textField.setText(oldValue);
		}else {
			textField.setText(newValue);
		}
	}
}
