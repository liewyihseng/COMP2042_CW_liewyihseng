package p4_group_8_repo;

import javafx.scene.image.Image;

public class RedTruck extends Obstacle{
	
	final int WIDTH = 120;
	final int HEIGHT = 120;
	
	public RedTruck(int xpos, int ypos, double s) {
		super(xpos, ypos, s);
		setImage(new Image("file:images/TruckRed.png", WIDTH, HEIGHT, true, true));
	}
}