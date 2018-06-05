package model.component;
/**
 * <h1>The Maarcg class.</h1>
Rayan Rayan
 *
 */
public class Maarcg extends Demon {
	private final static String PATH = "Pictures/demons/maarcg";
/**
 * Constructor of Maarcg.
 * 
 * @param lorannPermeability
 * The Lorann Permeability.
 * @param demonPermeability
 * The demon Permeability.
 * @param coordinate
 * The coordinate.
 * @param direction
 * The direction.
 */
	public Maarcg(boolean lorannPermeability, boolean demonPermeability, Coordinate coordinate, Direction direction) {
		super(PATH, lorannPermeability, demonPermeability, coordinate, direction);
	}

}