package model.component;

import javax.swing.JOptionPane;

import controller.Order;

/**
 * <h1>The Enum Direction.</h1>
 * 
Rayan
Rayan
 *
 */
public enum Direction {
	UP, UPRIGHT, UPLEFT, RIGHT, LEFT, DOWN, DOWNRIGHT, DOWNLEFT;
	/**
	 * Operation call to get the direction from the Order.
	 * 
	 * @param order
	 *            The order of the human.
	 * @return Direction The result direction of Lorann.
	 */
	public static Direction getDirectionFromOrder(Order order) {
		switch (order) {
		case DOWN:
			return Direction.DOWN;

		case DOWNLEFT:
			return Direction.DOWNLEFT;

		case DOWNRIGHT:
			return Direction.DOWNRIGHT;

		case LEFT:
			return Direction.LEFT;

		case RIGHT:
			return Direction.RIGHT;

		case UP:
			return Direction.UP;

		case UPLEFT:
			return Direction.UPLEFT;

		case UPRIGHT:
			return Direction.UPRIGHT;

		default:
			if (order.equals(Order.FIRE)) {
				JOptionPane.showMessageDialog(null, "Critical error !\nAn error occured", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
			return null;
		}
	}

	/**
	 * This method allow us to get two opposite direction of an other direction.
	 * 
	 * @param direction
	 *            The direction to oppose
	 * 
	 * @return Direction The opposite direction.
	 */
	public static Direction getOppositeDirection(Direction direction) {
		switch (direction) {
		case DOWN:
			return UP;

		case DOWNLEFT:
			return UPRIGHT;

		case DOWNRIGHT:
			return UPLEFT;

		case LEFT:
			return RIGHT;

		case RIGHT:
			return LEFT;

		case UP:
			return DOWN;

		case UPLEFT:
			return DOWNRIGHT;

		case UPRIGHT:
			return DOWNLEFT;

		default:
			JOptionPane.showMessageDialog(null, "Critical error !\nAn error occured", "Error",
					JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}
}
