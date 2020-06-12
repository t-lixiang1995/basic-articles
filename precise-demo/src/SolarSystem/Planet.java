package SolarSystem;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;



public class Planet extends Star {

	//����ͼƬ�����ꡣ ��������ĳ����Բ���У����ᡢ���ᡢ�ٶȡ��Ƕȡ� ����ĳ��Star�ɡ�
	double longAxis;  //��Բ�ĳ���
	double shortAxis;  //��Բ�Ķ���
	double speed;     //���е��ٶ�
	double degree;    
	Star center;
	
	boolean satellite;
	
	
	public void draw(Graphics g){
		super.draw(g);
		move();
		if(!satellite){
			drawTrace(g);
		}
	}
	
	public void drawTrace(Graphics g){
		double ovalX,ovalY,ovalWidth,ovalHeight;
		
		ovalWidth = longAxis*2;
		ovalHeight = shortAxis*2;
		ovalX = (center.x+center.width/2)-longAxis;
		ovalY = (center.y+center.height/2)-shortAxis;
		
		Color c =g.getColor();
		g.setColor(Color.blue);
		g.drawOval((int)ovalX, (int)ovalY, (int)ovalWidth, (int)ovalHeight);
		g.setColor(c);
	}

	public void move(){
		//������Բ�켣����
		x = (center.x+center.width/2) + longAxis*Math.cos(degree);
		y = (center.y+center.height/2)+ shortAxis*Math.sin(degree);
		
		degree += speed;
	}
	
	
	
	public Planet(Star center,String imgpath, double longAxis,
			double shortAxis, double speed) {
		super(GameUtil.getImage(imgpath));
		
		
		this.center = center;
		this.x = center.x + longAxis;
		this.y = center.y;
		
		this.longAxis = longAxis;
		this.shortAxis = shortAxis;
		this.speed = speed;
		
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);

	}
	
	public Planet(Star center,String imgpath, double longAxis,
			double shortAxis, double speed,boolean satellite) {
		this(center, imgpath, longAxis, shortAxis, speed);
		this.satellite = satellite;
		
	}
	public Planet(Image img, double x, double y) {
		super(img, x, y);
	}
	public Planet(String imgpath, double x, double y) {
		super(imgpath, x, y);
	}
	
	
}
