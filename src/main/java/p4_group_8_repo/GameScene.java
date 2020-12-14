package p4_group_8_repo;


import javafx.animation.AnimationTimer;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import p4_group_8_repo.actor.BackgroundImage;
import p4_group_8_repo.actor.Character;
import p4_group_8_repo.actor.Crocodile;
import p4_group_8_repo.actor.Frame;
import p4_group_8_repo.actor.Lilypad;
import p4_group_8_repo.actor.LongLog;
import p4_group_8_repo.actor.NonSinkingTurtle;
import p4_group_8_repo.actor.ShortLog;
import p4_group_8_repo.actor.SinkingTurtle;
import p4_group_8_repo.actor.obstacle.LongTruck;
import p4_group_8_repo.actor.obstacle.RedCar;
import p4_group_8_repo.actor.obstacle.RedTruck;
import p4_group_8_repo.actor.obstacle.Snake;
import p4_group_8_repo.actor.obstacle.TaxiCar;
import p4_group_8_repo.actor.obstacle.YellowTruck;
import p4_group_8_repo.controller.SceneController;
import p4_group_8_repo.user.User;

public class GameScene{

	public User user = Main.getUser();
	private MyStage background;
	AnimationTimer timer;
	private Character[] score = new Character[4];
	private Pane GameScene;
	private int currentLevel;
	public SceneController scene;
	

	public GameScene() {
		
		setBackground(new MyStage());
		BackgroundImage gameBack = new BackgroundImage("file:src/main/resources/images/PageBackground/Map.png");
		getBackground().add(gameBack);
		currentLevel = user.getLevel();
		System.out.println("User detail:");
		System.out.println("User Name in Game Scene:"+ user.getUsername());
		System.out.println("User level:" + user.getLevel());
		
		displayMenuButton();
		displayScore();
		displayLevel();
		
		//End
		//The ending point
		if(user.getLevel() == 1 || user.getLevel() == 4 || user.getLevel() == 7 || user.getLevel() == 10) {
			getBackground().add(new Lilypad(13,45));
			getBackground().add(new Lilypad(141,45));
			getBackground().add(new Lilypad(141 + 141-13,45));
			getBackground().add(new Lilypad(141 + 141-13+141-13+1,45));
			getBackground().add(new Lilypad(141 + 141-13+141-13+141-13+3,45));
		}else if(user.getLevel() == 2 || user.getLevel() == 5 || user.getLevel() == 8) {
			getBackground().add(new Lilypad(13,45));
			getBackground().add(new Crocodile(130,45));
			getBackground().add(new Lilypad(141 + 141-13,45));
			getBackground().add(new Crocodile(130 + 141-13+141-13+1,45));
			getBackground().add(new Lilypad(141 + 141-13+141-13+141-13+3,45));
		}else if(user.getLevel() == 3 || user.getLevel() == 6 || user.getLevel() == 9) {
			getBackground().add(new Crocodile(13,45));
			getBackground().add(new Lilypad(141,45));
			getBackground().add(new Crocodile(141 + 141-13,45));
			getBackground().add(new Lilypad(141 + 141-13+141-13+1,45));
			getBackground().add(new Crocodile(135 + 141-13+141-13+141-13+3,45));
		}
		
		//Water
		//Lane counting from top to bottom
		//Lane 1
		//With speed
		getBackground().add(new ShortLog(0, 120, 0.75 + user.getIncrementDifficulty()));
		getBackground().add(new ShortLog(220, 120, 0.75 + user.getIncrementDifficulty()));
		getBackground().add(new ShortLog(440, 120, 0.75 + user.getIncrementDifficulty()));

		//Lane 2
		//With speed
		getBackground().add(new SinkingTurtle(600, 168, -1 - user.getIncrementDifficulty()));
		getBackground().add(new SinkingTurtle(400, 168, -1 - user.getIncrementDifficulty()));
		getBackground().add(new SinkingTurtle(200, 168, -1 - user.getIncrementDifficulty()));
						
		//Lane 3
		//With speed
		getBackground().add(new LongLog(0, 224, -2 - user.getIncrementDifficulty()));
		getBackground().add(new LongLog(400, 224, -2 - user.getIncrementDifficulty()));
						
		//Lane 4
		//With speed
		getBackground().add(new ShortLog(50, 279, 0.75 + user.getIncrementDifficulty()));
		getBackground().add(new ShortLog(270, 279, 0.75 + user.getIncrementDifficulty()));
		getBackground().add(new ShortLog(490, 279, 0.75 + user.getIncrementDifficulty()));
			
		//Lane 5
		//With speed
		getBackground().add(new NonSinkingTurtle(500, 327, -1 - user.getIncrementDifficulty()));
		getBackground().add(new NonSinkingTurtle(300, 327, -1 - user.getIncrementDifficulty()));
		getBackground().add(new SinkingTurtle(700, 330, -1 - user.getIncrementDifficulty()));
		
		if(user.getLevel() > 3) {
		//Grass Lane
		//With Speed
		getBackground().add(new Snake(0, 392, 4 + user.getIncrementDifficulty()));
		}
		
		//Land
		//Lane1
		//With speed
		getBackground().add(new TaxiCar(500, 500,-5 - user.getIncrementDifficulty()));
		
		//Lane 2
		//With speed
		getBackground().add(new LongTruck(0, 540, 1 + user.getIncrementDifficulty()));
		getBackground().add(new LongTruck(500, 540, 1 + user.getIncrementDifficulty()));
		//attribute
		//<a href='https://www.freepik.com/vectors/background'>Background vector created by vectorpocket - www.freepik.com</a>
						
		//Lane 3
		//With speed
		getBackground().add(new RedCar(100, 604, -1 - user.getIncrementDifficulty()));
		getBackground().add(new RedCar(250, 604, -1 - user.getIncrementDifficulty()));
		getBackground().add(new RedCar(400, 604, -1 - user.getIncrementDifficulty()));
		getBackground().add(new RedCar(550, 604, -1 - user.getIncrementDifficulty()));
				
		//Lane 4
		//With speed
		getBackground().add(new RedTruck(0, 645, 1+ user.getIncrementDifficulty()));
		getBackground().add(new YellowTruck(300, 647, 1+ user.getIncrementDifficulty()));
		getBackground().add(new YellowTruck(600, 647, 1+ user.getIncrementDifficulty()));
		//attribute
		//<a href='https://www.freepik.com/vectors/background'>Background vector created by vectorpocket - www.freepik.com</a>
		
		getBackground().add(user.getAnimal());
		GameScene = getBackground();
		getBackground().start();
		start();
	}
	
