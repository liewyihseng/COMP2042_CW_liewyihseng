package p4_group_8_repo.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import p4_group_8_repo.Main;
import p4_group_8_repo.actor.ChangeListener;
import p4_group_8_repo.user.User;

public class StartSceneController implements Initializable{
	public User user = Main.getUser();
	
	@FXML
	private Pane startRoot;
	
	@FXML
	private ImageView startgame;

	@FXML
	private ImageView menu;
	
	@FXML
	private TextField username;
	
	public SceneController scene;
	
	
	public StartSceneController(SceneController scene) {
		this.scene = scene;
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		int maxLength = 13;
		username.textProperty().addListener(new ChangeListener(username, maxLength));
	}
	
	@FXML
	void menuClick(MouseEvent event) throws Exception{
		scene.activate("MenuScene");
	}
	
	@FXML
	void startGame(MouseEvent event) throws Exception{

		if(username.getText() == null || username.getText().trim().isEmpty()) {
			Main.setUser(user);
		}else {
			Main.getUser().setUsername(username.getText());
		}
		System.out.println("Username in Start Scene: " + Main.getUser().getUsername());
		scene.activate("GameScene");
		Main.sceneController.gameScene.displayUsername(Main.getUser().getUsername());
    }
}
