package controller;

import model.IModel;
import view.IView;

/**
 * <h1>The Interface IController.</h1>
 * 
 * @author Rayan
 * @version 1.0
 */
public interface IController 
{
	public IModel getModel();
	public IView getView();
	public int getAnimationMagicBallStatement();
}
