package p4_group_8_repo;

import javafx.scene.image.Image;

public class ShortLog extends Log{
	final int SIZE = 150;
	
	public ShortLog(int xpos, int ypos, double s) {
		super(xpos, ypos, s);
		setImage(new Image("file:src/main/resources/images/LogShort.png", SIZE, SIZE, true, true));
	}
}
