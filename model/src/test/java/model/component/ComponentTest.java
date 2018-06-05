package model.component;

import static org.junit.Assert.assertFalse;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ComponentTest {
private Lorann lorann;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		lorann = new Lorann(false, true, new Coordinate(5, 5), Direction.UP);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void isLORANN_PERMEABLE() {
		assertFalse(null, lorann.isLORANN_PERMEABLE());
	}
}
