package view;

import controller.IController;

public class thread_lorann extends Thread {

	
	IController controller;
	
	
	private final int loop = 100;
	
	
	public thread_lorann (String name, IController controller_p){
		super(name);
		this.controller = controller_p;
	}
	
	
	public void run(){
		  
		while (controller.getView().getStop() == 0) 
		{
		
				 controller.getModel().getMap().getLorann().animationLorann();
				 controller.getView().updateMap();
				 
				 try {
					Thread.sleep(loop);
				} catch (InterruptedException e) {
					e.printStackTrace();
			}			
		}
	  } 
	
}
