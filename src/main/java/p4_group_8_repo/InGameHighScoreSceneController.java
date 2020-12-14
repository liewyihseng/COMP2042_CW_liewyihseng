package p4_group_8_repo;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

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
	
	public SceneController scene;

	public Label[] name;
	public Label[] level;
	public Label[] score;

	private HighScores highScores = Main.getHighScore();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		name = new Label[] {name0, name1, name2, name3, name4, name5, name6, name7, name8, name9};
		level = new Label[] {level0, level1, level2, level3, level4, level5, level6, level7, level8, level9};
		score = new Label[] {score0, score1, score2, score3, score4, score5, score6, score7, score8, score9};
		//Will display but no update when not quitting the game
		/*
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
		*/
	}

	
	public InGameHighScoreSceneController(HighScores highScores) {
		this.highScores = highScores;
		
	}
	
	public InGameHighScoreSceneController(SceneController scene) {
		this.scene = scene;
	}
	
	@FXML
	void submit(MouseEvent event) {
		Main.getHighScore().newScore(Main.getUser().getScore());
		scene.activate("StartScene");
		scene.refreshGame();
	}
	
	@FXML
	void backMenu(MouseEvent event) {
		if(Main.getUser().isInGame()) {
			scene.activate("PauseScene");
		}else {
			if(Main.getUser().getLevel() <= 10) {
				scene.activate("BetweenLevelScene");
			}else {
				scene.activate("EndGameScene");
			}
		}
	}
	
	public void setScoreText() {
		for(int i=0; i<highScores.getScoreList().size(); i++) {
			System.out.println(highScores.getScoreList());
			System.out.println(highScores.getScoreList().size());

			System.out.println(highScores.getScoreList().get(i).getName());
			System.out.println(highScores.getScoreList().get(i).getLevel());
			System.out.println(highScores.getScoreList().get(i).getScore());
			//name[i].setText(highScores.getScoreList().get(i).getName());
			//level[i].setText(highScores.getScoreList().get(i).getLevel());
			//score[i].setText(highScores.getScoreList().get(i).getScore());
		}
	}
}
