import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.JPanel;

public class HangmanFigure extends JPanel {
	
	private int guesses;
	
	URL plank = MainWindow.class.getResource("Plank.png");
	URL head = MainWindow.class.getResource("PHead.png");
	URL torso = MainWindow.class.getResource("PTorso.png");
	URL leftFoot = MainWindow.class.getResource("PLeftFoot.png");
	URL rightFoot = MainWindow.class.getResource("PRightFoot.png");
	URL leftHand = MainWindow.class.getResource("PLeftHand.png");
	URL rightHand = MainWindow.class.getResource("PRightHand.png");

	Image img;

	public HangmanFigure() {
		super();
		guesses = 0;
		setPreferredSize(new Dimension(800, 600));
		setVisible(true);
	}
	
	public void paintComponent(Graphics g) {
	
		
		//plank
		if(guesses > 0) {
			img = Toolkit.getDefaultToolkit().createImage(plank);
			g.drawImage(img, 0, 0, null);
		}
		
		// right wall
		if(guesses > 1) {
			g.drawLine(299, 299, 299, 1);
		}
		
		// top line
		if(guesses > 2) {
			g.drawLine(150, 1, 299, 1);
		}
		
		// hanging line
		if(guesses > 3) {
			g.drawLine(150, 1, 150, 70);
		}
		
		// face
		if(guesses > 4) {
			g.drawOval(150-25, 70, 50, 50);
		}
		
		// body
		if(guesses > 5) {
			g.drawLine(150, 120, 150, 200);
		}
		
		// left hand
		if(guesses > 6) {
			g.drawLine(150, 150, 110, 140);
		}
		
		// right hand
		if(guesses > 7) {
			g.drawLine(150, 150, 190, 140);
		}
		
		// left leg
		if(guesses > 8) {
			g.drawLine(150, 200, 120, 250);
		}
		
		// right leg
		if(guesses > 9) {
			g.drawLine(150, 200, 180, 250);
		}
	}
	
	public void set() {
		guesses++;
		paintComponent(getGraphics());
	}
	
}