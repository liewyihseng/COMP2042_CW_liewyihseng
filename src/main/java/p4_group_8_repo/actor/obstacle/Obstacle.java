package p4_group_8_repo.actor.obstacle;

import p4_group_8_repo.actor.Actor;

public class Obstacle extends Actor {
	private double speed;
	@Override
	public void act(long now) {
		move(speed , 0);
		loopEnterScreen(-200, 600, 600, -50, speed);
	}
	
	public Obstacle(int xpos, int ypos, double s) {
		setCoordinate(xpos, ypos);
		speed = s;
	}

}
