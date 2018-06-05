package controller;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JOptionPane;

import model.Model;
import model.component.IComponent;
import model.component.ILorann;

/**
 * <h1>The class GameController</h1>
Rayan
Rayan
 *
 */
public class GameController implements Runnable {
	private ILorann player;
	private IController controller;
	private List<DemonMover> movers;

	/**
	 * Operation call to control the game.
	 * @param player
	 * 	The player.
	 * @param controller
	 * 	The controller.
	 * @param movers
	 * The movers.
	 */
	public GameController(ILorann player, IController controller, CopyOnWriteArrayList<DemonMover> movers) {
		this.player = player;
		this.controller = controller;
		this.movers = movers;
	}

	@Override
	public void run() {
		int count = 0;

		do {
			IComponent[][] components = controller.getModel().getMap();

			if (count == 4) {
				if (controller.getModel().getLorann().isSpellLaunched()) {
					controller.moveComponent((IComponent) controller.getModel().getSpell(null, null),
							((IComponent) controller.getModel().getSpell(null, null)).getDirection());
				}

				for (DemonMover mover : movers) {
					if (!mover.getDemon().isAlive()) {
						controller.removeComponent(mover.getDemon());
						movers.remove(mover);
					} else {
						mover.move();
					}
				}
				count = 0;
			}

			controller.getGameFrame().getPanel().updateMap(components);

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			count++;

			if (controller.isVictory()) {
				break;
			}
		}while (player.isAlive());

		int choice;
		if (controller.isVictory()) {
			// Add popup for victory or defeat.
			int finalscore = 100 + controller.getScore();
			choice = JOptionPane.showConfirmDialog(null, "CONGRATULATION !\nYour score is " + finalscore + "\n\nDo you want to save the World of Nova-Ann again?", "GAME OVER",
					JOptionPane.YES_NO_OPTION);
			
		} else {
			choice = JOptionPane.showConfirmDialog(null, "GAME OVER\nYour score is " + controller.getScore() + "\n\nDo you want to try again?", "GAME OVER",
					JOptionPane.YES_NO_OPTION);
		}
		if(choice == JOptionPane.OK_OPTION) {
			Model restartModel = new Model();
			Controller restartController = new Controller(restartModel);
			controller.getGameFrame().dispose();
			restartController.play();
		}
		else{
		controller.getGameFrame().dispose();
		}
	}

}
