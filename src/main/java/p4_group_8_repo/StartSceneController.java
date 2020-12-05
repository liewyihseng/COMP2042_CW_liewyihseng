package p4_group_8_repo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class StartSceneController implements Initializable{
	public User user = Main.getUser();
	
	@FXML
	private AnchorPane startRoot;
	
	@FXML
	private ImageView startgame;
	
	@FXML
	private Button startGame;
	
	@FXML
	private ImageView menu;
	
	@FXML
	private TextField username;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		int maxLength = 13;
		username.textProperty().addListener(new ChangeListener(username, maxLength));
	}
	
	@FXML
	void menuClick(MouseEvent event) throws Exception{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/MenuScene.fxml"));
		AnchorPane pane = fxmlLoader.load();
		startRoot.getChildren().setAll(pane);
	}
	
	@FXML
	void startGame(MouseEvent event) throws Exception{

		if(username.getText() == null || username.getText().trim().isEmpty()) {
			Main.setUser(user);
		}else {
			Main.user.setUsername(username.getText());
		}
		
		Main.setScene("GameScene");
		Main.scene.gameScene.displayUsername(Main.user.getUsername());
    }
}
