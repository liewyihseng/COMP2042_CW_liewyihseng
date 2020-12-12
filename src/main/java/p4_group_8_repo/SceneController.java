package p4_group_8_repo;

import java.io.IOException;
import java.util.HashMap;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

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
	
	FXMLLoader pauseLoader = new FXMLLoader(getClass().getResource("/views/PauseScene.fxml"));
	PauseSceneController pauseScenec = new PauseSceneController(this);
	
	FXMLLoader highscoreLoader = new FXMLLoader(getClass().getResource("/views/HighScoreScene.fxml"));
	HighScoreSceneController highscoreScenec = new HighScoreSceneController(this);
	
	FXMLLoader ingamehighscoreLoader = new FXMLLoader(getClass().getResource("/views/InGameHighScoreScene.fxml"));
	InGameHighScoreSceneController ingamehighscoreScenec = new InGameHighScoreSceneController(this);
	
	FXMLLoader endLoader = new FXMLLoader(getClass().getResource("/views/EndGameScene.fxml"));

	
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
		
		pauseLoader.setController(pauseScenec);
		Pane pausePane = pauseLoader.load();
		
		highscoreLoader.setController(highscoreScenec);
		Pane highscorePane = highscoreLoader.load();
		
		ingamehighscoreLoader.setController(ingamehighscoreScenec);
		Pane ingamehighscorePane = ingamehighscoreLoader.load();
		
		endLoader.setController(betweenLevelScenec);
		Pane endPane = endLoader.load();
		
		addScene("StartScene", startPane);
		addScene("BetweenLevelScene", betweenPane);
		addScene("InstructionScene", instructionPane);
		addScene("MenuScene", menuPane);
		addScene("PauseScene", pausePane);
		addScene("HighScoreScene", highscorePane);
		addScene("InGameHighScoreScene", ingamehighscorePane);
		addScene("EndGameScene", endPane);
		
		addScene("GameScene", gameScene.getScene());
		
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
	
	protected void resumeGame() {
		gameScene.background.start();
		gameScene.start();
		activate("GameScene");
	}

	protected void resetGame() {
		
		gameScene = new GameScene();
		screenMap.replace("GameScene", gameScene.getScene());
		activate("GameScene");
		
	}
	
	protected void refreshGame() {
		Main.setUser(new User());
		gameScene = new GameScene();
		screenMap.replace("GameScene", gameScene.getScene());
	}

}
