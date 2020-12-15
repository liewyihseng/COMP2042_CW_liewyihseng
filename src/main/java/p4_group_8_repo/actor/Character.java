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
	
	
	/**
	 * A method that is inherited from the class Actor.
	 */
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * A constructor that initialize the Character that handles integer as the parameter.
	 * It has the use of displaying integer in the game play by invoking method {@link #setCharacter(int)}
	 * then using {@link #setCoordinate(int, int)} to set the position of the character to be displayed.
	 * @param n An integer that represents the character to be displayed.
	 * @param x An integer representing the X-Coordinate of the character.
	 * @param y An integer representing the Y-Coordinate of the character.
	 */
	public Character(int n, int x, int y) {
		setCharacter(n);
		setCoordinate(x,y);
	}
	
	/**
	 * A constructor that initialize the Character that handles char as the parameter.
	 * It has the use of displaying char in the game play. It invokes the constructor
	 * {@link Image#Image(String, double, double, boolean, boolean)},
	 * then assigns it to {@link #img} then passing {@link #img} into {@link #setImage(Image)}
	 * as a parameter to display the image. Whereas, the coordinate of the image has been taken 
	 * care by {@link #setCoordinate(int, int)}.
	 * @param c A char that represents the character to be displayed.
	 * @param x An integer representing the X-Coordinate of the character.
	 * @param y An integer representing the Y-Coordinate of the character.
	 */
	public Character(char c, int x, int y) {
		img = new Image("file:src/main/resources/images/Character/"+c+".png", SIZE, SIZE, true, true);
		setImage(img);
		setCoordinate(x,y);
	}
	
	/**
	 * A method that retrieves and sets the image of the integer to be displayed on the scenes.
	 * This method invokes the constructor {@link Image#Image(String, double, double, boolean, boolean)},
	 * then assigns it to {@link #img} then passing {@link #img} into {@link #setImage(Image)}
	 * as a parameter to display the image.
	 * @param n An integer that represents the character to be displayed.
	 */
	public void setCharacter(int n) {
		img = new Image("file:src/main/resources/images/Character/"+n+".png", SIZE, SIZE, true, true);
		setImage(img);
	}
	
}

