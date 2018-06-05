package model.component;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class CoordinateTest {
private static Coordinate coordinate;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		coordinate = new Coordinate(1, 1);
	}

	@Test
	public void getX() {
		final int expected = 1;
		assertEquals(expected, coordinate.getX());

	}

}
