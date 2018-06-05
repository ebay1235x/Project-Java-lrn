package controller;

import model.IModel;
import model.component.Direction;
import model.component.IComponent;
import view.IGameFrame;

/**
 * <h1>The Interface IController.</h1>
 * 
Rayan
Rayan
 * 
 */
public interface IController {

	public void play();

	/**
	 * Operation call when a component move.
	 * 
	 * @param component
	 *            The component to move
	 * @param direction
	 *            The current direction of the component
	 */
	public void moveComponent(IComponent component, Direction direction);

	/**
	 * Operation call when Lorann has an order to execute.
	 * 
	 * @param order
	 *            The order Lorann has to execute.
	 */
	public void setAction(Order order);

	/**
	 * Operation call to get a model.
	 * 
	 * @return Imodel The interface the Model.
	 */
	public IModel getModel();

	/**
	 * Operation call to get a GameFrame.
	 * 
	 * @return IGameFrame The interface the GameFrame.
	 */
	public IGameFrame getGameFrame();

	/**
	 * Operation call to get a score.
	 * 
	 * @return int The score.
	 */
	public int getScore();

	/**
	 * Operation call to set a score
	 * 
	 * @param score
	 *            The new score.
	 */
	public void setScore(int score);

	/**
	 * Operation call to ad a Victory.
	 * 
	 * @return boolean If the Victory is true or false.
	 */
	public boolean isVictory();

	/**
	 * Operation call to set a victory.
	 * 
	 * @param victory
	 *            set the victory to true or false.
	 */
	public void setVictory(boolean victory);

	/**
	 * Operation call to remove a Component
	 * 
	 * @param component
	 *            The component.
	 */
	public void removeComponent(IComponent component);
}
