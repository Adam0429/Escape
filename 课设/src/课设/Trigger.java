package ����;

import java.awt.Rectangle;

public class Trigger {
	static MainFrame mf;
	public Trigger(MainFrame m){
		mf=m;
	}
	public static boolean enter(hero h){
		for(int i=0;i<mf.Current.door.length;i++){
			if(mf.Current.door[i].contains(h.x,h.y)){			//�����ڵص�ת��������
				mf.Current=mf.Current.destination[i];//����destination�Ķ�û��,Ӧ����destination���˴�,�ɸ���door���������ж�destination������
				System.out.println("ת������"+mf.map1303.destination[0]);
				return true;
			}
		}
			return false;
	}
	public static void check(hero h,NPC n){			//���жϺ�����û����.
	}
}
