package p4_group_8_repo;

import javafx.scene.image.Image;

public class Character extends Actor{
	int dim;
	Image im1;
	int width;
	final int SIZE= 21;
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
	public Character(int n, int x, int y) {
		im1 = new Image("file:images/"+n+".png", SIZE, SIZE, true, true);
		setImage(im1);
		setCoordinate(x,y);
	}
	
	public Character(char c, int x, int y) {
		im1 = new Image("file:images/"+c+".png", SIZE, SIZE, true, true);
		setImage(im1);
		setCoordinate(x,y);
	}
	
}

