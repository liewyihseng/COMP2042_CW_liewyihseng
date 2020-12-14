package p4_group_8_repo.actor;

import javafx.scene.image.Image;

public class LongLog extends Log{
	final int SIZE = 300;
	
	public LongLog(int xpos, int ypos, double s) {
		super(xpos, ypos, s);
		setImage(new Image("file:src/main/resources/images/Actor/LogLong.png", SIZE, SIZE, true, true));
	}
}