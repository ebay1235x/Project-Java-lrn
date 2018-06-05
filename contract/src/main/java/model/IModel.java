package model;

import java.sql.SQLException;

import model.component.Direction;
import model.component.IComponent;
import model.component.ICoordinate;
import model.component.IGate;
import model.component.ILorann;
import model.component.ISpell;

/**
 * <h1>The Interface IModel.</h1>
 *
Rayan
Rayan
 * 
 */
public interface IModel {
	/**
	 * Operation call to get a Map
	 * 
	 * @return IComponent The Map.
	 * 
	 */
	public IComponent[][] getMap();

	/**
	 * Generate the map which is an array of two dimensions of <b>Component</b>.
	 * 
	 * @param idMap
	 *            The id of the level.
	 * @throws SQLException
	 *             The SQL exception
	 */
	public void generateMap(int idMap) throws SQLException;

	/**
	 * operation call to get a Lorann.
	 * 
	 * @return ILorann The Lorann.
	 */
	public ILorann getLorann();

	/**
	 * Operation call to get a Gate.
	 * 
	 * @return IGate The Gate.
	 */
	public IGate getGate();

	/**
	 * Operation call to get a Spell.
	 * 
	 * @param coordinate
	 *            Of the spell.
	 * @param direction
	 *            The current direction of the spell.
	 * 
	 * @return ISpell The spell.
	 */
	public ISpell getSpell(ICoordinate coordinate, Direction direction);

	/**
	 * Reinitialize the spell to null value
	 */
	public void setSpellToNull();
}
