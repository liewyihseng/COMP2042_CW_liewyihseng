package p4_group_8_repo;

import javafx.scene.image.Image;

public class Crocodile extends End{
	Image crocodile = new Image("file:images/Crocodile.png", CROCSIZE, CROCSIZE, true, true);
	@Override
	public void act(long now) {
		// TODO Auto-generated method stud
	}
	
	public Crocodile(int x, int y) {
		super(x,y);
		setImage(crocodile);
	}
	public void setEnd() {
		setImage(crocodile);
		activated = true;
	}
	
	
}
