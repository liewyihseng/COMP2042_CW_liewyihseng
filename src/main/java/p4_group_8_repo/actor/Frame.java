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
	 * A constructor that initializes the frame class, then displaying the frame in the game scene.
	 * It instantiates an {@link Image#Image(String, double, double, boolean, boolean)} constructor which 
	 * is then being assigned to {@link #img} where {@link #img} will again be assigned into
	 * {@link #setImage(Image)} where it will be displayed in the game play. For the coordinate settings,
	 * this method invokes the method {@link #setCoordinate(int, int)} to set the position of the frame 
	 * being displayed in the game play.
	 * @param imageLink A string representing the path to the frame image.
	 * @param height An integer representing the height of the frame.
	 * @param width An integer representing the width of the frame.
	 * @param x An integer representing the X-coordinate of the frame.
	 * @param y An integer representing the Y-coordinate of the frame.
	 */
	public Frame(String imageLink, int height, int width,int x, int y) {
		img = new Image(imageLink, height, width, true, true);
		setImage(img);
		setCoordinate(x,y);
	}
	
}
