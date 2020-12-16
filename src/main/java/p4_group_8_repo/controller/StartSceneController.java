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

/**
 * A controller that handles all events within the Start Scene.
 * @author Liew Yih Seng
 *
 */
public class StartSceneController implements Initializable{
	/**
	 * Represent the {@link p4_group_8_repo.user.User} in this class.
	 */
	public User user = Main.getUser();
	
	@FXML
	private Pane startRoot;
	
	@FXML
	private ImageView startgame;

	@FXML
	private ImageView menu;
	
	@FXML
	private TextField username;
	
	/**
	 * Represents the {@link SceneController} in this class.
	 */
	public SceneController scene;
	
	/**
	 * A constructor that sets this {@link #scene} to the {@link SceneController#scene} initialized in {@link SceneController} class.
	 * @param scene A {@link SceneController} that represents {@link SceneController} to be passed into this class.
	 */
	public StartSceneController(SceneController scene) {
		this.scene = scene;
	}

	/**
	 * A method where FXML will automatically call onto once this controller has been initialized.
	 * It creates a text field with a limited number of character limit by
	 * invoking the method {@link p4_group_8_repo.actor.ChangeListener}, where in this case
	 * the maximum character limit has been set to 13.
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		int maxLength = 13;
		username.textProperty().addListener(new ChangeListener(username, maxLength));
	}
	
	/**
	 * A method that will allow user to visit the Menu Scene.
	 * It invokes the method {@link SceneController#activate(String)} to activate
	 * and display the Menu Scene.
	 * @param event A {@link MouseEvent} that represents if the user has clicked on this button.
	 * @throws Exception If the source is null.
	 */
	@FXML
	void menuClick(MouseEvent event) throws Exception{
		scene.activate("MenuScene");
	}
	
	/**
	 * This method will allow users to launch the game play.
	 * If a user name has been entered into the text field, the user's user name will be set to
	 * the particular string. If the user has not entered the username, this application will
	 * generate a random string then assigning to the user. Then it will invoke
	 * the method {@link SceneController#activate(String)} to activate
	 * and display the Game Scene.
	 * @param event A {@link MouseEvent} that represents if the user has clicked on this button.
	 * @throws Exception If the source is null.
	 */
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
