package model.component;

/**
 * <h1>The Cargyv class.</h1>
 * 
Rayan
Rayan
 *
 */
public class Cargyv extends Demon {
	private final static String PATH = "Pictures/demons/cargyv";

	/**
	 * Constructor call to create a Cargyv.
	 * 
	 * @param lorannPermeability
	 *            The Lorann Permeability.
	 * @param demonPermeability
	 *            The Demon permeability.
	 * @param coordinate
	 *            The coordinate.
	 * @param direction
	 *            The default direction of the component
	 */

	public Cargyv(boolean lorannPermeability, boolean demonPermeability, Coordinate coordinate, Direction direction) {
		super(PATH, lorannPermeability, demonPermeability, coordinate, direction);
	}

}