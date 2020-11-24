package p4_group_8_repo;

import javafx.scene.image.Image;

public class Digit extends Actor{
	int dim;
	Image im1;
	final int SIZE= 30;
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
	public Digit(int n, int x, int y) {
		im1 = new Image("file:images/"+n+".png", SIZE, SIZE, true, true);
		setImage(im1);
		setCoordinate(x,y);
	}
	
}

