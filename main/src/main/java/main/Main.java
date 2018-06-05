package main;

import controller.Controller;
import model.Model;

/**
 * <h1>The Class Main.</h1>
 *
Rayan Rayan
 * 
 */
public abstract class Main {

	/**
	 * The main method.
	 *
	 * @param args
	 *            The arguments.
	 */
	public static void main(final String[] args) {
		//Instantiate new model
		final Model model = new Model();
		//Instantiate new controller
		final Controller controller = new Controller(model);
		//Run the game
		controller.play();
	}

}
