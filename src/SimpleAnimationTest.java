import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SimpleAnimationTest {
	
	private int distanceHorizonal= 100;
	private int distanceVertical= 200;
	
	public static void main(String[] args) {
		new SimpleAnimationTest().go();
	}
	
	public void go() {	
		JFrame f = new JFrame( );
		BallPanel panel = new BallPanel( );

		f.add(panel);
		
		f.setSize(300, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		while( distanceHorizonal > 0){
			distanceHorizonal--;
			distanceVertical -= 2;
			
			panel.repaint();
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	class BallPanel extends JPanel {
		public void paintComponent(Graphics g) {
			Graphics2D g2= (Graphics2D) g;
			g2.fillRect(0, 0, this.getWidth(), this.getHeight());
			g2.setColor(Color.red);
			g2.fillOval((distanceHorizonal), (distanceVertical), 10, 10);
		}
	}
}