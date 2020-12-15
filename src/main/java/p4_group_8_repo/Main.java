package p4_group_8_repo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import p4_group_8_repo.controller.SceneController;
import p4_group_8_repo.user.User;

/**
 * 
 * @author Liew Yih Seng
 *
 */
public class Main extends Application {
	
	public Stage primaryStage;
	public static SceneController sceneController;
	private static User user = new User();
	private static HighScores highScore = new HighScores();
	
	public static void main(String[] args) {
		launch(args);
	}

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

	public static void setScene(String sceneName) {
		sceneController.activate(sceneName);
	}
	
	public static User getUser() {
		return Main.user;
	}
	
	
	public static void setUser(User user) {
		Main.user = user;
	}
	
	public static HighScores getHighScore() {
		return highScore;
	}

	public static void setHighScore(HighScores highScore) {
		Main.highScore = highScore;
	}
}