package p4_group_8_repo.actor;

import javafx.scene.image.Image;

/**
 * Represents the crocodile in the game play.
 * @author Liew Yih Seng
 *
 */

public class Crocodile extends End{
	Image crocodile = new Image("file:src/main/resources/images/Actor/Crocodile.png", CROCSIZE, CROCSIZE, true, true);
	

	@Override
	public void act(long now) {
		// TODO Auto-generated method stud
	}
	
	/**
	 * A constructor that initializes a crocodile that act as an end within game scene. It triggers
	 * the super constructor in class {@link End} that handles the setting of its coordinate, then 
	 * invokes the method {@link #setImage(Image)} to set the image of the crocodile.
	 * @param x An integer representing the X-coordinate of the crocodile.
	 * @param y An integer representing the Y-coordinate of the crocodile.
	 */
	public Crocodile(int x, int y) {
		super(x,y);
		setImage(crocodile);
	}
	
	
}
