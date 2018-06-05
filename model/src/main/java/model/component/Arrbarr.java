package model.component;

/**
 * <h1>The Arbarr class.</h1>
 * 
Rayan
Rayan
 *
 */
public class Arrbarr extends Demon {
	private final static String PATH = "Pictures/demons/arrbarr";

	/**
	 * Constructor call to create a Arrbarr.
	 * 
	 * @param lorannPermeability
	 *            The lorann permeability.
	 * @param demonPermeability
	 *            The demon permeability.
	 * 
	 * @param coordinate
	 *            The default cooredinate of the component
	 * @param direction
	 *            The default direction of the component
	 */

	public Arrbarr(boolean lorannPermeability, boolean demonPermeability, Coordinate coordinate, Direction direction) {
		super(PATH, lorannPermeability, demonPermeability, coordinate, direction);
	}

}