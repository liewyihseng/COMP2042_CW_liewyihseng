package p4_group_8_repo.controller;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import p4_group_8_repo.Main;

/**
 * A controller that handles all events within the Pause Scene.
 * @author Liew Yih Seng
 *
 */
public class PauseSceneController {
	@FXML
	private Pane pauseRoot;
	
	@FXML
	private ImageView resumebutton;
	
	@FXML
	private ImageView highscorebutton;
	
	@FXML
	private ImageView homebutton;
	
	/**
	 * Represents the {@link SceneController} in this class.
	 */
	public SceneController scene;
	
	/**
	 * Represents the {@link HighScoreSceneController} in this class.
	 */
	public HighScoreSceneController highScoreController;

	/**
	 * A constructor that sets this {@link #scene} to the {@link SceneController#scene} initialized in {@link SceneController} class.
	 * @param scene A {@link SceneController} that represents {@link SceneController} to be passed into this class.
	 */
	public PauseSceneController(SceneController scene) {
		this.scene = scene;
	}
	
	/**
	 * A method that sets this {@link #highScoreController} to the highScoreController in class {@link HighScoreSceneController}.
	 * @param highScoreController A {@link HighScoreSceneController} that represents the {@link HighScoreSceneController} in this project.
	 */
	public void setHighScoreController(HighScoreSceneController highScoreController) {
		this.highScoreController = highScoreController;
	}
	
	/**
	 * A method that allows users to resume their game play.
	 * It invokes a method in {@link SceneController#resumeGame()} that
	 * starts the {@link p4_group_8_repo.GameScene} by invoking 
	 * {@link p4_group_8_repo.MyStage#start()} and {@link p4_group_8_repo.GameScene#start()}.
	 * Then invoking the {@link SceneController#activate(String)} to activate and display the
	 * Start Scene.
	 * @param event A {@link MouseEvent} that represents if the user has clicked on this button.
	 * @throws Exception If the source is null.
	 */
	@FXML
	void resume(MouseEvent event) throws Exception{
		scene.resumeGame();
	}
	
	/**
	 * A method that triggers the method {@link HighScoreSceneController#setScoreText()}
	 * that sets the high score list into the most updated version of high score list, before invoking
	 * the method {@link SceneController#activate(String)} to activate and display the High Score Scene.
	 * @param event A {@link MouseEvent} that represents if the user has clicked on this button.
	 * @throws Exception If the source is null.
	 */
	@FXML
	void highScore(MouseEvent event) throws Exception{
		highScoreController.setScoreText();
		scene.activate("HighScoreScene");
	}
	
	/**
	 * A method that triggers the method {@link p4_group_8_repo.user.User#setLevel(int)} that
	 * resets the user level to level 1 once the user has opted to go back home. This method has allowed
	 * user to maintain the same identity(username) throughout their interaction in the game. It will then
	 * invoke the method {@link SceneController#activate(String)} to activate and display the Start Scene.
	 * In the mean time, the {@link p4_group_8_repo#GameScene} has been refreshed by invoking the
	 * method {@link SceneController#refreshGame()} in class {@link SceneController}.
	 * @param event A {@link MouseEvent} that represents if the user has clicked on this button.
	 * @throws Exception If the source is null.
	 */
	@FXML
	void backHome(MouseEvent event) throws Exception{
		Main.getUser().setLevel(1);
		scene.activate("StartScene");
		scene.refreshGame();
	}
	
}
