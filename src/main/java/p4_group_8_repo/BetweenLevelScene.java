package p4_group_8_repo;

import java.util.Optional;

import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class BetweenLevelScene {
	private Scene BetweenLevelScene;
	private BackgroundImage backgroundImage;
	public SceneController screen;
	public User user = Main.getUser();
	
	public BetweenLevelScene() {
	
		
		AnchorPane pane = new AnchorPane();
		pane.setMinSize(800.00, 600.00);
		pane.setStyle("-fx-background-image: url('file:src/main/resources/PausePage.png');" + "-fx-background-size: 600 800");
		
		Button nextLevelButton= new Button();
		ImageView nextLevelButtonImage = new ImageView("file:src/main/resources/NextLevelButton.png");
		nextLevelButtonImage.setFitHeight(70);
		nextLevelButtonImage.setFitWidth(140);
		nextLevelButton.setGraphic(nextLevelButtonImage);
		nextLevelButton.setLayoutX(222);
		nextLevelButton.setLayoutY(325);
		nextLevelButton.setStyle("-fx-focus-color: transparent;-fx-background-color: transparent");
		nextLevelButton.setCursor(Cursor.HAND);
		
		nextLevelButton.setOnAction(e ->{
			screen.resetGame();
			screen.activate("GameScene");
			Main.scene.gameScene.displayUsername(Main.getUser().getUsername());
		});
		
		Button highScoreButton = new Button();
		ImageView highScoreButtonImage = new ImageView("file:src/main/resources/HighScoreButton.png");
		highScoreButtonImage.setFitHeight(70);
		highScoreButtonImage.setFitWidth(140);
		highScoreButton.setGraphic(highScoreButtonImage);
		highScoreButton.setLayoutX(222);
		highScoreButton.setLayoutY(425);
		highScoreButton.setStyle("-fx-focus-color: transparent;-fx-background-color: transparent");
		highScoreButton.setCursor(Cursor.HAND);
		
		highScoreButton.setOnAction(e ->{
		
			System.out.println("High Score Button Successful");
		});
		
		
		Button returnHomeButton= new Button();
		ImageView returnHomeButtonImage = new ImageView("file:src/main/resources/HomeButton.png");
		returnHomeButtonImage.setFitHeight(70);
		returnHomeButtonImage.setFitWidth(140);
		returnHomeButton.setGraphic(returnHomeButtonImage);
		returnHomeButton.setLayoutX(222);
		returnHomeButton.setLayoutY(525);
		returnHomeButton.setStyle("-fx-focus-color: transparent;-fx-background-color: transparent");
		returnHomeButton.setCursor(Cursor.HAND);
		returnHomeButton.setOnAction(e ->{
			System.out.println("Return Home Button Successful");
		});
		
		pane.getChildren().addAll(nextLevelButton, highScoreButton, returnHomeButton);
		BetweenLevelScene = new Scene(pane, 600, 800);
		
	}
	
	public Scene getScene() {
		return BetweenLevelScene;
	}
	
	public BackgroundImage getBackgroundImage() {
		return backgroundImage;
	}

	public void setBackgroundImage(BackgroundImage backgroundImage) {
		this.backgroundImage = backgroundImage;
	}
	
	public void setSceneController(SceneController screen) {
		this.screen = screen;
	}
}
