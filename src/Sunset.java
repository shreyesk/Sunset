import javax.swing.*;
import java.awt.*;

public class Sunset extends JFrame {
	int width = 900;
	int height = 600;
	
	int sunX = width/2-30;
	int sunY = 0;
	
	int groundGreen = 200;
	
	int skyBlue = 255;
	int skyGreen = skyBlue / 2;
	int skyRed = skyGreen / 2;
	
	int sunGreen = 255;
	public Sunset() {
		
	}

	public static void main(String[] args) {
		new Sunset().go();
	}
	
	public void go() {
		JFrame f = new JFrame();
		f.setSize(width, height);
		 
		
		SunPanel s = new SunPanel();
		f.add(s);
		
		f.setVisible(true);
		
		while(sunX < width) { // while sun is still in sky
			s.repaint(); // animate frame once
			
			sunX+=2;
			sunY = (int) ((sunX - 450) * (sunX - 450) / 337.5) - 30;
			if(sunX > 600) {
				if(sunGreen > 150)
					sunGreen--;
			}
			
			if(groundGreen > 10)
				groundGreen--;
			
			skyBlue--;
			skyGreen = skyBlue / 2;
			skyRed = skyGreen / 2;
			
			try {
				Thread.sleep(35);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void paint(Graphics g) {
		//creates sky
		g.setColor(Color.CYAN);
		int skyX = 0;
		int skyY = 0;
		int skyWidth = width;
		int skyHeight = 3*height/5;
		g.drawRect(skyX, skyY, skyWidth, skyHeight);
		g.fillRect(skyX, skyY, skyWidth, skyHeight);
		
		// creates ground
		g.setColor(Color.GREEN);
		int groundX = 0;
		int groundY = 3*height/5;
		int groundWidth = width;
		int groundHeight = height - skyHeight;
		g.drawRect(groundX, groundY, groundWidth, groundHeight);
		g.fillRect(groundX, groundY, groundWidth, groundHeight);

	}
	
	class SunPanel extends JPanel {
		public void paint(Graphics g) {
			Graphics2D g2= (Graphics2D) g;

			//creates sky
			g.setColor(new Color(skyRed, skyGreen, skyBlue));
			int skyX = 0;
			int skyY = 0;
			int skyWidth = width;
			int skyHeight = 3*height/5;
			g.drawRect(skyX, skyY, skyWidth, skyHeight);
			g.fillRect(skyX, skyY, skyWidth, skyHeight);
			
			// creates sun
			g.setColor(new Color(255, sunGreen, 0)); //sun color
			int sunWidth = 60;
			int sunHeight = 60;
			g.drawOval(sunX, sunY, sunWidth, sunHeight); // sun border
			g.fillOval(sunX, sunY, sunWidth, sunHeight); //sun filling
			
			// creates ground
			g.setColor(new Color(0, groundGreen, 0));
			int groundX = 0;
			int groundY = 3*height/5;
			int groundWidth = width;
			int groundHeight = height - skyHeight;
			g.drawRect(groundX, groundY, groundWidth, groundHeight);
			g.fillRect(groundX, groundY, groundWidth, groundHeight);
		}
	}
}