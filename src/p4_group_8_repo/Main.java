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
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
	AnimationTimer timer;
	MyStage background;
	Animal animal;
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
	    background = new MyStage();

	    //primaryStage is the window itself
	    //So its like showing scene in the stage (Scene in primaryStage)
	    //Show something inside Stage (Setting the scene on the stage)
	    Scene scene  = new Scene(background,610,829);
	    
		//Obstacle obstacle = new Obstacle("file:src/p4_group_8_repo/truck1Right.png", 25, 25, 3);
		//Obstacle obstacle1 = new Obstacle("file:src/p4_group_8_repo/truck2Right.png", 100, 100,2 );
		//Obstacle obstacle2 = new Obstacle("file:src/p4_group_8_repo/truck1Right.png",0,  150, 1);
	    
	    //Parent startPage=FXMLLoader.load(getClass().getResource("/p4_group_8_repo/startPage.fxml"));
	    //Scene scene = new Scene(startPage,610,829);
	    
	    
	    
		BackgroundImage froggerback = new BackgroundImage("file:images/mapfinal1.png");
	    
		background.add(froggerback);
		
		
	
		background.add(new Log("file:images/log3test.png", 150, 0, 120, 0.75));
		background.add(new Log("file:images/log3test.png", 150, 220, 120, 0.75));
		background.add(new Log("file:images/log3test.png", 150, 440, 120, 0.75));
		//background.add(new Log("file:src/p4_group_8_repo/log3.png", 150, 0, 166, 0.75));
		background.add(new Log("file:images/logtest.png", 300, 0, 224, -2));
		background.add(new Log("file:images/logtest.png", 300, 400, 224, -2));
		//background.add(new Log("file:src/p4_group_8_repo/logs.png", 300, 800, 276, -2));
		background.add(new Log("file:images/log3test.png", 150, 50, 279, 0.75));
		background.add(new Log("file:images/log3test.png", 150, 270, 279, 0.75));
		background.add(new Log("file:images/log3test.png", 150, 490, 279, 0.75));
		//background.add(new Log("file:src/p4_group_8_repo/log3.png", 150, 570, 329, 0.75));
		
		background.add(new Turtle(500, 327, -1, 140, 140));
		background.add(new Turtle(300, 327, -1, 140, 140));
		background.add(new WetTurtle(700, 330, -1, 140, 140));
		background.add(new WetTurtle(600, 168, -1, 140, 140));
		background.add(new WetTurtle(400, 168, -1, 140, 140));
		background.add(new WetTurtle(200, 168, -1, 140, 140));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 100, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 0, 100, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 120, -1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 120, -1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 140, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 140, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 160, -1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 300, 160, -1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 180, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 180, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 200, -1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 200, -1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 220, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 220, 1));
		//background.add(new Log("file:src/p4_group_8_repo/log2.png", 400, 220, 1));
		//End end2 = new End();
		//End end3 = new End();
		//End end4 = new End();
		//End end5 = new End();
		background.add(new End(13,45));
		background.add(new End(141,45));
		background.add(new End(141 + 141-13,45));
		background.add(new End(141 + 141-13+141-13+1,45));
		background.add(new End(141 + 141-13+141-13+141-13+3,45));
		animal = new Animal("file:src/p4_group_8_repo/froggerUp.png");
		background.add(animal);
		
		//Lane1
		background.add(new Obstacle("file:images/truck2Righttest.png", 0, 645, 1, 120, 120));
		background.add(new Obstacle("file:images/truck1Righttest.png", 300, 647, 1, 120, 120));
		background.add(new Obstacle("file:images/truck1Righttest.png", 600, 647, 1, 120, 120));
		//background.add(new Obstacle("file:src/p4_group_8_repo/truck1"+"Right.png", 720, 649, 1, 120, 120));
		//
		//attribute
		//<a href='https://www.freepik.com/vectors/background'>Background vector created by vectorpocket - www.freepik.com</a>
		

		
		//Lane2
		background.add(new Obstacle("file:images/car1Lefttest.png", 100, 604, -1, 50, 50));
		background.add(new Obstacle("file:images/car1Lefttest.png", 250, 604, -1, 50, 50));
		background.add(new Obstacle("file:images/car1Lefttest.png", 400, 604, -1, 50, 50));
		background.add(new Obstacle("file:images/car1Lefttest.png", 550, 604, -1, 50, 50));
		
		//Lane3
		background.add(new Obstacle("file:images/trucklongRighttest.png", 0, 540, 1, 200, 200));
		background.add(new Obstacle("file:images/trucklongRighttest.png", 500, 540, 1, 200, 200));
		//attribute
		//<a href='https://www.freepik.com/vectors/background'>Background vector created by vectorpocket - www.freepik.com</a>
		
		
		//Lane4
		background.add(new Obstacle("file:images/car2Lefttest.png", 500, 500,-5, 50, 50));
		background.add(new Digit(0, 30, 400, 5));
		//background.add(obstacle);
		//background.add(obstacle1);
		//background.add(obstacle2);
		background.start();
	    primaryStage.setWidth(610);
	    primaryStage.setHeight(829);
	    primaryStage.setTitle("Frogger Arcade");
		primaryStage.setScene(scene);
		primaryStage.show();
		//Make the stage visible
		start();  
		
		
		/*
		 Parent startPAge = FXMLLoader.load(getClass().getResource("StartPage.fxml"));
		 Scene scene = new Scene(startPage, 600, 800);
		 primaryStage.setTitle("Frogger Arcade");
		 primaryStage.setScene(scene);
		 primaryStage.show();
		*/
	}
	public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	if (animal.changeScore()) {
            		setNumber(animal.getPoints());
            	}
            	if (animal.getStop()) {
            		System.out.print("STOPP:");
            		background.stopMusic();
            		stop();
            		background.stop();
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
		//
		// Remember to delete comment
		//
		// 
		//background.playMusic();
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
    		  background.add(new Digit(k, 30, 360 - shift, 25));
    		  shift+=30;
    		}
    }
}
