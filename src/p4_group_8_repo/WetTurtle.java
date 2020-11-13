package p4_group_8_repo;

import javafx.scene.image.Image;

public class WetTurtle extends Actor{
	Image turtle1;
	Image turtle2;
	Image turtle3;
	Image turtle4;
	final long counter = 900000000;
	private double speed;
	int i = 1;
	boolean bool = true;
	boolean sunk = false;
	@Override
	public void act(long now) {

				if (now/counter  % 4 ==0) {
					setImage(turtle2);
					sunk = false;
				}
				else if (now/counter % 4 == 1) {
					setImage(turtle1);
					sunk = false;
				}
				else if (now/counter %4 == 2) {
					setImage(turtle3);
					sunk = false;
				}
				else if (now/counter %4 == 3) {
					setImage(turtle4);
					sunk = true;
				}
			
		move(speed , 0);
		
		loopEnterScreen(-200, 600, 600, -75 ,speed);
	}
	public WetTurtle(int xpos, int ypos, double s, int w, int h) {
		turtle1 = new Image("file:images/WetTurtleAnimation2.png", w, h, true, true);
		turtle2 = new Image("file:images/WetTurtleAnimation1.png", w, h, true, true);
		turtle3 = new Image("file:images/WetTurtleAnimation3.png", w, h, true, true);
		turtle4 = new Image("file:images/WetTurtleAnimation4.png", w, h, true, true);
		setCoordinate(xpos, ypos);
		speed = s;
		setImage(turtle2);
	}
	public boolean isSunk() {
		return sunk;
	}
}
