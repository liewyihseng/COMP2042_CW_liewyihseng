package p4_group_8_repo;

import javafx.scene.image.Image;

public class Frame extends Actor{
	Image img;
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
	public Frame(String imageLink, int height, int width,int x, int y) {
		img = new Image(imageLink, height, width, true, true);
		setImage(img);
		setCoordinate(x,y);
	}
	
}
