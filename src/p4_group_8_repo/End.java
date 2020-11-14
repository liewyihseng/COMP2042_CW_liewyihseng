package p4_group_8_repo;

import javafx.scene.image.Image;

public class End extends Actor{
	boolean activated = false;
	@Override
	public void act(long now) {
		// TODO Auto-generated method stud
	}
	
	public End(int x, int y) {
		setCoordinate(x, y);
		setImage(new Image("file:images/lilypad.png", 70, 70, true, true));
	}
	
	public void setEnd() {
		setImage(new Image("file:images/FrogEndFinal.png", 70, 70, true, true));
		activated = true;
	}
	
	public boolean isActivated() {
		return activated;
	}
	

}
