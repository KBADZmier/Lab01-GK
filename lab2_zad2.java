package lab1_zad2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.AffineTransform;


public class lab2_zad2  extends JPanel 
{
	
	//------- For drawing ONLY while paintComponent is being executed! --------

		private Graphics2D g2; // A copy of the graphics context from paintComponent.

		private void resetTransform() {
			g2.setTransform(new AffineTransform());
		}

	
		private void square() {
			g2.fillRect(-100,-100,100,100);
		}
		
		private void triangle() 
		{

			 Polygon polygon2 = new Polygon();
		      polygon2.addPoint(-100,-100);
		       polygon2.addPoint(0,70);
		       polygon2.addPoint(100,-100);

		      g2.fillPolygon(polygon2);

		}

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g2 = (Graphics2D)g.create();
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			
		

			g2.translate(450,450);
			g2.scale(3,3);
			g2.setColor(Color.GREEN);

		
			square();
			
			resetTransform();
			
		g2.translate(300,350);
			g2.scale(1.5,1);
	g2.rotate(Math.toRadians(180));
			g2.setColor(Color.WHITE);
			triangle();
		
			
			
			
			
		} 


		
		public lab2_zad2() {
			setPreferredSize(new Dimension(600,600) );
			setBackground(Color.WHITE);
			setBorder(BorderFactory.createLineBorder(Color.BLACK,4));
		}

		public static void main(String[] args)  {
			JFrame window = new JFrame("Drawing With Transforms");
			window.setContentPane(new lab2_zad2());
			window.pack();
			window.setResizable(false);
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
			window.setLocation( (screen.width - window.getWidth())/2, (screen.height - window.getHeight())/2 );
			window.setVisible(true);
		}





}
