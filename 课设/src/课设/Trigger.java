package ����;

import java.awt.Rectangle;

public class Trigger {
	static MainFrame mf;
	static hero h;
	public Trigger(MainFrame Frame,hero h1){
		mf=Frame;
		h=MainFrame.h;
	}
	public static boolean enter(){
		for(int i=0;i<mf.Current.destination.length;i++){
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
