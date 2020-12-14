package p4_group_8_repo.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

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
	public SceneController scene;
	public HighScoreSceneController highScoreController;
	
	public MenuSceneController(SceneController scene) {
		this.scene = scene;
	}
	
	public void setHighScoreController(HighScoreSceneController highScoreController) {
		this.highScoreController = highScoreController;
	}
	
	@FXML
	void backHome(MouseEvent event) throws Exception{
		scene.activate("StartScene");
	}
	
	@FXML
	void highScore(MouseEvent event) throws Exception{
		highScoreController.setScoreText();
		scene.activate("HighScoreScene");
	}
	
	@FXML
	void instruction(MouseEvent event) throws Exception{
		scene.activate("InstructionScene");
	}
	
	@FXML
	void quit(MouseEvent event) throws Exception{
		Platform.exit();
	}
}