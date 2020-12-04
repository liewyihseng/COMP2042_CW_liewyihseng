package p4_group_8_repo;

import javafx.scene.image.Image;

public class ShortLog extends Log{
	final int SIZE = 150;
	
	public ShortLog(int xpos, int ypos, double s) {
		super(xpos, ypos, s);
		setImage(new Image("file:src/main/resources/LogShort.png", SIZE, SIZE, true, true));
	}
	/*
	public ShortLog(int xpos, int ypos, double s) {
		setCoordinate(xpos, ypos);
		speed = s;
		setImage(new Image("file:images/LogShort.png", SIZE, SIZE, true, true));
		
	}
	*/
}
