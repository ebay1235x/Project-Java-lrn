package controller;

import static org.junit.Assert.assertNotEquals;

//import static org.junit.Assert.assertNotEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Model;
import model.component.Cargyv;
import model.component.Coordinate;
import model.component.Direction;

public class DemonMoverTest {
private Controller controller;
private DemonMover mover;
private Cargyv cargyv;
private Coordinate coordinate;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		controller = new Controller(new Model());
		coordinate = new Coordinate(2, 2);
		cargyv = new Cargyv(true, false, coordinate, Direction.UP);
	mover = new DemonMover(cargyv, controller);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void move() {
	mover.move();
		Coordinate unexpected = coordinate;
		assertNotEquals(unexpected.getX(), cargyv.getCoordinate().getX());
	}
}
