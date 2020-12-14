package p4_group_8_repo.user;

import static org.junit.Assert.*;
import p4_group_8_repo.MyTest;
import org.junit.Test;

public class UserTest extends MyTest {

	@Test
	public void testSetLevel1() {
		User user = new User();
		user.setLevel(2);
		int level = user.getLevel();
		assertEquals(2, level);
	}
	
	@Test
	public void testSetLevel2() {
		User user = new User();
		user.setLevel(7);
		int level = user.getLevel();
		assertEquals(7, level);
	}

	@Test
	public void testSetUsername1() {
		User user = new User();
		user.setUsername("UserTest");
		String userName = user.getUsername();
		assertEquals("UserTest", userName);
	}
	
	@Test
	public void testSetUsername2() {
		User user = new User();
		String userName = user.getUsername();
		assertNotNull(userName);
	}

	@Test
	public void testSetScore1() {
		User user = new User();
		user.setScore(200);
		int score = user.getScore();
		assertEquals(200, score);
	}
	
	@Test
	public void testSetScore2() {
		User user = new User();
		user.setScore(700);
		int score = user.getScore();
		assertEquals(700, score);
	}

	@Test
	public void testIsInGame1() {
		User user = new User();
		user.setInGame(true);
		boolean inGame = user.isInGame();
		assertEquals(true, inGame);
	}
	
	@Test
	public void testIsInGame2() {
		User user = new User();
		user.setInGame(false);
		boolean inGame = user.isInGame();
		assertEquals(false, inGame);
	}

}

