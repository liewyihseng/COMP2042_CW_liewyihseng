package p4_group_8_repo;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class PauseSceneController {
	@FXML
	private Pane pauseRoot;
	
	@FXML
	private ImageView resumebutton;
	
	@FXML
	private ImageView highscorebutton;
	
	@FXML
	private ImageView homebutton;
	public SceneController scene;

	
	public PauseSceneController(SceneController scene) {
		this.scene = scene;
	}
	
	@FXML
	void resume(MouseEvent event) throws Exception{
		scene.resumeGame();
	}
	
	@FXML
	void highScore(MouseEvent event) throws Exception{
		scene.activate("InGameHighScoreScene");
	}
	
	@FXML
	void backHome(MouseEvent event) throws Exception{
		scene.activate("StartScene");
		scene.refreshGame();
	}
	
}
