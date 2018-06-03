package view;

import controller.IController;

public class thread_magicball extends Thread 
{

	
	IController controller;
	
	
	private final int loop = 100;
	
	
	public thread_magicball  (String name, IController controller_p){
		super(name);
		this.controller = controller_p;
	}
	
	
	public void run()
	{
			while (controller.getView().getStop() == 0) 
			{
					if (controller.getAnimationMagicBallStatement() == 1)
					{
						controller.getModel().getMap().getMagicBall().magicBallMouvement();
						controller.getModel().getMap().getMagicBall().animationBallMouvement();
						controller.getView().updateMap();
					}
					 
					 try 
					 {
						Thread.sleep(loop);
					 } 
					 catch (InterruptedException e) 
					 {
						e.printStackTrace();
					 }	
			}
		
	} 
	
}