package p4_group_8_repo.actor;

import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import p4_group_8_repo.Main;
import p4_group_8_repo.actor.obstacle.Obstacle;

/**
 * Represents the protagonist in the game play.
 * @author Liew Yih Seng
 *
 */
public class Animal extends Actor {
	static final int IMGSIZE = 40;
	
	
	
//	Image imgW1 = new Image("file:src/main/resources/images/FrogAnimation/froggerUp.png", IMGSIZE, IMGSIZE, true, true);
//	Image imgA1 = new Image("file:src/main/resources/images/FrogAnimation/froggerLeft.png", IMGSIZE, IMGSIZE, true, true);
//	Image imgS1 = new Image("file:src/main/resources/images/FrogAnimation/froggerDown.png", IMGSIZE, IMGSIZE, true, true);
//	Image imgD1 = new Image("file:src/main/resources/images/FrogAnimation/froggerRight.png", IMGSIZE, IMGSIZE, true, true);
//	Image imgW2 = new Image("file:src/main/resources/images/FrogAnimation/froggerUpJump.png", IMGSIZE, IMGSIZE, true, true);
//	Image imgA2 = new Image("file:src/main/resources/images/FrogAnimation/froggerLeftJump.png", IMGSIZE, IMGSIZE, true, true);
//	Image imgS2 = new Image("file:src/main/resources/images/FrogAnimation/froggerDownJump.png", IMGSIZE, IMGSIZE, true, true);
//	Image imgD2 = new Image("file:src/main/resources/images/FrogAnimation/froggerRightJump.png", IMGSIZE, IMGSIZE, true, true);
	
	
	Image imgW1 = frogMovementImg("froggerUp.png");
	Image imgA1 = frogMovementImg("froggerLeft.png");
	Image imgS1 = frogMovementImg("froggerDown.png");
	Image imgD1 = frogMovementImg("froggerRight.png");
	Image imgW2 = frogMovementImg("froggerUpJump.png");
	Image imgA2 = frogMovementImg("froggerLeftJump.png");
	Image imgS2 = frogMovementImg("froggerDownJump.png");
	Image imgD2 = frogMovementImg("froggerRightJump.png");
	int points = 0;
	int end = 0;
	boolean flag;
	private boolean second = false;
	boolean noMove = false;
	double movement = 13.3333333*2;
	double movementX = 10.666666*2;
	boolean carDeath = false;
	boolean waterDeath = false;
	boolean changeScore = false;
	int death = 0;
	double w = 800;
	MovementKeys keys = new MovementKeys();
	ArrayList<Lilypad> interLily = new ArrayList<Lilypad>();
	ArrayList<Crocodile> interCroc = new ArrayList<Crocodile>();
	
	
	/**
	 * Construct an instance of animal that acts as the protagonist in the game play.
	 */
	public Animal() {
		
		setImage(imgW1);
		
		setCoordinate(275, (int) (679.8+movement));
		
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event){
				if (noMove) {
					
				}
				else {
					if (isSecond()) {
						if (keys.testKeyW(event)) {	 
							moveLocationDisplay(0, -movement, imgW1);
			                move(0, -movement);
			                changeScore = false;
			                setImage(imgW1);
			                setSecond(false);
			            }
			            else if (keys.testKeyA(event)) {
			            	moveLocationDisplay(-movementX, 0, imgA1);
			            	setSecond(false);
			            }
			            else if (keys.testKeyS(event)) {
			            	moveLocationDisplay(0, movement, imgS1);
			            	setSecond(false);
			            }
			            else if (keys.testKeyD(event)) {
			            	moveLocationDisplay(movementX, 0, imgD1);
			            	setSecond(false);
			            }
					}
					else if (keys.testKeyW(event)) {
						moveLocationDisplay(0, -movement, imgW2);
						setSecond(false);
		            }
		            else if (keys.testKeyA(event)) {	
		            	moveLocationDisplay(-movementX, 0, imgA2);
		            	setSecond(false);
		            }
		            else if (keys.testKeyS(event)) {	
		            	moveLocationDisplay(0, movement, imgS2);
		            	setSecond(false);
		            }
		            else if (keys.testKeyD(event)) {
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
					if (keys.testKeyW(event)) {	  
						if (getY() < w) {
							changeScore = true;
							w = getY(); // Keep track of which y-coordinate you die at
							points += 10; // Add 10points to every step forward you have made
						}
						moveLocationDisplay(0, -movement, imgW1);
		                setSecond(false);
		            }
		            else if (keys.testKeyA(event)) {	
		            	moveLocationDisplay(-movementX, 0, imgA1);
		            	setSecond(false);
		            }
		            else if (keys.testKeyS(event)) {
		            	moveLocationDisplay(0, movement, imgS1);
		            	setSecond(false);
		            }
		            else if (keys.testKeyD(event)) {	       
		            	moveLocationDisplay(movementX, 0, imgD1);
		            	setSecond(false);
		            }
				}
			}
			
		});
	}
	
	
	/**
	 * Determine how this animal should act during game play.
	 * It will invoke various method such as {@link Animal#setHeightBound()}, {@link Animal#setLeftBound()},
	 * {@link Animal#setRightBound()}, {@link Animal#setCarDeathAnimation(long)}, {@link Animal#setWaterDeath(boolean)} 
	 * and {@link Animal#setCrashObstacle()} to set the reaction of this animal on certain limitation. Then it will perform
	 * several if else test to check if this animal has intersected with any of the {@link Actor} class objects.
	 * This method will be invoked during every clock tick checking for the suitable actions
	 * to be set on the animal.
	 */
	@Override
	public void act(long now) {
	
		setHeightBound();
		
		setLeftBound();
		
		setRightBound();

		setCarDeathAnimation(now);
		
		setWaterDeathAnimation(now);
		
		setCrashObstacle();
		
		/**
		 * Sets this animal by attaching it onto the log once it landed on the log.
		 * This method will allow this animal to move with the log at a same speed and the same
		 * direction, preventing this animal from slipping off the log.
		 */
		if (getIntersectingObjects(Log.class).size() >= 1 && !noMove) {
			if(getIntersectingObjects(Log.class).get(0).getLeft()) {
				move(-2 - Main.getUser().getIncrementDifficulty(), 0); //move left with speed of 2
				//Controlling logs moving left
			}else {
				move (.75 + Main.getUser().getIncrementDifficulty(), 0); //move right with speed of 0.75
				//Controlling logs moving right
			}
		}
		
		/**
		 * Sets this animal by attaching it onto the non sinking turtle once it landed on the non sinking turtle.
		 * This method will allow this animal to move with the non sinking turtle at a same speed and the same
		 * direction, preventing this animal from slipping off the non sinking turtle.
		 */
		else if (getIntersectingObjects(NonSinkingTurtle.class).size() >= 1 && !noMove) {
			move(-1 - Main.getUser().getIncrementDifficulty(), 0); // move left with the speed of 1
		}
		
		/**
		 * Sets this animal by attaching it onto the sinking turtle once it landed on the sinking turtle.
		 * This method will allow this animal to move with the sinking turtle at a same speed and the same
		 * direction, preventing this animal from slipping off the sinking turtle.
		 */
		else if (getIntersectingObjects(SinkingTurtle.class).size() >= 1) {
			if (getIntersectingObjects(SinkingTurtle.class).get(0).isSunk()) {
				setWaterDeath(true); //When water death is true, frog step on will cause death
			}else {
				move(-1 - Main.getUser().getIncrementDifficulty(), 0); // move left with the speed of 1
			}
		}
		
		/**
		 * When the lilypad is being activated, increment of score will not occur
		 * when the user once again landed on it.
		 */
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

		/**
		 * Sets the boundary of the water(hazard) when Y-coordinate < 360
		 */
		else if (getY() < 360){
			setWaterDeath(true);
		}
		
		/**
		 * Sets the boundary of water (hazard) to greater than X-Coordinate greater
		 * than 600 and lesser than 0.
		 */
		else if (getY() < 360) {
			if(getX() >600 || getX() < 0 ) {
				setWaterDeath(true);
			}
		}
		
	}
	
	/**
	 * Sets the image of the current animal movement.
	 * @param imageName A string that represents the current animal movement.
	 * @return An image of the current animal movement.
	 */
	public Image frogMovementImg(String imageName) {	
		return new Image("file:src/main/resources/images/FrogAnimation/"+ imageName, IMGSIZE, IMGSIZE, true, true);
	}
	
	/**
	 * Setting the height bound of the game play where this animal will always be kept within the screen
	 * of size 600 x 800 (W x H) by invoking the method {@link #setCoordinate(int, int)} that resets the
	 * position of this animal back to the initial starting point if by any chance it crossed the border.
	 */
	public void setHeightBound() {
		if(getY() < 0 || getY() > 734) {
			setCoordinate(275, (int)(679.8+movement));
		}
	}
	

	/**
	 * Sets the left bound of the game play at X-coordinate of 0.
	 * Where this animal will be move back into the screen if it touches the left bound by
	 * invoking the {@link #move(double, double)} method.
	 */
	public void setLeftBound(){
		if(getX() < 0) {
			move(movement * 2, 0);
		}
	}
	
	/**
	 * Sets the right bound of the game play at X-coordinate of 600.
	 * Where this animal will be move back into the screen if it touches the right bound by
	 * invoking the {@link #move(double, double)} method.
	 */
	public void setRightBound() {
		if(getX() > 600) {
			move(-movement * 2, 0);
		}
	}
	
	/**
	 * A method that checks if this animal's death is caused by crashing onto an obstacle.
	 * If the test condition returns true, it invokes the {@link #deathLoopAnimation(long)}
	 * which triggers the change of car death animation in the method {@link #carDeathAnimation()}.
	 * @param now A long integer that represents the current clock tick.
	 */
	public void setCarDeathAnimation(long now) {
		if (isCarDeath()) {
			changeScore = true;
			deathLoopAnimation(now);
			carDeathAnimation();
		}
	}
	
	/**
	 * A method that checks if this animal's death is caused by drowning in water.
	 * If the test condition returns true, it invokes the {@link #deathLoopAnimation(long)}
	 * which triggers the change of water death animation in the method {@link #waterDeathAnimation()}.
	 * @param now A long integer that represents the current clock tick.
	 */
	public void setWaterDeathAnimation(long now) {
		if (isWaterDeath()) {
			changeScore = true;
			deathLoopAnimation(now);
			waterDeathAnimation();
		}
	}
	
	/**
	 * A method that sets the death of this animal to car crash if the test condition
	 * using method {@link #getIntersectingObjects(Class)} states that the animal has intersected
	 * with an {@link Obstacle} class object returns true.
	 */
	public void setCrashObstacle() {
		if (getIntersectingObjects(Obstacle.class).size() >= 1) {
			setCarDeath(true);
		}
	}
	
	/**
	 * Gets the number of ends in a level.
	 * @param level An integer representing the current level of the user.
	 * @return A boolean that is used to trigger a stop between level switching.
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
	 * Gets the number of points in the current game.
	 * @return An integer representing the points of user in the current game.
	 */
	public int getPoints() {
		return points;
	}
	
	/**
	 * Sets the number of points in the current game.
	 * @param points An integer representing the current point of user in the game.
	 */
	public void setPoints(int points) {
		this.points = points;
	}
	
	/**
	 * Determine whether this animal is at its second jump animation.
	 * @return A boolean representing the jump state of this animal.
	 */
	public boolean isSecond() {
		return second;
	}

	/**
	 * Sets the jump state animation of this animal.
	 * @param second A boolean representing if this animal's animation is at the second jump state.
	 */
	public void setSecond(boolean second) {
		this.second = second;
	}
	
	/**
	 * Gets if the death type is by hitting an obstacle.
	 * @return A boolean representing whether the death is by hitting an obstacle.
	 */
	public boolean isCarDeath() {
		return carDeath;
	}
	
	/**
	 * Sets the death type to car death (hitting an obstacle).
	 * @param carDeath A boolean stating if the death type is car death (hitting an obstacle).
	 */
	public void setCarDeath(boolean carDeath) {
		this.carDeath = carDeath;
	}

	/**
	 * Gets if the death type is by water.
	 * @return A boolean representing whether the death is by water.
	 */
	public boolean isWaterDeath() {
		return waterDeath;
	}

	/**
	 * Sets the death type to water death.
	 * @param waterDeath A boolean stating if the death type is water death.
	 */
	public void setWaterDeath(boolean waterDeath) {
		this.waterDeath = waterDeath;
	}

	/**
	 * Trigger score change in gameScene's score counter.
	 * @return A boolean stating the necessity to change score.
	 */
	public boolean changeScore() {
		if (changeScore) {
			this.changeScore = false;
			return true;
		}
		return false;
	}
	
	/**
	 * Displays the animation of this animal being crashed by a car(obstacle) as clock ticks.
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
			deathScoreDecrement(points);
		}
	}
	
	/**
	 * Displays the animation of this animal drowning in the water as clock ticks.
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
			deathScoreDecrement(points);
		}
	}
	
	/**
	 * Decrement in the score if this animal is dead.
	 * @param points An integer representing the current point of the user.
	 */
	public void deathScoreDecrement(int points) {
		if(points > 50) {
			points -= 50;
			setPoints(points);
			changeScore = true;
		}
	}
	
	/**
	 * Sets the respawn point of this animal when it dies.
	 * @param deathType An integer representing the death type of this animal.
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
	 * Process the clock tick to change the death animation of this animal.
	 * @param now A long integer representing the clock tick.
	 */
	public void deathLoopAnimation(long now) {
		noMove = true;
		if ((now)% 11 ==0) {
			death++;
		}
	}
	

	
	/**
	 * Sets the location of this animal after the jump and it corresponding image animation.
	 * @param xpos A double that represents the coordinate of X-axis of this animal.
	 * @param ypos A double that represents the coordinate of Y-axis of this animal.
	 * @param img The corresponding image of this animal after the jump.
	 */
	public void moveLocationDisplay(double xpos, double ypos,Image img) {
		move(xpos, ypos);
		setImage(img);
	}
	
	/**
	 * Sets the image for the death animation of this animal.
	 * @param imageName A String that represents the name of the image.
	 */
	public void setDeathAniImg(String imageName) {
		setImage(DeathAnimationImg(imageName));
	}
	
	/**
	 * Retrieves the image of death animation from the project directory.
	 * @param imageName A string that represents the name of the image.
	 * @return An image that corresponds to the imageName and the current phase of death animation of this animal.
	 */
	public Image DeathAnimationImg(String imageName) {
		return new Image("file:src/main/resources/images/DeathAnimation/"+ imageName +".png", IMGSIZE, IMGSIZE, true, true);
	}
	
}
