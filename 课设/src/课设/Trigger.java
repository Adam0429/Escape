package ����;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.Serializable;

public class Trigger implements Serializable{
	static MainFrame mf;
	static hero h;
	public Trigger(MainFrame Frame,hero h1){
		mf=Frame;
		h=h1;
	}
	public static void enter(){					//���жϺ�����û����.
		int destination=-1;
		for(int i=0;i<mf.Current.door.length;i++){
			if(mf.Current.door[i].contains(h.x,h.y)){			//�����ڵص�ת��������
				destination=i;
				break;
			}
		}
		
		if(mf.Current==mf.map1303){
			switch(destination){
				case 0:
					mf.Current=mf.mapCorridor1;
					System.out.println(destination);
					break;
				case 1:
					mf.Current=mf.mapCorridor1;
					System.out.println(destination);
					break;
				case 2:
					mf.Current=mf.mapCorridor1;
					System.out.println(destination);
					break;
			}
		}
		
		else if(mf.Current==mf.mapCorridor1)
			switch(destination){
			case 0:
				mf.Current=mf.map1303;
				System.out.println(destination);
				break;
			case 1:
				mf.Current=mf.map1303;
				System.out.println(destination);
				break;
			case 2:
				mf.Current=mf.map1303;
				System.out.println(destination);
				break;
		}
	
	}
	public static void check(NPC n){			
		Rectangle r=new Rectangle(n.x,n.y,n.width,n.height);
		//Rectangle r1=new Rectangle(h.x,h.y,h.width,h.height);
		if(r.contains(h.x+58, h.y+70)){	//��Ϊ����������ͼƬ�����Ͻǣ�Ҫ�����������ĵ������жϽӴ���Ҫ��СС�ĵ���
			System.out.println("�Ӵ�");
			if(mf.dialog==false){			//dialogû�иı䣬�߼��д�
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
			if(mf.dialog==false){			//dialogû�иı䣬�߼��д�
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
				while(mf.Current.T[i]!=null){
					mf.Current.T[i].state=0;
					i++;
				}
			}
		}
	}
	
}
