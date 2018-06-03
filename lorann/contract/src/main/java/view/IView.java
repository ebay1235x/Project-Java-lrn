package view;

import showboard.BoardFrame;

/**
 * <h1>The Interface IView.</h1>
 *
 * @author Rayan
 * @version 1.0
 */
public interface IView 
{
	public void run();
	public void updateMap();
	public int addMagicBall();
	public void removeMagicBall();
	public void updateMapElements(String Elements,int x,int y);
	public void OpenGate(int x, int y);
	public void getRayan(int x,int y);
	public void getPurse(int x, int y);
	public void reachingOpenGate(int x,int y);
	public void reachingThreat(int x, int y);
	public void monsterReachingLorann();
	public BoardFrame getBoardFrame();
	public void setBoardFrame(BoardFrame boardFrame);
	public int getStop();
	public void setStop(int stop);
	public void runBoardHome ();
	public HomeFrame getHome();
	public void setHome(HomeFrame home);
}
