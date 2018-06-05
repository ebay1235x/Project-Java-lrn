package model.component;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * <h1>The ComponentFactory class.</h1>
 * 
Rayan
Rayan
 *
 */
public abstract class ComponentFactory {
	private static Lorann lorann;
	private static Gate gate;
	private static CopyOnWriteArrayList<Demon> demons;

	/**
	 * Build each component in function of the the map and put them into an array of
	 * two dimensions of Components.
	 * 
	 * @param map
	 *            The map.
	 * 
	 * @return Component[][] The component.
	 */
	public static Component[][] buildComponentsFromMap(String map) {
		Component[][] components = new Component[12][20];
		demons = new CopyOnWriteArrayList<Demon>();

		char[] charArray = map.toCharArray();

		int index = 0;

		for (int x = 0; x < 12; x++) {
			for (int y = 0; y < 20; y++, index++) {

				switch (charArray[index]) {
				case 'C':
					components[x][y] = createCornerSet(new Coordinate(x, y));
					break;

				case 'H':
					components[x][y] = createHorizontalSet(new Coordinate(x, y));
					break;

				case 'V':
					components[x][y] = createVerticalSet(new Coordinate(x, y));
					break;

				case ' ':
					components[x][y] = createEmpty(new Coordinate(x, y));
					break;

				case 'P':
					lorann = createLorann(new Coordinate(x, y));
					components[x][y] = getLorann();
					break;

				case 'L':
					components[x][y] = createEnergySphere(new Coordinate(x, y));
					break;

				case 'T':
					components[x][y] = createTreasure(new Coordinate(x, y));
					break;

				case '1':
					components[x][y] = createCargyv(new Coordinate(x, y));
					demons.add((Demon) components[x][y]);

					break;

				case '2':
					components[x][y] = createArrbarr(new Coordinate(x, y));
					demons.add((Demon) components[x][y]);
					break;

				case '3':
					components[x][y] = createKyacj(new Coordinate(x, y));
					demons.add((Demon) components[x][y]);
					break;

				case '4':
					components[x][y] = createMarrcg(new Coordinate(x, y));
					demons.add((Demon) components[x][y]);
					break;

				case 'G':
					gate = createGate(new Coordinate(x, y));
					components[x][y] = gate;
					break;

				default:
					components[x][y] = components[x][y] = createEmpty(new Coordinate(x, y));
					break;
				}
			}
		}

		return components;
	}

	/**
	 * Build new Lorann.
	 * 
	 * @param coordinate
	 *            The coordinate.
	 * @return Lorann The Lorann.
	 */
	private static Lorann createLorann(Coordinate coordinate) {
		return new Lorann(true, true, coordinate, Direction.UP);
	}

	/**
	 * Build new Spell.
	 * 
	 * @param coordinate
	 *            The coordinate.
	 * @param direction
	 *            The default direction of the component
	 * @return Spell The Spell
	 * 
	 */
	public static Spell createSpell(Coordinate coordinate, Direction direction) {
		return new Spell(true, true, coordinate, false, direction);
	}

	/**
	 * Build new Kyracj.
	 * 
	 * @param coordinate
	 *            The coordinate.
	 * @return Kyracj The Kyracj.
	 */
	private static Kyracj createKyacj(Coordinate coordinate) {
		return new Kyracj(true, false, coordinate, Direction.UP);
	}

	/**
	 * Build new Maarcg.
	 * 
	 * @param coordinate
	 *            The coordinate.
	 * @return Maarcg The Maarcg.
	 */
	private static Maarcg createMarrcg(Coordinate coordinate) {
		return new Maarcg(true, false, coordinate, Direction.UP);
	}

	/**
	 * Build new Arrbarr.
	 * 
	 * @param coordinate
	 *            The coordinate.
	 * @return Arrbarr The Arrbarr.
	 */
	private static Arrbarr createArrbarr(Coordinate coordinate) {
		return new Arrbarr(true, false, coordinate, Direction.UP);
	}

	/**
	 * Build new Cargyv.
	 * 
	 * @param coordinate
	 *            The coordinate.
	 * @return Cargyv The Cargyv.
	 */
	private static Cargyv createCargyv(Coordinate coordinate) {
		return new Cargyv(true, false, coordinate, Direction.UP);
	}

	/**
	 * Build new Treasure.
	 * 
	 * @param coordinate
	 *            The coordinate.
	 * @return Treasure The Treasure.
	 */
	private static Treasure createTreasure(Coordinate coordinate) {
		return new Treasure(true, false, coordinate, true);
	}

	/**
	 * Build new EnergySphere.
	 * 
	 * @param coordinate
	 *            The coordinate.
	 * @return EnergySphere The Energy sphere.
	 */
	private static EnergySphere createEnergySphere(Coordinate coordinate) {
		return new EnergySphere(true, false, coordinate, true);
	}

	/**
	 * Build new Gate.
	 * 
	 * @param coordinate
	 *            The coordinate.
	 * @return Gate The Gate.
	 */
	private static Gate createGate(Coordinate coordinate) {
		return new Gate(true, false, coordinate, false);
	}

	/**
	 * Build new CornerSet.
	 * 
	 * @param coordinate
	 *            The coordinate.
	 * @return CornerSet The cornerSet.
	 */
	private static CornerSet createCornerSet(Coordinate coordinate) {
		return new CornerSet(coordinate);
	}

	/**
	 * Build new HorizontalSet.
	 * 
	 * @param coordinate
	 *            The coordinate.
	 * @return HorizontalSet The Horizontal set.
	 */
	private static HorizontalSet createHorizontalSet(Coordinate coordinate) {
		return new HorizontalSet(coordinate);
	}

	/**
	 * Build new VerticalSet.
	 * 
	 * @param coordinate
	 *            The coordinate.
	 * @return VerticalSet The vertical set.
	 */
	private static VerticalSet createVerticalSet(Coordinate coordinate) {
		return new VerticalSet(coordinate);
	}

	/**
	 * Build new Empty.
	 * 
	 * @param coordinate
	 *            The coordinate.
	 * @return Empty The empty.
	 */
	private static Empty createEmpty(Coordinate coordinate) {
		return new Empty(coordinate);
	}

	/**
	 * Get a Lorann.
	 * 
	 * @return Lorann The Lorann.
	 */
	public static Lorann getLorann() {
		return lorann;
	}

	/**
	 * Get Gate.
	 * 
	 * @return gate the gate.
	 */
	public static Gate getGate() {
		return gate;
	}

	/**
	 * Get Demons.
	 * 
	 * @return demons the demon.
	 */
	public static CopyOnWriteArrayList<Demon> getDemons() {
		return demons;
	}

	
}
