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
	public Stage primaryStage;
	public static ScreenController screen;
	public static User user = new User();
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception{
		
	    //primaryStage is the window itself
	    //So its like showing scene in the stage (Scene in primaryStage)
	    //Show something inside Stage (Setting the scene on the stage)
		/*
		screen = new ScreenController(primaryStage);
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Frogger Arcade");
		this.primaryStage.getIcons().add(new Image("file:src/main/resources/FrogIcon.png"));
		this.primaryStage.setResizable(false);
		this.primaryStage.show();
		//Keep
		//It is working
		*/
		
		
		//FXMLLoader startSceneLoader = new FXMLLoader(getClass().getResource("/views/StartScene.fxml"));
		//Pane startScene = startSceneLoader.load();
		screen = new ScreenController(primaryStage);
		Parent startPage = FXMLLoader.load(getClass().getResource("/views/StartScene.fxml"));
		Scene scene = new Scene(startPage, 600, 800);
		//Scene scene = new Scene(startScene, 600, 800);
		primaryStage.setTitle("Frogger Arcade");
		primaryStage.setScene(scene);
		primaryStage.getIcons().add(new Image("file:src/main/resources/FrogIcon.png"));
		primaryStage.setResizable(false);
		primaryStage.show();
		
	}

	public static void setScene(String sceneName) {
		screen.activate(sceneName);
	}
	
	public static void setUser(User user) {
		Main.user = user;
	}
	
	public static User getUser() {
		return Main.user;
	}
	
}
