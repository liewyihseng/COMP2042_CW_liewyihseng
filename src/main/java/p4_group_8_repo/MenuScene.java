package p4_group_8_repo;

import javafx.application.Platform;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class MenuScene {

	private Scene MenuScene;
	
	public MenuScene() {
		AnchorPane pane = new AnchorPane();
		pane.setMinSize(800.00, 600.00);
		pane.setStyle("-fx-background-image: url('file:src/main/resources/Menu.png');" + "-fx-background-size: 600 800;");
		
		Button homeButton = new Button();
		ImageView homeButtonImage = new ImageView("file:src/main/resources/HomeButton.png");
		homeButtonImage.setFitHeight(70);
		homeButtonImage.setFitWidth(140);
		homeButton.setGraphic(homeButtonImage);
		homeButton.setLayoutX(222);
		homeButton.setLayoutY(200);
		homeButton.setStyle("-fx-focus-color: transparent;-fx-background-color: transparent");
		homeButton.setCursor(Cursor.HAND);
		homeButton.setOnAction(e -> {
			Main.setScene("StartScene");
			System.out.println("Home Button Test Successfully");
		});
		
		Button highScoreButton = new Button();
		ImageView highScoreButtonImage = new ImageView("file:src/main/resources/HighScoreButton.png");
		highScoreButtonImage.setFitHeight(70);
		highScoreButtonImage.setFitWidth(140);
		highScoreButton.setGraphic(highScoreButtonImage);
		highScoreButton.setLayoutX(222);
		highScoreButton.setLayoutY(300);
		highScoreButton.setStyle("-fx-focus-color: transparent;-fx-background-color: transparent");
		highScoreButton.setCursor(Cursor.HAND);
		highScoreButton.setOnAction(e -> {
			System.out.println("High Score Button Test Successfully");
		});
		
		Button instructionButton = new Button();
		ImageView instructionButtonImage = new ImageView("file:src/main/resources/InstructionButton.png");
		instructionButtonImage.setFitHeight(73);
		instructionButtonImage.setFitWidth(140);
		instructionButton.setGraphic(instructionButtonImage);
		instructionButton.setLayoutX(222);
		instructionButton.setLayoutY(400);
		instructionButton.setStyle("-fx-focus-color: transparent;-fx-background-color: transparent");
		instructionButton.setCursor(Cursor.HAND);
		instructionButton.setOnAction(e -> {
			System.out.println("Instruction Button Test Successfully");
		});
		
		Button quitButton = new Button();
		ImageView quitButtonImage = new ImageView("file:src/main/resources/QuitButton.png");
		quitButtonImage.setFitHeight(70);
		quitButtonImage.setFitWidth(140);
		quitButton.setGraphic(quitButtonImage);
		quitButton.setLayoutX(222);
		quitButton.setLayoutY(500);
		quitButton.setStyle("-fx-focus-color: transparent;-fx-background-color: transparent");
		quitButton.setCursor(Cursor.HAND);
		quitButton.setOnAction(e -> {
			Platform.exit();
		});
		pane.getChildren().addAll(homeButton, highScoreButton, instructionButton, quitButton);
		
		MenuScene = new Scene(pane, 600, 800);
	}
	
	public Scene getScene() {
		return MenuScene;
	}
}
