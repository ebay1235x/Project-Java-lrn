package view;

import java.awt.*;
import java.io.IOException;
import java.util.Observable;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import showboard.BoardFrame;
import model.*;



/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Rayan
 * @version 1.0
 */
public class ViewFacade extends Observable implements IView, Runnable
{
	
	private static final int sizeFrameWidth = 1280;
	
	private static final int sizeFrameHeight = 768;
	
	private static final Rectangle lorannGame = new Rectangle(0 ,0 ,map.getWidth(),map.getHeight());
	
	private IModel model;
	
	private BoardFrame boardFrame;
	private HomeFrame Home;
	
	private int stop = 0;
    
	/**
     * Instantiates a new view facade.
     */
    public ViewFacade(IModel model) throws IOException
    {
        super();
        this.model = model;
        this.model.getMap().getBone().loadImage();
        this.model.getMap().getRayan().loadImage();
        this.model.getMap().getH_Bone().loadImage();
        this.model.getMap().getV_Bone().loadImage();
        this.model.getMap().getNothing().loadImage();
        this.model.getMap().getCloseGate().loadImage();
        this.model.getMap().getLorann().loadImage();
        this.model.getMap().getMagicBall().loadImage();
        this.model.getMap().getMonster1().loadImage();
        this.model.getMap().getMonster2().loadImage();
        this.model.getMap().getMonster3().loadImage();
        this.model.getMap().getMonster4().loadImage();
        this.model.getMap().getPurse().loadImage();
        this.model.getMap().getCrystallBall().loadImage();
        this.model.getMap().getOpenGate().loadImage();
    }
    public void run() 
    {   
    	Sounds.START.play();
        this.boardFrame = new BoardFrame("LORANN GAME");
        boardFrame.setDimension(new Dimension(map.getWidth(), map.getHeight()));
        boardFrame.setDisplayFrame(lorannGame);
        boardFrame.setSize(sizeFrameWidth, sizeFrameHeight);
        boardFrame.setLocationRelativeTo(null);
        //Frame Configure
        this.frameConfigure(boardFrame);
    }
    
    
    public void runBoardHome () 
    {
    	this.setHome(new HomeFrame());
   }
       
  
    public final void frameConfigure(final BoardFrame frame) 
    {
		
    	for (int y = 0; y < map.getHeight(); y++) {
            for (int x = 0; x < map.getWidth(); x++)
            {
            	switch(model.getMap().mapRead[x][y])
            	{
            		case 'B':
            			frame.addSquare(model.getMap().getBone(), x, y);
            			break;
            		case 'H':
            			frame.addSquare(model.getMap().getH_Bone(), x, y);
            			break;
            		case 'V':
            			frame.addSquare(model.getMap().getV_Bone(), x, y);
            			break;
            		case 'N':
            			frame.addSquare(model.getMap().getNothing(), x, y);
        				break;
            		case 'G':
            			frame.addSquare(model.getMap().getCloseGate(), x, y);
        				break;
            		case 'P':
            			frame.addSquare(model.getMap().getPurse(), x, y);
    					break;
            		case 'C':
            			frame.addSquare(model.getMap().getCrystallBall(), x, y);
            			break;
            		case 'R':
            			frame.addSquare(model.getMap().getRayan(), x, y);
            			break;
            	}
            }
            frame.addPawn(this.model.getMap().getLorann());
            frame.addPawn(this.model.getMap().getMonster1());
            frame.addPawn(this.model.getMap().getMonster2());
            frame.addPawn(this.model.getMap().getMonster3());
            frame.addPawn(this.model.getMap().getMonster4());
        }
    	
    	this.addObserver(frame.getObserver());
        frame.setVisible(true);
    }
        
	public void updateMap()
	{
		this.setChanged();
        this.notifyObservers();
	}
	
