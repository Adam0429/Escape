package 课设;

import java.awt.Rectangle;

public class Trigger {
	static MainFrame mf;
	static hero h;
	public Trigger(MainFrame Frame,hero h1){
		mf=Frame;
		h=MainFrame.h;
	}
	public static void enter(){
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
				mf.Current=mf.mapCorridor2;
				System.out.println(destination);
				break;
			case 1:
				mf.Current=mf.mapCorridor2;
				System.out.println(destination);
				break;
			case 2:
				mf.Current=mf.mapCorridor2;
				System.out.println(destination);
				break;
		}
	
	}
	public static void check(hero h,NPC n){			//先判断和门有没有碰.
	}
}
