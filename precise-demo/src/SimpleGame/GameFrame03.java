package SimpleGame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;



/*
 ���Դ��������������ⷽ���ƶ���̨����Ϸ
 */
	public class GameFrame03 extends Frame {
		Image img=GameUtil.getImage("images/sun.jpg");
		public void launchFrame()
		{
			setSize(500,500);
			setLocation(100,100);
			setVisible(true);
			new paintThread().start();
			addWindowListener(new WindowAdapter(){

				@Override
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
				
			});
		
		}
	private double x=100,y=100;
	private double degree=3.14/3;
	private double speed=10;
		public void paint(Graphics g) {
			
			g.drawImage(img,(int)x,(int)y,null);
			if(speed>0)
			{speed-=0.05;}
			else{speed=0;}
			
			
			x+=speed*Math.cos(degree);
			y+=speed*Math.sin(degree);
			if(x<0||x>500-30)
			{degree=Math.PI-degree;}
			if(y<30||y>500-30)
			{degree=-degree;}
			
		}
		class paintThread extends Thread
		{
			public void run()
			{
				while(true)
				{
					repaint();
					try {
						Thread.sleep(40);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		



		public static void main(String[] args)
		{
			GameFrame03 gf=new GameFrame03();
			gf.launchFrame();
		}
	}
