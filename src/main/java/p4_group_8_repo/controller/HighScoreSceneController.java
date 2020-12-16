package p4_group_8_repo.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import p4_group_8_repo.Main;
import p4_group_8_repo.user.HighScores;

/**
 * A controller that handles all event within the High Score Scene.
 * @author Liew Yih Seng
 *
 */
public class HighScoreSceneController {
	
	@FXML
	private Pane highscoreRoot;
	
	@FXML
	private ImageView backbutton;
	
	@FXML
	private Label name0, name1, name2, name3, name4, name5, name6, name7, name8, name9;
	
	@FXML
	private Label level0, level1, level2, level3, level4, level5, level6, level7, level8, level9;
	
	@FXML
	private Label score0, score1, score2, score3, score4, score5, score6, score7, score8, score9;

	/**
	 * An array of labels that hold the most current names of high score achiever.
	 */
	public Label[] name;
	
	/**
	 * An array of labels that hold the most current levels of high score achiever.
	 */
	public Label[] level;
	
	/**
	 * An array of labels that hold the most current scores of high score achiever.
	 */
	public Label[] score;

	/**
	 * Represents the {@link SceneController} in this class.
	 */
	public SceneController scene;
	
	/**
	 * Always gets the {@link Main#getHighScore()} to ensure the list of high score
	 * this class is working on is the updated version of the high score list.
	 */
	private HighScores highScores = Main.getHighScore();
	
	/**
	 * A method where FXML will automatically call onto once this controller
	 * has been initialized. It sets three distinct arrays holding the names, levels
	 * and scores of high score achievers. Then displaying them out in the Scene. 
	 */
	@FXML
	private void initialize() {
		name = new Label[] {name0, name1, name2, name3, name4, name5, name6, name7, name8, name9};
		level = new Label[] {level0, level1, level2, level3, level4, level5, level6, level7, level8, level9};
		score = new Label[] {score0, score1, score2, score3, score4, score5, score6, score7, score8, score9};
		
		name[0].setText(highScores.getScoreList().get(0).getName());
		level[0].setText(highScores.getScoreList().get(0).getLevel());
		score[0].setText(highScores.getScoreList().get(0).getScore());
		name[1].setText(highScores.getScoreList().get(1).getName());
		level[1].setText(highScores.getScoreList().get(1).getLevel());
		score[1].setText(highScores.getScoreList().get(1).getScore());
		name[2].setText(highScores.getScoreList().get(2).getName());
		level[2].setText(highScores.getScoreList().get(2).getLevel());
		score[2].setText(highScores.getScoreList().get(2).getScore());
		name[3].setText(highScores.getScoreList().get(3).getName());
		level[3].setText(highScores.getScoreList().get(3).getLevel());
		score[3].setText(highScores.getScoreList().get(3).getScore());
		name[4].setText(highScores.getScoreList().get(4).getName());
		level[4].setText(highScores.getScoreList().get(4).getLevel());
		score[4].setText(highScores.getScoreList().get(4).getScore());
		name[5].setText(highScores.getScoreList().get(5).getName());
		level[5].setText(highScores.getScoreList().get(5).getLevel());
		score[5].setText(highScores.getScoreList().get(5).getScore());
		name[6].setText(highScores.getScoreList().get(6).getName());
		level[6].setText(highScores.getScoreList().get(6).getLevel());
		score[6].setText(highScores.getScoreList().get(6).getScore());
		name[7].setText(highScores.getScoreList().get(7).getName());
		level[7].setText(highScores.getScoreList().get(7).getLevel());
		score[7].setText(highScores.getScoreList().get(7).getScore());
		name[8].setText(highScores.getScoreList().get(8).getName());
		level[8].setText(highScores.getScoreList().get(8).getLevel());
		score[8].setText(highScores.getScoreList().get(8).getScore());
		name[9].setText(highScores.getScoreList().get(9).getName());
		level[9].setText(highScores.getScoreList().get(9).getLevel());
		score[9].setText(highScores.getScoreList().get(9).getScore());
	}
	
	
	/**
	 * A constructor that sets this {@link #scene} to the {@link SceneController#scene} initialized in {@link SceneController} class.
	 * @param scene A {@link SceneController} that represents {@link SceneController} to be passed into this class.
	 */
	public HighScoreSceneController(SceneController scene) {
		this.scene = scene;
	}
	
	/**
	 * A method that allows user to go back to the Menu Scene or the Pause Scene
	 * depending whether the user is in game or not by using the method 
	 * {@link p4_group_8_repo.user.User#isInGame()}. If a true has been returned,
	 * it will invoke the method {@link SceneController#activate(String)} to activate
	 * and display the Pause Scene. If it returns false, it will activate and displays the
	 * MenuScene.
	 * @param event A {@link MouseEvent} that represents if the user has clicked on this button.
	 * @throws Exception If the source is null.
	 */
	@FXML
	void backMenu(MouseEvent event) throws Exception{
		if(Main.getUser().isInGame()) {
			scene.activate("PauseScene");
		}else {
			scene.activate("MenuScene");
		}
	}
	
	/**
	 * A method the sets the high score list into the most updated version of the list.
	 * It will update every element within the array {@link #name}, {@link #level} and {@link #score}.
	 */
	public void setScoreText() {
		for(int i = 0; i < 10; i++) {
			name[i].setText(highScores.getScoreList().get(i).getName());
			level[i].setText(highScores.getScoreList().get(i).getLevel());
			score[i].setText(highScores.getScoreList().get(i).getScore());
		}
	}
}
