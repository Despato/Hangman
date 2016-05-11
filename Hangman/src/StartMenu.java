import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class StartMenu extends JFrame
{
	final static JButton pirate = new JButton("Pirate");
	final static JButton space = new JButton("Space");
	final static JButton exit = new JButton("Exit");
	static JPanel corePanel = new JPanel();
	
	public StartMenu()
	{
		
		URL imageSrc = MainWindow.class.getResource("HangManTitle.png");
		ImageIcon logo = new ImageIcon(imageSrc);
		
		corePanel.setLayout(new BorderLayout());
		
		final JLabel title = new JLabel();
		
		title.setIcon(logo);
		
		JPanel southPanel = new JPanel(new GridLayout(4, 3, 110, 110));
		southPanel.setBackground(Color.ORANGE);
		
		southPanel.add(pirate);
		southPanel.add(space);
		southPanel.add(exit);

		corePanel.add(southPanel, BorderLayout.PAGE_END);
		corePanel.add(title, BorderLayout.CENTER);
		
		this.add(corePanel, BorderLayout.CENTER);
		
		this.pack();
		this.setTitle("Hangman Main Menu");
		this.setLocationRelativeTo(null);
		this.setSize(400, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String args[]) throws IOException
	{
		new StartMenu();	
		checkButtons();
	}
	
	public static void checkButtons(){
		pirate.addActionListener(new ActionListener() {
		       public void actionPerformed(ActionEvent e) {
		             if(e.getSource() == pirate) {
		            	 try {
							new MainWindow("PirateWords.txt");
							
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		              }
		       }
		 });	
		space.addActionListener(new ActionListener() {
		       public void actionPerformed(ActionEvent e) {
		             if(e.getSource() == space) {
		            	 try {
							new MainWindow("SpaceWords.txt");
							
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		              }
		       }
		 });	
		exit.addActionListener(new ActionListener() {
		       public void actionPerformed(ActionEvent e) {
		             if(e.getSource() == exit) {
		            	 System.exit(0);
		              }
		       }
		 });	
	}
}