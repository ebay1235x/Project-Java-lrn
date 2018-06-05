package model.component;

import java.awt.Image;

/**
 * <h1>The Interface IComponent.</h1>
 * 
Rayan
Rayan
 *
 */
public interface IComponent {
	/**
	 * Operation call to get a Coordinate.
	 * 
	 * @return ICoordinate The coordinate.
	 */
	public ICoordinate getCoordinate();

	/**
	 * Operation call to get an Image
	 * 
	 * @param direction
	 *            The direction.
	 * @return Image The Image.
	 */
	public Image getImage(Direction direction);

	/**
	 * Operation call to set the Coordinate.
	 * 
	 * @param coordinate
	 *            The coordinate.
	 */
	public void setCoordinate(ICoordinate coordinate);

	/**
	 * Operation call to make Lorann Permeable.
	 * 
	 * @return boolean The permeability of Lorann.
	 */
	public boolean isLORANN_PERMEABLE();

	/**
	 * Operation call to make a demon permeable.
	 * 
	 * @return boolean The permeability of a demon.
	 */
	public boolean isDEMON_PERMEABLE();

	/**
	 * Operation call to get a Direction.
	 * 
	 * @return direction the Direction The direction.
	 */
	public Direction getDirection();

	/**
	 * Operation call to set the Direction.
	 * 
	 * @param direction
	 *            The Direction.
	 * 
	 */
	public void setDirection(Direction direction);

}