	public void start() {
		getBackground().playMusic();
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
            		Main.getUser().setScore(user.getScore());
            		Main.getUser().setLevel(user.getLevel());
            		stopGame(getBackground());
            		Main.setScene("BetweenLevelScene");
            		Main.getUser().setInGame(false);
            	}
            	if(user.getLevel() == 11) {
            		stopGame(getBackground());
            		Main.setScene("EndGameScene");
            		Main.getUser().setInGame(false);
            	}
            }
        };
    }
	
	/**
	 * Handles the stopping for background media, Timer from World Class and Timer from GameScene
	 * @param background A MyStage that represents the stage that holds the scene
	 */
	public void stopGame(MyStage background) {
		background.stopMusic();
		stop();
		background.stop();
	}
	
    
    public void stop() {
        timer.stop();
    }
    
    public void displayScore() {
    	Frame scoreFrame = new Frame("file:src/main/resources/images/Frame/ScoreFrame.png", 160, 100, 330, 0);
		getBackground().add(scoreFrame);
		score[0] = new Character(0, 460, 10);
		score[1] = new Character(0, 445, 10);
		score[2] = new Character(0, 430, 10);
		score[3] = new Character(0, 415, 10);
		getBackground().add(score[0]);
		getBackground().add(score[1]);
		getBackground().add(score[2]);
		getBackground().add(score[3]);
    }
    
    public void displayLevel() {
    	Frame levelFrame = new Frame("file:src/main/resources/images/Frame/LevelFrame.png", 110, 100, 490, 0);
		getBackground().add(levelFrame);
		int shift = 0;
		char c;
		String l = Integer.toString(Main.getUser().getLevel());
		for(int i=0; i< l.length();i++) {
			c = l.charAt(i);
    		Character character = new Character(c, 565 + shift, 10);
    		getBackground().add(character);
    		shift += character.getWidth();
		}
    }
   
    public void displayUsername(String name) {
    	int shift = 0;
    	char c;
    	Frame idFrame = new Frame("file:src/main/resources/images/Frame/IdFrame.png", 270, 400, 60, 0);
    	getBackground().add(idFrame);
    	for(int i=0;i<name.length();i++) {
    		c = name.toUpperCase().charAt(i);
    		Character character = new Character(c, 115 + shift, 11);
    		getBackground().add(character);
    		shift += character.getWidth();
    	}
    }
  
 
    public void displayMenuButton() {
    	Button menuButton = new Button();
    	ImageView menuButtonImage = new ImageView("file:src/main/resources/images/Button/MenuButton.png");
		menuButtonImage.setFitHeight(32);
		menuButtonImage.setFitWidth(38);
		menuButton.setGraphic(menuButtonImage);
		menuButton.setLayoutX(4);
		menuButton.setLayoutY(1);
		menuButton.setStyle("-fx-focus-color: transparent;-fx-background-color: transparent");
		menuButton.setCursor(Cursor.HAND);
		getBackground().getChildren().add(menuButton);
		menuButton.setOnAction(e ->{
			stop();
			getBackground().stopMusic();
			getBackground().stop();
			Main.getUser().setInGame(true);
			Main.setScene("PauseScene");
			
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

	public MyStage getBackground() {
		return background;
	}

	public void setBackground(MyStage background) {
		this.background = background;
	}

}