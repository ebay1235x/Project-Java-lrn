package view.gameview;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import controller.IController;
import model.Model;
import view.IGameFrame;

/**
 * <h1>The gameFrame class.</h1>
 * 
Rayan
Rayan
 *
 */
public class GameFrame extends JFrame implements IGameFrame {
	/**
	 *Default ID of the Frame. 
	 */
	private static final long serialVersionUID = -4728961914482503188L;
	private GamePanel panel;
	/**
	 * Constructor of game frame
	 * 
	 * @param model
	 *            The model.
	 * @param controller
	 *            The controller.
	 */
	public GameFrame(Model model, IController controller) {
		/*
		 * We create a Frame with parameters We put the Panel attentive to the events
		 * Prevent the creation of a shortcut bar at the top of the screen We put the
		 * title of the game on the Frame We put the Frame on the center of the screen
		 * We close the process's when we close the window We put the Frame on full
		 * screen We put the background in black We put the Panel on the center of the
		 * Frame We forbid resizing
		 */
		this.panel = new GamePanel(model, controller);
		this.panel.setFocusable(true);
		this.setUndecorated(true);
		this.setTitle("Lorann");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.getContentPane().add(panel, BorderLayout.CENTER);
		this.setResizable(false);
	}

	public GamePanel getPanel() {
		return panel;
	}

}
