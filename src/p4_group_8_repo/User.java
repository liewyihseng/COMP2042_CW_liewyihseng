package p4_group_8_repo;

import java.util.Random;

public class User {
	public String userName;
	public int points;
	Animal animal;
	int level;
	
	public User() {
		setUsername(randomUsername());
		setFinalPoints(0);
		setLevel(1); //Every User starts with level 1
		//testing
		animal = new Animal();
		setAnimal(animal);
	}
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public User(String name) {
		setUsername(name);
		setFinalPoints(0);
	}
	
	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
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
	
	public void setFinalPoints(int points) {
		this.points = points;
	}
	
	public int getFinalPoints() {
		return points;
		//Used to upload points
	}
	
}