package p4_group_8_repo;

import javafx.scene.image.Image;

/**
 * Represents the crocodile at the end.
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
	 * A constructor that instantiates a crocodile within game scene
	 * @param x An integer representing the X-coordinate of the crocodile
	 * @param y An integer representing the Y-coordinate of the crocodile
	 */
	public Crocodile(int x, int y) {
		super(x,y);
		setImage(crocodile);
	}
	
	
}
