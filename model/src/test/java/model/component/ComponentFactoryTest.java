package model.component;

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import model.Model;

/**
 * <h1>The ComponentFactoryTest class.</h1>
Rayan
Rayan
 *
 */
public class ComponentFactoryTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		Model model = new Model();
		model.generateMap(1);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {

	}

	/**
	 * get Lorann is a method who return the object Lorann so we created a new Loran
	 * with the basic setup then we use assertEquals to find if expected and the
	 * return Lorann are the same
	 */
	@Test
	public void getLorann() {
	assertEquals(Lorann.class, ComponentFactory.getLorann().getClass());
	}

}
