package ����;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.Serializable;
import java.net.URI;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

import javax.lang.model.util.SimpleElementVisitor6;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import pintugame.*;
public class MainFrame extends JPanel {//�̳�jpanel���ԭ����,����repaint�����ǳ�����
	//�и����⣺�����jar��eclipse�¿�����ʾ��ͼƬ��jar�޷���ʾ��Ӧ����ͼƬ·��������
	public static JFrame frame=new JFrame();
	public static MainFrame mf=new MainFrame();
	public static hero h=new hero();	
	//public static MapSet ms=new MapSet();����������У���Ϊ��ʼ��MapSet��ʱ�������ÿ�ŵ�ͼ����Ҫ��ʵ����MapSet�����Բ��С�
	public static Map mapStart=new MapStart(mf,h);
	public static Map map1303=new Map1303(mf,h);
	public static boolean map;
	public static Map map1304=new Map1304(mf,h);
	public static Map map1305=new Map1305(mf,h);
	public static Map map1306=new Map1306(mf,h);
	public static Map map1307=new Map1307(mf,h);
	public static Map map1308=new Map1308(mf,h);
	/*������ÿ��map���destination����mf�Ѿ�ʵ������map,��������Щ��ͼ�໥���ӣ�����˭���޷��ȶ��塣���ַ�������ɿ�ָ���쳣��
	 * ������destination=mf.map1303�ĳ�destination=new Map1303(mf,h)�������ǻ᲻ͣ�ص����Լ�����Ϊÿ��map1303��Ҫ��newһ��
	 * map1303,������,�ɴ��ų����ַ���.����ֻ���½�һ����ר������newÿ��map,Ȼ���map�Ķ��󴫵�destination����,����������ǲ���*/
	public static Map mapCorridor1=new MapCorridor1(mf,h);
	public static Map mapCorridor2=new MapCorridor2(mf,h);
	public static Map mapMaster=new MapMaster(mf, h);
	public static Map mapComputer=new MapComputer(mf,h);
	public static Map mapToilet=new MapToilet(mf,h);
	public static Map mapLift=new MapLift(mf,h);
	public static Map mapIntroduce=new MapIntroduce(mf,h);
	public static Map mapSuc=new MapSuc(mf, h);
	public static Map Current=mapStart;
	public static boolean isOver=false;
	public static MyKeyListener mk=new MyKeyListener(mf,h);
	public static MyMouseListener mm=new MyMouseListener(mf,h);
	Image TalkBox = new ImageIcon(this.getClass().getResource("/picture/TalkBox.png")).getImage();
	Image Help = new ImageIcon(this.getClass().getResource("/picture/help.png")).getImage();
	Image Hammer = new ImageIcon(this.getClass().getResource("/picture/Hammer.png")).getImage();
	//use this method,jar can find the path of picture correctly
	public static boolean dialog=false;//��������ͬʱֻ����һ���Ի�
	public static int Missoin=0;
	public static void main(String[] Args){
		h.start();
		frame.setTitle("Escape");
		frame.setSize(1200, 750);
		frame.setResizable(false);//�̶����ڴ�С
		frame.getContentPane().add(mf);
		mf.setBounds(0, 0, 1200, 750);
		frame.getContentPane().setLayout(null);//���ÿ�ܲ���ģʽΪ�գ�ֻ������������֪���ؼ�������λ�� 
		frame.addKeyListener(mk);
		frame.addMouseListener(mm);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.setLocationRelativeTo(null); 
		frame.setVisible(true);	
		new Thread(){
			public void run(){
				new Music(1);
				try {
					sleep(95000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				new Music(0);
			}	
		}.start();
		new Thread(){
		public void run() {
			int d=1;
				while(true){
					System.out.println(Missoin);
						while(d==1){
						map1307.N[0].x--;
						try {
							sleep(10);
						} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
						}
						if(map1307.N[0].x<0){
							d=0;
						}
					}
						while(d==0){
							map1307.N[0].x++;
							try {
								sleep(10);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							if(map1307.N[0].x>600){
								d=1;
							}
						}					
				}
			}
		}.start();
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
		if(Current==mapSuc){
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
			//ths map must paint first,or it will cover other picture
			g.drawImage(h.stateimage, 0, 0, this);
			g.drawImage(Help, 0, 50,150,100, this);
			while(Current.N[i]!=null){
				g.drawImage(Current.N[i].img1, Current.N[i].x, Current.N[i].y,Current.N[i].width,Current.N[i].height,this);
				i++;
			}
			i=0;
			g.drawImage(h.img,h.x,h.y,h.width,h.height,this);
			g.setFont(new Font("����", Font.BOLD, 25));
				g.setColor(Color.BLACK);
			if(map1303.N[0].state==1){
				g.drawImage(TalkBox,300, 500, 600, 200,this);
				g.drawString("���ɺ裺����Ҫ��ȥ�Ļ���Ҫ�ǵô��϶���",330,600);
			}
			if(map1303.N[1].state==1){
				g.drawImage(TalkBox,300, 500, 600, 200,this);
				g.drawString("��r���������Ѿ����ˣ������ȥ",330,600);
			}
			if(map1303.N[2].state==1){
				g.drawImage(TalkBox,300, 500, 600, 200,this);
				g.drawString("��������ĵ������������ʲô��Ϣ....?",330,600);
			}
			if(Missoin>0)
				g.drawImage(Hammer,890,40,150,100,this);
			g.setColor(Color.BLUE);
			//g.setFont(new Font("���Ĳ���", Font.BOLD, 25));
			//g.drawString("Hero"+Current, 50, 50);
		}
		else if(Current==map1304){
			
			g.drawImage(Current.image,Current.x,Current.y,Current.width,Current.height,this);
			g.drawImage(h.stateimage, 0, 0, this);
			g.drawImage(Help, 0, 50,150,100, this);
			while(Current.N[i]!=null){
				g.drawImage(Current.N[i].img1, Current.N[i].x, Current.N[i].y,Current.N[i].width,Current.N[i].height,this);
				i++;
			}
			i=0;
			g.drawImage(h.img,h.x,h.y,h.width,h.height,this);
			g.setFont(new Font("����", Font.BOLD, 25));
			g.setColor(Color.BLACK);
			if(Missoin>0)
				g.drawImage(Hammer,890,40,150,100,this);
			g.setColor(Color.BLUE);
			
		}
		
		else if(Current==map1305){
			
			g.drawImage(Current.image,Current.x,Current.y,Current.width,Current.height,this);
			g.drawImage(h.stateimage, 0, 0, this);
			g.drawImage(Help, 0, 50,150,100, this);
			while(Current.N[i]!=null){
				g.drawImage(Current.N[i].img1, Current.N[i].x, Current.N[i].y,Current.N[i].width,Current.N[i].height,this);
				i++;
			}
			i=0;
			g.drawImage(h.img,h.x,h.y,h.width,h.height,this);
			g.setFont(new Font("����", Font.BOLD, 25));
			g.setColor(Color.BLACK);
			if(Missoin>0)
				g.drawImage(Hammer,890,40,150,100,this);
			g.setColor(Color.BLUE);
			g.setFont(new Font("���Ĳ���", Font.BOLD, 25));
		
		}
		
		
		else if(Current==map1306){
			
			g.drawImage(Current.image,Current.x,Current.y,Current.width,Current.height,this);
			g.drawImage(h.stateimage, 0, 0, this);
			g.drawImage(Help, 0, 50,150,100, this);
			while(Current.N[i]!=null){
				g.drawImage(Current.N[i].img1, Current.N[i].x, Current.N[i].y,Current.N[i].width,Current.N[i].height,this);
				i++;
			}
			i=0;
			g.drawImage(h.img,h.x,h.y,h.width,h.height,this);
			g.setFont(new Font("����", Font.BOLD, 25));
			g.setColor(Color.BLACK);
			if(Missoin>0)
				g.drawImage(Hammer,890,40,150,100,this);
			g.setColor(Color.BLUE);
			g.setFont(new Font("���Ĳ���", Font.BOLD, 25));
			
		}
		
		else if(Current==map1307){
			
			g.drawImage(map1307.N[0].img1, 0, 0, null);
			g.drawImage(h.stateimage, 0, 0, this);
			g.drawImage(Help, 0, 50,150,100, this);
			g.drawImage(Current.image,Current.x,Current.y,Current.width,Current.height,this);
			i=0;
			while(Current.N[i]!=null){
				g.drawImage(Current.N[i].img1, Current.N[i].x, Current.N[i].y,Current.N[i].width,Current.N[i].height,this);
				i++;
			}
			i=0;
			g.drawImage(h.img,h.x,h.y,h.width,h.height,this);
			g.setFont(new Font("����", Font.BOLD, 25));
			g.setColor(Color.BLACK);
			if(map1307.N[0].state==1){
				g.drawImage(TalkBox,300, 500, 600, 200,this);
				g.drawString("���곽����������������ʲô",330,600);
			}
			g.setColor(Color.BLUE);
			if(Missoin>0)
				g.drawImage(Hammer,890,40,150,100,this);
			g.setFont(new Font("���Ĳ���", Font.BOLD, 25));
			
		}
		
		else if(Current==map1308){
			
			g.drawImage(Current.image,Current.x,Current.y,Current.width,Current.height,this);
			g.drawImage(h.stateimage, 0, 0, this);
			while(Current.N[i]!=null){
				g.drawImage(Current.N[i].img1, Current.N[i].x, Current.N[i].y,Current.N[i].width,Current.N[i].height,this);
				i++;
			}
			i=0;
			g.drawImage(h.img,h.x,h.y,h.width,h.height,this);
			g.setFont(new Font("����", Font.BOLD, 25));
			g.setColor(Color.BLACK);
			g.setColor(Color.BLUE);
			if(Missoin>0)
				g.drawImage(Hammer,890,40,150,100,this);
			g.setFont(new Font("���Ĳ���", Font.BOLD, 25));
		}
		
		else if(Current==mapMaster){
			
			g.drawImage(Current.image,Current.x,Current.y,Current.width,Current.height,this);
			g.drawImage(h.stateimage, 0, 0, this);
			g.drawImage(Help, 0, 50,150,100, this);
			if(Missoin<2)
				g.drawImage(Current.N[0].img1, Current.N[0].x, Current.N[0].y, Current.N[0].width,Current.N[0].height,this);
			i=0;
			g.drawImage(h.img,h.x,h.y,h.width,h.height,this);
			g.setFont(new Font("����", Font.BOLD, 25));
			g.setColor(Color.BLACK);
			if(Missoin>0)
				g.drawImage(Hammer,890,40,150,100,this);
			g.setColor(Color.BLUE);
			g.setFont(new Font("���Ĳ���", Font.BOLD, 25));
		}
		
		else if(Current==mapCorridor1){
			
			g.drawImage(Current.image,Current.x,Current.y,Current.width,Current.height,this);
			g.drawImage(h.stateimage, 0, 0, this);
			g.drawImage(h.img,h.x,h.y,h.width,h.height,this);
			g.drawImage(Help, 0, 50,150,100, this);
			g.setColor(Color.BLUE);
			if(Missoin>0)
				g.drawImage(Hammer,890,40,150,100,this);
			g.setFont(new Font("���Ĳ���", Font.BOLD, 25));
			
		}
		else if(Current==mapCorridor2){
			
			g.drawImage(Current.image,Current.x,Current.y,Current.width,Current.height,this);
			g.drawImage(h.stateimage, 0, 0, this);
			g.drawImage(h.img,h.x,h.y,h.width,h.height,this);
			g.drawImage(Help, 0, 50,150,100, this);
			i=0;
			while(Current.N[i]!=null){
				g.drawImage(Current.N[i].img1, Current.N[i].x, Current.N[i].y,Current.N[i].width,Current.N[i].height,this);
				i++;
			}
			i=0;
			g.setColor(Color.BLUE);
			if(Missoin>0)
				g.drawImage(Hammer,890,40,150,100,this);
			g.setFont(new Font("���Ĳ���", Font.BOLD, 25));
		
		}
		
		else if(Current==mapLift){
			
			g.drawImage(Current.image,Current.x,Current.y,Current.width,Current.height,this);
			g.drawImage(h.stateimage, 0, 0, this);
			g.drawImage(Help, 0, 50,150,100, this);
			while(mapLift.N[i]!=null){
				g.drawImage(mapLift.N[i].img1, mapLift.N[i].x, mapLift.N[i].y,mapLift.N[i].width,mapLift.N[i].height,this);
				i++;
			}
			i=0;
			g.drawImage(h.img,h.x,h.y,h.width,h.height,this);
			g.setFont(new Font("����", Font.BOLD, 25));
			g.setColor(Color.BLACK);
			if(mapLift.N[0].state==1){
				g.drawImage(TalkBox,300, 500, 600, 200,this);
				g.drawString("����ΰ:��������?",330,600);
			 }
			g.setColor(Color.BLUE);
			if(Missoin>0)
				g.drawImage(Hammer,890,40,150,100,this);
			g.setFont(new Font("���Ĳ���", Font.BOLD, 25));
			
		}
		else if(Current==mapToilet){
			
			g.drawImage(Current.image,Current.x,Current.y,Current.width,Current.height,this);
			g.drawImage(h.stateimage, 0, 0, this);
			g.drawImage(Help, 0, 50,150,100, this);
			g.drawImage(h.img,h.x,h.y,h.width,h.height,this);
			g.setColor(Color.BLUE);
			if(Missoin>0)
				g.drawImage(Hammer,890,40,150,100,this);
			if(Missoin>=2)
				g.drawImage(Current.N[0].img1, Current.N[0].x, Current.N[0].y, Current.N[0].width,Current.N[0].height,this);
			g.setFont(new Font("���Ĳ���", Font.BOLD, 25));
		
		}
	}	

	
	
	static class MyTask extends TimerTask{
		public void run(){
			mf.repaint();					
        }     
	}

}