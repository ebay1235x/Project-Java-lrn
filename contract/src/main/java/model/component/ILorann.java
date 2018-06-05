package model.component;

/**
 * <h1>The interface ILorann.</h1>
Rayan
Rayan
 *
 */
public interface ILorann extends IComponent {

	/**
	 * Operation call to launch the spell.
	 * 
	 * @return boolean The spell.
	 */
	public boolean launchSpell();

	/**
	 * Operation call to set Alive.
	 * 
	 * @return boolean The Alive.
	 */
	public boolean isAlive();

	/**
	 * Operation call to set kill.
	 */
	public void kill();

	/**
	 * Operation call to had a spel Launched.
	 * 
	 * @return true If the spell is launched.
	 */
	public boolean isSpellLaunched();

	/**
	 * Operation to set the Spell Launched.
	 * 
	 * @param spellLaunched
	 *            The spell set.
	 */
	public void setSpellLaunched(boolean spellLaunched);
}
