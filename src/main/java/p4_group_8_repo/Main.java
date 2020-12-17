package p4_group_8_repo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import p4_group_8_repo.controller.SceneController;
import p4_group_8_repo.user.HighScores;
import p4_group_8_repo.user.User;

/**
 * The Main class of the application.
 * @author Liew Yih Seng
 *
 */
public class Main extends Application {
	/**
	 * Represents the stage for this program.
	 */
	public Stage primaryStage;
	
	/**
	 * Represents the main controller in the program.
	 */
	public static SceneController sceneController;
	private static User user = new User();
	private static HighScores highScore = HighScores.getInstance();
	
	/**
	 * The entry point of this Java program.
	 * @param args A single argument of type String array.
	 */
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * Setup a window for the game to be launched on.
	 */
	@Override
	public void start(Stage primaryStage) throws Exception{
		Pane pane = new Pane();
		Scene scene = new Scene(pane, 600, 800);
		sceneController = new SceneController(scene);
		sceneController.activate("StartScene");
		primaryStage.setTitle("Frogger Arcade");
		primaryStage.setScene(scene);
		primaryStage.getIcons().add(new Image("file:src/main/resources/images/Icon/FrogIcon.png"));
		primaryStage.setResizable(false);
		primaryStage.show();
		
	}

	/**
	 * Sets the current scene to a new scene by using a string.
	 * @param sceneName A string that represents the name of
	 * the scene to be activated.
	 */
	public static void setScene(String sceneName) {
		sceneController.activate(sceneName);
	}
	
	/**
	 * Gets the user in Main class.
	 * @return A User from Main class.
	 */
	public static User getUser() {
		return Main.user;
	}
	
	/**
	 * Sets the user of the Main class.
	 * @param user A User that represents the user to be assigned
	 * to {@link #user}.
	 */
	public static void setUser(User user) {
		Main.user = user;
	}
	
	/**
	 * Gets the highScore in the Main class.
	 * @return A HighScores that represents 
	 * the {@link HighScores} initialized in the Main class.
	 */
	public static HighScores getHighScore() {
		return highScore;
	}

}