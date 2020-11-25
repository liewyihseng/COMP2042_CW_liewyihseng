package p4_group_8_repo;

import java.io.File;
import java.util.List;
import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Parent;
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
	Animal animal;
	public Stage primaryStage;
	public static ScreenController screen;
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
		
		screen = new ScreenController(primaryStage);
		//StartScene startScene  = new StartScene();
		//GameScene gameScene = new GameScene(background);
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Frogger Arcade");
		//primaryStage.setScene(screen);
		//primaryStage.setScene(gameScene);
		this.primaryStage.setResizable(false);
		this.primaryStage.show();
		//gameScene.start(gameScene.user);
		//Keep
		//It is working
	}
	
	//Try creating a public method here to link to gamescene from startscene
	//but will move to controller class
	//Call it statechange class

	public static void setScene(String sceneName) {
		screen.activate(sceneName);
	}
	
}
