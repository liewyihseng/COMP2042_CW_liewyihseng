package p4_group_8_repo;

import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;

public class StartScene extends Scene{

	private BackgroundImage backgroundImage;
	
	public BackgroundImage getBackgroundImage() {
		return backgroundImage;
	}

	public void setBackgroundImage(BackgroundImage backgroundImage) {
		this.backgroundImage = backgroundImage;
	}

	public StartScene(MyStage background,BackgroundImage backgroundImage) {
		super(background, 600, 800);

		background.add(backgroundImage);
		
		Button menuButton = new Button();
		ImageView menuButtonImage = new ImageView("file:images/MenuButton.png");
		menuButtonImage.setFitHeight(32);
		menuButtonImage.setFitWidth(38);
		menuButton.setGraphic(menuButtonImage);
		menuButton.setLayoutX(4);
		menuButton.setLayoutY(3);
		menuButton.setStyle("-fx-focus-color: transparent;-fx-background-color: transparent");
		menuButton.setCursor(Cursor.HAND);
		menuButton.setOnAction(e ->{
			//create menuScene here;
			System.out.println("Menu Testing successful");
		});
		
		TextField text = new TextField();
		text.setPromptText("Username");
		text.setFocusTraversable(false);
		text.setAlignment(Pos.CENTER);
		text.setLayoutX(188);
		text.setLayoutY(420);
		Font font = Font.font(18);
		text.setFont(font);
		
		Button startButton = new Button();
		ImageView startButtonImage = new ImageView("file:images/StartButton.png");
		startButtonImage.setFitHeight(66);
		startButtonImage.setFitWidth(105);
		startButton.setGraphic(startButtonImage);
		startButton.setLayoutX(240);
		startButton.setLayoutY(485);
		startButton.setStyle("-fx-focus-color: transparent;-fx-background-color: transparent");
		startButton.setCursor(Cursor.HAND);
		background.getChildren().addAll(menuButton, text, startButton);
		
		startButton.setOnAction(e ->{
			User user = new User();
			user.setUsername(text.getText());
			System.out.println(user.getUsername());
			System.out.println("Start Testing successful");
		});
		
	}
	
	//Try make a controller to handle linking to gamescene
	
	
	
	

}
