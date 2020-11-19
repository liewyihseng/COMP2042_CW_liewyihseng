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
	
	public GameScene(MyStage background) {
		super(background, 600, 800);
		BackgroundImage gameBack = new BackgroundImage("file:images/Map.png");
		background.add(gameBack);
		
		//Testing
		user = new User();
		displayLevel(background);
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
		background.add(new ShortLog(0, 120, 0.75));
		background.add(new ShortLog(220, 120, 0.75));
		background.add(new ShortLog(440, 120, 0.75));

		//Lane 2
		background.add(new WetTurtle(600, 168, -1));
		background.add(new WetTurtle(400, 168, -1));
		background.add(new WetTurtle(200, 168, -1));
						
		//Lane 3
		background.add(new LongLog(0, 224, -2));
		background.add(new LongLog(400, 224, -2));
						
		//Lane 4
		background.add(new ShortLog(50, 279, 0.75));
		background.add(new ShortLog(270, 279, 0.75));
		background.add(new ShortLog(490, 279, 0.75));
						
		//Lane 5
		background.add(new Turtle(500, 327, -1));
		background.add(new Turtle(300, 327, -1));
		background.add(new WetTurtle(700, 330, -1));

		//Land
		//Lane1
		background.add(new TaxiCar(500, 500,-5));
						
		//Lane 2
		background.add(new LongTruck(0, 540, 1));
		background.add(new LongTruck(500, 540, 1));
		//attribute
		//<a href='https://www.freepik.com/vectors/background'>Background vector created by vectorpocket - www.freepik.com</a>
						
		//Lane 3
		background.add(new RedCar(100, 604, -1));
		background.add(new RedCar(250, 604, -1));
		background.add(new RedCar(400, 604, -1));
		background.add(new RedCar(550, 604, -1));
				
		//Lane 4
		background.add(new RedTruck(0, 645, 1));
		background.add(new YellowTruck(300, 647, 1));
		background.add(new YellowTruck(600, 647, 1));
		//attribute
		//<a href='https://www.freepik.com/vectors/background'>Background vector created by vectorpocket - www.freepik.com</a>
		
		
		background.add(user.animal);
		background.start();
	}
	
	public void createTimer(MyStage background, User user) {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	if (user.animal.changeScore()) {
            		setNumber(user.animal.getPoints(), background);
            		
            	}
            	if (user.animal.getStop()) {
            		System.out.print("STOPP:");
            		background.stopMusic();
            		stop();
            		background.stop();
            		Alert alert = new Alert(AlertType.INFORMATION);
            		alert.setTitle("You Have Won The Game!");
            		alert.setHeaderText("Hey "+ user.getUsername() +", Your High Score: "+ user.animal.getPoints()+"!");
            		alert.setContentText("Highest Possible Score: 850");
            		alert.show();
            	}
            	//setNumber(user.animal.getPoints(), background);
            	//user.setFinalPoints(user.animal.getPoints());
            	//System.out.println(user.getUsername());
        		//System.out.println(user.getFinalPoints());
            }
        };
    }
	
	public void start(MyStage background, User user) {
		background.playMusic();
    	createTimer(background, user);
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
    		background.add(new Digit(k, 360 - shift, 5));
    		shift += 30;
    	}
    }
    
    public void displayLevel(MyStage background) {
    	int level;
    	level = user.getLevel();
    	background.add(new Digit(level, 500, 5));
    }
    
    
    

}



