package p4_group_8_repo.user;

import java.util.Random;

import p4_group_8_repo.actor.Animal;

/**
 * Represents the profile of each user when the application, Frogger Arcade has been launched.
 * @author Liew Yih Seng
 *
 */
public class User {
	private String username;
	private int score;
	private Animal animal;
	private int level;
	private boolean pauseGame;

	/**
	 * A constructor that initializes the user. All users will be assigned with a random name
	 * with maximum of 13 character long once they have launched the game using {@link #randomUsername()}.
	 * All users has an animal(Frog) and will be initialized with an initial score of 0 and an initial level 
	 * in game of 1 once they have executed the application. 
	 * 
	 */
	public User() {
		setUsername(randomUsername());
		setScore(0);
		setLevel(1); //Every User starts with level 1
		animal = new Animal();
	}

	/**
	 * Gets the current level of the user.
	 * @return An integer representing the current level of the user.
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * Sets the current level of the user during game play.
	 * @param level An integer that represents the current level of the user in the game play.
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * Gets the animal of the user.
	 * @return An {@link p4_group_8_repo.actor.Animal} of the user.
	 */
	public Animal getAnimal() {
		return animal;
	}

	/**
	 * Sets the animal of the user.
	 * @param animal An {@link p4_group_8_repo.actor.Animal} that represents the animal of the user.
	 */
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	
	/**
	 * A method that assigns a random username to the users upon initialisation.
	 * @return A string representing the randomized user name.
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
	 * Gets the username of the user.
	 * @return A string representing the username of the user.
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * Sets the username of the user.
	 * @param userName A string representing the username of the user.
	 */
	public void setUsername(String userName) {
		this.username = userName;
	}
	
	/**
	 * Sets the score of the user.
	 * @param score An integer that represents the current score of the user.
	 */
	public void setScore(int score) {
		this.score = score;
	}
	
	/**
	 * Gets the current score of the user.
	 * @return An integer that represents the current score of the user.
	 */
	public int getScore() {
		return score;
		//Used to upload points
	}
	
	/**
	 * A method that gets the increment in speed as user's level increases.
	 * This method has allows developers to increase the difficulty of the game by
	 * increasing the speed of actors movement during the game play.
	 * @return A double that represents the amount of speed increment to be added into the
	 * existing actor's movement speed.
	 */
    public double getIncrementDifficulty() {
    	double speedIncrement;
    	speedIncrement = getLevel() * 0.15;
    	return speedIncrement;
    }
    
    /**
     * Gets the state of user in game play.
     * @return A boolean representing the if the game has been paused or not.
     */
    public boolean isInGame() {
		return pauseGame;
	}

    /**
     * Sets the state of the game play.
     * @param inGame A boolean representing the state of game play whether if the game has been paused or not.
     */
	public void setInGame(boolean inGame) {
		this.pauseGame = inGame;
	}

}