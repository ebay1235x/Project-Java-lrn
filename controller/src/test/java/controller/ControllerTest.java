package controller;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Model;

/**
 * <h1>The test class ControllerTest.</h1>
 * 
Rayan
Rayan
 *
 */
public class ControllerTest {
private Controller control;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		control = new Controller(new Model());
		control.setScore(10);
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test if the score equal 10
	 */
	@Test
	public void testGetScore() {
		final int expected = 10;
		assertEquals(expected, control.getScore());

	}

}
