package p4_group_8_repo;

import java.io.File;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
	AnimationTimer timer;
	MyStage gameplay;
	MyStage startpage;
	Animal animal;
	User user;
	
	//MyStage background;
	
	static MyStage background = new MyStage();
	
	public static void main(String[] args) {
		launch(args);

	}
	
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		
	    //primaryStage is the window itself
	    //So its like showing scene in the stage (Scene in primaryStage)
	    //Show something inside Stage (Setting the scene on the stage)
		//startpage = new MyStage();
		
		//Displaying the background for Start Page screen
		//Scene scene = new Scene(startpage, 600, 800);
		
		//Setting the background image for Start Page screen
		//startpage.addBackgroundImage("file:images/StartPage.png", startpage);

		//BackgroundImage startBack = new BackgroundImage("file:images/StartPage.png");
		//StartScene startScene  = new StartScene(background, startBack);
		
		
		BackgroundImage gameBack = new BackgroundImage("file:images/Map.png");
		GameScene gameScene = new GameScene(background, gameBack);
		
		
		primaryStage.setTitle("Frogger Arcade");
		//primaryStage.setScene(startScene);
		primaryStage.setScene(gameScene);
		primaryStage.setResizable(false);
		primaryStage.show();
		gameScene.start(background, gameScene.getAnimal());
		
		
		
		//Keep
		//It is working
		
	}
	
	//Try creating a public method here to link to gamescene from startscene
	//but will move to controller class
	//Call it statechange class
	
   
}
