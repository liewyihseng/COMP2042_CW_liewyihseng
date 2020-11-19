package p4_group_8_repo;

import javafx.scene.image.Image;

public class RedCar extends Obstacle{
	
	final int WIDTH = 50;
	final int HEIGHT = 50;
	
	public RedCar(int xpos, int ypos, double s) {
		super(xpos, ypos, s);
		setImage(new Image("file:images/CarRed.png", WIDTH, HEIGHT, true, true));
	}
}
