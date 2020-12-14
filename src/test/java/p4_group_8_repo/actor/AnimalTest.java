package p4_group_8_repo.actor;

import static org.junit.Assert.*;

import org.junit.Test;

import p4_group_8_repo.MyTest;

public class AnimalTest extends MyTest{


	@Test
	public void testSetPoints1() {
		Animal animal = new Animal();
		animal.setPoints(200);
		int points = animal.getPoints();
		assertEquals(points, 200);
	}
	
	@Test
	public void testSetPoints2() {
		Animal animal = new Animal();
		animal.setPoints(10);
		int points = animal.getPoints();
		assertEquals(points, 10);
	}

	@Test
	public void testSetSecond1() {
		Animal animal = new Animal();
		animal.setSecond(true);
		boolean second = animal.isSecond();
		assertTrue(second);
	}
	
	@Test
	public void testSetSecond2() {
		Animal animal = new Animal();
		animal.setSecond(false);
		boolean second = animal.isSecond();
		assertFalse(second);
	}

	@Test
	public void testSetCarDeath1() {
		Animal animal = new Animal();
		animal.setCarDeath(true);
		boolean death = animal.isCarDeath();
		assertEquals(true, death);
	}
	
	@Test
	public void testSetCarDeath2() {
		Animal animal = new Animal();
		animal.setCarDeath(false);
		boolean death = animal.isCarDeath();
		assertEquals(false, death);
	}

	@Test
	public void testSetWaterDeath1() {
		Animal animal = new Animal();
		animal.setWaterDeath(true);
		boolean death = animal.isWaterDeath();
		assertEquals(true, death);
	}
	
	@Test
	public void testSetWaterDeath2() {
		Animal animal = new Animal();
		animal.setWaterDeath(false);
		boolean death = animal.isWaterDeath();
		assertEquals(false, death);
	}

	@Test
	public void testDeathScoreDecrement1() {
		Animal animal = new Animal();
		animal.setPoints(500);
		animal.deathScoreDecrement(animal.getPoints(), true);
		int score = animal.getPoints();
		assertEquals(450, score);
	}
	
	@Test
	public void testDeathScoreDecrement2() {
		Animal animal = new Animal();
		animal.setPoints(60);
		animal.deathScoreDecrement(animal.getPoints(), true);
		int score = animal.getPoints();
		assertEquals(10, score);
	}
	
	@Test
	public void testDeathScoreDecrement3() {
		Animal animal = new Animal();
		animal.setPoints(50);
		animal.deathScoreDecrement(animal.getPoints(), true);
		int score = animal.getPoints();
		assertEquals(50, score);
	}
	
	@Test
	public void testDeathScoreDecrement4() {
		Animal animal = new Animal();
		animal.setPoints(30);
		animal.deathScoreDecrement(animal.getPoints(), true);
		int score = animal.getPoints();
		assertEquals(30, score);
	}
	
	@Test
	public void testDeathScoreDecrement5() {
		Animal animal = new Animal();
		animal.setPoints(10);
		animal.deathScoreDecrement(animal.getPoints(), true);
		int score = animal.getPoints();
		assertEquals(10, score);
	}
	
	@Test
	public void testDeathScoreDecrement6() {
		Animal animal = new Animal();
		animal.setPoints(1000);
		animal.deathScoreDecrement(animal.getPoints(), true);
		int score = animal.getPoints();
		assertEquals(950, score);
	}

	@Test
	public void testDeathScoreDecrement7() {
		Animal animal = new Animal();
		animal.setPoints(0);
		animal.deathScoreDecrement(animal.getPoints(), true);
		int score = animal.getPoints();
		assertEquals(0, score);
	}

}
