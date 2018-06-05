package model.component;

import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;

import model.dao.SpriteReader;

/**
 * <h1>The Component class.</h1>
 * 
Rayan
Rayan
 *
 */
public abstract class Component implements IComponent {
	private final boolean LORANN_PERMEABILITY;
	private final boolean DEMON_PERMEABILITY;

	private ICoordinate coordinate;
	private ArrayList<Image> sprites;
	private Direction direction;

	/**
	 * Constructor of component
	 * 
	 * @param path
	 *            The path.
	 * @param lorannPermeability
	 *            The lorann permeability.
	 * @param demonPermeability
	 *            The demon permeability.
	 * @param coordinate
	 *            The coordinate.
	 * @param direction
	 *            The default direction of the component
	 */
	public Component(String path, boolean lorannPermeability, boolean demonPermeability, ICoordinate coordinate,
			Direction direction) {
		this.LORANN_PERMEABILITY = lorannPermeability;
		this.DEMON_PERMEABILITY = demonPermeability;
		this.coordinate = coordinate;
		this.sprites = new ArrayList<Image>();
		this.setDirection(direction);

		SpriteReader reader = null;

		try {
			reader = new SpriteReader(path);
		} catch (IOException e) {
			e.printStackTrace();
		}

		sprites = reader.getSprites();
	}

	@Override
	public ICoordinate getCoordinate() {
		return coordinate;
	}

	@Override
	public Image getImage(Direction direction) {
		return sprites.get(0);
	}

	@Override
	public void setCoordinate(ICoordinate coordinate) {
		this.coordinate = coordinate;
	}

	@Override
	public boolean isLORANN_PERMEABLE() {
		return LORANN_PERMEABILITY;
	}

	/**
	 * Operation call to get the Sprites.
	 * 
	 * @return sprites the sprites.
	 */

	protected ArrayList<Image> getSprites() {
		return sprites;
	}

	@Override
	public boolean isDEMON_PERMEABLE() {
		return DEMON_PERMEABILITY;
	}

	@Override
	public Direction getDirection() {
		return direction;
	}

	@Override
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
}
