package p4_group_8_repo;

import java.util.HashMap;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ScreenController {
	private HashMap<String, Scene> screenMap = new HashMap<String, Scene>();
	private Stage primaryStage;
	GameScene gameScene = new GameScene();
	BetweenLevelScene betweenLevelScene = new BetweenLevelScene();
	//User user = Main.getUser();
	
	public ScreenController(Stage primaryStage) {
		this.primaryStage = primaryStage;
		
		addScreen("GameScene", gameScene.getScene());
		addScreen("BetweenLevelScene", betweenLevelScene.getScene());
		betweenLevelScene.setSceneController(this);
		//this.primaryStage.show();
	}
	
	protected void addScreen(String name, Scene scene) {
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
