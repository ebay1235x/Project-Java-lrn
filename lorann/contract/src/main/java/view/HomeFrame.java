package view;

import javax.swing.JFrame;

public class HomeFrame extends JFrame  {

	private static final long serialVersionUID = 1L;

	private HomePanel PanEdit;
	
	public HomeFrame () {
		
		this.setTitle("Menu");
	    this.setSize(584, 438);
	    this.setLocationRelativeTo(null);
	    this.setResizable(false);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
	    this.PanEdit = new HomePanel ();
	    this.setContentPane(this.PanEdit);
	    this.setVisible(true);
		
		
		
	}

	public HomePanel getPanEdit() {
		return PanEdit;
	}

	public void setPanEdit(HomePanel panEdit) {
		PanEdit = panEdit;
	}
	
}
