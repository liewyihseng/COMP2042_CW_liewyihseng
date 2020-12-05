package p4_group_8_repo;

import javafx.scene.image.Image;

public class YellowTruck extends Obstacle implements TruckVehicle{
	
	public YellowTruck(int xpos, int ypos, double s) {
		super(xpos, ypos, s);
		setImage(new Image("file:src/main/resources/images/TruckYellow.png", WIDTH, HEIGHT, true, true));
	}
}
