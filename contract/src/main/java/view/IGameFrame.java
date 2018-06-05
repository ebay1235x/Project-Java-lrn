package view;

/**
 * <h1>The Interface IView.</h1>
 *
Rayan Rayan

 */
public interface IGameFrame {
	/**
	 * Operation call to get a Panel.
	 * @return IGamePanel
	 * The GamePanel.
	 */
	public IGamePanel getPanel();
	
	/**
	 * Operation call to dispose.
	 */
	public void dispose();
}
