package model.component;

import java.awt.Image;
/**
 * <h1>The Gate class.</h1>
Rayan Rayan
 *
 */
public class Gate extends Touch implements IGate, Kill {
	private final static String PATH = "Pictures/gate";
	/**
	 * Constructor of gate.
	 * 
	 * @param lorannPermeability
	 * The Lorann permeability.
	 * @param demonPermeability
	 * The demon permeability.
	 * @param coordinate
	 * The coordinate.
	 * @param available
	 * the avaibility.
	 */
	public Gate(boolean lorannPermeability, boolean demonPermeability, Coordinate coordinate, boolean available) {
		super(PATH, lorannPermeability, demonPermeability, coordinate, available, Direction.UP);
	}

	@Override
	public void kill(Component target) {
		if (!isAvailable()) {
			if (target instanceof Lorann) {
				Lorann character = (Lorann) target;
				character.kill();
			}
		}
	}
/**
 * If direction equal up, the sprite of the door is closed else, it's
 * open
 */
	@Override
	public Image getImage(Direction direction) { 
													 
		if (isAvailable()) {
			return getSprites().get(1);
		} else {
			return getSprites().get(0);
		}
	}

}
