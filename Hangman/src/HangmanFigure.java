import java.awt.Dimension;
import java.awt.Graphics;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class HangmanFigure extends JLabel {
	
	private int guesses;
	
	
	URL g0p = MainWindow.class.getResource("Guess0P.png");
	URL g1p = MainWindow.class.getResource("Guess1P.png");
	URL g2p = MainWindow.class.getResource("Guess2P.png");
	URL g3p = MainWindow.class.getResource("Guess3P.png");
	URL g4p = MainWindow.class.getResource("Guess4P.png");
	URL g5p = MainWindow.class.getResource("Guess5P.png");
	URL g6p = MainWindow.class.getResource("Guess6P.png");
	URL g8p = MainWindow.class.getResource("Guess8P.png");
	URL g9p = MainWindow.class.getResource("Guess9P.png");

	URL uLoseP = MainWindow.class.getResource("YouLoseP.png");
	
	
	

	ImageIcon guess0P = new ImageIcon(g0p);
	ImageIcon guess1P  = new ImageIcon(g1p);
	ImageIcon guess2P = new ImageIcon(g2p);
	ImageIcon guess3P  = new ImageIcon(g3p);
	ImageIcon guess4P = new ImageIcon(g4p);
	ImageIcon guess5P  = new ImageIcon(g5p);
	ImageIcon guess6P = new ImageIcon(g6p);
	ImageIcon guess8P  = new ImageIcon(g8p);
	ImageIcon guess9P = new ImageIcon(g9p);
	ImageIcon loseP = new ImageIcon(uLoseP);

	
	
	URL imageSrc = MainWindow.class.getResource("PirateBackground.png");
	ImageIcon bg = new ImageIcon(imageSrc);

	public HangmanFigure() {
		guesses = 0;
		setPreferredSize(new Dimension(800, 600));
		this.setIcon(bg);
		validate();
	}

	public void paintComponent() {
	
		if(guesses > 0) {
			this.setIcon(guess6P);
			validate();
		}
		
		if(guesses > 1) {
			this.setIcon(guess5P);
			validate();
		}

		if(guesses > 2) {
			this.setIcon(guess4P);
			validate();
		}
		
		if(guesses > 3) {
			this.setIcon(guess3P);
			validate();
		}

		if(guesses > 4) {
			this.setIcon(guess2P);
			validate();
		}
		
		if(guesses > 5) {
			this.setIcon(guess1P);
			validate();
		}
		
		if(guesses > 6) {
			this.setIcon(guess0P);
			validate();
		}
		
		if(guesses > 7) {
			this.setIcon(guess8P);
			validate();
		}
		
		if(guesses > 8) {
			this.setIcon(guess9P);
			validate();
		}
		
		if(guesses > 9) {
			this.setIcon(guess6P);
			validate();
		}
		if(guesses > 10) {
			this.setIcon(loseP);
			validate();
		}
	}

	public void set() {
		guesses++;
		paintComponent();
	}

}