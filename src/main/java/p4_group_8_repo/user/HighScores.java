package p4_group_8_repo.user;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import p4_group_8_repo.Main;

/**
 * This class handles the listing of all high scores being stored within the game.
 * @author Liew Yih Seng
 *
 */
public class HighScores {
	private String root = System.getProperty("user.dir");
	private String scoreFile = root+"\\src\\main\\resources\\score\\scoreFile.txt";
	private static final int MAX_SCORES = 10;
	private ArrayList<HighScore> score_list;
	private static final String[] DUMMY_NAMES = {
			"Test1",
			"Test2",
			"Test3",
			"Test4",
			"Test5",
			"Test6",
			"Test7",
			"Test8",
			"Test9",
			"Test10"
		};
	
	
	/**
	 * The constructor that handles the initialization of this class. It opens the scoreFile,
	 * reads the details of users existed within the scoreFile. These details are user's name, level
	 * and score. Each line within the file will be read and split into parts where each part will
	 * be assigned to its holding variable(name, level, score).
	 */
	/* Open HIGH_SCORE_FILE and read the scores, names into an array */
	public HighScores(){
		String line;
		String[] parts;
		int score;
		int level;
		String name;
		score_list = new ArrayList<HighScore>(MAX_SCORES);
		
		try {
			BufferedReader file = new BufferedReader(new FileReader(scoreFile));
			while((line = file.readLine()) != null) {
				parts = line.split("\t", 3);
				
				score = Integer.parseInt(parts[0]);
				level = Integer.parseInt(parts[1]);
				name = parts[2];
				score_list.add(new HighScore(name, score, level));
			}
			
			file.close();
		}catch(IOException e) {
			System.err.println("No high score file found, creating new high scores...");

			int dummy_score = 1000;
			int dummy_level = 10;
			
			for(int i = 0; i< DUMMY_NAMES.length; i++) {
				score_list.add(new HighScore(DUMMY_NAMES[i], dummy_score, dummy_level));
				dummy_score -= 100;
				dummy_level -= 1;
			}
		}
	}
	
	/**
	 * A method that tests if the score being input is higher than any of the scores inside {@link #score_list}
	 * @param score An integer that represents the score achieved by the current user.
	 * @return A boolean that states if the input score is larger than any scores within the {@link #score_list}
	 */
	public boolean isNewHighScore(int score) {
		HighScore lowestHighScores = score_list.get(score_list.size() - 1);
		
		if(score < lowestHighScores.score) {
			return false;
		}
		return true;
	}

	/**
	 * A method that opens the scoreFile then writing the high scores into the file in order.
	 */
	public void writeScoreFile() {
		try {
			FileWriter write = new FileWriter(scoreFile);
			PrintWriter out = new PrintWriter(write);
			
			for(int i=0; i<score_list.size() && i<10; i++) {
				out.println(score_list.get(i));
			}
			out.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method prints out the current high scores existed within the list. The usage
	 * of this method is mostly for debugging as developers can check the current contents within
	 * the scoreFile.
	 */
	public void printScores() {
		System.out.println("High Scores:");
		for(int i=0; i<score_list.size(); i++) {
			System.out.println(score_list.get(i));
		}
	}

	/**
	 * A method that returns the {@link #score_list}.
	 * @return An array list of {@link HighScore}
	 */
	public ArrayList<HighScore> getScoreList(){
		return score_list;
	}
	
	/**
	 * A method that adds the {@link #HighScores()} then sorts the {@link #score_list},
	 * arranging all elements within the list in a descending order based on the scores. A for loop
	 * will be used to loop through all element within the list in order to perform the sorting of high scores. 
	 * @param name A string that represents the name of the user.
	 * @param score An integer that represents the score of the user.
	 * @param level An integer that represents the level that the user has achieved.
	 */
	public void add(String name, int score, int level) {
		score_list.add(new HighScore(name, score, level));
		int min_element;
		int index;
		int temp_score;
		int temp_level;
		String temp_name;
		
		for(min_element = score_list.size() - 1; min_element >= 0; min_element--) {
			for(index=0; index<=min_element-1;index++) {
				if(score_list.get(index).score < score_list.get(index + 1).score) {
					temp_score = score_list.get(index).score;
					score_list.get(index).score = score_list.get(index+1).score;
					score_list.get(index+1).score=temp_score;
					
					temp_name = score_list.get(index).name;
					score_list.get(index).name = score_list.get(index+1).name;
					score_list.get(index+1).name = temp_name;
					
					temp_level = score_list.get(index).level;
					score_list.get(index).level = score_list.get(index+1).level;
					score_list.get(index+1).level = temp_level;
				}
			}
		}
		
	}
	
	/**
	 * A method that adds the score in to the {@link #score_list}
	 * if the score to be added is tested to be a new high score by using method
	 * {@link #isNewHighScore(int)} that returns a boolean stating the result of the test.
	 * @param score An integer representing the score achieved by the user.
	 */
	public void newScore(int score) {
		if(this.isNewHighScore(score)) {
			String name = Main.getUser().getUsername();
			int level = Main.getUser().getLevel() - 1;
			this.add(name, score, level);
			writeScoreFile();
		}
	}
	
	/**
	 * A class that holds the detail of a single user that were to be added into the {@link HighScores#score_list}.
	 * This class has a name, a score and a level that hold the detail of high score achiever.
	 * @author Liew Yih Seng
	 *
	 */
	public static class HighScore {
		/**
		 * Represents the name of the high score achiever (user).
		 */
		public String name;
		
		/**
		 * Represent the score of the high score achiever (user).
		 */
		public int score;
		
		/**
		 * Represent the level of the high score achiever (user).
		 */
		public int level;

		/**
		 * A constructor that initializes the name, the score and the level of the high score achiever.
		 * @param name A String that represents the name of the user.
		 * @param score An integer that represents the score of the user.
		 * @param level An integer that represents the level of the user.
		 */
		public HighScore(String name, int score, int level) {
			this.name = name;
			this.score = score;
			this.level = level;
		}

		/**
		 * A method that returns the high score achiever's detail in a string form.
		 * @return A string that represents the user's detail.
		 */
		public String toString() {
			return score + "\t" + level +"\t" + name;
		}
		
		/**
		 * Gets the name of the high score achiever.
		 * @return A string that represents the name of the high score achiever.
		 */
		public String getName() {
			return name;
		}
		
		/**
		 * Gets the level of the high score achiever.
		 * @return A string that represents the level of the high score achiever.
		 */
		public String getLevel() {
			return Integer.toString(level);
		}
		
		/**
		 * Gets the score of the high score achiever.
		 * @return A string that represents the score of the high score achiever.
		 */
		public String getScore() {
			return Integer.toString(score);
		}
	}
}
