package model.component;

/**
 * <h1>The interface ISpell.</h1>
Rayan
Rayan
 *
 */
public interface ISpell extends IComponent {
	/**
	 * Operation call to get a Target
	 * @return {@link IComponent} 
	 * The component targeted.
	 */
	public IComponent getTarget();

	/**
	 * Operation call to set the target.
	 * 
	 * @param target
	 * The component targeted.
	 */
	public void setTarget(IComponent target);
}