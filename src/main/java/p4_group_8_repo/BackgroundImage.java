package p4_group_8_repo;

import javafx.scene.image.Image;
/**
 * Sets the background image of scenes within the game.
 * @author Liew Yih Seng
 *
 */

public class BackgroundImage extends Actor{

	@Override
	public void act(long now) {
		
		
	}
	
	/**
	 * Sets the Image of the background
	 * @param imageLink A string representing the path to the background image
	 */
	public BackgroundImage(String imageLink) {
		setImage(new Image(imageLink, 600, 800, true, true));
	}

}
