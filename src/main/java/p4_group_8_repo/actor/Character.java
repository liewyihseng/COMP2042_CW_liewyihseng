package p4_group_8_repo.actor;

import javafx.scene.image.Image;

/**
 * Represents the characters shown within the game.
 * @author Liew Yih Seng
 *
 */
public class Character extends Actor{
	final int SIZE = 20;
	private Image img;
	
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
	public Character(int n, int x, int y) {
		setCharacter(n);
		setCoordinate(x,y);
	}
	
	public Character(char c, int x, int y) {
		img = new Image("file:src/main/resources/images/Character/"+c+".png", SIZE, SIZE, true, true);
		setImage(img);
		setCoordinate(x,y);
	}
	
	public void setCharacter(int n) {
		img = new Image("file:src/main/resources/images/Character/"+n+".png", SIZE, SIZE, true, true);
		setImage(img);
	}
	
}

