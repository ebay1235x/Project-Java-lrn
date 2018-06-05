package model;

import java.sql.SQLException;

import model.component.Component;
import model.component.ComponentFactory;
import model.component.Coordinate;
import model.component.Direction;
import model.component.Gate;
import model.component.IComponent;
import model.component.ICoordinate;
import model.component.ISpell;
import model.component.Lorann;
import model.component.Spell;
import model.dao.DTBReader;

/**
 * <h1>The Model class.</h1>
 * 
Rayan
Rayan
 *
 */
public class Model implements IModel {
	private IComponent[][] components;
	private Lorann lorann;
	private Gate gate;
	private Spell spell;

	/**
	 * Constructor of Model.
	 */
	public Model() {
		components = new Component[12][20];//
	}

	/**
	 * Creation of a Map
	 */
	public synchronized IComponent[][] getMap() {
		return components;
	}

	/**
	 * Operation call to get a Map from DTB.
	 * 
	 * @param idMap
	 *            The id of the Map.
	 * @return String The id.
	 * @throws SQLException
	 *             The SQL exception
	 */
	private String getMapFromDTB(int idMap) throws SQLException {
		return DTBReader.ReturnMap(idMap);
	}

	/**
	 * Operation call to generate the Map.
	 */
	public void generateMap(int idMap) throws SQLException {
		String map = getMapFromDTB(idMap);
		components = ComponentFactory.buildComponentsFromMap(map);
		lorann = ComponentFactory.getLorann();
		gate = ComponentFactory.getGate();
	}

	/**
	 * Creation of Lorann.
	 */
	public Lorann getLorann() {
		return lorann;
	}

	/**
	 * Operation call to get a gate.
	 */
	public Gate getGate() {
		return gate;
	}

	@Override
	public ISpell getSpell(ICoordinate coordinate, Direction direction) {
		if (spell == null) {
			spell = ComponentFactory.createSpell((Coordinate) coordinate, direction);
			return spell;
		} else {
			return spell;
		}
	}

	@Override
	public void setSpellToNull() {
		spell = null;
	}
}
