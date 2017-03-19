package 课设;

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
	public static void check(hero h,NPC n){			
		Rectangle r=new Rectangle(n.x,n.y,n.triggerwidth,n.triggerheight);
		Rectangle r1=new Rectangle(h.x,h.y,h.width,h.height);
		if(r.contains(h.x, h.y)){
			System.out.println("接触");
			if(n.state==0){
				n.state=1;
				n.function(h);
			}
			else 
				n.state=0;
		}
	}
}
