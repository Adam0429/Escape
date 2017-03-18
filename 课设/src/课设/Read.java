package 课设;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class Read implements Serializable{  
	//所有用到的类必须implements Serializable，包括类中用到的其他类。还有不能实例化的类要注明transient
	MainFrame m;
	hero h;
	public Read(){
		try{
			FileInputStream is=new FileInputStream("C:/Users/wfh/Desktop/save.ser");
			ObjectInputStream oi=new ObjectInputStream(is);
			m=(MainFrame)oi.readObject();
			System.out.println("读取地图"+m.Current);//地图一直显示为当前界面是因为，read对象在keylistener类里被调用,read中被参入的参数是kl里的
			//mf.Current=map;  这样做会使界面卡住，因为image不能序列化
			h=(hero)oi.readObject();
			oi.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
