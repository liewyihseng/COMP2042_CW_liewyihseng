package p4_group_8_repo;

import java.util.HashMap;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ScreenController {
	private HashMap<String, Scene> screenMap = new HashMap<String, Scene>();
	private Stage primaryStage;
	StartScene startScene = new StartScene();
	GameScene gameScene = new GameScene();
	MenuScene menuScene = new MenuScene();
	//User user = Main.getUser();
	
	public ScreenController(Stage primaryStage) {
		this.primaryStage = primaryStage;
		
		addScreen("StartScene", startScene.getScene());
		addScreen("MenuScene", menuScene.getScene());
		addScreen("GameScene", gameScene.getScene());
		
		activate("StartScene");
		this.primaryStage.show();
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

	
	
}
