package p4_group_8_repo;

public class User {
	public String userName;
	public int points;
	
	public User() {
		setUsername("null");
		//Add random generator here
		setCurrentPoints(0);
	}
	
	public User(String name) {
		setUsername(name);
		setCurrentPoints(0);
	}
	
	public String getUsername() {
		return userName;
	}
	
	public void setUsername(String userName) {
		this.userName = userName;
	}
	
	public void setCurrentPoints(int points) {
		this.points = points;
	}
	
	public int getCurrentPoints() {
		return points;
	}
	
}