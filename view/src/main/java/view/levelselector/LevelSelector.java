package view.levelselector;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
 * <h1>The LevelSelector class.</h1>
Rayan Rayan
 *
 */
public class LevelSelector {

	private final static String[] LEVEL_LIST = { "Map 1", "Map 2", "Map 3", "Map 4", "Map 5" };

	/**
	 * Constructor of level Selector.
	 */
	public LevelSelector() {
		super();
	}
	
/**
 * Operation call to get a Level.
 * @return int
 * The map selected.
 */
	public static int getLevel() {
		
		String nom = (String) JOptionPane.showInputDialog(null, "Choose a Map!", "Lorann-MapSelector",
				JOptionPane.QUESTION_MESSAGE, null, LEVEL_LIST, LEVEL_LIST[0]);

		if (nom == null) {
			System.exit(0);
		}
			/**
	 * Display the popup to select level and return the level number
	 * we program our popup with all the options of choice
	 * Here is our switch with its choices
	 * Default, its an error
	 */
		switch (nom) {
		case "Map 1":
			return 1;

		case "Map 2":
			return 2;

		case "Map 3":
			return 3;

		case "Map 4":
			return 4;

		case "Map 5":
			return 5;
			
		default:
	
			final JPanel panel = new JPanel();
			JOptionPane.showMessageDialog(panel, "Invalid choice !", "Error", JOptionPane.ERROR_MESSAGE);
			return 1;
		}
	}

}
