package ����;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class Read implements Serializable{  
	//�����õ��������implements Serializable�����������õ��������ࡣ���в���ʵ��������Ҫע��transient
	MainFrame m;
	hero h;
	public Read(){
		try{
			FileInputStream is=new FileInputStream("C:/Users/wfh/Desktop/save.ser");
			ObjectInputStream oi=new ObjectInputStream(is);
			m=(MainFrame)oi.readObject();
			System.out.println("��ȡ��ͼ"+m.Current);//��ͼһֱ��ʾΪ��ǰ����,��֪��Ϊʲô
			//mf.Current=map;  ��������ʹ���濨ס����Ϊimage�������л�
			h=(hero)oi.readObject();
			oi.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
