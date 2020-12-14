package p4_group_8_repo;

import javafx.scene.image.Image;

public class NonSinkingTurtle extends Actor implements Turtle{
	Image turtle1 = new Image("file:src/main/resources/images/Actor/TurtleAnimation1.png", WIDTH, HEIGHT, true, true);
	Image turtle2 = new Image("file:src/main/resources/images/Actor/TurtleAnimation2.png", WIDTH, HEIGHT, true, true);
	Image turtle3 = new Image("file:src/main/resources/images/Actor/TurtleAnimation3.png", WIDTH, HEIGHT, true, true);
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
		setCoordinate(xpos, ypos);
		speed = s;
		setImage(turtle2);
	}
	
}
