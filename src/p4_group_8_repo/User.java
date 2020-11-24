package p4_group_8_repo;

import java.util.Random;

public class User {
	public String userName;
	public int points;
	Animal animal;
	int level;
	
	
	/**
	 * construct an instance of user
	 */
	public User() {
		setUsername(randomUsername());
		setFinalPoints(0);
		setLevel(1); //Every User starts with level 1
		//testing
		animal = new Animal();
		setAnimal(animal);
	}
	
	/**
	 * construct an instance of user
	 * @param name to give the instance
	 */
	public User(String name) {
		setUsername(name);
		setFinalPoints(0);
	}
	
	/**
	 * Accesses the user's level 
	 * @return the user's level value
	 */
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}


	/**
	 * Accessing the user's animal
	 * @return the user's animal
	 */
	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	
	/**
	 * Assigning a random user name if user name is not entered
	 * @return the randomly generated string to be the user name
	 */
	public String randomUsername() {
	    int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 13; //Random at 13 character
	    Random random = new Random();
	 
	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();
	 
	    return generatedString;
	}
	
	/**
	 * Accessing the user's user name
	 * @return the user's user name
	 */
	public String getUsername() {
		return userName;
	}
	
	public void setUsername(String userName) {
		this.userName = userName;
	}
	
	/**
	 * Accessing the user's final point
	 * @return the user's final point
	 */
	public int getFinalPoints() {
		return points;
		//Used to upload points
	}
	
	public void setFinalPoints(int points) {
		this.points = points;
	}
	
    public double getIncrementDifficulty() {
    	double speedIncrement;
    	speedIncrement = getLevel() * 0.25;
    	return speedIncrement;
    }
	
}