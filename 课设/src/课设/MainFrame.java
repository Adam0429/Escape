package 课设;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import MainFrame.MyListener;

public class MainFrame extends JPanel  {
	//有个问题：打包成jar后，eclipse下可以显示的图片，jar无法显示，应该是图片路径的问题
	static JFrame frame=new JFrame();
	static MainFrame mf=new MainFrame();
	static MainFrame.MyListener mk=mf.new MyListener();
	public static hero h=new hero();
	public static Map m=new Map();
	public static final boolean isOver=false;
	public static final int START=0;
	public static final int HELP=1;
	public static final int INTRODUCE=1;
	public static final int D1303=2;
	public static int STATE=START;
	public static int q;
	public static void main(String[] Args){
		h.start();
		frame.setTitle("威哥开房记");
		frame.setSize(1200, 750);
		frame.getContentPane().add(mf);	
		//frame.getContentPane().setLayout(null);//设置框架布局模式为空，只有这样，才能知道图片的真正位置  
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
		g.drawImage(m.img,1,1,this);
		g.drawImage(h.img,h.x,h.y,150,150,this);
		g.setColor(Color.BLUE);
		g.setFont(new Font("华文彩云", Font.BOLD, 25));
		g.drawString("杜威", 50, 50);
	}
	public class MyListener implements KeyListener{
		public void keyPressed(KeyEvent e) {
			 if(e.getKeyCode() == KeyEvent.VK_RIGHT) {  
				 h.right=true;
			 }
			 if(e.getKeyCode() == KeyEvent.VK_LEFT) {  
			     h.left=true;	
			 }
			 if(e.getKeyCode() == KeyEvent.VK_SPACE) {  
				 h.down=false;
				 h.up=true;
			 }
		}
		public void keyReleased(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_RIGHT) {  
				 h.right=false;	
				 /*用这种写法会比用之前的写法手感好.原来的只有按下去一段时间才会走，猜想是多线程的缘故
				  用多线程提高了人物的灵敏度。
				  */
			}
			if(e.getKeyCode() == KeyEvent.VK_LEFT) {  
				h.left=false;	
			}
			if(e.getKeyCode() == KeyEvent.VK_SPACE) {  
				h.up=false;
				h.down=true;
			}	 
		}
		public void keyTyped(KeyEvent e) {
		}    
	}
	static class MyTask extends TimerTask{		
		private int runTimes = 0;  								
		public void run(){
                //每执行一次run方法，runTimes就+1  
                runTimes++;  
                h.step();
                mf.repaint();					
        }     
	}

}