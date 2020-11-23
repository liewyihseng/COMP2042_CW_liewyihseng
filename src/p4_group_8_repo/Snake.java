package p4_group_8_repo;

import javafx.scene.image.Image;

public class Snake extends Obstacle{
	private double speed;
	final int WIDTH = 60;
	final int HEIGHT = 60;
	static final int TICK = 900000000;
	Image Snake1 = new Image("file:images/Snake1.png", WIDTH, HEIGHT, true, true);
	Image Snake2 = new Image("file:images/Snake2.png", WIDTH, HEIGHT, true, true);
	Image Snake3 = new Image("file:images/Snake3.png", WIDTH, HEIGHT, true, true);
	Image Snake4 = new Image("file:images/Snake4.png", WIDTH, HEIGHT, true, true);

	public Snake(int xpos, int ypos, double s) {
		super(xpos, ypos, s);
		speed = s;
		setImage(Snake4);
	}
	
	@Override
	public void act(long now) {

				if (now/TICK % 4 ==0) {
					setImage(Snake4);
					
				}
				else if (now/TICK % 4 == 1) {
					setImage(Snake1);
					
				}
				else if (now/TICK % 4 == 2) {
					setImage(Snake2);
					
				}
				else if (now/TICK % 4 == 3) {
					setImage(Snake3);
					
				}
			
		move(speed , 0);
		loopEnterScreen(-200, 600, 600, -50, speed);
	}
}
