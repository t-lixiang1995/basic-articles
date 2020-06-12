package SimpleGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GmeFrame extends Frame {
	Image img=GameUtil.getImage("images/sun.jpg");
	public void launchFrame()
	{
		setSize(300,300);
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
	
	public void paint(Graphics g) {
		g.drawLine(100,100,200,200);
		g.drawRect(100, 100, 200, 200);
		g.drawOval(100, 100, 200, 200);
		Font f=new Font("����",Font.BOLD,100);
		g.setFont(f);
		g.drawString("��ӭ����Ӣ������", 200, 200);
		
		
		Color c=g.getColor();
		g.fillRect(100, 100, 20, 20);
		g.setColor(Color.red);
		g.fillOval(300, 300, 20, 20);
		g.setColor(c);
		g.drawImage(img,(int)x,(int)y,null);
		x+=3;
		y+=3;
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
		GmeFrame gf=new GmeFrame();
		gf.launchFrame();
	}
}
