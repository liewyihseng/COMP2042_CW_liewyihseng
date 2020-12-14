package p4_group_8_repo;

import java.util.Random;

/**
 * Represents the profile of each user when the application, Frogger Arcade has been launched
 * @author Liew Yih Seng
 *
 */

public class User {
	private String username;
	private int score;
	private Animal animal;
	private int level;
	private boolean pauseGame;

	public User() {
		setUsername(randomUsername());
		setScore(0);
		setLevel(1); //Every User starts with level 1
		animal = new Animal();
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
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
	    int targetStringLength = 13; //Random at 13 character
	    Random random = new Random();
	 
	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();
	 
	    return generatedString;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String userName) {
		this.username = userName;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getScore() {
		return score;
		//Used to upload points
	}
	
    public double getIncrementDifficulty() {
    	double speedIncrement;
    	speedIncrement = getLevel() * 0.15;
    	return speedIncrement;
    }
    
    /**
     * Gets the state of user in game play
     * @return A boolean representing the if the game has been paused or not
     */
    public boolean isInGame() {
		return pauseGame;
	}

    /**
     * Sets the state of the game play
     * @param inGame A boolean representing the state of gameplay whether if the game has been paused or not
     */
	public void setInGame(boolean inGame) {
		this.pauseGame = inGame;
	}

}