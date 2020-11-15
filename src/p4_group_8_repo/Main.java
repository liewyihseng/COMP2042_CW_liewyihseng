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
	
	public static void main(String[] args) {
		launch(args);

	}
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		
	    //primaryStage is the window itself
	    //So its like showing scene in the stage (Scene in primaryStage)
	    //Show something inside Stage (Setting the scene on the stage)
		startpage = new MyStage();
		gameplay = new MyStage();
		user = new User();
		
		//Displaying the background for Start Page screen
		Scene scene = new Scene(startpage, 600, 800);
		
		//Setting the background image for Start Page screen
		startpage.addBackgroundImage("file:images/StartPage.png", startpage);

		//Displaying the background for Game Play screen
		Scene scene1 = new Scene(gameplay, 600, 800);
		//Pay more attention here
		
		
		//Setting the background image for gameplay screen
		gameplay.addBackgroundImage("file:images/Map.png", gameplay);
		
		//Displaying the element of start page scene
		//Buttons button = new Buttons("file:images/StartButton.png", 240, 485, 66, 105, primaryStage, scene1, startpage);
		//<a href='https://www.freepik.com/vectors/frame'>Frame vector created by vectorpouch - www.freepik.com</a>
	
		
		//Displaying the element of Game Play scene
		//Pay more attention here
		Buttons button2 = new Buttons("file:images/MenuButton.png", 4, 3, 32, 38, primaryStage, scene, gameplay);
		
		
		//End
		//The ending point
		gameplay.add(new End(13,45));
		gameplay.add(new End(141,45));
		gameplay.add(new End(141 + 141-13,45));
		gameplay.add(new End(141 + 141-13+141-13+1,45));
		gameplay.add(new End(141 + 141-13+141-13+141-13+3,45));
		
		//Water
		//Lane counting from top to bottom
		//Lane 1
		gameplay.add(new Log("file:images/LogShort.png", 150, 0, 120, 0.75));
		gameplay.add(new Log("file:images/LogShort.png", 150, 220, 120, 0.75));
		gameplay.add(new Log("file:images/LogShort.png", 150, 440, 120, 0.75));

		//Lane 2
		gameplay.add(new WetTurtle(600, 168, -1, 140, 140));
		gameplay.add(new WetTurtle(400, 168, -1, 140, 140));
		gameplay.add(new WetTurtle(200, 168, -1, 140, 140));
				
		//Lane 3
		gameplay.add(new Log("file:images/LogLong.png", 300, 0, 224, -2));
		gameplay.add(new Log("file:images/LogLong.png", 300, 400, 224, -2));
				
		//Lane 4
		gameplay.add(new Log("file:images/LogShort.png", 150, 50, 279, 0.75));
		gameplay.add(new Log("file:images/LogShort.png", 150, 270, 279, 0.75));
		gameplay.add(new Log("file:images/LogShort.png", 150, 490, 279, 0.75));
				
		//Lane 5
		gameplay.add(new Turtle(500, 327, -1, 140, 140));
		gameplay.add(new Turtle(300, 327, -1, 140, 140));
		gameplay.add(new WetTurtle(700, 330, -1, 140, 140));

		//Land
		//Lane1
		gameplay.add(new Obstacle("file:images/Taxi.png", 500, 500,-5, 50, 50));
				
		//Lane 2
		gameplay.add(new Obstacle("file:images/TruckLong.png", 0, 540, 1, 200, 200));
		gameplay.add(new Obstacle("file:images/TruckLong.png", 500, 540, 1, 200, 200));
		//attribute
		//<a href='https://www.freepik.com/vectors/background'>Background vector created by vectorpocket - www.freepik.com</a>
				
		//Lane 3
		gameplay.add(new Obstacle("file:images/CarRed.png", 100, 604, -1, 50, 50));
		gameplay.add(new Obstacle("file:images/CarRed.png", 250, 604, -1, 50, 50));
		gameplay.add(new Obstacle("file:images/CarRed.png", 400, 604, -1, 50, 50));
		gameplay.add(new Obstacle("file:images/CarRed.png", 550, 604, -1, 50, 50));
		
		//Lane 4
		gameplay.add(new Obstacle("file:images/TruckRed.png", 0, 645, 1, 120, 120));
		gameplay.add(new Obstacle("file:images/TruckYellow.png", 300, 647, 1, 120, 120));
		gameplay.add(new Obstacle("file:images/TruckYellow.png", 600, 647, 1, 120, 120));
		//attribute
		//<a href='https://www.freepik.com/vectors/background'>Background vector created by vectorpocket - www.freepik.com</a>
		
		TextField text = new TextField();
		text.setPromptText("Username");
		text.setFocusTraversable(false);
		text.setAlignment(Pos.CENTER);
		text.setLayoutX(188);
		text.setLayoutY(420);
		Font font = Font.font(18);
		text.setFont(font);
		startpage.getChildren().add(text);
		
		Button button = new Button();
		ImageView buttonImage = new ImageView("file:images/StartButton.png");
		buttonImage.setFitHeight(66);
		buttonImage.setFitWidth(105);
		button.setGraphic(buttonImage);
		setButtonStyle(button, 240, 485);
		startpage.getChildren().add(button);
		button.setOnAction(e -> {
			//Retrieving data
			user.setUsername(text.getText());
			primaryStage.setScene(scene1);
		
			}
		);
		
		//Protagonist
		animal = new Animal("file:src/p4_group_8_repo/froggerUp.png", user);
		gameplay.add(animal);
		gameplay.start();

		
		//Buttons button = new Buttons("file:images/StartButton.png", 240, 485, 66, 105, primaryStage, scene1, startpage, text);
		
		
		primaryStage.setTitle("Frogger Arcade");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
		start();
	}
	
	public void setButtonStyle(Button button, int xpos, int ypos){
		
		button.setLayoutX(xpos);
		button.setLayoutY(ypos);
		button.setStyle("-fx-focus-color: transparent;-fx-background-color: transparent");
		button.setCursor(Cursor.HAND);
	}

	
	public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	if (animal.changeScore()) {
            		//setNumber(animal.getPoints());
            		
            	}
            	if (animal.getStop()) {
            		System.out.print("STOPP:");
            		gameplay.stopMusic();
            		stop();
            		gameplay.stop();
            		Alert alert = new Alert(AlertType.INFORMATION);
            		alert.setTitle("You Have Won The Game!");
            		alert.setHeaderText("Hey "+ animal.user.getUsername() +", Your High Score: "+animal.user.getCurrentPoints()+"!");
            		alert.setContentText("Highest Possible Score: 850");
            		alert.show();
            	}
            	setNumber(animal.getPoints());
            	animal.user.setCurrentPoints(animal.getPoints());
            	System.out.println(animal.user.getUsername());
        		System.out.println(animal.user.getCurrentPoints());
            }
        };
    }
	
	public void start() {
		gameplay.playMusic();
    	createTimer();
        timer.start();
    }

    public void stop() {
        timer.stop();
    }
   
    //Altered from a while loop to a for loop
    //Solved problem displaying 0 in the hundreds if its a two digit number
    public void setNumber(int n) {
    	int shift = 0;
    	for (int i = 0; i < 3; i++) {
    		int d = n / 10;
    		int k = n - d * 10;
    		n = d;
    		gameplay.add(new Digit(k, 30, 360 - shift, 5));
    		shift += 30;
    	}
    }
    
}
