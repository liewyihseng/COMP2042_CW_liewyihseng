package p4_group_8_repo.actor;

public class Log extends Actor {

	private double speed;
	@Override
	public void act(long now) {
		move(speed , 0);
		loopEnterScreen(-180, 700, 600, -300, speed);
		if (getX()>600 && speed>0)
			setX(-180);
		if (getX()<-300 && speed<0)
			setX(700);
	}
	
	public Log(int xpos, int ypos, double s) {
		setCoordinate(xpos, ypos);
		speed = s;
		
	}
	public boolean getLeft() {
		return speed < 0;
	}
	
	
}
