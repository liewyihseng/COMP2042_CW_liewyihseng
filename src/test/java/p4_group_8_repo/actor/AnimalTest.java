package p4_group_8_repo.actor;

import static org.junit.Assert.*;

import org.junit.Test;

import p4_group_8_repo.MyTest;

public class AnimalTest extends MyTest{


	/**
	 * Test if the setPoint method will set the number of score of the user's animal
	 */
	@Test
	public void testSetPoints1() {
		Animal animal = new Animal();
		animal.setPoints(200);
		int points = animal.getPoints();
		assertEquals(points, 200);
	}
	
	
	/**
	 * Test if the setPoint method will set the number of score of the user's animal
	 */
	@Test
	public void testSetPoints2() {
		Animal animal = new Animal();
		animal.setPoints(10);
		int points = animal.getPoints();
		assertEquals(points, 10);
	}
	
	/**
	 * Test if setSecond method will set the frog's image to the second part of the jump when isSecond returns true
	 */
	@Test
	public void testSetSecond1() {
		Animal animal = new Animal();
		animal.setSecond(true);
		boolean second = animal.isSecond();
		assertTrue(second);
	}
	
	/**
	 * Test if setSecond method will not set the frog's image to the second part of the jump when isSecond returns false
	 */
	@Test
	public void testSetSecond2() {
		Animal animal = new Animal();
		animal.setSecond(false);
		boolean second = animal.isSecond();
		assertFalse(second);
	}
	
	/**
	 * Test if the setCarDeath method will trigger the isCarDeath to represent the frog has died in a car crash when a true has been inserted as parameter
	 */
	@Test
	public void testSetCarDeath1() {
		Animal animal = new Animal();
		animal.setCarDeath(true);
		boolean death = animal.isCarDeath();
		assertEquals(true, death);
	}
	
	/**
	 * Test if the setCarDeath method will not trigger the isCarDeath to represent the frog has not died in a car crash when a false has been inserted as parameter
	 */
	@Test
	public void testSetCarDeath2() {
		Animal animal = new Animal();
		animal.setCarDeath(false);
		boolean death = animal.isCarDeath();
		assertEquals(false, death);
	}

	/**
	 * Test if the setWaterDeath method will trigger the isWaterDeath to represent the frog has died drowning when a true has been inserted as a parameter
	 */
	@Test
	public void testSetWaterDeath1() {
		Animal animal = new Animal();
		animal.setWaterDeath(true);
		boolean death = animal.isWaterDeath();
		assertEquals(true, death);
	}
	
	/**
	 * Test if the setWaterDeath method will not trigger the isWaterDEath to represent th frog has not died from drowning when a false has been inserted as a parameter
	 */
	@Test
	public void testSetWaterDeath2() {
		Animal animal = new Animal();
		animal.setWaterDeath(false);
		boolean death = animal.isWaterDeath();
		assertEquals(false, death);
	}

	/**
	 * Test if deathScoreDecrement method will decrease the score when the score is at 500
	 * Score will be decreased when they are more than 50
	 */
	@Test
	public void testDeathScoreDecrement1() {
		Animal animal = new Animal();
		animal.setPoints(500);
		animal.deathScoreDecrement(animal.getPoints());
		int score = animal.getPoints();
		assertEquals(450, score);
	}
	
	/**
	 * Test if deathScoreDecrement method will decrease the score when the score is at 60
	 * Score will be decreased when they are more than 50
	 */
	@Test
	public void testDeathScoreDecrement2() {
		Animal animal = new Animal();
		animal.setPoints(60);
		animal.deathScoreDecrement(animal.getPoints());
		int score = animal.getPoints();
		assertEquals(10, score);
	}
	
	/**
	 * Test if deathScoreDecrement method will decrease the score when the score is at 50
	 * Score will be decreased when they are more than 50
	 */
	@Test
	public void testDeathScoreDecrement3() {
		Animal animal = new Animal();
		animal.setPoints(50);
		animal.deathScoreDecrement(animal.getPoints());
		int score = animal.getPoints();
		assertEquals(50, score);
	}
	
	
	/**
	 * Test if deathScoreDecrement method will decrease the score when the score is at 30
	 * Score will be decreased when they are more than 50
	 */
	@Test
	public void testDeathScoreDecrement4() {
		Animal animal = new Animal();
		animal.setPoints(30);
		animal.deathScoreDecrement(animal.getPoints());
		int score = animal.getPoints();
		assertEquals(30, score);
	}
	
	
	/**
	 * Test if deathScoreDecrement method will decrease the score when the score is at 10
	 * Score will be decreased when they are more than 50
	 */
	@Test
	public void testDeathScoreDecrement5() {
		Animal animal = new Animal();
		animal.setPoints(10);
		animal.deathScoreDecrement(animal.getPoints());
		int score = animal.getPoints();
		assertEquals(10, score);
	}
	
	/**
	 * Test if deathScoreDecrement method will decrease the score when the score is at 1000
	 * Score will be decreased when they are more than 50
	 */
	@Test
	public void testDeathScoreDecrement6() {
		Animal animal = new Animal();
		animal.setPoints(1000);
		animal.deathScoreDecrement(animal.getPoints());
		int score = animal.getPoints();
		assertEquals(950, score);
	}

	/**
	 * Test if deathScoreDecrement method will decrease the score when the score is at 0
	 * Score will be decreased when they are more than 50
	 */
	@Test
	public void testDeathScoreDecrement7() {
		Animal animal = new Animal();
		animal.setPoints(0);
		animal.deathScoreDecrement(animal.getPoints());
		int score = animal.getPoints();
		assertEquals(0, score);
	}

}
