package model.component;
/**
 * 
 * <h1>The Demon class.</h1>
Rayan Rayan
 *
 */
public abstract class Demon extends Component implements Kill {
	private boolean alive;
	/**
	 * The constructor of demon.
	 * @param path
	 * The path.
	 * @param lorannPermeability
	 * The Lorann Permeability.
	 * @param demonPermeability
	 * The demon Permeability.
	 * @param coordinate
	 * The coordinate.
	 * @param direction
	 * The direction.
	 */
	public Demon(String path, boolean lorannPermeability, boolean demonPermeability, Coordinate coordinate,
			Direction direction) {
		super(path, lorannPermeability, demonPermeability, coordinate, direction);
		this.alive = true;
	}

	@Override
	public void kill(Component target) {
		if (target instanceof Lorann) {
			Lorann character = (Lorann) target;
			character.kill();
		}
	}
	/**
	 * Operation call boolean alive.
	 * @return alive
	 * The alive.
	 */
	public boolean isAlive() {
		return alive;
	}
	/**
	 * Operation call to kill demon.
	 * 
	 */
	public void kill() {
		this.alive = false;
	}
}