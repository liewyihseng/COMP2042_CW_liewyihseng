package p4_group_8_repo;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class BetweenLevelSceneController {
	@FXML
	private Pane betweenLevelRoot;
	
	@FXML
	private ImageView nextlevelbutton;
	
	@FXML
	private ImageView highscorebutton;
	
	@FXML
	private ImageView homebutton;
	
	public SceneController scene;
	public User user = Main.getUser();
	
	public BetweenLevelSceneController(SceneController scene) {
		this.scene = scene;
	}
	
	@FXML
	void nextLevel(MouseEvent event) throws Exception{
		scene.resetGame();
		Main.sceneController.gameScene.displayUsername(Main.getUser().getUsername());
	}
	
	@FXML
	void highScore(MouseEvent event) throws Exception{
		Main.getHighScore().newScore(Main.getUser().getScore());
		System.out.println("High Score Button Successful");
	}
	
	@FXML
	void backHome(MouseEvent event) throws Exception{
		scene.activate("StartScene");
		scene.refreshGame();
	}
	
}
