package p4_group_8_repo;

import java.io.IOException;
import java.util.HashMap;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SceneController {
	private HashMap<String, Pane> screenMap = new HashMap<String, Pane>();
	GameScene gameScene = new GameScene();
	Scene scene;
	FXMLLoader startLoader = new FXMLLoader(getClass().getResource("/views/StartScene.fxml"));
	StartSceneController startScenec = new StartSceneController(this);
	FXMLLoader betweenLoader = new FXMLLoader(getClass().getResource("/views/BetweenLevelScene.fxml"));
	BetweenLevelSceneController betweenLevelScenec = new BetweenLevelSceneController(this);
	FXMLLoader instructionLoader = new FXMLLoader(getClass().getResource("/views/InstructionScene.fxml"));
	InstructionSceneController instructionScenec = new InstructionSceneController(this);
	FXMLLoader menuLoader = new FXMLLoader(getClass().getResource("/views/MenuScene.fxml"));
	MenuSceneController menuScenec = new MenuSceneController(this);
	
	public SceneController(Scene scene) throws IOException {
		this.scene = scene;
		startLoader.setController(startScenec);
		Pane startPane = startLoader.load();
		betweenLoader.setController(betweenLevelScenec);
		Pane betweenPane = betweenLoader.load();
		instructionLoader.setController(instructionScenec);
		Pane instructionPane = instructionLoader.load();
		menuLoader.setController(menuScenec);
		Pane menuPane = menuLoader.load();
		addScene("StartScene", startPane);
		addScene("BetweenLevelScene", betweenPane);
		addScene("InstructionScene", instructionPane);
		addScene("MenuScene", menuPane);
		addScene("GameScene", gameScene.getScene());
		//addScene("BetweenLevelScene", betweenLevelScene.getScene());
		//betweenLevelScene.setSceneController(this);
	}
	
	protected void addScene(String name, Pane pane) {
		screenMap.put(name, pane);
	}
	
	protected void removeScene(String name) {
		screenMap.remove(name);
	}
	
	protected void activate(String name) {
		scene.setRoot(screenMap.get(name));
	}

	protected void resetGame() {
		
		gameScene = new GameScene();
		screenMap.replace("GameScene", gameScene.getScene());
		activate("GameScene");
		
	}

}
