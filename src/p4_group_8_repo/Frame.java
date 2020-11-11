package p4_group_8_repo;

import javafx.scene.image.Image;

public class Frame extends Actor {
	
	public Frame(String imageLink, int size, int xpos, int ypos) {
		setImage(new Image(imageLink, size, size, true, true));
		setX(xpos);
		setY(ypos);
	}
	
	public void act(long now) {
		
	};
	
}
