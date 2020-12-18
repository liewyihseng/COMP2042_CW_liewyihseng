package p4_group_8_repo.controller;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import p4_group_8_repo.Main;
import p4_group_8_repo.user.User;

/**
 * A controller that handles all events within the Between Level Scene.
 * @author Liew Yih Seng
 *
 */
public class BetweenLevelSceneController implements PagesNavAbstractFactory {
	
	@FXML
	private Pane betweenLevelRoot;
	
	@FXML
	private Pane endGameRoot;
	
	@FXML
	private ImageView restartbutton;
	
	@FXML
	private ImageView nextlevelbutton;
	
	@FXML
	private ImageView highscorebutton;
	
	@FXML
	private ImageView homebutton;
	
	/**
	 * Represents the {@link SceneController} in this class.
	 */
	public SceneController scene;
	
	/**
	 * Represents the {@link InGameHighScoreSceneController} in this class.
	 */
	public InGameHighScoreSceneController ingameController;
	
	/**
	 * A constructor that sets this {@link #scene} to the {@link SceneController#scene} initialized in {@link SceneController} class.
	 * @param scene A {@link SceneController} that represents {@link SceneController} to be passed into this class.
	 */
	public BetweenLevelSceneController(SceneController scene) {
		this.scene = scene;
	}
	
	/**
	 * A method that sets this {@link #ingameController} to the ingameController in class {@link InGameHighScoreSceneController}.
	 * @param ingameController An {@link InGameHighScoreSceneController} that represents the {@link InGameHighScoreSceneController} in this project.
	 */
	public void setInGameController(InGameHighScoreSceneController ingameController) {
		this.ingameController = ingameController;
	}
	
	/**
	 * A method that handles the restart of game play when the user felt like restarting.
	 * It invokes method {@link SceneController#refreshGame()} that resets the user data,
	 * then replacing the current {@link p4_group_8_repo.GameScene} with a new {@link p4_group_8_repo.GameScene} for user to have
	 * a fresh start.
	 * @param event A {@link MouseEvent} that represents if the user has clicked on this button.
	 * @throws Exception If the source is null.
	 */
	@FXML
	public void restart(MouseEvent event) throws Exception{
		Main.setUser(new User(Main.getUser().getUsername()));
		Main.getUser().setScore(0);
		Main.getUser().setLevel(1);
		scene.resetGame();
		scene.activate("GameScene");
		Main.sceneController.gameScene.displayUsername(Main.getUser().getUsername());
	}
	
	/**
	 * A method that handles the linking the user form the ended level to the next level.
	 * It invokes method {@link SceneController#resetGame()} that refreshes the {@link p4_group_8_repo.GameScene},
	 * then allowing the user to progress into the next level with the same set of score the user has.
	 * @param event A {@link MouseEvent} that represents if the user has clicked on this button.
	 * @throws Exception If the source is null.
	 */
	@FXML
	public void nextLevel(MouseEvent event) throws Exception{
		scene.resetGame();
		Main.sceneController.gameScene.displayUsername(Main.getUser().getUsername());
	}
	
	/**
	 * A method that triggers the method {@link InGameHighScoreSceneController#setScoreText()}
	 * that sets the high score list into the most updated version of high score list, before invoking
	 * the method {@link SceneController#activate(String)} to activate and display the In Game High Score Scene.
	 * @param event A {@link MouseEvent} that represents if the user has clicked on this button.
	 * @throws Exception If the source is null.
	 */
	@Override
	@FXML
	public void highScore(MouseEvent event) throws Exception{
		ingameController.setScoreText();
		scene.activate("InGameHighScoreScene");
	}
	
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
	@Override
	@FXML
	public void backHome(MouseEvent event) throws Exception{
		Main.getUser().setScore(0);
		Main.getUser().setLevel(1);
		scene.activate("StartScene");
		scene.refreshGame();
	}

}
