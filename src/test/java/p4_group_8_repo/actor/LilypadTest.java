package p4_group_8_repo.actor;

import static org.junit.Assert.*;

import org.junit.Test;

import p4_group_8_repo.MyTest;

public class LilypadTest extends MyTest{

	/**
	 * Test if setEnd will function when a frog has landed on it triggering the change of end image
	 */
	@Test
	public void testSetEnd() {
		Lilypad lilypad = new Lilypad(40 , 60);
		lilypad.setEnd();
		boolean activated = lilypad.isActivated();
		assertTrue(activated);
	}

	/**
	 * Test if setActivated is functioning to detect whether a frog has landed on it
	 */
	@Test
	public void testSetActivated1() {
		Lilypad lilypad = new Lilypad(40, 60);
		lilypad.setActivated(true);
		boolean activated = lilypad.isActivated();
		assertTrue(activated);
	}
	
	/**
	 * Test if setActivated is functioning to detect whether a frog has landed on it
	 */
	@Test
	public void testSetActivated2() {
		Lilypad lilypad = new Lilypad(40, 60);
		lilypad.setActivated(false);
		boolean activated = lilypad.isActivated();
		assertFalse(activated);
	}

}
