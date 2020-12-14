package p4_group_8_repo.actor;

import javafx.scene.image.Image;

/**
 * Represents the frame in the game
 * @author Liew Yih Seng
 *
 */
public class Frame extends Actor{
	Image img;
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * A constructor that instantiates the frame class, then displaying the frame in the game scene
	 * @param imageLink A string representing the path to the frame image
	 * @param height An integer representing the height of the frame
	 * @param width An integer representing the width of the frame
	 * @param x An integer representing the X-coordinate of the frame
	 * @param y An integer representing the Y-coordinate of the frame
	 */
	public Frame(String imageLink, int height, int width,int x, int y) {
		img = new Image(imageLink, height, width, true, true);
		setImage(img);
		setCoordinate(x,y);
	}
	
}
