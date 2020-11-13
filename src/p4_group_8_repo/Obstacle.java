package p4_group_8_repo;

import javafx.scene.image.Image;

public class Obstacle extends Actor {
	private double speed;
	@Override
	public void act(long now) {
		move(speed , 0);
		loopEnterScreen(-200, 600, 600, -50, speed);
	}
	
	public Obstacle(String imageLink, int xpos, int ypos, double s, int w, int h) {
		setImage(new Image(imageLink, w,h, true, true));
		setCoordinate(xpos, ypos);
		speed = s;
	}

}
