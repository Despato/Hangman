import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MainWindow extends JFrame {
	
	private int remainingGuesses;
	private String wrongGuesses;
	private String word;
	private String visible;
	String toGuess;


	public MainWindow(String toGuess) throws IOException {
		
		remainingGuesses = 10;
		this.toGuess = toGuess;
		wrongGuesses = "";
		word = chooseWord(toGuess);

		visible = "";

		for(int i = 0; i < word.length(); ++i) {
			visible += "_ ";
		}

		JPanel corePanel = new JPanel();
		corePanel.setLayout(new BorderLayout());
		
	
		final JLabel status = new JLabel("You have "+remainingGuesses+" remaining", SwingConstants.CENTER);
		final JLabel wrong = new JLabel("Wrong guesses so far: "+wrongGuesses);
		final JLabel visibleLabel = new JLabel(visible, SwingConstants.CENTER);
		final JTextField input = new JTextField(); 
		
		JPanel southPanel = new JPanel(new GridLayout(4, 1));
		southPanel.add(status);
		southPanel.add(visibleLabel);
		southPanel.add(input, BorderLayout.CENTER);
		southPanel.setBackground(Color.ORANGE);
		southPanel.add(wrong);
		
		corePanel.add(southPanel, BorderLayout.SOUTH);
		
		final HangmanFigure hf = new HangmanFigure(toGuess);
		
		corePanel.add(hf, BorderLayout.CENTER);

		this.add(corePanel, BorderLayout.CENTER);
		
		input.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String text = input.getText();
				
				if(text.length()  == 1 && text.matches("[a-z]")) {
					
					boolean guessFound = false;
					
					for(int i = 0; i < word.length(); ++i) {
						if(text.charAt(0) == word.charAt(i)) {
							guessFound = true;
							
							String newVisible = "";
							for(int j = 0; j < visible.length(); ++j) {
								if(j == (i*2)) {
									newVisible += word.charAt(i);
								}
								else {
									newVisible += visible.charAt(j);
								}
							}
							visible = newVisible;
							visibleLabel.setText(visible);
						}
					}
					
					if(!guessFound) {
						if(--remainingGuesses >= 0) {
							status.setText("You have "+remainingGuesses+" guesses remaining");
							wrongGuesses += text+" ";
							wrong.setText("Wrong guesses so far: "+wrongGuesses);
							hf.set();
						}
						else {
							status.setText("You lost: the word was "+word);
							hf.set();
							input.setEnabled(false);
							try {
								showRestart();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
					else {
						String actualVisible = "";
						for(int i = 0; i < visible.length(); i+=2) {
							actualVisible += visible.charAt(i);
						}
						
						if(actualVisible.equals(word)) {
							status.setText("Congratulations, you have won!");
							input.setEnabled(false);
							try {
								showRestart();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
					
				}
				else {
					System.out.println("Invalid input!");
				}
				
				input.setText("");
			}
			
		});
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setTitle("Hangman");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	
	public void showRestart() throws IOException{                                            
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult = JOptionPane.showConfirmDialog(this, "Restart", "Would you like to restart?", dialogButton);
		if(dialogResult == 0) {
		   new MainWindow(toGuess);
		   setVisible(false);
		   dispose();
		} else {
		   System.exit(0);
		} 
	}
	
	public static String chooseWord(String file) throws IOException{
		   
		   InputStream is = MainWindow.class.getResourceAsStream(file);
		   
		   InputStreamReader fr = new InputStreamReader(is);
	       BufferedReader readFile = new BufferedReader(fr);
	      
	       String line = null;
	       Random rand = new Random();
	       final int MAXWORD = 200;
	       int randNum =  rand.nextInt((MAXWORD) + 1);
	       String word = "";
	       
	       int i = 0;
	       while ((line = readFile.readLine()) != null && i <= randNum){
	    	   word = line;
	    	   i++;
	       }
	       return word;
	}   
}