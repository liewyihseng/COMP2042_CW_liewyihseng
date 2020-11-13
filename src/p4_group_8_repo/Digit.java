package p4_group_8_repo;

import javafx.scene.image.Image;

public class Digit extends Actor{
	int dim;
	Image im1;
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
	public Digit(int n, int size, int x, int y) {
		im1 = new Image("file:src/p4_group_8_repo/"+n+".png", size, size, true, true);
		setImage(im1);
		setCoordinate(x,y);
	}
	
}
