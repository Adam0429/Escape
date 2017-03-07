package 课设;

import java.awt.Rectangle;

public class Trigger {
	static MainFrame mf;
	public Trigger(MainFrame m){
		mf=m;
	}
	public static boolean enter(hero h){
		for(int i=0;i<mf.Current.door.length;i++){
			if(mf.Current.door[i].contains(h.x,h.y)){			//坐标在地点转换的区域
				mf.Current=mf.Current.destination[i];//加了destination的都没用,应该是destination出了错,可根据door的属性来判断destination的问题
				System.out.println("转换场地"+mf.map1303.destination[0]);
				return true;
			}
		}
			return false;
	}
	public static void check(hero h,NPC n){			//先判断和门有没有碰.
	}
}
