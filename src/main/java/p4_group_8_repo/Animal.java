package p4_group_8_repo;

import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * Represents the main character in the gameplay
 * @author Liew Yih Seng
 *
 */
public class Animal extends Actor {
	Image imgW1;
	Image imgA1;
	Image imgS1;
	Image imgD1;
	Image imgW2;
	Image imgA2;
	Image imgS2;
	Image imgD2;
	int points = 0;
	int end = 0;
	boolean flag;
	private boolean second = false;
	boolean noMove = false;
	double movement = 13.3333333*2;
	double movementX = 10.666666*2;
	int imgSize = 40;
	boolean carDeath = false;
	boolean waterDeath = false;
	boolean stop = false;
	boolean changeScore = false;
	int death = 0;
	double w = 800;
	ArrayList<Lilypad> interLily = new ArrayList<Lilypad>();
	ArrayList<Crocodile> interCroc = new ArrayList<Crocodile>();
	
	/**
	 * Construct an instance of animal that act as the main character in the gameplay
	 */
	public Animal() {
		imgW1 = frogMovementImg("froggerUp.png");
		imgA1 = frogMovementImg("froggerLeft.png");
		imgS1 = frogMovementImg("froggerDown.png");
		imgD1 = frogMovementImg("froggerRight.png");
		imgW2 = frogMovementImg("froggerUpJump.png");
		imgA2 = frogMovementImg("froggerLeftJump.png");
		imgS2 = frogMovementImg("froggerDownJump.png");
		imgD2 = frogMovementImg("froggerRightJump.png");
		setImage(imgW1);
		setCoordinate(275, (int) (679.8+movement));
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event){
				if (noMove) {
					
				}
				else {
				if (isSecond()) {
					if (testKeyW(event)) {	 
						moveLocationDisplay(0, -movement, imgW1);
		                move(0, -movement);
		                changeScore = false;
		                setImage(imgW1);
		                setSecond(false);
		            }
		            else if (testKeyA(event)) {
		            	moveLocationDisplay(-movementX, 0, imgA1);
		            	setSecond(false);
		            }
		            else if (testKeyA(event)) {
		            	moveLocationDisplay(0, movement, imgS1);
		            	setSecond(false);
		            }
		            else if (testKeyD(event)) {
		            	moveLocationDisplay(movementX, 0, imgD1);
		            	setSecond(false);
		            }
				}
				else if (testKeyW(event)) {
					moveLocationDisplay(0, -movement, imgW2);
					setSecond(false);
	            }
	            else if (testKeyA(event)) {	
	            	moveLocationDisplay(-movementX, 0, imgA2);
	            	setSecond(false);
	            }
	            else if (testKeyS(event)) {	
	            	moveLocationDisplay(0, movement, imgS2);
	            	setSecond(false);
	            }
	            else if (testKeyD(event)) {
	            	moveLocationDisplay(movementX, 0, imgD2);
	            	setSecond(false);
	            }
	        }
			}
		});	
		setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if (noMove) {

				}
				else {
					if (event.getCode() == KeyCode.W) {	  
						if (getY() < w) {
							changeScore = true;
							w = getY(); // Keep track of which coordinate-y you die at
							points += 10; // Add 10points to every step forward you have made
						}
						moveLocationDisplay(0, -movement, imgW1);
		                setSecond(false);
		            }
		            else if (event.getCode() == KeyCode.A) {	
		            	moveLocationDisplay(-movementX, 0, imgA1);
		            	setSecond(false);
		            }
		            else if (event.getCode() == KeyCode.S) {
		            	moveLocationDisplay(0, movement, imgS1);
		            	setSecond(false);
		            }
		            else if (event.getCode() == KeyCode.D) {	       
		            	moveLocationDisplay(movementX, 0, imgD1);
		            	setSecond(false);
		            }
				}
			}
			
		});
	}
	
	
	@Override
	public void act(long now) {
		int bounds = 0;
		
		//Setting the bound for gameplay(height) (Frog will always be within the screen on land)
		if (getY() < 0 || getY() > 734) {
			setCoordinate(275, (int) (679.8+movement));
		}
		
		//Bound for Screen(left)
		if (getX() < 0) {
			move(movement*2, 0);
		}
		
		//Bound for Screen(right)
		if (getX() > 600) {
			move(-movement*2, 0);
		}

		if (isCarDeath()) {
			changeScore = true;
			deathLoopAnimation(now);
			carDeathAnimation();
		}
		
		if (isWaterDeath()) {
			changeScore = true;
			deathLoopAnimation(now);
			waterDeathAnimation();
		}
		
		if (getIntersectingObjects(Obstacle.class).size() >= 1) {
			setCarDeath(true);
		}
		
		if (getX() == 240 && getY() == 82) {
			stop = true;
		}
		
		if (getIntersectingObjects(Log.class).size() >= 1 && !noMove) {
			if(getIntersectingObjects(Log.class).get(0).getLeft()) {
				move(-2 - Main.getUser().getIncrementDifficulty(), 0); //move left with speed of 2
			//Controlling logs moving left
			}
			else {
				move (.75 + Main.getUser().getIncrementDifficulty(), 0); //move right with speed of 0.75
				//Controlling logs moving right
			}
		}
		else if (getIntersectingObjects(NonSinkingTurtle.class).size() >= 1 && !noMove) {
			move(-1 - Main.getUser().getIncrementDifficulty(), 0); // move left with the speed of 1
		}
		else if (getIntersectingObjects(SinkingTurtle.class).size() >= 1) {
			if (getIntersectingObjects(SinkingTurtle.class).get(0).isSunk()) {
				setWaterDeath(true); //When water death is true, frog step on will cause death
			} else {
				move(-1 - Main.getUser().getIncrementDifficulty(), 0); // move left with the speed of 1
			}
		}
		else if (getIntersectingObjects(Lilypad.class).size() >= 1) {
			interLily = (ArrayList<Lilypad>) getIntersectingObjects(Lilypad.class);
			if (getIntersectingObjects(Lilypad.class).get(0).isActivated()) {
				end--;
				points -= 60;
			}
				points += 50;
				changeScore = true;
				w = 800;
				getIntersectingObjects(Lilypad.class).get(0).setEnd();
				end++;
				setCoordinate(275, (int) (679.8+movement));
			}

		else if (getY() < 360 ){
			setWaterDeath(true);
			//setX(300);
			//setY(679.8+movement);
		}
		else if (getY() < 360)
			if(getX() >600 || getX() < 0 ) {
				setWaterDeath(true);
			}
		}
	
	/**
	 * Gets the number of ends in a level
	 * @param level An integer representing the current level of the user
	 * @return A boolean that is used to trigger a stop between level switching
	 */
	public boolean getStop(int level) {
		flag = false;
		switch (level){
			case 1:
			case 4:
			case 7: 
			case 10:
				if(end == 5) {
					end = 0;
					flag = true;
					changeScore = true;
				}
				break;
			case 2:
			case 5:
			case 8:
				if(end == 3) {
					end = 0;
					flag = true;
					changeScore = true;
				}
				break;
			case 3:
			case 6:
			case 9:
				if(end == 2) {
					end = 0;
					flag = true;
					changeScore = true;
				}
				break;
		}
		return flag;
	}
	
	/**
	 * Gets the number of points in the current game
	 * @return An integer representing the p[oints of user in the current game
	 */
	public int getPoints() {
		return points;
	}
	
	/**
	 * Sets the number of points in the current game
	 * @param points An integer representing the current point of user in the game
	 */
	public void setPoints(int points) {
		this.points = points;
	}
	
	/**
	 * Determine whether the frog is at its second animation
	 * @return A boolean representing the state of the frog
	 */
	public boolean isSecond() {
		return second;
	}

	/**
	 * Sets the state of animation of the frog
	 * @param second A boolean representing if the frog's animation is at the second state
	 */
	public void setSecond(boolean second) {
		this.second = second;
	}
	
	/**
	 * Gets if the death type is by car
	 * @return A boolean representing whether the death is by car
	 */
	public boolean isCarDeath() {
		return carDeath;
	}
	
	/**
	 * Sets the death type to car death
	 * @param carDeath A boolean stating if the death type is car death
	 */
	public void setCarDeath(boolean carDeath) {
		this.carDeath = carDeath;
	}

	/**
	 * Gets if the death type is by water
	 * @return A boolean representing whether the death is by water
	 */
	public boolean isWaterDeath() {
		return waterDeath;
	}

	/**
	 * Sets the death type to water death
	 * @param waterDeath A boolean stating if the death type is water death
	 */
	public void setWaterDeath(boolean waterDeath) {
		this.waterDeath = waterDeath;
	}

	/**
	 * Sets the necessity to change score
	 * @return a boolean stating the necessity to change score
	 */
	public boolean changeScore() {
		if (changeScore) {
			this.changeScore = false;
			return true;
		}
		return false;
	}
	
	/**
	 * Displays the animation of the frog being crashed by a car as clock ticks
	 */
	public void carDeathAnimation(){
		int deathType = 1;
		if (death == 1) {
			setDeathAniImg("CarDeath1");
		}
		if (death == 2) {
			setDeathAniImg("CarDeath2");
		}
		if (death == 3) {
			setDeathAniImg("CarDeath3");
		}
		if (death == 4) {
			setDeathAniImg("CarDeath4");
		}
		if (death == 5) {
			setDeathAniImg("CarDeath5");
		}
		if (death == 6) {
			setDeathAniImg("CarDeath6");
		}
		// attribute
		// <a href="https://www.freepik.com/vectors/cartoon">Cartoon vector created by freepik - www.freepik.com</a>
		if (death == 7) {
			respawn(deathType);
			deathScoreDecrement(points, changeScore);
		}
	}
	
	/**
	 * Displays the animation of the frog drowning in the river as clock ticks
	 */
	public void waterDeathAnimation() {
		int deathType = 2;
		if (death == 1) {
			setDeathAniImg("WaterDeath1");
		}
		if (death == 2) {
			setDeathAniImg("WaterDeath2");
		}
		if (death == 3) {
			setDeathAniImg("WaterDeath3");
		}
		if (death == 4) {
			setDeathAniImg("WaterDeath4");
		}
		if (death == 5) {
			respawn(deathType);
			deathScoreDecrement(points, changeScore);
		}
	}
	
	/**
	 * Decrement in the score if the frog is dead
	 * @param points An integer representing the current point of the user
	 * @param changeScore A boolean representing the necessity to change score
	 */
	public void deathScoreDecrement(int points, Boolean changeScore) {
		if(getPoints() > 50) {
			points -= 50;
			setPoints(points);
			changeScore = true;
		}
	}
	
	/**
	 * Sets the respawn point of the frog when it dies
	 * @param deathType An integer representing the death type of the frog
	 */
	public void respawn(int deathType) {
		//Set Respawn
		setCoordinate(275, (int)(679.8 + movement));
		death = 0;
		switch(deathType) {
		case 1 :
			carDeath = false;
			break;
			
		case 2 :
			waterDeath = false;
			break;
		}
		setImage(imgW1);
		noMove = false;
	}
	
	/**
	 * Acts a clock tick in changing the death animation of the frog
	 * @param now A long integer representing the clock tick
	 */
	public void deathLoopAnimation(long now) {
		noMove = true;
		if ((now)% 11 ==0) {
			death++;
		}
	}
	
	/**
	 * Gets the image of the current frog movement
	 * @param imageName A string that represents the current frog movement
	 * @return An image of the current frog movement
	 */
	public Image frogMovementImg(String imageName) {	
		return new Image("file:src/main/resources/images/"+ imageName, imgSize, imgSize, true, true);
	}
	
	/**
	 * Sets the location of the frog after the jump and it corresponding image animation
	 * @param xpos A double that represents the coordinate of X-axis of the frog
	 * @param ypos A double that represents the coordinate of Y-axis of the frog
	 * @param img The corresponding image of the frog after the jump
	 */
	public void moveLocationDisplay(double xpos, double ypos,Image img) {
		move(xpos, ypos);
		setImage(img);
	}
	
	/**
	 * Determines if the keyboard input is W
	 * @param event A key event that represents the user input's key
	 * @return A boolean stating whether the key input is W
	 */
	public boolean testKeyW(KeyEvent event) {
		return event.getCode() == KeyCode.W;
	}
	
	/**
	 * Determines if the keyboard input is A
	 * @param event A key event that represents the user input's key
	 * @return A boolean stating whether the key input is A
	 */
	public boolean testKeyA(KeyEvent event) {
		return event.getCode() == KeyCode.A;
	}
	
	/**
	 * Determines if the keyboard input is S
	 * @param event A key event that represents the user input's key
	 * @return A boolean stating whether the key input is S
	 */
	public boolean testKeyS(KeyEvent event) {
		return event.getCode() == KeyCode.S;
	}
	
	/**
	 * Determines if the keyboard input is D
	 * @param event A key event that represents the user input's key
	 * @return A boolean stating whether the key input is D
	 */
	public boolean testKeyD(KeyEvent event) {
		return event.getCode() == KeyCode.D;
	}
	
	
	/**
	 * Sets the image for the death animation of the frog
	 * @param imageName A String that represents the name of the image
	 */
	public void setDeathAniImg(String imageName) {
		setImage(DeathAnimationImg(imageName));
	}
	
	/**
	 * Retrieves the image of death animation from the project directory
	 * @param imageName A string that represents the name of the image
	 * @return An image that corresponds to the imageName and the current phase of death animation of the frog
	 */
	public Image DeathAnimationImg(String imageName) {
		return new Image("file:src/main/resources/images/"+ imageName +".png", imgSize, imgSize, true, true);
	}
	
}
