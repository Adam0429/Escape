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
import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainFrame extends JPanel implements Serializable {
	//有个问题：打包成jar后，eclipse下可以显示的图片，jar无法显示，应该是图片路径的问题
	public static JFrame frame=new JFrame();
	public static MainFrame mf=new MainFrame();
	public static hero h=new hero();	
	//public static MapSet ms=new MapSet();这个方法不行，因为初始化MapSet的时候里面的每张地图都需要先实例化MapSet，所以不行。
	public static Map mapStart=new MapStart(mf,h);
	public static Map map1303=new Map1303(mf,h);
	public static Map map1304=new Map1304(mf,h);
	public static Map map1305=new Map1305(mf,h);
//	public static Map map1306=new Map1306(mf,h);
	public static Map map1307=new Map1307(mf,h);
	public static Map map1308=new Map1308(mf,h);
	/*本想在每个map里给destination传入mf已经实例化的map,但发现这些地图相互连接，无论谁都无法先定义。这种方法会造成空指针异常。
	 * 后来把destination=mf.map1303改成destination=new Map1303(mf,h)发现他们会不停地调用自己，因为每个map1303都要新new一个
	 * map1303,最后溢出,由此排出这种方法.后来只能新建一个类专门用来new每个map,然后把map的对象传到destination里面,这个方法还是不行*/
	public static Map mapCorridor1=new MapCorridor1(mf,h);
	public static Map mapCorridor2=new MapCorridor2(mf,h);
	public static Map mapComputer=new MapComputer(mf,h);
	public static Map mapToilet=new MapToilet(mf,h);
	public static Map mapIntroduce=new MapIntroduce(mf,h);
	public static Map Current=mapStart;
	public static boolean isOver=false;
	public static MyKeyListener mk=new MyKeyListener(mf,h);
	public static MyMouseListener mm=new MyMouseListener(mf,h);
	Image TalkBox = new ImageIcon(this.getClass().getResource("./TalkBox.png")).getImage();
	public static boolean dialog=false;//用来控制同时只存在一个对话
	public static void main(String[] Args){
		h.start();
		frame.setTitle("Escape");
		frame.setSize(1200, 750);
		frame.setResizable(false);//固定窗口大小
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
		timer.schedule(new MyTask(), 0, 25);
	}
	public void paint(Graphics g){ 
		int i=0;
		if(Current==mapStart){
			g.drawImage(Current.image,Current.x,Current.y,Current.width,Current.height,this);	
		}
		else if(Current==mapIntroduce){
			g.drawImage(Current.image,Current.x,Current.y,Current.width,Current.height,this);
		}
		else if(Current==mapComputer){
			g.drawImage(Current.image,Current.x,Current.y,Current.width,Current.height,this);
		}
		else if(Current==map1303){
			g.drawImage(Current.image,Current.x,Current.y,Current.width,Current.height,this);
			g.drawImage(h.stateimage, 0, 0, this);
			while(map1303.N[i]!=null){
				g.drawImage(map1303.N[i].img1, map1303.N[i].x, map1303.N[i].y,map1303.N[i].width,map1303.N[i].height,this);
				i++;
			}
			i=0;
			g.drawImage(h.img,h.x,h.y,h.width,h.height,this);
			g.setFont(new Font("楷体", Font.BOLD, 25));
				g.setColor(Color.BLACK);
			if(map1303.N[0].state==1){
				g.drawImage(TalkBox,300, 500, 600, 200,this);
				g.drawString("王飞鸿：威哥要出去的话，要记得带上东西",330,600);
			}
			if(map1303.N[1].state==1){
				g.drawImage(TalkBox,300, 500, 600, 200,this);
				g.drawString("吴瑀：宿舍门已经锁了，别想出去",330,600);
			}
			if(map1303.N[2].state==1){
				g.drawImage(TalkBox,300, 500, 600, 200,this);
				g.drawString("娇娇：你的电脑上面好像有什么信息....?",330,600);
			}
			if(map1303.T[0].state==1){
				//mf.Current=
				System.out.println("22dsdsd");
			}
			g.setColor(Color.BLUE);
			g.setFont(new Font("华文彩云", Font.BOLD, 25));
			//g.drawString("Hero"+Current, 50, 50);
		}
		else if(Current==map1304){
			g.drawImage(Current.image,Current.x,Current.y,Current.width,Current.height,this);
			g.drawImage(h.stateimage, 0, 0, this);
			while(map1304.N[i]!=null){
				g.drawImage(map1304.N[i].img1, map1304.N[i].x, map1304.N[i].y,map1304.N[i].width,map1304.N[i].height,this);
				i++;
			}
			i=0;
			g.drawImage(h.img,h.x,h.y,h.width,h.height,this);
			g.setFont(new Font("楷体", Font.BOLD, 25));
			g.setColor(Color.BLACK);
			g.setColor(Color.BLUE);
			g.setFont(new Font("华文彩云", Font.BOLD, 25));
			//g.drawString("Hero"+Current, 50, 50);
		}
		
		else if(Current==map1305){
			g.drawImage(Current.image,Current.x,Current.y,Current.width,Current.height,this);
			g.drawImage(h.stateimage, 0, 0, this);
			while(map1305.N[i]!=null){
				g.drawImage(map1305.N[i].img1, map1305.N[i].x, map1305.N[i].y,map1305.N[i].width,map1305.N[i].height,this);
				i++;
			}
			i=0;
			g.drawImage(h.img,h.x,h.y,h.width,h.height,this);
			g.setFont(new Font("楷体", Font.BOLD, 25));
			g.setColor(Color.BLACK);
			g.setColor(Color.BLUE);
			g.setFont(new Font("华文彩云", Font.BOLD, 25));
			//g.drawString("Hero"+Current, 50, 50);
		}
		else if(Current==map1305){
			g.drawImage(Current.image,Current.x,Current.y,Current.width,Current.height,this);
			g.drawImage(h.stateimage, 0, 0, this);
			while(map1304.N[i]!=null){
				g.drawImage(map1304.N[i].img1, map1304.N[i].x, map1304.N[i].y,map1304.N[i].width,map1304.N[i].height,this);
				i++;
			}
			i=0;
			g.drawImage(h.img,h.x,h.y,h.width,h.height,this);
			g.setFont(new Font("楷体", Font.BOLD, 25));
			g.setColor(Color.BLACK);
			g.setColor(Color.BLUE);
			g.setFont(new Font("华文彩云", Font.BOLD, 25));
			//g.drawString("Hero"+Current, 50, 50);
		}
		else if(Current==map1307){
			g.drawImage(Current.image,Current.x,Current.y,Current.width,Current.height,this);
			g.drawImage(h.stateimage, 0, 0, this);
			while(map1304.N[i]!=null){
				g.drawImage(map1304.N[i].img1, map1304.N[i].x, map1304.N[i].y,map1304.N[i].width,map1304.N[i].height,this);
				i++;
			}
			i=0;
			g.drawImage(h.img,h.x,h.y,h.width,h.height,this);
			g.setFont(new Font("楷体", Font.BOLD, 25));
			g.setColor(Color.BLACK);
			g.setColor(Color.BLUE);
			g.setFont(new Font("华文彩云", Font.BOLD, 25));
			//g.drawString("Hero"+Current, 50, 50);
		}
		else if(Current==map1308){
			g.drawImage(Current.image,Current.x,Current.y,Current.width,Current.height,this);
			g.drawImage(h.stateimage, 0, 0, this);
			while(map1304.N[i]!=null){
				g.drawImage(map1304.N[i].img1, map1304.N[i].x, map1304.N[i].y,map1304.N[i].width,map1304.N[i].height,this);
				i++;
			}
			i=0;
			g.drawImage(h.img,h.x,h.y,h.width,h.height,this);
			g.setFont(new Font("楷体", Font.BOLD, 25));
			g.setColor(Color.BLACK);
			g.setColor(Color.BLUE);
			g.setFont(new Font("华文彩云", Font.BOLD, 25));
			//g.drawString("Hero"+Current, 50, 50);
		}
		else if(Current==mapCorridor1){
			g.drawImage(Current.image,Current.x,Current.y,Current.width,Current.height,this);
			g.drawImage(h.img,h.x,h.y,h.width,h.height,this);
			g.setColor(Color.BLUE);
			g.setFont(new Font("华文彩云", Font.BOLD, 25));
			g.drawString("Hero"+Current, 50, 50);
		}
		else if(Current==mapCorridor2){
			g.drawImage(Current.image,Current.x,Current.y,Current.width,Current.height,this);
			g.drawImage(h.img,h.x,h.y,h.width,h.height,this);
			g.setColor(Color.BLUE);
			g.setFont(new Font("华文彩云", Font.BOLD, 25));
			g.drawString("Hero"+Current, 50, 50);
		}
		else if(Current==mapToilet){
			g.drawImage(Current.image,Current.x,Current.y,Current.width,Current.height,this);
			g.drawImage(h.img,h.x,h.y,h.width,h.height,this);
			g.setColor(Color.BLUE);
			g.setFont(new Font("华文彩云", Font.BOLD, 25));
			g.drawString("Hero"+Current, 50, 50);
		}
	}	

	
	
	static class MyTask extends TimerTask{
		public void run(){
			mf.repaint();					
        }     
	}

}