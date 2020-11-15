package p4_group_8_repo;

import java.io.File;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
	AnimationTimer timer;
	MyStage gameplay;
	MyStage startpage;
	Animal animal;
	
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
		
		//Displaying the background for Start Page screen
		Scene scene = new Scene(startpage, 600, 800);
		
		//Setting the background image for Start Page screen
		startpage.addBackgroundImage("file:images/startpagefinal1.png", startpage);

		//Displaying the background for Game Play screen
		Scene scene1 = new Scene(gameplay, 600, 800);
		//Pay more attention here
		
		
		//Setting the background image for gameplay screen
		gameplay.addBackgroundImage("file:images/mapfinal1.png", gameplay);
		
		//Displaying the element of start page scene
		Buttons button = new Buttons("file:images/startButton.png", 240, 485, 66, 105, primaryStage, scene1, startpage);
		//<a href='https://www.freepik.com/vectors/frame'>Frame vector created by vectorpouch - www.freepik.com</a>
	
		
		//Displaying the element of Game Play scene
		//Pay more attention here
		Buttons button2 = new Buttons("file:images/menu.png", 4, 3, 32, 38, primaryStage, scene, gameplay);
		
		
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
		gameplay.add(new Log("file:images/log3test.png", 150, 0, 120, 0.75));
		gameplay.add(new Log("file:images/log3test.png", 150, 220, 120, 0.75));
		gameplay.add(new Log("file:images/log3test.png", 150, 440, 120, 0.75));

		//Lane 2
		gameplay.add(new WetTurtle(600, 168, -1, 140, 140));
		gameplay.add(new WetTurtle(400, 168, -1, 140, 140));
		gameplay.add(new WetTurtle(200, 168, -1, 140, 140));
				
		//Lane 3
		gameplay.add(new Log("file:images/logtest.png", 300, 0, 224, -2));
		gameplay.add(new Log("file:images/logtest.png", 300, 400, 224, -2));
				
		//Lane 4
		gameplay.add(new Log("file:images/log3test.png", 150, 50, 279, 0.75));
		gameplay.add(new Log("file:images/log3test.png", 150, 270, 279, 0.75));
		gameplay.add(new Log("file:images/log3test.png", 150, 490, 279, 0.75));
				
		//Lane 5
		gameplay.add(new Turtle(500, 327, -1, 140, 140));
		gameplay.add(new Turtle(300, 327, -1, 140, 140));
		gameplay.add(new WetTurtle(700, 330, -1, 140, 140));
		
		//Land
		//Lane1
		gameplay.add(new Obstacle("file:images/car2Lefttest.png", 500, 500,-5, 50, 50));
		gameplay.add(new Digit(0, 30, 400, 5));
				
		//Lane 2
		gameplay.add(new Obstacle("file:images/trucklongRighttest.png", 0, 540, 1, 200, 200));
		gameplay.add(new Obstacle("file:images/trucklongRighttest.png", 500, 540, 1, 200, 200));
		//attribute
		//<a href='https://www.freepik.com/vectors/background'>Background vector created by vectorpocket - www.freepik.com</a>
				
		//Lane 3
		gameplay.add(new Obstacle("file:images/car1Lefttest.png", 100, 604, -1, 50, 50));
		gameplay.add(new Obstacle("file:images/car1Lefttest.png", 250, 604, -1, 50, 50));
		gameplay.add(new Obstacle("file:images/car1Lefttest.png", 400, 604, -1, 50, 50));
		gameplay.add(new Obstacle("file:images/car1Lefttest.png", 550, 604, -1, 50, 50));
				
		//Lane 4
		gameplay.add(new Obstacle("file:images/truck2Righttest.png", 0, 645, 1, 120, 120));
		gameplay.add(new Obstacle("file:images/truck1Righttest.png", 300, 647, 1, 120, 120));
		gameplay.add(new Obstacle("file:images/truck1Righttest.png", 600, 647, 1, 120, 120));
		//attribute
		//<a href='https://www.freepik.com/vectors/background'>Background vector created by vectorpocket - www.freepik.com</a>

		//Protagonist
		animal = new Animal("file:src/p4_group_8_repo/froggerUp.png");
		gameplay.add(animal);
		gameplay.start();
				
		//TextField text = new TextField();
		//text.setMaxWidth(100);
		
		
		primaryStage.setTitle("Frogger Arcade");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
		start();
	}

	
	
	
	
	
	
	
	//V1
	/*
	@Override
	public void start(Stage primaryStage) throws Exception {
	    background = new MyStage();


	    Scene scene  = new Scene(background,610,829);
	    
		//Obstacle obstacle = new Obstacle("file:src/p4_group_8_repo/truck1Right.png", 25, 25, 3);
		//Obstacle obstacle1 = new Obstacle("file:src/p4_group_8_repo/truck2Right.png", 100, 100,2 );
		//Obstacle obstacle2 = new Obstacle("file:src/p4_group_8_repo/truck1Right.png",0,  150, 1);
	    
	    //Uncomment it after the start page is done
	    //Parent startPage=FXMLLoader.load(getClass().getResource("/p4_group_8_repo/startPage.fxml"));
	    //Scene scene = new Scene(startPage,610,829);
	    
	    
	    
		BackgroundImage froggerback = new BackgroundImage("file:images/mapfinal1.png");
	    
		background.add(froggerback);
		
		//End
		//The ending point
		background.add(new End(13,45));
		background.add(new End(141,45));
		background.add(new End(141 + 141-13,45));
		background.add(new End(141 + 141-13+141-13+1,45));
		background.add(new End(141 + 141-13+141-13+141-13+3,45));
		
		//Water
		//Lane counting from top to bottom
		//Lane 1
		background.add(new Log("file:images/log3test.png", 150, 0, 120, 0.75));
		background.add(new Log("file:images/log3test.png", 150, 220, 120, 0.75));
		background.add(new Log("file:images/log3test.png", 150, 440, 120, 0.75));

		//Lane 2
		background.add(new WetTurtle(600, 168, -1, 140, 140));
		background.add(new WetTurtle(400, 168, -1, 140, 140));
		background.add(new WetTurtle(200, 168, -1, 140, 140));
		
		//Lane 3
		background.add(new Log("file:images/logtest.png", 300, 0, 224, -2));
		background.add(new Log("file:images/logtest.png", 300, 400, 224, -2));
		
		//Lane 4
		background.add(new Log("file:images/log3test.png", 150, 50, 279, 0.75));
		background.add(new Log("file:images/log3test.png", 150, 270, 279, 0.75));
		background.add(new Log("file:images/log3test.png", 150, 490, 279, 0.75));
		
		//Lane 5
		background.add(new Turtle(500, 327, -1, 140, 140));
		background.add(new Turtle(300, 327, -1, 140, 140));
		background.add(new WetTurtle(700, 330, -1, 140, 140));

		
		//Land
		//Lane1
		background.add(new Obstacle("file:images/car2Lefttest.png", 500, 500,-5, 50, 50));
		background.add(new Digit(0, 30, 400, 5));
		

		//Lane 2
		background.add(new Obstacle("file:images/trucklongRighttest.png", 0, 540, 1, 200, 200));
		background.add(new Obstacle("file:images/trucklongRighttest.png", 500, 540, 1, 200, 200));
		//attribute
		//<a href='https://www.freepik.com/vectors/background'>Background vector created by vectorpocket - www.freepik.com</a>
		
		//Lane 3
		background.add(new Obstacle("file:images/car1Lefttest.png", 100, 604, -1, 50, 50));
		background.add(new Obstacle("file:images/car1Lefttest.png", 250, 604, -1, 50, 50));
		background.add(new Obstacle("file:images/car1Lefttest.png", 400, 604, -1, 50, 50));
		background.add(new Obstacle("file:images/car1Lefttest.png", 550, 604, -1, 50, 50));
		
		//Lane 4
		background.add(new Obstacle("file:images/truck2Righttest.png", 0, 645, 1, 120, 120));
		background.add(new Obstacle("file:images/truck1Righttest.png", 300, 647, 1, 120, 120));
		background.add(new Obstacle("file:images/truck1Righttest.png", 600, 647, 1, 120, 120));
		//attribute
		//<a href='https://www.freepik.com/vectors/background'>Background vector created by vectorpocket - www.freepik.com</a>

		//Protagonist
		animal = new Animal("file:src/p4_group_8_repo/froggerUp.png");
		background.add(animal);
		background.start();
		
		//background.add(obstacle);
		//background.add(obstacle1);
		//background.add(obstacle2);
		
	    primaryStage.setWidth(610);
	    primaryStage.setHeight(829);
	    primaryStage.setTitle("Frogger Arcade");
		primaryStage.setScene(scene);
		primaryStage.show();
		//Make the stage visible
		start();  
		
	}
	
	*/
	
	public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	if (animal.changeScore()) {
            		setNumber(animal.getPoints());
            	}
            	if (animal.getStop()) {
            		System.out.print("STOPP:");
            		gameplay.stopMusic();
            		stop();
            		gameplay.stop();
            		Alert alert = new Alert(AlertType.INFORMATION);
            		alert.setTitle("You Have Won The Game!");
            		alert.setHeaderText("Your High Score: "+animal.getPoints()+"!");
            		alert.setContentText("Highest Possible Score: 800");
            		alert.show();
            	}
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
    
    public void setNumber(int n) {
    	int shift = 0;
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  gameplay.add(new Digit(k, 30, 360 - shift, 5));
    		  shift+=30;
    		}
    }
}
