package p4_group_8_repo;


public abstract class End extends Actor{
	boolean activated = false;
	static final int CROCSIZE = 90;
	static final int LILYPADSIZE = 70;
	
	public End(int x, int y) {
		setCoordinate(x, y);
	}
	
	public boolean isActivated() {
		return activated;
	}
	
	public abstract void act(long now);
}
 