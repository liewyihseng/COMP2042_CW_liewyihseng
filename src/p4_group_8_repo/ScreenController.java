package p4_group_8_repo;

import java.util.HashMap;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ScreenController {
	private HashMap<String, Scene> screenMap = new HashMap<>();
	private Stage primaryStage;
	
	public ScreenController(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	protected void addScreen(String name, Scene scene) {
		screenMap.put(name, scene);
	}
	
	protected void removeScreen(String name) {
		screenMap.remove(name);
	}
	
	protected void activate(String name) {
		primaryStage.setScene(screenMap.get(name));
	}
	
	
}
