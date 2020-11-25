package p4_group_8_repo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class StartPageController {
	@FXML
	private AnchorPane startRoot;
	
	@FXML
	private ImageView menubutton;
	
	@FXML
	private ImageView startbutton;
	
	@FXML
	private LimitedTextField usernameField;
	
	@FXML
	private Button menuButton;
	
	@FXML
	private Button startButton;
	
	@FXML
	void menuButton(MouseEvent event) throws Exception{
		//FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Menu.fxml"));
		//AnchorPane pane = fxmlLoader.load();
		//MenuController controller = fxmlLoader.<MenuController>getController();
		//startRoot.getChildren().setAll(pane);
		System.out.println("Testing Menu Button");
	}
	
	@FXML
	void startButton(MouseEvent event) throws Exception{
		//FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Gameplay.fxml"));
		//AnchorPane pane = fxmlLoader.load();
		//GameController controller = fxmlLoader.<GameController>getController();
		//startRoot.getChildren().setAll(pane);
		System.out.println("Testing Start Button");
	}
}
