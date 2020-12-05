package p4_group_8_repo;

import javafx.scene.image.Image;

public class TaxiCar extends Obstacle implements SedanVehicle{
		
	public TaxiCar(int xpos, int ypos, double s) {
		super(xpos, ypos, s);
		setImage(new Image("file:src/main/resources/images/Taxi.png", WIDTH, HEIGHT, true, true));
	}
}
