package p4_group_8_repo;

import javafx.scene.image.Image;

public class LongTruck extends Obstacle{
	
	final int WIDTH = 200;
	final int HEIGHT = 200;
	
	public LongTruck(int xpos, int ypos, double s) {
		super(xpos, ypos, s);
		setImage(new Image("file:src/main/resources/images/TruckLong.png", WIDTH, HEIGHT, true, true));
	}
}
