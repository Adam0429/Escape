package ����;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class Read implements Serializable{  
	//�����õ��������implements Serializable�����������õ��������ࡣ���в���ʵ��������Ҫע��transient
	Map map;
	public Read(MainFrame mf,hero h){
		try{
			FileInputStream is=new FileInputStream("C:/Users/wfh/Desktop/save.ser");
			ObjectInputStream oi=new ObjectInputStream(is);
			//map=((MainFrame)oi.readObject()).Current;
			//mf.Current=mf.mapCorridor2;�����ǹ��õ�
			//System.out.println("��ȡ��ͼ"+map);//mapһֱ�ǵ�ǰ�ĵ�ͼ
			//mf.Current=map; ��ʹ���濨ס��ԭ����
			h=(hero)oi.readObject();
			System.out.println(h.x);
			oi.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
