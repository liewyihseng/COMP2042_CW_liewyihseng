package p4_group_8_repo;

import javafx.scene.image.Image;

public class SinkingTurtle extends Actor implements Turtle{
	Image turtle1;
	Image turtle2;
	Image turtle3;
	Image turtle4;
	private double speed;
	boolean sunk = false;
	@Override
	public void act(long now) {

				if (now/TICK  % 4 ==0) {
					setImage(turtle2);
					sunk = false;
				}
				else if (now/TICK % 4 == 1) {
					setImage(turtle1);
					sunk = false;
				}
				else if (now/TICK %4 == 2) {
					setImage(turtle3);
					sunk = false;
				}
				else if (now/900000000 %4 == 3) {
					setImage(turtle4);
					sunk = true;
				}
			
		move(speed , 0);

		loopEnterScreen(-200, 600, 600, -75 ,speed);
	}
	public SinkingTurtle(int xpos, int ypos, double s) {
		turtle1 = new Image("file:images/WetTurtleAnimation2.png", WIDTH, HEIGHT, true, true);
		turtle2 = new Image("file:images/WetTurtleAnimation1.png", WIDTH, HEIGHT, true, true);
		turtle3 = new Image("file:images/WetTurtleAnimation3.png", WIDTH, HEIGHT, true, true);
		turtle4 = new Image("file:images/WetTurtleAnimation4.png", WIDTH, HEIGHT, true, true);
		setCoordinate(xpos, ypos);
		speed = s;
		setImage(turtle2);
	}
	public boolean isSunk() {
		return sunk;
	}
}
