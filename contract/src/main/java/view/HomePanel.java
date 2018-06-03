package view;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class HomePanel extends JPanel {

private static final long serialVersionUID = 1L;
	
	private ActionButton button_choice_1_home;
	private ActionButton button_choice_2_home;
	
	Image img_home;
	
	
	public HomePanel () {
		this.setLayout(null);
		this.button_choice_1_home = new ActionButton ("Start", 17, 240);
		this.button_choice_2_home = new ActionButton ("Choose Level", 350, 240);
		
		try {
			this.img_home = ImageIO.read(getClass().getResourceAsStream("ImagesRayanEngine/LorannHome.PNG"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
		
		
	}
	
	
	
	public void paintComponent(Graphics g){ 
		
		g.drawImage(this.img_home, 0, 0, this.getWidth(), this.getHeight(), this);
		

		this.add(button_choice_1_home);
		this.add(button_choice_2_home);
	    
	}



	public ActionButton getButton_choice_1_home() {
		return button_choice_1_home;
	}



	public void setButton_choice_1_home(ActionButton button_choice_1_home) {
		this.button_choice_1_home = button_choice_1_home;
	}



	public ActionButton getButton_choice_2_home() {
		return button_choice_2_home;
	}



	public void setButton_choice_2_home(ActionButton button_choice_2_home) {
		this.button_choice_2_home = button_choice_2_home;
	}

}
	
