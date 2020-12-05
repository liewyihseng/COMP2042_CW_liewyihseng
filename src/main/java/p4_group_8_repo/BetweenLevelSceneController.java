package p4_group_8_repo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
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
	
	public SceneController screen;
	public User user = Main.getUser();
	
	@FXML
	void nextLevel(MouseEvent event) throws Exception{
		screen.resetGame();
		screen.activate("GameScene");
		Main.scene.gameScene.displayUsername(Main.getUser().getUsername());
	}
	
	@FXML
	void highScore(MouseEvent event) throws Exception{
		System.out.println("High Score Button Successful");
	}
	
	@FXML
	void backHome(MouseEvent event) throws Exception{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("views/StartScene.fxml"));
		Pane pane = fxmlLoader.load();
		betweenLevelRoot.getChildren().setAll(pane);
	}
	
}
