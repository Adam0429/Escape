package 课设;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
	//有个问题：打包成jar后，eclipse下可以显示的图片，jar无法显示，应该是图片路径的问题
	public static JFrame frame=new JFrame();
	public static MainFrame mf=new MainFrame();
	public static hero h=new hero();	
	public static Map mapStart=new MapStart(mf,h);
	public static Map Current=mapStart;
	public static Map map1303=new Map1303(mf,h);
	/*本想在每个map里给destination传入mf已经实例化的map,但发现这些地图相互连接，无论谁都无法先定义。这种方法会造成空指针异常。
	 * 后来把destination=mf.map1303改成destination=new Map1303(mf,h)发现他们会不停地调用自己，因为每个map1303都要新new一个
	 * map1303,最后溢出,由此排出这种方法.后来只能新建一个类专门用来new每个map,然后把map的对象传到destination里面.*/
	public static Map mapCorridor1=new MapCorridor1(mf,h);
	public static Map mapCorridor2=new MapCorridor2(mf,h);
	public static Map mapIntroduce=new MapIntroduce();
	public static boolean isOver=false;
	public static MyKeyListener mk=new MyKeyListener(mf,h);
	public static MyMouseListener mm=new MyMouseListener();
	public static void main(String[] Args){
		h.start();
		frame.setTitle("Escape");
		frame.setSize(1200, 750);
		frame.getContentPane().add(mf);
		//frame.getContentPane().setLayout(null);//设置框架布局模式为空，只有这样，才能知道图片的真正位置  
		frame.addKeyListener(mk);
		frame.addMouseListener(mm);
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
	public void paint(Graphics g){  
		if(Current==mapStart){
			g.drawImage(Current.image,Current.x,Current.y,Current.width,Current.height,this);	
		}
		else if(Current==map1303){
			g.drawImage(Current.image,Current.x,Current.y,Current.width,Current.height,this);
			g.drawImage(h.img,h.x,h.y,150,150,this);
			g.setColor(Color.BLUE);
			g.setFont(new Font("华文彩云", Font.BOLD, 25));
			g.drawString("Hero"+Current, 50, 50);
		}
		else if(Current==mapCorridor1){
			g.drawImage(Current.image,Current.x,Current.y,Current.width,Current.height,this);
			g.drawImage(h.img,h.x,h.y,150,150,this);
			g.setColor(Color.BLUE);
			g.setFont(new Font("华文彩云", Font.BOLD, 25));
			g.drawString("Hero"+Current, 50, 50);
		}
		else if(Current==mapCorridor2){
			g.drawImage(Current.image,Current.x,Current.y,Current.width,Current.height,this);
			g.drawImage(h.img,h.x,h.y,150,150,this);
			g.setColor(Color.BLUE);
			g.setFont(new Font("华文彩云", Font.BOLD, 25));
			g.drawString("Hero"+Current, 50, 50);
		}
	}	

	
	
	static class MyTask extends TimerTask{					
		public void run(){
                h.step();
                mf.repaint();					
        }     
	}

}