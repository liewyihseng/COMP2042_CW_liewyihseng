package p4_group_8_repo.controller;

import javafx.scene.input.MouseEvent;

/**
 * An interface that acts an abstract factory for creating high score pages families of related or dependent objects
 * without specifying the concrete class.
 * @author Liew Yih Seng
 *
 */
public interface HighScoreControllerAbstractFactory {

	/**
	 * A method that allows user to go back to the Menu Scene or the Pause Scene
	 * depending whether the user is in game or not by using the method 
	 * {@link p4_group_8_repo.user.User#isInGame()}. If a true has been returned,
	 * it will invoke the method {@link SceneController#activate(String)} to activate
	 * and display the Pause Scene. If it returns false, it will activate and displays the
	 * MenuScene.
	 * @param event A {@link MouseEvent} that represents if the user has clicked on this button.
	 * @throws Exception If the source is null.
	 */
	void backMenu(MouseEvent event) throws Exception;

	/**
	 * A method the sets the high score list into the most updated version of the list.
	 */
	void setScoreText();

}