package p4_group_8_repo;

import javafx.scene.image.Image;

public class TaxiCar extends Obstacle{
	
	final int WIDTH = 50;
	final int HEIGHT = 50;
	
	public TaxiCar(int xpos, int ypos, double s) {
		super(xpos, ypos, s);
		setImage(new Image("file:images/Taxi.png", WIDTH, HEIGHT, true, true));
	}
}
