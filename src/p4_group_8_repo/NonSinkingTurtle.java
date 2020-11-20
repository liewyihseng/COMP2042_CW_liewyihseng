package p4_group_8_repo;

import javafx.scene.image.Image;

public class NonSinkingTurtle extends Actor implements Turtle{
	Image turtle1;
	Image turtle2;
	Image turtle3;
	private double speed;
	@Override
	public void act(long now) {

				if (now/TICK % 3 ==0) {
					setImage(turtle2);
					
				}
				else if (now/TICK % 3 == 1) {
					setImage(turtle1);
					
				}
				else if (now/TICK %3 == 2) {
					setImage(turtle3);
					
				}
			
		move(speed , 0);
		loopEnterScreen(-200, 600, 600, -75, speed);
	}
	public NonSinkingTurtle(int xpos, int ypos, double s) {
		turtle1 = new Image("file:images/TurtleAnimation1.png", WIDTH, HEIGHT, true, true);
		turtle2 = new Image("file:images/TurtleAnimation2.png", WIDTH, HEIGHT, true, true);
		turtle3 = new Image("file:images/TurtleAnimation3.png", WIDTH, HEIGHT, true, true);
		setCoordinate(xpos, ypos);
		speed = s;
		setImage(turtle2);
	}
	
}