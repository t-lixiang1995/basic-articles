package SolarSystem;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class MyFrame  extends Frame {
	
	/**
	 * ���ش���
	 */
	public void launchFrame(){
		setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		setLocation(100, 100);
		setVisible(true);
		
		new PaintThread().start();  //�����ػ��߳�
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	/**
	 * ����һ���ػ����ڵ��߳��࣬��һ���ڲ���
	 * @author dell
	 *
	 */
	class PaintThread extends Thread {
		
		public void run(){
			while(true){
				repaint();
				try {
					Thread.sleep(1000); //1s = 1000ms
				} catch (InterruptedException e) {
					e.printStackTrace();
				}   
			}
		}
		
	}
}
