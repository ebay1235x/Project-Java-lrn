package controller;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Random;

import model.component.Demon;
import model.component.Direction;

/**
 * <h1>Create the class DemonMover which is implements by Runnable.</h1>
 * 
Rayan
Rayan
 *
 */
public class DemonMover {
	private Demon demon;
	private Controller controller;

	/**
	 * Operation call to move Demon.
	 * 
	 * @param demon
	 *            The demon.
	 * @param controller
	 *            The controller.
	 */
	public DemonMover(Demon demon, Controller controller) {
		this.demon = demon;
		this.controller = controller;

	}

	/**
	 * Call of MoveComponent. get the enum in an ArrayList and use it randomly.
	 * Creation of the new Random.
	 * 
	 */
	public void move() {
		Random random = new Random();
		ArrayList<Direction> list = new ArrayList<Direction>(EnumSet.allOf(Direction.class));
		int index = random.nextInt(list.size());
		controller.moveComponent(demon, list.get(index));
	}

	/**
	 * Operation call to get a Demon.
	 * 
	 * @return demon The demon.
	 */
	public Demon getDemon() {
		return demon;
	}

}