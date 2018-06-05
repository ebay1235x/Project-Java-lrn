package view.gameview;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Model;

/**
 * <h1>The GameFrameTest class.</h1>
 * 
Rayan
Rayan
 *
 */
public class GameFrameTest {
	 GameFrame frame;
	 Model model;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		 model = new Model();
		 frame = new GameFrame(model, null);
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * asserEquals compare the expected value relative to GamePanel from the frame
	 */
	@Test
	public void testGetPanel() {
		
		 final GamePanel expected = this.frame.getPanel();
		 assertEquals(expected, frame.getPanel());
	}

}
