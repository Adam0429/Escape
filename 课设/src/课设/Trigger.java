package ����;

import java.awt.Rectangle;

public class Trigger {
	static Map map;
	static MainFrame mf;
	public Trigger(MainFrame m){
		map=m.Current;
		mf=m;
	}
	public static boolean enter(hero h){
		for(int i=0;i<map.door.length;i++){
			if(map.door[i].contains(h.x,h.y)){			//�����ڵص�ת��������
				mf.Current=map.destination[i];
				return true;
			}
		}
			return false;
		
	}
	public static void check(hero h,NPC n){			//���жϺ�����û����ײ

	}
}
