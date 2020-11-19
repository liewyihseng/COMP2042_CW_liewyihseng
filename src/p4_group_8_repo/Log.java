package p4_group_8_repo;

public class Log extends Actor {

	private double speed;
	@Override
	public void act(long now) {
		move(speed , 0);
		loopEnterScreen(-180, 700, 600, -300, speed);
	}
	
	public Log(int xpos, int ypos, double s) {
		setCoordinate(xpos, ypos);
		speed = s;
		
	}
	public boolean getLeft() {
		return speed < 0;
	}
}
