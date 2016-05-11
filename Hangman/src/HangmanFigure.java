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
	
	URL s0p = MainWindow.class.getResource("p1.png");
	URL s1p = MainWindow.class.getResource("p2.png");
	URL s2p = MainWindow.class.getResource("p3.png");
	URL s3p = MainWindow.class.getResource("p4.png");
	URL s4p = MainWindow.class.getResource("p5.png");
	URL s5p = MainWindow.class.getResource("p6.png");
	URL s6p = MainWindow.class.getResource("p7.png");
	URL s8p = MainWindow.class.getResource("p9.png");
	URL s9p = MainWindow.class.getResource("p10.png");
	URL s10p = MainWindow.class.getResource("p8.png");

	URL uLoseP = MainWindow.class.getResource("YouLoseP.png");
	URL uLoseS = MainWindow.class.getResource("p11.png");

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
	
	ImageIcon guess0S = new ImageIcon(s0p);
	ImageIcon guess1S  = new ImageIcon(s1p);
	ImageIcon guess2S = new ImageIcon(s2p);
	ImageIcon guess3S  = new ImageIcon(s3p);
	ImageIcon guess4S = new ImageIcon(s4p);
	ImageIcon guess5S  = new ImageIcon(s5p);
	ImageIcon guess6S = new ImageIcon(s6p);
	ImageIcon guess8S  = new ImageIcon(s8p);
	ImageIcon guess9S = new ImageIcon(s9p);
	ImageIcon guess10S = new ImageIcon(s10p);
	ImageIcon loseS = new ImageIcon(uLoseS);

	
	
	URL imageSrc = MainWindow.class.getResource("PirateBackground.png");
	URL imageSrc2 = MainWindow.class.getResource("p0.png");
	
	ImageIcon bg = new ImageIcon(imageSrc);
	ImageIcon bg2 = new ImageIcon(imageSrc2);
	
	String theme;

	public HangmanFigure(String theme) {
		guesses = 0;
		this.theme = theme;
		setPreferredSize(new Dimension(800, 600));
		if(theme == "PirateWords.txt"){
			this.setIcon(bg);
		}
		if(theme == "SpaceWords.txt"){
			this.setIcon(bg2);
		}
		validate();
	}

	public void paintComponent() {
	
		if(guesses > 0) {
			if(theme == "PirateWords.txt"){
				this.setIcon(guess6P);
			}
			if(theme == "SpaceWords.txt"){
				this.setIcon(guess0S);
			}
			validate();
		}
		
		if(guesses > 1) {
			if(theme == "PirateWords.txt"){
				this.setIcon(guess5P);
			}
			if(theme == "SpaceWords.txt"){
				this.setIcon(guess1S);
			}
			validate();
		}

		if(guesses > 2) {
			if(theme == "PirateWords.txt"){
				this.setIcon(guess4P);
			}
			if(theme == "SpaceWords.txt"){
				this.setIcon(guess2S);
			}
			validate();
		}
		
		if(guesses > 3) {
			if(theme == "PirateWords.txt"){
				this.setIcon(guess3P);
			}
			if(theme == "SpaceWords.txt"){
				this.setIcon(guess3S);
			}
			validate();
		}

		if(guesses > 4) {
			if(theme == "PirateWords.txt"){
				this.setIcon(guess2P);
			}
			if(theme == "SpaceWords.txt"){
				this.setIcon(guess4S);
			}
			validate();
		}
		
		if(guesses > 5) {
			if(theme == "PirateWords.txt"){
				this.setIcon(guess1P);
			}
			if(theme == "SpaceWords.txt"){
				this.setIcon(guess5S);
			}
			validate();
		}
		
		if(guesses > 6) {
			if(theme == "PirateWords.txt"){
				this.setIcon(guess0P);
			}
			if(theme == "SpaceWords.txt"){
				this.setIcon(guess6S);
			}
			validate();
		}
		
		if(guesses > 7) {
			if(theme == "PirateWords.txt"){
				this.setIcon(guess8P);
			}
			if(theme == "SpaceWords.txt"){
				this.setIcon(guess10S);
			}
			validate();
		}
		
		if(guesses > 8) {
			if(theme == "PirateWords.txt"){
				this.setIcon(guess9P);
			}
			if(theme == "SpaceWords.txt"){
				this.setIcon(guess8S);
			}
			validate();
		}
		
		if(guesses > 9) {
			if(theme == "PirateWords.txt"){
				this.setIcon(guess6P);
			}
			if(theme == "SpaceWords.txt"){
				this.setIcon(guess9S);
			}
			validate();
		}
		if(guesses > 10) {
			if(theme == "PirateWords.txt"){
				this.setIcon(loseP);
			}
			if(theme == "SpaceWords.txt"){
				this.setIcon(loseS);
			}
			validate();
		}
	}

	public void set() {
		guesses++;
		paintComponent();
	}

}