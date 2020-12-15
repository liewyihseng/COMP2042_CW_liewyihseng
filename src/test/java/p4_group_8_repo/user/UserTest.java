package p4_group_8_repo.user;

import static org.junit.Assert.*;
import p4_group_8_repo.MyTest;
import org.junit.Test;

public class UserTest extends MyTest {

	/**
	 * Test the setLevel method if it will set the user level when a parameter representing the level has been inserted
	 */
	@Test
	public void testSetLevel1() {
		User user = new User();
		user.setLevel(2);
		int level = user.getLevel();
		assertEquals(2, level);
	}
	
	/**
	 * Test the setLevel method if it will set the user level when a parameter representing the level has been inserted
	 */
	@Test
	public void testSetLevel2() {
		User user = new User();
		user.setLevel(7);
		int level = user.getLevel();
		assertEquals(7, level);
	}

	/**
	 * Test the setUsername method if it will set the user's username when a parameter representing the username has been inserted
	 */
	@Test
	public void testSetUsername1() {
		User user = new User();
		user.setUsername("UserTest");
		String userName = user.getUsername();
		assertEquals("UserTest", userName);
	}
	
	/**
	 * Test the setUsername method if it will assign the user with a random username when the username is not enter upon start scene
	 */
	@Test
	public void testSetUsername2() {
		User user = new User();
		String userName = user.getUsername();
		assertNotNull(userName);
	}

	/**
	 * Test the setScore method if it will assign a score to the user when a parameter representing the score has been inserted
	 */
	@Test
	public void testSetScore1() {
		User user = new User();
		user.setScore(200);
		int score = user.getScore();
		assertEquals(200, score);
	}
	
	/**
	 * Test the setScore method if it will assign a score to the user when a parameter representing the score has been inserted
	 */
	@Test
	public void testSetScore2() {
		User user = new User();
		user.setScore(700);
		int score = user.getScore();
		assertEquals(700, score);
	}

	/**
	 * Test the isInGame method if it will set the user's status whether he/she is currently playing the game or in pause scene
	 */
	@Test
	public void testIsInGame1() {
		User user = new User();
		user.setInGame(true);
		boolean inGame = user.isInGame();
		assertEquals(true, inGame);
	}
	
	/**
	 * Test the isInGame method if it will set the user's status whether he/she is currently playing the game or in pause scene
	 */
	@Test
	public void testIsInGame2() {
		User user = new User();
		user.setInGame(false);
		boolean inGame = user.isInGame();
		assertEquals(false, inGame);
	}

}

