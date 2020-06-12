package SimpleGame;

import java.awt.Graphics;
import java.awt.Image;

public class GameFrame04  extends MyFrame{

		Image img=GameUtil.getImage("images/sun.jpg");
		private double x=100,y=100;
		private double degree=3.14/3;
		public void paint(Graphics g) 
		{
			
			g.drawImage(img,(int)x,(int)y,null);
			x=100+100*Math.cos(degree);
			y=200+50*Math.sin(degree);
			degree+=0.1;
		}
		public static void main(String[] args)
		{
			GameFrame04 gf=new GameFrame04();
			gf.launchFrame();
		}
	}


