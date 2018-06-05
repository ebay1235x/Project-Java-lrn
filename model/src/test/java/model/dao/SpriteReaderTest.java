package model.dao;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SpriteReaderTest {
	private final static String PATH = "Pictures/";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		String expected = "Can't create an ImageInputStream!";
		String exception = null;

		try {
			@SuppressWarnings("unused")
			SpriteReader reader = new SpriteReader(PATH);
		} catch (IOException e) {
			exception = e.getMessage();
		}

		assertEquals(expected, exception);
	}

}
