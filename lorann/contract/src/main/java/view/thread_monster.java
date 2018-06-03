package view;

import controller.IController;

public class thread_monster extends Thread
{
	IController controller;
	
	
	private final int loop = 700;
	
	
	public thread_monster (String name, IController controller_p)
	{
		super(name);
		this.controller = controller_p;
	}
	
	
	public void run()
	{
		  
		while (controller.getView().getStop() == 0) 
		{
			controller.getModel().getMap().getMonster1().monstersTrackingLorann();
			controller.getModel().getMap().getMonster2().RamdomMovingMonster();
			controller.getModel().getMap().getMonster3().RamdomMovingMonster();
			controller.getModel().getMap().getMonster4().monsterTrackingLorannSmarter();
			controller.getView().monsterReachingLorann();
			controller.getView().updateMap(); 
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
