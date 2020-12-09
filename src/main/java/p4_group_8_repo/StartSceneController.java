package p4_group_8_repo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class StartSceneController implements Initializable{
	public User user = Main.getUser();
	
	@FXML
	private Pane startRoot;
	
	@FXML
	private ImageView startgame;
	
	@FXML
	private Button startGame;
	
	@FXML
	private ImageView menu;
	
	@FXML
	private TextField username;
	
	public SceneController screen;
	
	public StartSceneController(SceneController scene) {
		this.screen = scene;
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		int maxLength = 13;
		username.textProperty().addListener(new ChangeListener(username, maxLength));
	}
	
	@FXML
	void menuClick(MouseEvent event) throws Exception{
		screen.activate("MenuScene");
	}
	
	@FXML
	void startGame(MouseEvent event) throws Exception{

		if(username.getText() == null || username.getText().trim().isEmpty()) {
			Main.setUser(user);
		}else {
			Main.user.setUsername(username.getText());
		}
		
		screen.activate("GameScene");
		Main.sceneController.gameScene.displayUsername(Main.user.getUsername());
    }
}
