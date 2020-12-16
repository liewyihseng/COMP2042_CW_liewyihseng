package p4_group_8_repo.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import p4_group_8_repo.Main;
import p4_group_8_repo.user.HighScores;

/**
 * A controller that handles all events within the In Game High Score Scene.
 * @author Liew Yih Seng
 *
 */
public class InGameHighScoreSceneController implements Initializable{

	@FXML
	private Pane ingamehighscoreRoot;
	
	@FXML
	private ImageView submitbutton;
	
	@FXML
	private ImageView backbutton;
	
	@FXML
	private Label name0, name1, name2, name3, name4, name5, name6, name7, name8, name9;
	
	@FXML
	private Label level0, level1, level2, level3, level4, level5, level6, level7, level8, level9;
	
	@FXML
	private Label score0, score1, score2, score3, score4, score5, score6, score7, score8, score9;
	
	@FXML
	private Label currentscore, currentlevel;
	
	/**
	 * Represents the {@link SceneController} in this class.
	 */
	public SceneController scene;
	
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
	 * Always gets the {@link Main#getHighScore()} to ensure the list of high score
	 * this class is working on is the updated version of the high score list.
	 */
	private HighScores highScores = Main.getHighScore();
	
	/**
	 * A method where FXML will automatically call onto once this controller
	 * has been initialized. It sets three distinct arrays holding the names, levels
	 * and scores of high score achievers. Then displaying them out in the Scene. 
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
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
	public InGameHighScoreSceneController(SceneController scene) {
		this.scene = scene;
	}
	
	/**
	 * A method that submits the user's detail into the high score list.
	 * The user detail will be shown on the list is the user's score is high enough
	 * to be in the list as the list only keep a record of top 10 highest score of
	 * previous users. This method will invoke a method {@link p4_group_8_repo.user.HighScores#newScore(int)}
	 * to add the details into the list. Next, the {@link p4_group_8_repo.GameScene} will be refreshed 
	 * by invoking {@link SceneController#refreshGame()}, then users will be be redirected back to the
	 * Start Scene by activating the Start Scene using {@link SceneController#activate(String)}.
	 * @param event  A {@link MouseEvent} that represents if the user has clicked on this button.
	 */
	@FXML
	void submit(MouseEvent event) {
		Main.getHighScore().newScore(Main.getUser().getScore());
		Main.getUser().setLevel(1);
		scene.refreshGame();
		scene.activate("StartScene");
		
	}
	
	/**
	 * A method that allows users to go back to the Between Level Scene or the End Game Scene
	 * depending whether the user is in game or not by using the method 
	 * {@link p4_group_8_repo.user.User#getLevel()} is lesser or equal to 10. 
	 * If a true has been returned, it will invoke the method {@link SceneController#activate(String)}
	 * to activate and display the Between Level Scene. If it returns false, it will activate and displays the
	 * End Game Scene.
	 * @param event A {@link MouseEvent} that represents if the user has clicked on this button.
	 * @throws Exception If the source is null.
	 */
	@FXML
	void backMenu(MouseEvent event) {
//		if(Main.getUser().isInGame()) {
//			scene.activate("PauseScene");
//		}else {
			if(Main.getUser().getLevel() <= 10) {
				scene.activate("BetweenLevelScene");
			}else {
				scene.activate("EndGameScene");
			}
	//	}
	}
	
	/**
	 * A method the sets the high score list into the most updated version of the list.
	 * It will update every element within the array {@link #name}, {@link #level} and {@link #score}.
	 * Then printing the user's current score and level onto the In Game High Score Scene.
	 */
	public void setScoreText() {
		for(int i = 0; i < 10; i++) {
			name[i].setText(highScores.getScoreList().get(i).getName());
			level[i].setText(highScores.getScoreList().get(i).getLevel());
			score[i].setText(highScores.getScoreList().get(i).getScore());
		}
		currentscore.setText(Integer.toString(Main.getUser().getScore()));
		currentlevel.setText(Integer.toString(Main.getUser().getLevel()-1));
	}
}
