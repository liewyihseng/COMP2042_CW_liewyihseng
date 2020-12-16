package p4_group_8_repo.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * A controller that handles all the events within the Menu Scene.
 * @author Liew Yih Seng
 *
 */
public class MenuSceneController {
	@FXML
	private Pane menuRoot;
	
	@FXML
	private ImageView homebutton;
	
	@FXML
	private ImageView highscorebutton;
	
	@FXML
	private ImageView instructionbutton;
	
	@FXML
	private ImageView quitbutton;
	
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
	public MenuSceneController(SceneController scene) {
		this.scene = scene;
	}
	
	/**
	 * A method that sets this highScoreController to the highScoreController in class {@link HighScoreSceneController}.
	 * @param highScoreController A {@link HighScoreSceneController} that represents the {@link HighScoreSceneController} in this project.
	 */
	public void setHighScoreController(HighScoreSceneController highScoreController) {
		this.highScoreController = highScoreController;
	}
	
	/**
	 * A method that allows users to go back home from the Menu Scene.
	 * It invokes the method {@link SceneController#activate(String)} to activate
	 * and display the Start Scene.
	 * @param event A {@link MouseEvent} that represents if the user has clicked on this button.
	 * @throws Exception If the source is null.
	 */
	@FXML
	void backHome(MouseEvent event) throws Exception{
		scene.activate("StartScene");
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
	 * A method that allows users to go to the instruction page from the Menu Scene.
	 * It invokes the method {@link SceneController#activate(String)} to activate
	 * and display the Instruction Scene.
	 * @param event A {@link MouseEvent} that represents if the user has clicked on this button.
	 * @throws Exception If the source is null.
	 */
	@FXML
	void instruction(MouseEvent event) throws Exception{
		scene.activate("InstructionScene");
	}
	
	/**
	 * A method that allows users to quit this application.
	 * It invokes {@link javafx.application.Platform#exit()} to close
	 * the tab of this application.
	 * @param event A {@link MouseEvent} that represents if the user has clicked on this button.
	 * @throws Exception If the source is null.
	 */
	@FXML
	void quit(MouseEvent event) throws Exception{
		Platform.exit();
	}
}
