package p4_group_8_repo;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class InGameHighScoreSceneController {

	@FXML
	private Pane ingamehighscoreRoot;
	
	@FXML
	private ImageView submitbutton;
	
	@FXML
	private ImageView backbutton;
	
	public SceneController scene;
	
	public User user = Main.getUser();
	
	public InGameHighScoreSceneController(SceneController scene) {
		this.scene = scene;
	}
	
	@FXML
	void submit(MouseEvent event) {
		Main.getHighScore().newScore(Main.getUser().getScore());
		scene.activate("StartScene");
	}
	
	@FXML
	void backMenu(MouseEvent event) {
		if(Main.getUser().isInGame()) {
			scene.activate("PauseScene");
		}else {
			if(Main.getUser().getLevel() <= 10) {
				scene.activate("BetweenLevelScene");
			}else {
				scene.activate("EndGameScene");
			}
		}
	}

}
