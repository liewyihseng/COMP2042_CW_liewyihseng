package p4_group_8_repo.actor.obstacle;

import javafx.scene.image.Image;

public class RedTruck extends Obstacle implements TruckVehicle{
	
	public RedTruck(int xpos, int ypos, double s) {
		super(xpos, ypos, s);
		setImage(new Image("file:src/main/resources/images/Actor/TruckRed.png", WIDTH, HEIGHT, true, true));
	}
}