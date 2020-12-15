package p4_group_8_repo;

import static org.junit.Assert.*;

import org.junit.Test;

public class HighScoresTest extends MyTest{
	
	/**
	 * Test if the isNewHighScore will determine if the parameter is a new high score to be added into the list.
	 * 10000 has been opted as the game only has 10 levels and the highest score achievable will not exceed 10000
	 * Therefore it will undeniably be the highest score,
	 * and will return a true
	 */
	@Test
	public void testIsNewHighScore1() {
		HighScores highScores = new HighScores();
		boolean isNew = highScores.isNewHighScore(10000);
		assertTrue(isNew);
	}
	
	/**
	 * Test if the isNewHighScore will determine if the parameter is a new high score to be added into the list.
	 * 0 has been opted in this test as the lowest score achievable will definitely 
	 * exceed 0 because user will be assured a minimum of 60 points when reaching an end
	 * Therefore it will undeniably be the lowest score,
	 * and will return a true
	 */
	@Test
	public void testIsNewHighScore2() {
		HighScores highScores = new HighScores();
		boolean isNew = highScores.isNewHighScore(0);
		assertFalse(isNew);
	}

}
