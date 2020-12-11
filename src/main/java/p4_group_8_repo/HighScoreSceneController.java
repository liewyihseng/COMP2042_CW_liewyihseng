package p4_group_8_repo;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class HighScoreSceneController {
	
	@FXML
	private Pane highscoreRoot;
	
	@FXML
	private ImageView backbutton;
	@FXML
	private TextField top;
	
	public SceneController scene;
	
	
	public HighScoreSceneController(SceneController scene) {
		this.scene = scene;
	}
	
	
	@FXML
	void backMenu(MouseEvent event) throws Exception{
		scene.activate("MenuScene");
	}
}
