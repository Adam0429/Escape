package ����;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JPanel  {
	//�и����⣺�����jar��eclipse�¿�����ʾ��ͼƬ��jar�޷���ʾ��Ӧ����ͼƬ·��������
	public static JFrame frame=new JFrame();
	public static MainFrame mf=new MainFrame();
	public static hero h=new hero();
	public static MyListener mk=new MyListener(mf,h);
	public static Map mapStart=new MapStart();
	public static Map map1303=new Map1303();
	public static Map mapIntroduce=new MapIntroduce();
	public static final boolean isOver=false;
	public static Map Current=mapStart;
	public static int q;
	public static void main(String[] Args){
		h.start();
		frame.setTitle("���翪����");
		frame.setSize(1200, 750);
		frame.getContentPane().add(mf);	
		//frame.getContentPane().setLayout(null);//���ÿ�ܲ���ģʽΪ�գ�ֻ������������֪��ͼƬ������λ��  
		frame.addKeyListener(mk);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.setLocationRelativeTo(null); 
		frame.setVisible(true);	
		
	}
	public MainFrame(){
		init();
	}
	void init(){
		Timer timer = new Timer();     								
		timer.schedule(new MyTask(), 0, 5);
	}
	public void paint(Graphics g) {  
		if(Current==mapStart){
			g.drawImage(Current.image,Current.x,Current.y,Current.width,Current.height,this);	
		}
		else if(Current==map1303){
			g.drawImage(Current.image,Current.x,Current.y,Current.width,Current.height,this);
			g.drawImage(h.img,h.x,h.y,150,150,this);
			g.setColor(Color.BLUE);
			g.setFont(new Font("���Ĳ���", Font.BOLD, 25));
			g.drawString("����", 50, 50);
		}
	}	

	
	
	static class MyTask extends TimerTask{		
		private int runTimes = 0;  								
		public void run(){
                //ÿִ��һ��run������runTimes��+1  
                runTimes++;  
                h.step();
                mf.repaint();					
        }     
	}

}