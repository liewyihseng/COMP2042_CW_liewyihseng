package p4_group_8_repo.controller;

import javafx.scene.input.MouseEvent;

/**
 * An interface that acts an abstract factory for creating pages navigation families of related or dependent objects
 * without specifying the concrete class.
 * @author Liew Yih Seng
 *
 */
public interface PagesNavAbstractFactory {

	/**
	 * A method that triggers the method {@link InGameHighScoreSceneController#setScoreText()}
	 * that sets the high score list into the most updated version of high score list, before invoking
	 * the method {@link SceneController#activate(String)} to activate and display the In Game High Score Scene.
	 * @param event A {@link MouseEvent} that represents if the user has clicked on this button.
	 * @throws Exception If the source is null.
	 */
	void highScore(MouseEvent event) throws Exception;

	/**
	 * A method that triggers the method {@link p4_group_8_repo.user.User#setLevel(int)} that
	 * resets the user level to level 1 once the user has opted to go back home. This method has allowed
	 * user to maintain the same identity(username) throughout their interaction in the game. It will then
	 * invoke the method {@link SceneController#activate(String)} to activate and display the Start Scene.
	 * In the mean time, the {@link p4_group_8_repo.GameScene} has been refreshed by invoking the
	 * method {@link SceneController#refreshGame()} in class {@link SceneController}.
	 * @param event A {@link MouseEvent} that represents if the user has clicked on this button.
	 * @throws Exception If the source is null.
	 */
	void backHome(MouseEvent event) throws Exception;

}