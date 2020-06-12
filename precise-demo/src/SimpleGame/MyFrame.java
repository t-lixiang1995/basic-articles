package SimpleGame;

import java.awt.Frame;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;




public class MyFrame extends Frame {
	Image img=GameUtil.getImage("images/sun.jpg");
	public void launchFrame()
	{
		setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
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
	
}