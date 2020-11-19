package p4_group_8_repo;

import javafx.animation.AnimationTimer;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class GameScene extends Scene{
	private BackgroundImage backgroundImage;
	Animal animal;
	User user;
	MyStage background;
	AnimationTimer timer;
	
	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public BackgroundImage getBackgroundImage() {
		return backgroundImage;
	}

	public void setBackgroundImage(BackgroundImage backgroundImage) {
		this.backgroundImage = backgroundImage;
	}
	
	public GameScene(MyStage background, BackgroundImage backgroundImage) {
		
		super(background, 600, 800);
		background.add(backgroundImage);
		
		user = new User("Testing Only");
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
		background.add(new Log("file:images/LogShort.png", 150, 0, 120, 0.75));
		background.add(new Log("file:images/LogShort.png", 150, 220, 120, 0.75));
		background.add(new Log("file:images/LogShort.png", 150, 440, 120, 0.75));

		//Lane 2
		background.add(new WetTurtle(600, 168, -1, 140, 140));
		background.add(new WetTurtle(400, 168, -1, 140, 140));
		background.add(new WetTurtle(200, 168, -1, 140, 140));
						
		//Lane 3
		background.add(new Log("file:images/LogLong.png", 300, 0, 224, -2));
		background.add(new Log("file:images/LogLong.png", 300, 400, 224, -2));
						
		//Lane 4
		background.add(new Log("file:images/LogShort.png", 150, 50, 279, 0.75));
		background.add(new Log("file:images/LogShort.png", 150, 270, 279, 0.75));
		background.add(new Log("file:images/LogShort.png", 150, 490, 279, 0.75));
						
		//Lane 5
		background.add(new Turtle(500, 327, -1, 140, 140));
		background.add(new Turtle(300, 327, -1, 140, 140));
		background.add(new WetTurtle(700, 330, -1, 140, 140));

		//Land
		//Lane1
		background.add(new Obstacle("file:images/Taxi.png", 500, 500,-5, 50, 50));
						
		//Lane 2
		background.add(new Obstacle("file:images/TruckLong.png", 0, 540, 1, 200, 200));
		background.add(new Obstacle("file:images/TruckLong.png", 500, 540, 1, 200, 200));
		//attribute
		//<a href='https://www.freepik.com/vectors/background'>Background vector created by vectorpocket - www.freepik.com</a>
						
		//Lane 3
		background.add(new Obstacle("file:images/CarRed.png", 100, 604, -1, 50, 50));
		background.add(new Obstacle("file:images/CarRed.png", 250, 604, -1, 50, 50));
		background.add(new Obstacle("file:images/CarRed.png", 400, 604, -1, 50, 50));
		background.add(new Obstacle("file:images/CarRed.png", 550, 604, -1, 50, 50));
				
		//Lane 4
		background.add(new Obstacle("file:images/TruckRed.png", 0, 645, 1, 120, 120));
		background.add(new Obstacle("file:images/TruckYellow.png", 300, 647, 1, 120, 120));
		background.add(new Obstacle("file:images/TruckYellow.png", 600, 647, 1, 120, 120));
		//attribute
		//<a href='https://www.freepik.com/vectors/background'>Background vector created by vectorpocket - www.freepik.com</a>
		
		animal = new Animal("file:src/p4_group_8_repo/froggerUp.png", user);
		background.add(animal);
		background.start();
	}
	
	public void createTimer(MyStage background, Animal animal) {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	if (animal.changeScore()) {
            		setNumber(animal.getPoints(), background);
            		
            	}
            	if (animal.getStop()) {
            		System.out.print("STOPP:");
            		background.stopMusic();
            		stop();
            		background.stop();
            		Alert alert = new Alert(AlertType.INFORMATION);
            		alert.setTitle("You Have Won The Game!");
            		alert.setHeaderText("Hey "+ animal.user.getUsername() +", Your High Score: "+animal.user.getCurrentPoints()+"!");
            		alert.setContentText("Highest Possible Score: 850");
            		alert.show();
            	}
            	setNumber(animal.getPoints(), background);
            	animal.user.setCurrentPoints(animal.getPoints());
            	System.out.println(animal.user.getUsername());
        		System.out.println(animal.user.getCurrentPoints());
            }
        };
    }
	
	public void start(MyStage background, Animal animal) {
		background.playMusic();
    	createTimer(background, animal);
        timer.start();
    }
   

    public void stop() {
        timer.stop();
    }
   
    
    //Altered from a while loop to a for loop
    //Solved problem displaying 0 in the hundreds if its a two digit number
    public void setNumber(int n, MyStage background) {
    	int shift = 0;
    	for (int i = 0; i < 3; i++) {
    		int d = n / 10;
    		int k = n - d * 10;
    		n = d;
    		background.add(new Digit(k, 30, 360 - shift, 5));
    		shift += 30;
    	}
    }
    
    
    

}



