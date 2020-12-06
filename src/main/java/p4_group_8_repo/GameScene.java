package p4_group_8_repo;

import java.io.IOException;
import java.util.Optional;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class GameScene{

	public User user = Main.getUser();
	MyStage background;
	AnimationTimer timer;
	private Character[] score = new Character[4];
	private Pane GameScene;
	private int currentLevel;
	public SceneController screen;
	

	public GameScene() {
		
		background = new MyStage();
		BackgroundImage gameBack = new BackgroundImage("file:src/main/resources/images/Map.png");
		background.add(gameBack);
		currentLevel = user.getLevel();
		System.out.println("User detail:");
		System.out.println("User Name:"+ user.getUsername());
		System.out.println("User level:" + user.getLevel());
		
		displayMenuButton();
		displayScore();
		displayLevel();
		
		//End
		//The ending point
		if(user.getLevel() == 1 || user.getLevel() == 4 || user.getLevel() == 7 || user.getLevel() == 10) {
			background.add(new Lilypad(13,45));
			background.add(new Lilypad(141,45));
			background.add(new Lilypad(141 + 141-13,45));
			background.add(new Lilypad(141 + 141-13+141-13+1,45));
			background.add(new Lilypad(141 + 141-13+141-13+141-13+3,45));
		}else if(user.getLevel() == 2 || user.getLevel() == 5 || user.getLevel() == 8) {
			background.add(new Lilypad(13,45));
			background.add(new Crocodile(141,45));
			background.add(new Lilypad(141 + 141-13,45));
			background.add(new Crocodile(141 + 141-13+141-13+1,45));
			background.add(new Lilypad(141 + 141-13+141-13+141-13+3,45));
		}else if(user.getLevel() == 3 || user.getLevel() == 6 || user.getLevel() == 9) {
			background.add(new Crocodile(13,45));
			background.add(new Lilypad(141,45));
			background.add(new Crocodile(141 + 141-13,45));
			background.add(new Lilypad(141 + 141-13+141-13+1,45));
			background.add(new Crocodile(141 + 141-13+141-13+141-13+3,45));
		}
		
		//Water
		//Lane counting from top to bottom
		//Lane 1
		//With speed
		background.add(new ShortLog(0, 120, 0.75 + user.getIncrementDifficulty()));
		background.add(new ShortLog(220, 120, 0.75 + user.getIncrementDifficulty()));
		background.add(new ShortLog(440, 120, 0.75 + user.getIncrementDifficulty()));

		//Lane 2
		//With speed
		background.add(new SinkingTurtle(600, 168, -1 - user.getIncrementDifficulty()));
		background.add(new SinkingTurtle(400, 168, -1 - user.getIncrementDifficulty()));
		background.add(new SinkingTurtle(200, 168, -1 - user.getIncrementDifficulty()));
						
		//Lane 3
		//With speed
		background.add(new LongLog(0, 224, -2 - user.getIncrementDifficulty()));
		background.add(new LongLog(400, 224, -2 - user.getIncrementDifficulty()));
						
		//Lane 4
		//With speed
		background.add(new ShortLog(50, 279, 0.75 + user.getIncrementDifficulty()));
		background.add(new ShortLog(270, 279, 0.75 + user.getIncrementDifficulty()));
		background.add(new ShortLog(490, 279, 0.75 + user.getIncrementDifficulty()));
			
		//Lane 5
		//With speed
		background.add(new NonSinkingTurtle(500, 327, -1 - user.getIncrementDifficulty()));
		background.add(new NonSinkingTurtle(300, 327, -1 - user.getIncrementDifficulty()));
		background.add(new SinkingTurtle(700, 330, -1 - user.getIncrementDifficulty()));
		
		if(user.getLevel() > 3) {
		//Grass Lane
		//With Speed
		background.add(new Snake(0, 392, 4 + user.getIncrementDifficulty()));
		}
		
		//Land
		//Lane1
		//With speed
		background.add(new TaxiCar(500, 500,-5 - user.getIncrementDifficulty()));
		
		//Lane 2
		//With speed
		background.add(new LongTruck(0, 540, 1 + user.getIncrementDifficulty()));
		background.add(new LongTruck(500, 540, 1 + user.getIncrementDifficulty()));
		//attribute
		//<a href='https://www.freepik.com/vectors/background'>Background vector created by vectorpocket - www.freepik.com</a>
						
		//Lane 3
		//With speed
		background.add(new RedCar(100, 604, -1 - user.getIncrementDifficulty()));
		background.add(new RedCar(250, 604, -1 - user.getIncrementDifficulty()));
		background.add(new RedCar(400, 604, -1 - user.getIncrementDifficulty()));
		background.add(new RedCar(550, 604, -1 - user.getIncrementDifficulty()));
				
		//Lane 4
		//With speed
		background.add(new RedTruck(0, 645, 1+ user.getIncrementDifficulty()));
		background.add(new YellowTruck(300, 647, 1+ user.getIncrementDifficulty()));
		background.add(new YellowTruck(600, 647, 1+ user.getIncrementDifficulty()));
		//attribute
		//<a href='https://www.freepik.com/vectors/background'>Background vector created by vectorpocket - www.freepik.com</a>
		
		background.add(user.getAnimal());
		GameScene = background;
		
		
		background.start();
		start();
	}
	
	public void start() {
		background.playMusic();
    	createTimer();
        timer.start();
    }
	
	public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	if (user.getAnimal().changeScore()) {
            		setNumber(user.getAnimal().getPoints());
            		System.out.println(user.getAnimal().getPoints());
            	}
            	if (user.getAnimal().getStop(currentLevel)) {
            		System.out.println("STOPP:");
            		user.setScore(user.getAnimal().getPoints());
            		user.setLevel(currentLevel + 1);
            		System.out.println("Score: " + user.getScore());
            		Main.user.setScore(user.getScore());
            		Main.user.setLevel(user.getLevel());
            		background.stopMusic();
            		stop();
            		background.stop();
            		/*
            		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/BetweenLevelScene.fxml"));
            		try {
						Pane pane = fxmlLoader.load();
						Scene scene = new Scene(pane, 800, 600);
						screen.addScene("BTL", scene);
						screen.activate("BTL");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            		*/
            		Main.setScene("BetweenLevelScene");
            	}
            }
        };
    }
	
    
    public void stop() {
        timer.stop();
    }
    
    public void displayScore() {
    	Frame scoreFrame = new Frame("file:src/main/resources/images/ScoreFrame.png", 160, 100, 330, 0);
		background.add(scoreFrame);
		score[0] = new Character(0, 460, 10);
		score[1] = new Character(0, 445, 10);
		score[2] = new Character(0, 430, 10);
		score[3] = new Character(0, 415, 10);
		background.add(score[0]);
		background.add(score[1]);
		background.add(score[2]);
		background.add(score[3]);
    }
    
    public void displayLevel() {
    	Frame levelFrame = new Frame("file:src/main/resources/images/LevelFrame.png", 110, 100, 490, 0);
		background.add(levelFrame);
		int shift = 0;
		char c;
		String l = Integer.toString(Main.user.getLevel());
		for(int i=0; i< l.length();i++) {
			c = l.charAt(i);
    		Character character = new Character(c, 565 + shift, 10);
    		background.add(character);
    		shift += character.getWidth();
		}
    }
   
    public void displayUsername(String name) {
    	int shift = 0;
    	char c;
    	Frame idFrame = new Frame("file:src/main/resources/images/IdFrame.png", 270, 400, 60, 0);
    	background.add(idFrame);
    	for(int i=0;i<name.length();i++) {
    		c = name.toUpperCase().charAt(i);
    		Character character = new Character(c, 115 + shift, 11);
    		background.add(character);
    		shift += character.getWidth();
    	}
    }
  
 
    public void displayMenuButton() {
    	Button menuButton = new Button();
    	ImageView menuButtonImage = new ImageView("file:src/main/resources/images/MenuButton.png");
		menuButtonImage.setFitHeight(32);
		menuButtonImage.setFitWidth(38);
		menuButton.setGraphic(menuButtonImage);
		menuButton.setLayoutX(4);
		menuButton.setLayoutY(1);
		menuButton.setStyle("-fx-focus-color: transparent;-fx-background-color: transparent");
		menuButton.setCursor(Cursor.HAND);
		background.getChildren().add(menuButton);
		menuButton.setOnAction(e ->{
			stop();
			background.stopMusic();
			background.stop();
    		Dialog<ButtonType> dialog = new Dialog<ButtonType>();
    		dialog.setTitle("Game Paused");
    		dialog.setContentText("Select The Options Below:");
    		ButtonType buttonTypeResume = new ButtonType("Yes", ButtonData.YES);
    		ButtonType buttonTypeNo = new ButtonType("No", ButtonData.NO);
    		ButtonType buttonTypeYes = new ButtonType("Yes", ButtonData.YES);

    		dialog.getDialogPane().getButtonTypes().addAll(buttonTypeYes, buttonTypeNo);
    		Optional<ButtonType> result = dialog.showAndWait();
    		if(result.get() == buttonTypeYes) {
    			background.start();
    			start();
    			System.out.println("Testing start successful");
    		}
		});
    }
    
    //Altered from a while loop to a for loop
    //Solved problem displaying 0 in the hundreds if its a two digit number
    public void setNumber(int n) {
    	for (int i = 0; i < 4; i++) {
    		int d = n / 10;
    		int k = n - d * 10;
    		score[i].setCharacter(k);
    		n = d;
    	}
    }
      
    public Pane getScene() {
    	return GameScene;
    }
    

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}



