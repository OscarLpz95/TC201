import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Menu extends JFrame{
		public static void main(String args [])
		{
		Menu w = new Menu();
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w.setSize(1920,1080);
		w.setVisible(true);

		}
	 public Menu()
		{   

		setLayout(null);
		PicPanel mainPanel = new PicPanel("fondo.jpg");
		mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER,800,300));
		//mainPanel.setLayout(null);
		mainPanel.setBounds(0,0,1920,1080);
		add(mainPanel);
		Font myFont = new Font("Serif", Font.BOLD, 30);
		JPanel buttonpanel = new JPanel();
		buttonpanel.setPreferredSize(new Dimension(400,200));
		JButton jb1 = new JButton();
		JButton jb2 = new JButton();

		jb2.setFont(myFont);
		jb2.setText("Tic Tac Toe");
		jb1.setText("Hangman");
		jb1.setFont(myFont);
		jb1.setPreferredSize(new Dimension(300,50));
		jb2.setPreferredSize(new Dimension(300,50));
		buttonpanel.add(jb1);
		buttonpanel.add(jb2);
		buttonpanel.setBackground(Color.black);
		mainPanel.add(buttonpanel);

	}

	class PicPanel extends JPanel{

		private BufferedImage image;
		private int w,h;
		public PicPanel(String fname){

		    //reads the image
		    try {
		        image = ImageIO.read(getClass().getResource(fname));
		        w = image.getWidth();
		        h = image.getHeight();

		    } catch (IOException ioe) {
		        System.out.println("Could not read in the pic");
		    }

		}

		public Dimension getPreferredSize() {
		    return new Dimension(w,h);
		}
		
		private void makeGUI(){
			JPanel buttonpanel = new JPanel();
			this.setLayout(null);
			buttonpanel.setLayout(null);
			JButton jb1 = new JButton();
			jb1.setText("Tic Tac Toe");
			buttonpanel.add(jb1);
			buttonpanel.setLocation(800,500);
		}
		//this will draw the image
		public void paintComponent(Graphics g){
			Font myFont = new Font("Serif", Font.BOLD, 70);
		    super.paintComponent(g);
		    g.drawImage(image,0,0,this);
		    g.setColor(Color.WHITE);
		    g.setFont(myFont);
		    g.drawString("ARCADE",800,100);
		}
		}

}
