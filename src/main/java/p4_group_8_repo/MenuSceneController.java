package p4_group_8_repo;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class MenuSceneController {
	@FXML
	private AnchorPane menuRoot;
	
	@FXML
	private ImageView homebutton;
	
	@FXML
	private ImageView highscorebutton;
	
	@FXML
	private ImageView instructionbutton;
	
	@FXML
	private ImageView quitbutton;
	
	@FXML
	void backHome(MouseEvent event) throws Exception{
		FXMLLoader menuLoader = new FXMLLoader(getClass().getResource("/views/StartScene.fxml"));
		AnchorPane pane = menuLoader.load();
		menuRoot.getChildren().setAll(pane);
	}
	
	@FXML
	void highScore(MouseEvent event) throws Exception{
		System.out.println("High Score Scenebuilder working");
	}
	
	@FXML
	void instruction(MouseEvent event) throws Exception{
		FXMLLoader instructionLoader = new FXMLLoader(getClass().getResource("/views/InstructionScene.fxml"));
		AnchorPane pane = instructionLoader.load();
		menuRoot.getChildren().setAll(pane);
	}
	
	@FXML
	void quit(MouseEvent event) throws Exception{
		Platform.exit();
	}
}
