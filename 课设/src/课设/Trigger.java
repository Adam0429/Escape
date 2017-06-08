package 课设;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.Serializable;
import java.util.logging.Handler;

import javax.net.ssl.SSLSession;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import pintugame.*;

public class Trigger implements Serializable{
	static MainFrame mf;
	static hero h;
	static Map temp;
	public Trigger(MainFrame Frame,hero h1){
		mf=Frame;
		h=h1;
	}
	public static void enter(){					//先判断和门有没有碰.
		int destination=-1;
		for(int i=0;i<mf.Current.door.length;i++){
			if(mf.Current.door[i].contains(h.x,h.y)){			//坐标在地点转换的区域
				destination=i;
				break;
			}
		}
		
		if(mf.Current==mf.map1303){
				switch(destination){
					case 0:
						if(mf.map1303.lock==true){
							mf.Current=mf.mapCorridor1;
							h.x=953;
							System.out.println(destination);
						}
						else{
							String passport=JOptionPane.showInputDialog("输入密码");
							System.out.println(passport);
							if(passport.equals("ZH1858")){
								mf.map1303.lock=true;
								JOptionPane.showMessageDialog(null, "门锁已开");
							}
							else 
								JOptionPane.showMessageDialog(null, "密码错误");
						}
							
						break;
					case 1:
						break;
					case 2:
						break;
				}
		}
		
		else if(mf.Current==mf.map1304){
			switch(destination){
				case 0:
					h.x=511;
					mf.Current=mf.mapCorridor1;
					System.out.println(destination);
					break;
				case 1:
					h.x=511;
					mf.Current=mf.mapCorridor1;
					System.out.println(destination);
					break;
				case 2:
					h.x=511;
					mf.Current=mf.mapCorridor1;
					System.out.println(destination);
					break;
			}
		}
		
		else if(mf.Current==mf.map1305){
			switch(destination){
				case 0:
					h.x=121;
					mf.Current=mf.mapCorridor1;
					System.out.println(destination);
					break;
				case 1:
					h.x=121;
					mf.Current=mf.mapCorridor1;
					System.out.println(destination);
					break;
				case 2:
					h.x=121;
					mf.Current=mf.mapCorridor1;
					System.out.println(destination);
					break;
			}
		}
		
		else if(mf.Current==mf.map1306){
			switch(destination){
				case 0:
					h.x=1041;
					mf.Current=mf.mapCorridor2;
					System.out.println(destination);
					break;
				case 1:
					h.x=1041;
					mf.Current=mf.mapCorridor2;
					System.out.println(destination);
					break;
				case 2:
					h.x=1041;
					mf.Current=mf.mapCorridor2;
					System.out.println(destination);
					break;
			}
		}
		

		else if(mf.Current==mf.map1307){
			switch(destination){
				case 0:
					h.x=688;
					mf.Current=mf.mapCorridor2;
					System.out.println(destination);
					break;
				case 1:
					h.x=953;
					mf.Current=mf.mapCorridor2;
					System.out.println(destination);
					break;
				case 2:
					h.x=953;
					mf.Current=mf.mapCorridor2;
					System.out.println(destination);
					break;
			}
		}
		

		else if(mf.Current==mf.map1308){
			switch(destination){
				case 0:
					h.x=289;
					mf.Current=mf.mapCorridor2;
					System.out.println(destination);
					break;
				case 1:
					h.x=289;
					mf.Current=mf.mapCorridor2;
					System.out.println(destination);
					break;
				case 2:
					h.x=289;
					mf.Current=mf.mapCorridor2;
					System.out.println(destination);
					break;
			}
		}
		
		else if(mf.Current==mf.mapMaster)
			switch(destination){
			case 0:
				h.x=0;
				mf.Current=mf.mapCorridor2;
				System.out.println(destination);
				break;
			case 1:
				h.x=1069;
				mf.Current=mf.map1307;
				System.out.println(destination);
				break;
			case 2:
				h.x=0;
				mf.Current=mf.map1308;
				System.out.println(destination);
				break;
		}
		
		else if(mf.Current==mf.mapCorridor1)
			switch(destination){
			case 0:
				h.x=1069;
				mf.Current=mf.map1303;
				System.out.println(destination);
				break;
			case 1:
				h.x=0;
				mf.Current=mf.map1304;
				System.out.println(destination);
				break;
			case 2:
				h.x=1069;
				mf.Current=mf.map1305;
				System.out.println(destination);
				break;
		}
	
		else if(mf.Current==mf.mapCorridor2)
			switch(destination){
			case 0:
				h.x=0;
				mf.Current=mf.map1306;
				System.out.println(destination);
				break;
			case 1:
				h.x=1069;
				mf.Current=mf.map1307;
				System.out.println(destination);
				break;
			case 2:
				h.x=0;
				mf.Current=mf.map1308;
				System.out.println(destination);
				break;
		}
	}
	public static void check(NPC n){			
		Rectangle r=new Rectangle(n.x,n.y,n.width,n.height);
		//Rectangle r1=new Rectangle(h.x,h.y,h.width,h.height);
		if(r.contains(h.x+58, h.y+70)){	//因为人物坐标是图片的左上角，要想用人物中心的坐标判断接触，要做小小的调整
			System.out.println("接触");
			if(mf.dialog==false){		
				if(n.state==0){
					n.state=1;
					n.function(h);
					
				}
				else{
					n.state=0;
				}
				mf.dialog=true;
			}
			else{
				int i=0;
				mf.dialog=false;
				while(mf.Current.N[i]!=null){
					mf.Current.N[i].state=0;
					i++;
				}
			}
		}
	}
	
	public static void use(NPC n,int x,int y){		
		Rectangle r=new Rectangle(n.x,n.y,n.width,n.height);
		if(r.contains(x, y)){
			if(n instanceof Map1303Computer){
				mf.Current=mf.mapComputer;
				n.function(h);
			}
			else if(n instanceof Map1304Hammer){
				mf.map1304.image=mf.map1304.image2;
				mf.map1304.T[0]=null;
				mf.Missoin=1;
				n.function(h);
			}
			else if(n instanceof MapToiletHose){				
				n.function(h);
			}
			else if(n instanceof Map1306Box){
				n.function(h);
			}
			else if(n instanceof MapMasterComputer){
				if(mf.Missoin<2)
					JOptionPane.showMessageDialog(null, "楼长在,不能动");
				else
					n.function(h);
			}
			else if(n instanceof MapLiftlift){
				if(mf.Missoin<3)
					JOptionPane.showMessageDialog(null, "电梯关闭了");
				else
					
					mf.Current=mf.mapSuc;
			}
		}
	}
	
}