	public int addMagicBall()
	{
		int xMagicBall = this.model.getMap().getLorann().getX();//BHVCGPO
		int yMagicBall = this.model.getMap().getLorann().getY();
		int addMagicBallState = 0;
		switch(this.model.getMap().getLorann().getDirection())
		{
			case 0:
				    if(this.model.getMap().mapRead[xMagicBall+1][yMagicBall] != 'B' 
					&& this.model.getMap().mapRead[xMagicBall+1][yMagicBall] != 'H' 
					&& this.model.getMap().mapRead[xMagicBall+1][yMagicBall] != 'V' 
					&& this.model.getMap().mapRead[xMagicBall+1][yMagicBall] != 'C' 
					&& this.model.getMap().mapRead[xMagicBall+1][yMagicBall] != 'G' 
					&& this.model.getMap().mapRead[xMagicBall+1][yMagicBall] != 'P' 
					&& this.model.getMap().mapRead[xMagicBall+1][yMagicBall] != 'O')
					{
						this.model.getMap().getMagicBall().setPosition(xMagicBall + 1, yMagicBall);
						this.model.getMap().getMagicBall().setDirection(0);
						getBoardFrame().addPawn(this.model.getMap().getMagicBall());
						addMagicBallState = 1;
					}
					break;
			case 1:
				 	if(this.model.getMap().mapRead[xMagicBall-1][yMagicBall] != 'B' 
					&& this.model.getMap().mapRead[xMagicBall-1][yMagicBall] != 'H' 
					&& this.model.getMap().mapRead[xMagicBall-1][yMagicBall] != 'V' 
					&& this.model.getMap().mapRead[xMagicBall-1][yMagicBall] != 'C' 
					&& this.model.getMap().mapRead[xMagicBall-1][yMagicBall] != 'G' 
					&& this.model.getMap().mapRead[xMagicBall-1][yMagicBall] != 'P' 
					&& this.model.getMap().mapRead[xMagicBall-1][yMagicBall] != 'O')
					{
				 		this.model.getMap().getMagicBall().setPosition(xMagicBall - 1, yMagicBall);
				 		this.model.getMap().getMagicBall().setDirection(1);
				 		getBoardFrame().addPawn(this.model.getMap().getMagicBall());
				 		addMagicBallState = 1;
					}
					break;
			case 2:
					if(this.model.getMap().mapRead[xMagicBall][yMagicBall-1] != 'B' 
					&& this.model.getMap().mapRead[xMagicBall][yMagicBall-1] != 'H' 
					&& this.model.getMap().mapRead[xMagicBall][yMagicBall-1] != 'V' 
					&& this.model.getMap().mapRead[xMagicBall][yMagicBall-1] != 'C' 
					&& this.model.getMap().mapRead[xMagicBall][yMagicBall-1] != 'G' 
					&& this.model.getMap().mapRead[xMagicBall][yMagicBall-1] != 'P' 
					&& this.model.getMap().mapRead[xMagicBall][yMagicBall-1] != 'O')
					{
						this.model.getMap().getMagicBall().setPosition(xMagicBall, yMagicBall - 1);
						this.model.getMap().getMagicBall().setDirection(2);
						getBoardFrame().addPawn(this.model.getMap().getMagicBall());
						addMagicBallState = 1;
					}
					break;
			case 3:
					if(this.model.getMap().mapRead[xMagicBall][yMagicBall+1] != 'B' 
					&& this.model.getMap().mapRead[xMagicBall][yMagicBall+1] != 'H' 
					&& this.model.getMap().mapRead[xMagicBall][yMagicBall+1] != 'V' 
					&& this.model.getMap().mapRead[xMagicBall][yMagicBall+1] != 'C' 
					&& this.model.getMap().mapRead[xMagicBall][yMagicBall+1] != 'G' 
					&& this.model.getMap().mapRead[xMagicBall][yMagicBall+1] != 'P' 
					&& this.model.getMap().mapRead[xMagicBall][yMagicBall+1] != 'O')
					{
						this.model.getMap().getMagicBall().setPosition(xMagicBall, yMagicBall + 1);
						this.model.getMap().getMagicBall().setDirection(3);
						getBoardFrame().addPawn(this.model.getMap().getMagicBall());
						addMagicBallState = 1;
					}
					break;
		}
		return addMagicBallState;	
	}
	
	
	
	public void removeMagicBall()
	{
	}
	
	public void OpenGate(int x, int y)
	{
		int numberOfCrystallBall = this.model.getMap().getNumberOfCrystallBall();
		if (this.model.getMap().mapRead[x][y] == 'C')
		{
			getBoardFrame().addSquare(model.getMap().getNothing(), x, y);
			this.model.getMap().updateElementsOnMap(x,y);
			numberOfCrystallBall = numberOfCrystallBall - 1;
			this.model.getMap().setNumberOfCrystallBall(numberOfCrystallBall);
			if (numberOfCrystallBall == 0)
			{
				this.updateMapElements("gateopen", x, y);
			}
		}
	}
	
	public void getPurse(int x, int y)
	{
		if (this.model.getMap().mapRead[x][y] == 'P')
		{
			this.updateMapElements("purse", x, y);
			this.model.getMap().updateElementsOnMap(x,y);
			int scoreLorann = this.model.getMap().getScoreLorann();
			scoreLorann = scoreLorann + 650;
			this.model.getMap().setScoreLorann(scoreLorann);
		}
	}
	
