package p4_group_8_repo;

import java.io.IOException;
import java.util.HashMap;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SceneController {
	private HashMap<String, Scene> screenMap = new HashMap<String, Scene>();
	private Stage primaryStage;
	GameScene gameScene = new GameScene();
	BetweenLevelScene betweenLevelScene = new BetweenLevelScene();
	
	public SceneController(Stage primaryStage) {
		this.primaryStage = primaryStage;
		
		addScene("GameScene", gameScene.getScene());
		addScene("BetweenLevelScene", betweenLevelScene.getScene());
		betweenLevelScene.setSceneController(this);
	}
	
	protected void addScene(String name, Scene scene) {
		screenMap.put(name, scene);
	}
	
	protected void removeScreen(String name) {
		screenMap.remove(name);
	}
	
	protected void activate(String name) {
		this.primaryStage.setScene(screenMap.get(name));
	}

	protected void resetGame() {
		
		gameScene = new GameScene();
		screenMap.replace("GameScene", gameScene.getScene());
		
	}
	
	
}
