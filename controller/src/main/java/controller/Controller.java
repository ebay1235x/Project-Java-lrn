package controller;

import java.sql.SQLException;
import java.util.concurrent.CopyOnWriteArrayList;

import model.Model;
import model.component.ComponentFactory;
import model.component.Coordinate;
import model.component.Demon;
import model.component.Direction;
import model.component.Empty;
import model.component.EnergySphere;
import model.component.Gate;
import model.component.IComponent;
import model.component.ICoordinate;
import model.component.Lorann;
import model.component.Setting;
import model.component.Spell;
import model.component.Treasure;
import view.gameview.GameFrame;
import view.levelselector.LevelSelector;

/**
 * <h1>The class Controller.</h1>
 ** 
Rayan
Rayan
 *
 */
public class Controller implements IController {
	private GameFrame gameFrame;
	private Model model;
	private GameController gameController;
	private Thread game;
	private int score;
	private boolean victory;

	/**
	 * Constructor call.
	 * 
	 * @param model
	 *            The model.
	 */
	public Controller(Model model) {
		this.model = model;
		gameFrame = new GameFrame(model, this);
		initializeGame();
	}

	/**
	 * Launch the game
	 * 
	 */
	public void play() {
		game.run();
	}

	/**
	 * Initialization of the game
	 */
	private void initializeGame() {
		setVictory(false);

		try {
			model.generateMap(LevelSelector.getLevel());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		gameController = new GameController(model.getLorann(), this, instantiateDemonMover());
		game = new Thread(gameController);
		gameFrame.setVisible(true);
	}

	/**
	 * Instantiate the movement of the demon
	 * 
	 * @return movers The list of all the movers
	 */
	private CopyOnWriteArrayList<DemonMover> instantiateDemonMover() {
		CopyOnWriteArrayList<Demon> demons = ComponentFactory.getDemons();
		CopyOnWriteArrayList<DemonMover> movers = new CopyOnWriteArrayList<DemonMover>();

		// Loop which add a new DemonMover for each demon into the ArrayList
		for (Demon demon : demons) {
			movers.add(new DemonMover(demon, this));
		}

		return movers;
	}

	/**
	 * Method used to move a component
	 * 
	 * @param component
	 *            The component to move
	 * @param direction
	 *            The direction that the component will take
	 */
	@Override
	public synchronized void moveComponent(IComponent component, Direction direction) {
		ICoordinate currentCoordinates = component.getCoordinate();
		ICoordinate newCoordinates;

		switch (direction) {
		case DOWN:
			newCoordinates = new Coordinate(currentCoordinates.getX() + 1, currentCoordinates.getY());
			break;

		case DOWNLEFT:
			newCoordinates = new Coordinate(currentCoordinates.getX() + 1, currentCoordinates.getY() - 1);
			break;

		case DOWNRIGHT:
			newCoordinates = new Coordinate(currentCoordinates.getX() + 1, currentCoordinates.getY() + 1);
			break;

		case LEFT:
			newCoordinates = new Coordinate(currentCoordinates.getX(), currentCoordinates.getY() - 1);
			break;

		case RIGHT:
			newCoordinates = new Coordinate(currentCoordinates.getX(), currentCoordinates.getY() + 1);
			break;

		case UP:
			newCoordinates = new Coordinate(currentCoordinates.getX() - 1, currentCoordinates.getY());
			break;

		case UPLEFT:
			newCoordinates = new Coordinate(currentCoordinates.getX() - 1, currentCoordinates.getY());
			break;

		case UPRIGHT:
			newCoordinates = new Coordinate(currentCoordinates.getX() - 1, currentCoordinates.getY() + 1);
			break;
		default:
			newCoordinates = new Coordinate(currentCoordinates.getX(), currentCoordinates.getY());
			break;
		}

		// Condition: if the component is Lorann, check if Lorann can move
		if (component instanceof Lorann) {
			component.setDirection(direction);
			if (directionisAvailableForLorann(newCoordinates)) {
				checkTargetLocation(component, model.getMap()[newCoordinates.getX()][newCoordinates.getY()]);

				component.setCoordinate(newCoordinates);
				model.getMap()[currentCoordinates.getX()][currentCoordinates.getY()] = new Empty(currentCoordinates);
				model.getMap()[newCoordinates.getX()][newCoordinates.getY()] = component;
			}

			// Condition: if the component is a demon, check if it can move
		} else if (component instanceof Demon) {
			if (directionIsAvailableForDemons(newCoordinates)) {
				checkTargetLocation(component, model.getMap()[newCoordinates.getX()][newCoordinates.getY()]);

				component.setCoordinate(newCoordinates);
				component.setDirection(direction);
				model.getMap()[currentCoordinates.getX()][currentCoordinates.getY()] = new Empty(currentCoordinates);
				model.getMap()[newCoordinates.getX()][newCoordinates.getY()] = component;
			}

			// Condition: if the component is the spell, move it
		} else if (component instanceof Spell) {
			moveSpell((Spell) component, newCoordinates, direction);
		}
	}

	/**
	 * This method is used to move the <b>spell</b>. Because the spell move in a
	 * very different way than others components, we use a different method than
	 * <b>moveComponent()</b>.
	 * 
	 * @param spell
	 *            the spell to move
	 * @param newCoordinatesForTheSpell
	 *            the future coordinates of the spell
	 * @param currentDirection
	 *            the current direction of the spell
	 */
	private synchronized void moveSpell(Spell spell, ICoordinate newCoordinatesForTheSpell,
			Direction currentDirection) {

		// If the future position of the spell contain Lorann
		if (model.getMap()[newCoordinatesForTheSpell.getX()][newCoordinatesForTheSpell.getY()] instanceof Lorann) {
			spell.setTarget(model.getMap()[newCoordinatesForTheSpell.getX()][newCoordinatesForTheSpell.getY()]);
			spell.actionWhenContactHappend();
			model.getMap()[spell.getCoordinate().getX()][spell.getCoordinate().getY()] = new Empty(
					spell.getCoordinate());
			model.setSpellToNull();

			// If the future position of the spell contain a demon
		} else if (model.getMap()[newCoordinatesForTheSpell.getX()][newCoordinatesForTheSpell
				.getY()] instanceof Demon) {
			spell.setTarget(model.getMap()[newCoordinatesForTheSpell.getX()][newCoordinatesForTheSpell.getY()]);
			spell.actionWhenContactHappend();

			// If the future position of the spell contain a border
		} else if (model.getMap()[newCoordinatesForTheSpell.getX()][newCoordinatesForTheSpell
				.getY()] instanceof Setting) {
			spell.setDirection(Direction.getOppositeDirection(currentDirection));
			moveComponent(spell, spell.getDirection());

			// If the future position of the spell contain an energy sphere
		} else if ((model.getMap()[newCoordinatesForTheSpell.getX()][newCoordinatesForTheSpell
				.getY()] instanceof EnergySphere)
				|| (model.getMap()[newCoordinatesForTheSpell.getX()][newCoordinatesForTheSpell
						.getY()] instanceof Gate)) {
			spell.setDirection(Direction.getOppositeDirection(currentDirection));
			moveComponent(spell, spell.getDirection());

		} else {
			if (!(model.getMap()[spell.getCoordinate().getX()][spell.getCoordinate().getY()] instanceof Lorann)) {
				model.getMap()[spell.getCoordinate().getX()][spell.getCoordinate().getY()] = new Empty(
						spell.getCoordinate());
			}
			spell.setCoordinate(newCoordinatesForTheSpell);
			model.getMap()[newCoordinatesForTheSpell.getX()][newCoordinatesForTheSpell.getY()] = spell;

		}
	}

	/**
	 * Check if Lorann can move here.
	 * 
	 * @param coordinateToCheck
	 *            The coordinates to check
	 * @return a boolean to allow or not the move
	 */
	private synchronized boolean directionisAvailableForLorann(ICoordinate coordinateToCheck) {
		IComponent destination = model.getMap()[coordinateToCheck.getX()][coordinateToCheck.getY()];

		if (destination.isLORANN_PERMEABLE()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Check if the demon can move here.
	 * 
	 * @param coordinateToCheck
	 *            The coordinates to check
	 * @return a boolean to allow or not the move
	 */
	private synchronized boolean directionIsAvailableForDemons(ICoordinate coordinateToCheck) {
		IComponent destination = model.getMap()[coordinateToCheck.getX()][coordinateToCheck.getY()];

		if (destination.isDEMON_PERMEABLE()) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Realize action relative to the target component
	 * 
	 * @param componentToMove
	 *            The component to move
	 * @param componentInPosition
	 *            The component which will be at the position of the component to
	 *            move
	 */
	private synchronized void checkTargetLocation(IComponent componentToMove, IComponent componentInPosition) {
		if (componentToMove instanceof Lorann) {
			Lorann lorann = (Lorann) componentToMove;
			// If Lorann catch a treasure, give 10 points to the player.
			if (componentInPosition instanceof Treasure) {
				Treasure treasure = (Treasure) componentInPosition;

				this.score = score + treasure.getValue();

				// If Lorann meet a demon, kill him
			} else if (componentInPosition instanceof Demon) {
				this.model.getLorann().kill();

			} else if (componentInPosition instanceof Gate) {
				Gate gate = (Gate) componentInPosition;
				// If gate is available, we win the game
				if (gate.isAvailable()) {
					setVictory(true);
				} else {
					// If the gate is not available, kill Lorann
					lorann.kill();
				}

			} else if (componentInPosition instanceof EnergySphere) {
				EnergySphere sphere = (EnergySphere) componentInPosition;
				// When we take the EnergySphere, open the gate
				if (sphere.isAvailable()) {
					model.getGate().setAvailable(true);
				}
				sphere.setAvailable(false);

				// If the position of Lorann will be the spell, get it
			} else if (componentInPosition instanceof Spell) {
				lorann.setSpellLaunched(false);
				model.getMap()[componentInPosition.getCoordinate().getX()][componentInPosition.getCoordinate()
						.getY()] = new Empty(componentInPosition.getCoordinate());
				model.setSpellToNull();

			}

			// If Lorann has the same position than a demon, Lorann die.
		} else if (componentToMove instanceof Demon) {
			if (componentInPosition instanceof Lorann) {
				Lorann lorann = (Lorann) componentInPosition;
				lorann.kill();

			} else if (componentInPosition instanceof Spell) {
				Demon demon = (Demon) componentToMove;
				demon.kill();
			}
		}
	}

	public void removeComponent(IComponent component) {
		model.getMap()[component.getCoordinate().getX()][component.getCoordinate().getY()] = new Empty(
				component.getCoordinate());
	}

	/**
	 * Set an action for Lorann.
	 * 
	 * @param order
	 *            The order Lorann has to execute.
	 */
	public void setAction(Order order) {
		if (order.equals(Order.FIRE)) {
			// Launch the spell if the order is to fire
			if (model.getLorann().launchSpell()) {
				moveComponent(
						(IComponent) model.getSpell(new Coordinate(model.getLorann().getCoordinate()),
								Direction.getOppositeDirection(model.getLorann().getDirection())),
						Direction.getOppositeDirection(model.getLorann().getDirection()));
			}
		} else {
			// Move the component
			moveComponent(model.getLorann(), Direction.getDirectionFromOrder(order));
		}

	}

	/**
	 * 
	 * Get the model.
	 * 
	 * @return model The model.
	 */
	public Model getModel() {
		return model;
	}

	/**
	 * Get the GameFrame.
	 * 
	 * @return The game frame
	 * 
	 */
	public GameFrame getGameFrame() {
		return gameFrame;
	}

	/**
	 * Operation call to get a score.
	 * 
	 * @return score the current score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Operation call to set the score
	 * 
	 * @param score
	 *            the score to set.
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * check if the victory happened
	 * 
	 * @return victory A boolean to check the victory
	 */
	public boolean isVictory() {
		return victory;
	}

	/**
	 * @param victory
	 *            The victory boolean
	 */
	public void setVictory(boolean victory) {
		this.victory = victory;
	}
}
