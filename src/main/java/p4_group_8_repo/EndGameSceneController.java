package p4_group_8_repo;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class EndGameSceneController {

	@FXML
	private Pane endGameRoot;
	
	@FXML
	private ImageView highscorebutton;
	
	@FXML
	private ImageView restartbutton;
	
	@FXML
	private ImageView homebutton;
	
	public SceneController scene;
	
	public EndGameSceneController(SceneController scene) {
		this.scene = scene;
	}
	
	@FXML
	void restart(MouseEvent event) throws Exception{
		scene.refreshGame();
		scene.activate("GameScene");
		Main.sceneController.gameScene.displayUsername(Main.getUser().getUsername());
	}
	
	@FXML
	void highScore(MouseEvent event) throws Exception{
		scene.activate("InGameHighScoreScene");
		Main.getHighScore().newScore(Main.getUser().getScore());
	}
	
	@FXML
	void backHome(MouseEvent event) throws Exception{
		scene.activate("StartScene");
		scene.refreshGame();
	}
}