	public void reachingOpenGate(int x,int y)
	{
		ImageIcon winIcon = new ImageIcon("Ressources/images/reward.png");
		if (this.model.getMap().mapRead[x][y] == 'O')
		{   
			Sounds.WON.play();
			getBoardFrame().dispose();
			JOptionPane.showMessageDialog(null, "You Win !!!\nYour score : " + this.model.getMap().getScoreLorann(),"Congratulation !!!", JOptionPane.INFORMATION_MESSAGE, winIcon);
			if (this.model.getMap_choice() <= 4)
            {
                this.model.setMap_choice(this.model.getMap_choice() + 1);
                this.model.connection();
                this.model.getMap().readmapBDD();
                this.model.getMap().calculatedNumberOfCrystallBall();
                this.frameConfigure(boardFrame);
               
            }
            else
                this.setStop(1);
		}
	}
	
	public void reachingThreat(int x, int y)
	{
		ImageIcon loseIcon = new ImageIcon("Ressources/images/game_over.png");
		
		if 	   (this.model.getMap().mapRead[x][y] == 'G' 
			|| ((this.model.getMap().getLorann().getX() == this.model.getMap().getMonster1().getX()) && (this.model.getMap().getLorann().getY() == this.model.getMap().getMonster1().getY()))
			|| ((this.model.getMap().getLorann().getX() == this.model.getMap().getMonster2().getX()) && (this.model.getMap().getLorann().getY() == this.model.getMap().getMonster2().getY()))
			|| ((this.model.getMap().getLorann().getX() == this.model.getMap().getMonster3().getX()) && (this.model.getMap().getLorann().getY() == this.model.getMap().getMonster3().getY()))
			|| ((this.model.getMap().getLorann().getX() == this.model.getMap().getMonster4().getX()) && (this.model.getMap().getLorann().getY() == this.model.getMap().getMonster4().getY())))
		{  
			getBoardFrame().dispose();
			Sounds.LOST.play();
			JOptionPane.showMessageDialog(null, "Unfortunately... You Lost..\nYour score : "+ this.model.getMap().getScoreLorann(), "Failer", JOptionPane.INFORMATION_MESSAGE, loseIcon);
			this.setStop(1);
		}
	}
	
	public void monsterReachingLorann()
	{   
		
		ImageIcon loseIcon = new ImageIcon("Ressources/images/game_over.png");
		if    (((this.model.getMap().getLorann().getX() == this.model.getMap().getMonster1().getX()) && (this.model.getMap().getLorann().getY() == this.model.getMap().getMonster1().getY()))
			|| ((this.model.getMap().getLorann().getX() == this.model.getMap().getMonster2().getX()) && (this.model.getMap().getLorann().getY() == this.model.getMap().getMonster2().getY()))
			|| ((this.model.getMap().getLorann().getX() == this.model.getMap().getMonster3().getX()) && (this.model.getMap().getLorann().getY() == this.model.getMap().getMonster3().getY()))
			|| ((this.model.getMap().getLorann().getX() == this.model.getMap().getMonster4().getX()) && (this.model.getMap().getLorann().getY() == this.model.getMap().getMonster4().getY())))
		{
			getBoardFrame().dispose();
			JOptionPane.showMessageDialog(null, "Unfortunately... You Lose..\nYour score : "+ this.model.getMap().getScoreLorann(), "Too Bad...", JOptionPane.INFORMATION_MESSAGE, loseIcon);
			this.setStop(1);
		}
	}
	
	public void updateMapElements(String Elements,int x,int y)
	{
		switch(Elements)
		{
			case "gateopen":
				for (int yMap = 0; yMap < map.getHeight(); yMap++) 
				{
		            for (int xMap = 0; xMap < map.getWidth(); xMap++)
		            {
		            	if(model.getMap().mapRead[xMap][yMap] == 'G')
		            	{
		            		x = xMap;
		            		y = yMap;
		            		this.model.getMap().updateGateOnMap(xMap, yMap);
		            		getBoardFrame().addSquare(model.getMap().getOpenGate(), x, y);
		            	}
		            }
				}
				break;
			case "purse":
				getBoardFrame().addSquare(model.getMap().getNothing(), x, y);
				break;
		}
	}
	
	
    public BoardFrame getBoardFrame() {
		return boardFrame;
	}
	public void setBoardFrame(BoardFrame boardFrame) {
		this.boardFrame = boardFrame;
	}
	
	public int getStop() {
		return stop;
	}
	public void setStop(int stop) {
		this.stop = stop;
	}
	public HomeFrame getHome() {
		return Home;
	}
	public void setHome(HomeFrame home) {
		Home = home;
	}
	@Override
	public void getRayan(int x, int y) {
		// TODO Auto-generated method stub
		
	}
	
}
