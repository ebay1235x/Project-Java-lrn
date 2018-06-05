package model.component;
/**
 * <h1>The Touch class.</h1>
Rayan Rayan
 *
 */
public abstract class Touch extends Component {
	private boolean available;
	private boolean touched;
/**
 * Constructor of touch.
 * @param path
 * The path.
 * @param lorannPermeability
 * The lorann Permeability.
 * 
 * @param demonPermeability
 * The demon Permeability.
 * 
 * @param coordinate
 * The coordinate.
 * 
 * @param available
 * The Availability.
 * @param direction
 * The direction.
 */
	public Touch(String path, boolean lorannPermeability, boolean demonPermeability, Coordinate coordinate,
			boolean available, Direction direction) {
		super(path, lorannPermeability, demonPermeability, coordinate, direction);
		this.setAvailable(available);
	}

	public void actionWhenContactHappend() {
		this.touched = true;
	}
/**
 * Operation call to Available
 * @return available
 * The available.
 */
	public boolean isAvailable() {
		return available;
	}
/**
 * Operation to set available.
 * @param available
 * The available.
 */
	public void setAvailable(boolean available) {
		this.available = available;
	}
/**
 * Operation when is touched.
 * @return touched
 * the component touched.
 */
	public boolean isTouched() {
		return touched;
	}
}
