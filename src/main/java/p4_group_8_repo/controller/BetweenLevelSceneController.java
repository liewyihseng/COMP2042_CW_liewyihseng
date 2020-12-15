package p4_group_8_repo.controller;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import p4_group_8_repo.HighScores;
import p4_group_8_repo.Main;

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

	public InGameHighScoreSceneController ingameController;
	
	
	public BetweenLevelSceneController(SceneController scene) {
		this.scene = scene;
	}
	
	public void setInGameController(InGameHighScoreSceneController ingameController) {
		this.ingameController = ingameController;
	}
	
	@FXML
	void restart(MouseEvent event) throws Exception{
		scene.refreshGame();
		scene.activate("GameScene");
		Main.getUser().setLevel(1);
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
		Main.getUser().setLevel(1);
		scene.activate("StartScene");
		scene.refreshGame();
	}

}
