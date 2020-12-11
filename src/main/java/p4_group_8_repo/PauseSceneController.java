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
	public SceneController screen;

	
	public PauseSceneController(SceneController scene) {
		this.screen = scene;
	}
	
	@FXML
	void resume(MouseEvent event) throws Exception{
		screen.resumeGame();
	}
	
	@FXML
	void highScore(MouseEvent event) throws Exception{
		System.out.println("High Score testing Successfully");
	}
	
	@FXML
	void backHome(MouseEvent event) throws Exception{
		screen.activate("StartScene");
		screen.refreshGame();
	}
	
}
