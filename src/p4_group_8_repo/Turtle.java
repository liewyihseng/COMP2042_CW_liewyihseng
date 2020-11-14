package p4_group_8_repo;

import javafx.scene.image.Image;

public class Turtle extends Actor{
	Image turtle1;
	Image turtle2;
	Image turtle3;
	final long counter = 900000000;
	private double speed;
	int i = 1;
	boolean bool = true;
	@Override
	public void act(long now) {

				if (now/counter % 3 ==0) {
					setImage(turtle2);
					
				}
				else if (now/counter % 3 == 1) {
					setImage(turtle1);
					
				}
				else if (now/counter %3 == 2) {
					setImage(turtle3);
					
				}
			
		move(speed , 0);
		
		loopEnterScreen(-200, 600, 600, -75, speed);
	}
	public Turtle(int xpos, int ypos, double s, int w, int h) {
		turtle1 = new Image("file:images/TurtleAnimation1final.png", w, h, true, true);
		turtle2 = new Image("file:images/TurtleAnimation2final.png", w, h, true, true);
		turtle3 = new Image("file:images/TurtleAnimation3final.png", w, h, true, true);
		setCoordinate(xpos, ypos);
		speed = s;
		setImage(turtle2);
	}
	
}
