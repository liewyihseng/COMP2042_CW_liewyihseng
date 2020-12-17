package p4_group_8_repo.controller;

import java.io.IOException;
import java.util.HashMap;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import p4_group_8_repo.GameScene;
import p4_group_8_repo.Main;
import p4_group_8_repo.user.User;

/**
 * A controller that acts as the main controller that handles all other 
 * controllers that existed within this project.
 * @author Liew Yih Seng
 *
 */
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
	HighScoreControllerAbstractFactory highscoreScenec = new HighScoreSceneController(this);
	
	FXMLLoader ingamehighscoreLoader = new FXMLLoader(getClass().getResource("/views/InGameHighScoreScene.fxml"));
	InGameHighScoreSceneController ingamehighscoreScenec = new InGameHighScoreSceneController(this);
	
	FXMLLoader endLoader = new FXMLLoader(getClass().getResource("/views/EndGameScene.fxml"));

	/**
	 * A constructor that handles all the assignments of controllers to their
	 * respective FXML pages then prepare them to be ready for activation.
	 * Besides, it will also handle the linking of the key value pair of the {@link Pane}
	 * to their respective names.
	 * @param scene A Scene that represents the place to hold these panes.
	 * @throws IOException It the IO Operation fails.
	 */
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
		
		betweenLevelScenec.setInGameController(ingamehighscoreScenec);
		menuScenec.setHighScoreController(highscoreScenec);
		pauseScenec.setHighScoreController(highscoreScenec);
		
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
	
	/**
	 * This method links a {@link Pane} up with a string in the form of key value concept hash map.
	 * @param name A string that represents the name of the root to be added into the hash map.
	 * @param pane A {@link Pane} that represents the {@link Pane} to be linked with the name.
	 */
	protected void addScene(String name, Pane pane) {
		screenMap.put(name, pane);
	}
	
	/**
	 * This method removes a {@link Pane} off the {@link SceneController#screenMap}
	 * in this class.
	 * @param name A string that represents the name of the {@link Pane} to be removed.
	 */
	protected void removeScene(String name) {
		screenMap.remove(name);
	}
	
	/**
	 * This method will set this {@link Pane} to a new {@link Pane}
	 * that has been initialized within this class.
	 * @param name A string that represents the name of the {@link Pane}.
	 */
	public void activate(String name) {
		scene.setRoot(screenMap.get(name));
	}
	
	/**
	 * This method allows users to resume their game when they paused
	 * the game play by clicking onto the resume button on the Pause Scene.
	 * It will invoke method {@link p4_group_8_repo.MyStage#start()} and
	 * {@link p4_group_8_repo.GameScene#start()} then the method
	 * {@link #activate(String)} to activate the GameScene.
	 */
	protected void resumeGame() {
		gameScene.getBackground().start();
		gameScene.start();
		activate("GameScene");
		Main.getUser().setInGame(true);
	}

	/**
	 * This method will replace the existing Game Scene with
	 * a new Game Scene where users will immediately be redirected
	 * to a new Game Scene with their scores set to 0 and level
	 * being set to 1.
	 */
	protected void resetGame() {
		gameScene = new GameScene();
		Main.getUser().getAnimal().setPoints(Main.getUser().getScore());
		screenMap.replace("GameScene", gameScene.getScene());
		activate("GameScene");
		
	}
	
	/**
	 * This method will replace the existing Game Scene with
	 * a new Game Scene where users are able to restart the
	 * game play.
	 */
	protected void refreshGame() {
		Main.setUser(new User());
		gameScene = new GameScene();
		screenMap.replace("GameScene", gameScene.getScene());
	}

}
