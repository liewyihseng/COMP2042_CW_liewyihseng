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
	public ScreenController screen;
	public User user = Main.getUser();
	
	public BetweenLevelScene() {
	
		
		AnchorPane pane = new AnchorPane();
		pane.setMinSize(800.00, 600.00);
		pane.setStyle("-fx-background-image: url('file:src/main/resources/Menu.png');" + "-fx-background-size: 600 800");
		
		Button nextLevelButton= new Button();
		ImageView nextLevelButtonImage = new ImageView("file:src/main/resources/startButton.png");
		nextLevelButtonImage.setFitHeight(66);
		nextLevelButtonImage.setFitWidth(105);
		nextLevelButton.setGraphic(nextLevelButtonImage);
		nextLevelButton.setLayoutX(240);
		nextLevelButton.setLayoutY(305);
		nextLevelButton.setStyle("-fx-focus-color: transparent;-fx-background-color: transparent");
		nextLevelButton.setCursor(Cursor.HAND);
		
		nextLevelButton.setOnAction(e ->{
			//System.out.println("Print User Detail in Between Level Scene");
    		//System.out.println("Username = " + user.getUsername());
    		//System.out.println("Level = " + user.getLevel());
    		//System.out.println("Score = "+ user.getScore());
    		//System.out.println("");
			
			screen.resetGame();
			screen.activate("GameScene");
			
			Main.screen.gameScene.displayUsername(Main.getUser().getUsername());
			
		
		});
		
		Button returnHomeButton= new Button();
		ImageView returnHomeButtonImage = new ImageView("file:src/main/resources/HomeButton.png");
		returnHomeButtonImage.setFitHeight(66);
		returnHomeButtonImage.setFitWidth(105);
		returnHomeButton.setGraphic(returnHomeButtonImage);
		returnHomeButton.setLayoutX(240);
		returnHomeButton.setLayoutY(525);
		returnHomeButton.setStyle("-fx-focus-color: transparent;-fx-background-color: transparent");
		returnHomeButton.setCursor(Cursor.HAND);
		
		returnHomeButton.setOnAction(e ->{
		
			System.out.println("Return Home Button Successful");
		});
		
		pane.getChildren().addAll(nextLevelButton, returnHomeButton);
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
	
	public void setSceneController(ScreenController screen) {
		this.screen = screen;
	}
}
