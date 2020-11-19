package p4_group_8_repo;

import java.util.Random;

public class User {
	public String userName;
	public int points;
	
	public User() {
		setUsername(randomUsername());
		setCurrentPoints(0);
	}
	
	public User(String name) {
		setUsername(name);
		setCurrentPoints(0);
	}
	
	public String randomUsername() {
	    int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 10;
	    Random random = new Random();
	 
	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();
	 
	    return generatedString;
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