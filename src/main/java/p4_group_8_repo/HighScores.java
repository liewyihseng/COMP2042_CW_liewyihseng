package p4_group_8_repo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

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
	
	/* Open HIGH_SCORE_FILE and read the scores, names into an array */
	public HighScores(){
		String line;
		String[] parts;
		int score;
		int level;
		score_list = new ArrayList<HighScore>(MAX_SCORES);
		
		try {
			BufferedReader file = new BufferedReader(new FileReader(scoreFile));
			while((line = file.readLine()) != null) {
				parts = line.split("\t", 3);
				
				score = Integer.parseInt(parts[0]);
				level = Integer.parseInt(parts[1]);
			
				score_list.add(new HighScore(parts[2], score, level));
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
	
	public boolean isNewHighScore(int score) {
		HighScore lowestHighScores = score_list.get(score_list.size() - 1);
		
		if(score < lowestHighScores.score)
			return false;
		return true;
	}

	/*
	 * Open HIGH_SCORE_FILE for writing (not appending), and write the high scores to the file in order 
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
	 * This prints out the current high scores, it's mostly for debugging
	 */
	public void printScores() {
		System.out.println("High Scores:");
		for(int i=0; i<score_list.size(); i++) {
			System.out.println(score_list.get(i));
		}
	}
	
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
	
	public void newScore(int score) {
		if(this.isNewHighScore(score)) {
			String name = Main.getUser().getUsername();
			int level = Main.getUser().getLevel() - 1;
			if(name == null)
				return;
			
			this.add(name, score, level);
			writeScoreFile();
		}
	}
	
	public ArrayList<HighScore> getScoreList(){
		return score_list;
	}
	
	private static class HighScore {
		public String name;
		public int score;
		public int level;

		public HighScore(String name, int score, int level) {
			this.name = name;
			this.score = score;
			this.level = level;
		}

		public String toString() {
			return score + "\t" + level +"\t" + name;
		}
	}
}
