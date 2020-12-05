package p4_group_8_repo;

import javafx.scene.image.Image;

public class Lilypad extends End{

	Image lilypad = new Image("file:src/main/resources/images/Lilypad.png", LILYPADSIZE, LILYPADSIZE, true, true);
	Image FrogEnd = new Image("file:src/main/resources/images/FrogEndFinal.png", LILYPADSIZE, LILYPADSIZE, true, true);
	@Override
	public void act(long now) {
		// TODO Auto-generated method stud
	}
	
	public Lilypad(int x, int y) {
		super(x,y);
		setImage(lilypad);
	}
	
	public void setEnd() {
		setImage(FrogEnd);
		activated = true;
	}
	
}
