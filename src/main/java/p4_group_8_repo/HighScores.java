package p4_group_8_repo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class HighScores {
	private String root = System.getProperty("user.dir");
	private String scoreFile = root+"\\src\\main\\resources\\scoreFile.txt";
	private static final int MAX_SCORES = 10;
	private ArrayList<HighScore> score_list;
	private static final String[] DUMMY_NAMES = {
			"John",
			"Josh",
			"Larry",
			"Bob",
			"133t",
			"George",
			"Chunk",
			"Cloud",
			"Gary",
			"Cthulu"
		};
	
	public HighScores() {
		String line;
		String[] parts;
		int score;
		
		score_list = new ArrayList<HighScore>(MAX_SCORES);
		
		try {
			BufferedReader file = new BufferedReader(new FileReader(scoreFile));
			while((line = file.readLine()) != null) {
				parts = line.split("\t", 2);
				
				score = Integer.parseInt(parts[0]);
				
				score_list.add(new HighScore(score, parts[1]));
			}
			
			file.close();
		}catch(IOException e) {
			System.err.println("No high score file found, creating new high scores...");
			int dummy_score = 1001;
			
			for(int i = 0; i< DUMMY_NAMES.length; i++) {
				score_list.add(new HighScore(dummy_score, DUMMY_NAMES[i]));
				dummy_score -= 100;
			}
		}
	}
	
	public boolean isNewHighScore(int score) {
		HighScore lowestHighScores = score_list.get(score_list.size() -1);
		
		if(score < lowestHighScores.score)
			return false;
		return true;
	}
	
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
	
	public void printScores() {
		System.out.println("High Scores:");
		for(int i=0; i<score_list.size(); i++) {
			System.out.println(score_list.get(i));
		}
	}
	
	public void add(String name, int score) {
		score_list.add(new HighScore(score, name));
		int min_element;
		int index;
		int temp_score;
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
				}
			}
		}
	}
	
	public void newScore(int score) {
		if(this.isNewHighScore(score)) {
			String name = JOptionPane.showInputDialog("New high score, enter your name");
			
			if(name == null)
				return;
			
			this.add(name, score);
			writeScoreFile();
		}
	}
	
	public ArrayList<HighScore>getScoreList(){
		return score_list;
	}
	
	private static class HighScore {
		public String name;
		public int score;

		public HighScore(int score, String name) {
			this.name = name;
			this.score = score;
		}

		public String toString() {
			return score + "\t" + name;
		}
	}
}
