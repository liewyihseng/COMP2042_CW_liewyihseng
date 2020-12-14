package p4_group_8_repo;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class BetweenLevelSceneController {
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
	
	public SceneController scene;
	
	public HighScores highScores = Main.getHighScore();

	public InGameHighScoreSceneController ingameController = new InGameHighScoreSceneController(highScores);
	
	
	public BetweenLevelSceneController(SceneController scene) {
		this.scene = scene;
	}
	
	@FXML
	void restart(MouseEvent event) throws Exception{
		scene.refreshGame();
		scene.activate("GameScene");
		Main.sceneController.gameScene.displayUsername(Main.getUser().getUsername());
	}
	
	@FXML
	void nextLevel(MouseEvent event) throws Exception{
		scene.resetGame();
		Main.sceneController.gameScene.displayUsername(Main.getUser().getUsername());
	}
	
	@FXML
	void highScore(MouseEvent event) throws Exception{
		ingameController.setScoreText();
		scene.activate("InGameHighScoreScene");
	}
	
	@FXML
	void backHome(MouseEvent event) throws Exception{
		scene.activate("StartScene");
		scene.refreshGame();
	}

}
