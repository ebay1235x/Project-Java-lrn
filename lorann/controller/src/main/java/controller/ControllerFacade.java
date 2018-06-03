package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;

import model.IModel;
import view.thread_lorann;
import view.thread_magicball;
import view.thread_monster;
import view.IView;

/**
 * <h1>The Class ControllerFacade provides a facade of the Controller component.</h1>
 *
 * @author Rayan
 * @version 1.0
 */
public class ControllerFacade implements IController, KeyListener
{

    /** The view. */
    private final IView  view;
    /** The model. */
    private final IModel model;
    
    thread_lorann thread_lorann;
    
    thread_monster thread_monster;
    
    thread_magicball thread_magicball;
    
    private int animationMagicBallStatement = 0;
    
    /**
     * Instantiates a new controller facade.
     *
     * @param view
     *            the view
     * @param model
     *            the model
     */
    public ControllerFacade(final IView view, final IModel model) {
        super();
        this.view = view;
        this.model = model;
        this.thread_lorann = new thread_lorann ("animationLorann", this);
        this.thread_monster = new thread_monster ("movingMonster", this);
        this.thread_magicball = new thread_magicball ("movingMagicBall",this);
    }

    /**
     * Start.
     *
     * @throws SQLException
     *             the SQL exception
     * @throws InterruptedException 
     */
    public void start() throws SQLException, InterruptedException 
    {
    	
    	this.getView().runBoardHome();
    	
    	while ((this.getView().getHome().getPanEdit().getButton_choice_1_home().getChoice() == 0)) {
    		
    		
    		Thread.sleep (0);
    	}
    	
    	this.getView().getHome().dispose();
    	
        this.getView().run();
        this.thread_lorann.start();
        this.thread_monster.start();
        this.thread_magicball.start();
        this.getView().getBoardFrame().addKeyListener(this);
        this.getView().getBoardFrame().requestFocus();
    }
    
    

    /**
     * Gets the view.
     *
     * @return the view
     */

	@Override
	public void keyTyped(KeyEvent e) 
	{	
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		int keyCode = e.getKeyCode();
		switch(keyCode)
		{
			case KeyEvent.VK_NUMPAD1:
				this.getModel().getMap().getLorann().leftMouvementLorann();
				spotEvent();
				this.getView().updateMap();
				break;
			case KeyEvent.VK_NUMPAD2:
				this.getModel().getMap().getLorann().backwardMouvementLorann();
				spotEvent();
				this.getView().updateMap();
				break;
			case KeyEvent.VK_NUMPAD3:
				this.getModel().getMap().getLorann().rightMouvementLorann();
				spotEvent();
				this.getView().updateMap();
				break;
			case KeyEvent.VK_NUMPAD5:
				this.getModel().getMap().getLorann().forwardMouvementLorann();
				spotEvent();
				this.getView().updateMap();
				break;
			case KeyEvent.VK_NUMPAD6:
				this.getModel().getMap().getLorann().diagonalRightForwardMouvementLorann();
				spotEvent();
				this.getView().updateMap();
				break;
			case KeyEvent.VK_NUMPAD4:
				this.getModel().getMap().getLorann().diagonalLeftForwardMouvementLorann();
				spotEvent();
				this.getView().updateMap();
				break;
			case KeyEvent.VK_E:
				this.getModel().getMap().getLorann().diagonalRightBackwardMouvementLorann();
				spotEvent();
				this.getView().updateMap();
				break;
			case KeyEvent.VK_Z:
				this.getModel().getMap().getLorann().diagonalLeftBackwardMouvementLorann();
				spotEvent();
				this.getView().updateMap();
				break;
			case KeyEvent.VK_SPACE:
				int addMagicBall;
				addMagicBall = this.getView().addMagicBall();
				if (addMagicBall == 1)
					this.animationMagicBallStatement = 1;
				this.getView().updateMap();
				break;
			case KeyEvent.VK_Q:
				this.getView().removeMagicBall();
				this.animationMagicBallStatement = 0;
				this.getView().updateMap();
				break;
			case KeyEvent.VK_ESCAPE:
				System.exit(0);
				break;
			}
	}
	
	public void spotEvent()
	{
		int LorannX = this.getModel().getMap().getLorann().getX();
		int LorannY = this.getModel().getMap().getLorann().getY();
		this.getView().OpenGate(LorannX, LorannY);
		this.getView().getPurse(LorannX, LorannY);
		this.getView().reachingOpenGate(LorannX, LorannY);
		this.getView().reachingThreat(LorannX, LorannY);	
	}
	
	
	@Override
	public void keyReleased(KeyEvent e) 
	{
		
	}
	
    public IView getView() 
    {
        return this.view;
    }
    /**
     * Gets the model.
     *
     * @return the model
     */
    public IModel getModel() 
    {
        return this.model;
    }

	public int getAnimationMagicBallStatement() 
	{
		return animationMagicBallStatement;
	}

	public void setAnimationMagicBallStatement(int animationMagicBallStatement) 
	{
		this.animationMagicBallStatement = animationMagicBallStatement;
	}

}
