package p4_group_8_repo;

import java.util.ArrayList;

import javafx.event.EventHandler;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


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
	private boolean second = false;
	boolean noMove = false;
	double movement = 13.3333333*2;
	double movementX = 10.666666*2;
	int imgSize = 40;
	int imgSizeWater = 70;
	boolean carDeath = false;
	boolean waterDeath = false;
	boolean stop = false;
	boolean changeScore = false;
	int death = 0;
	double w = 800;
	ArrayList<End> inter = new ArrayList<End>();
	
	
	public Animal() {
		setImage(new Image("file:src/p4_group_8_repo/froggerUp.png", imgSize, imgSize, true, true));
		setCoordinate(275, (int) (679.8+movement));
		imgW1 = frogMovementImg("file:src/p4_group_8_repo/froggerUp.png");
		imgA1 = frogMovementImg("file:src/p4_group_8_repo/froggerLeft.png");
		imgS1 = frogMovementImg("file:src/p4_group_8_repo/froggerDown.png");
		imgD1 = frogMovementImg("file:src/p4_group_8_repo/froggerRight.png");
		imgW2 = frogMovementImg("file:src/p4_group_8_repo/froggerUpJump.png");
		imgA2 = frogMovementImg("file:src/p4_group_8_repo/froggerLeftJump.png");
		imgS2 = frogMovementImg("file:src/p4_group_8_repo/froggerDownJump.png");
		imgD2 = frogMovementImg("file:src/p4_group_8_repo/froggerRightJump.png");
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event){
				if (noMove) {
					
				}
				else {
				if (second) {
					if (testKeyW(event)) {	 
						moveLocationDisplay(0, -movement, imgW1);
		                move(0, -movement);
		                changeScore = false;
		                setImage(imgW1);
		                second = false;
		            }
		            else if (testKeyA(event)) {
		            	moveLocationDisplay(-movementX, 0, imgA1);
		            	second = false;
		            }
		            else if (testKeyA(event)) {
		            	moveLocationDisplay(0, movement, imgS1);
		            	second = false;
		            }
		            else if (testKeyD(event)) {
		            	moveLocationDisplay(movementX, 0, imgD1);
		            	second = false;
		            }
				}
				else if (testKeyW(event)) {
					moveLocationDisplay(0, -movement, imgW2);
	                second = true;
	            }
	            else if (testKeyA(event)) {	
	            	moveLocationDisplay(-movementX, 0, imgA2);
	            	second = true;
	            }
	            else if (testKeyS(event)) {	
	            	moveLocationDisplay(0, movement, imgS2);
	            	second = true;
	            }
	            else if (testKeyD(event)) {
	            	moveLocationDisplay(movementX, 0, imgD2);
	            	second = true;
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
		                second = false;
		            }
		            else if (event.getCode() == KeyCode.A) {	
		            	moveLocationDisplay(-movementX, 0, imgA1);
		            	second = false;
		            }
		            else if (event.getCode() == KeyCode.S) {
		            	moveLocationDisplay(0, movement, imgS1);
		            	second = false;
		            }
		            else if (event.getCode() == KeyCode.D) {	       
		            	moveLocationDisplay(movementX, 0, imgD1);
		            	second = false;
		            }
				}
			}
			
		});
		//setUser(user);
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

		if (carDeath) {
			deathLoopAnimation(now);
			carDeathAnimation();
		}
		
		if (waterDeath) {
			deathLoopAnimation(now);
			waterDeathAnimation();
		}
		
		if (getIntersectingObjects(Obstacle.class).size() >= 1) {
			carDeath = true;
		}
		
		if (getX() == 240 && getY() == 82) {
			stop = true;
		}
		
		if (getIntersectingObjects(Log.class).size() >= 1 && !noMove) {
			if(getIntersectingObjects(Log.class).get(0).getLeft()) {
				move(-2, 0); //move left with speed of 2
			//Controlling logs moving left
			}
			else {
				move (.75, 0); //move right with speed of 0.75
			//Controlling logs moving right
			}
		}
		else if (getIntersectingObjects(Turtle.class).size() >= 1 && !noMove) {
			move(-1, 0); // move left with the speed of 1
		}
		else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
				waterDeath = true; //When water death is true, frog step on will cause death
			} else {
				move(-1, 0); // move left with the speed of 1
			}
		}
		else if (getIntersectingObjects(End.class).size() >= 1) {
			inter = (ArrayList<End>) getIntersectingObjects(End.class);
			if (getIntersectingObjects(End.class).get(0).isActivated()) {
				end--;
				points -= 50;
				setPoints(points);
			}
			points += 50;
			changeScore = true;
			w = 800;
			getIntersectingObjects(End.class).get(0).setEnd();
			end++;
			setCoordinate(275, (int) (679.8+movement));
		}
		else if (getY() < 360 ){
			waterDeath = true;
			//setX(300);
			//setY(679.8+movement);
		}
		else if (getY() < 360)
			if(getX() >600 || getX() < 0 ) {
				waterDeath = true;
			}
		}
	public boolean getStop() {
		return end == 5;
	}
	
	public int getPoints() {
		return points;
	}
	
	public void setPoints(int points) {
		this.points = points;
	}
	
	public boolean getChangeScore() {
		return changeScore;
	}
	
	public void setChangeScore(boolean changeScore) {
		this.changeScore = changeScore;
	}
	
	public boolean changeScore() {
		if (getChangeScore()) {
			setChangeScore(false);
			return true;
		}
		return false;
	}
	
	public void carDeathAnimation(){
		int deathType = 1;
		if (death == 1) {
			setImage(new Image("file:images/CarDeath1.png", imgSize, imgSize, true, true));
		}
		if (death == 2) {
			setImage(new Image("file:images/CarDeath2.png", imgSize, imgSize, true, true));
		}
		if (death == 3) {
			setImage(new Image("file:images/CarDeath3.png", imgSize, imgSize, true, true));
		}
		if (death == 4) {
			setImage(new Image("file:images/CarDeath4.png", imgSize, imgSize, true, true));
		}
		if (death == 5) {
			setImage(new Image("file:images/CarDeath5.png", imgSize, imgSize, true, true));
		}
		if (death == 6) {
			setImage(new Image("file:images/CarDeath6.png", imgSize, imgSize, true, true));
		}
		// attribute
		// <a href="https://www.freepik.com/vectors/cartoon">Cartoon vector created by freepik - www.freepik.com</a>
		if (death == 7) {
			respawn(deathType);
			deathScoreDecrement(points, changeScore);
		}
	}
	
	public void waterDeathAnimation() {
		int deathType = 2;
		if (death == 1) {
			setImage(new Image("file:images/waterdeath1test.png", imgSizeWater, imgSizeWater, true, true));
		}
		if (death == 2) {
			setImage(new Image("file:images/waterdeath2test.png", imgSizeWater, imgSizeWater, true, true));
		}
		if (death == 3) {
			setImage(new Image("file:images/waterdeath3test.png", imgSizeWater, imgSizeWater, true, true));
		}
		if (death == 4) {
			setImage(new Image("file:images/waterdeath4test.png", imgSizeWater, imgSizeWater, true, true));
		}
		if (death == 5) {
			respawn(deathType);
			deathScoreDecrement(points, changeScore);
		}
	}
	
	public void deathScoreDecrement(int points, Boolean changeScore) {
		if(getPoints() > 50) {
			points -= 50;
			setPoints(points);
			changeScore = true;
		}
	}
	
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
		setImage(new Image("file:src/p4_group_8_repo/froggerUp.png", imgSize, imgSize, true, true));
		noMove = false;
	}
	
	public void deathLoopAnimation(long now) {
		noMove = true;
		if ((now)% 11 ==0) {
			death++;
		}
	}
	
	public Image frogMovementImg(String imageLink) {
		return new Image(imageLink, imgSize, imgSize, true, true);
	}
	
	public void moveLocationDisplay(double xpos, double ypos,Image img) {
		move(xpos, ypos);
		setImage(img);
	}
	
	public boolean testKeyW(KeyEvent event) {
		return event.getCode() == KeyCode.W;
	}
	
	public boolean testKeyA(KeyEvent event) {
		return event.getCode() == KeyCode.A;
	}
	public boolean testKeyS(KeyEvent event) {
		return event.getCode() == KeyCode.S;
	}
	public boolean testKeyD(KeyEvent event) {
		return event.getCode() == KeyCode.D;
	}
	
}
