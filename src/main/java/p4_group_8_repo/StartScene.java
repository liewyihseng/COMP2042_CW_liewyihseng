package p4_group_8_repo;

import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Popup;

public class StartScene{
	
	private Scene StartScene;
	private BackgroundImage backgroundImage;
	public User user = Main.getUser();
	
	public BackgroundImage getBackgroundImage() {
		return backgroundImage;
	}

	public void setBackgroundImage(BackgroundImage backgroundImage) {
		this.backgroundImage = backgroundImage;
	}

	public StartScene() {
		AnchorPane pane = new AnchorPane();
		pane.setMinSize(800.00, 600.00);
		
		pane.setStyle("-fx-background-image: url('file:src/main/resources/StartPage.png');" + "-fx-background-size: 600 800;");
		
		Button menuButton = new Button();
		ImageView menuButtonImage = new ImageView("file:src/main/resources/MenuButton.png");
		menuButtonImage.setFitHeight(32);
		menuButtonImage.setFitWidth(38);
		menuButton.setGraphic(menuButtonImage);
		menuButton.setLayoutX(5);
		menuButton.setLayoutY(5);
		menuButton.setStyle("-fx-focus-color: transparent;-fx-background-color: transparent");
		menuButton.setCursor(Cursor.HAND);
		menuButton.setOnAction(e ->{
			//create menuScene here;
			Main.setScene("MenuScene");
			System.out.println("Menu Testing successful");
		});
		
		LimitedTextField text = new LimitedTextField();
		text.setPromptText("Username");
		text.setFocusTraversable(false);
		text.setAlignment(Pos.CENTER);
		text.setLayoutX(188);
		text.setLayoutY(430);
		text.setText(null);
		Font font = Font.font(18);
		text.setFont(font);
		
		Button startButton = new Button();
		ImageView startButtonImage = new ImageView("file:src/main/resources/StartButton.png");
		startButtonImage.setFitHeight(66);
		startButtonImage.setFitWidth(105);
		startButton.setGraphic(startButtonImage);
		startButton.setLayoutX(240);
		startButton.setLayoutY(485);
		startButton.setStyle("-fx-focus-color: transparent;-fx-background-color: transparent");
		startButton.setCursor(Cursor.HAND);
		pane.getChildren().addAll(menuButton, text, startButton);
		
		StartScene = new Scene(pane, 600, 800);
		
		startButton.setOnAction(e ->{
			//user = new User();
			//System.out.println("Default Username: "+ user.getUsername());
			if(text.getText()!=null) {
				//Main.setUser(new User(text.getText()));
			}else {
				//Main.setUser(user);
			}
			//System.out.println("StartScreen username: "+ user.getUsername());
			//GameScene gameScene = new GameScene(background);
			//launch gamescene
			//shud pass user into gamescene
			
			Main.setScene("GameScene");
			Main.screen.gameScene.displayUsername(Main.getUser().getUsername());
			System.out.println("Printing username in StartScene: "+ Main.getUser().getUsername());
		});
		
	}
	
	//Try make a controller to handle linking to gamescene
	public Scene getScene() {
		return StartScene;
	}
}
