package model.component;
/**
 * <h1>The Treasure class.</h1>
Rayan Rayan
 *
 */
public class Treasure extends Touch {
	private final static String PATH = "Pictures/treasure";
	private final static int VALUE = 10;
/**
 * Constructor of Treasure.
 * @param lorannPermeability
 * The Loran Permeability.
 * @param demonPermeability
 * The Demon Permeability.
 * @param coordinate
 * The coordinate.
 * @param available
 * The availability.
 */
	public Treasure(boolean lorannPermeability, boolean demonPermeability, Coordinate coordinate, boolean available) {
		super(PATH, lorannPermeability, demonPermeability, coordinate, available, Direction.UP);
	}
/**
 * Operation call to get a value
 * @return Value
 * The Value.
 */
	public int getValue() {
		return VALUE;
	}

}
