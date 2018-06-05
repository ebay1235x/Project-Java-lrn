package view;

import model.component.IComponent;
/**
 * <h1>The interface IGamePanel.</h1>
Rayan Rayan
 *
 */
public interface IGamePanel {
	/**
	 * Operation call to update the Map.
	 * @param components
	 * The updated Map.
	 */
	public void updateMap(IComponent[][] components);
}
