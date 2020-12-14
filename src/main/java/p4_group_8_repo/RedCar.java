package p4_group_8_repo;

import javafx.scene.image.Image;

public class RedCar extends Obstacle implements SedanVehicle{
	
	public RedCar(int xpos, int ypos, double s) {
		super(xpos, ypos, s);
		setImage(new Image("file:src/main/resources/images/Actor/CarRed.png", WIDTH, HEIGHT, true, true));
	}
}
