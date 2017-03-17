package 课设;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class Read implements Serializable{  
	//所有用到的类必须implements Serializable，包括类中用到的其他类。还有不能实例化的类要注明transient
	Map map;
	public Read(MainFrame mf,hero h){
		try{
			FileInputStream is=new FileInputStream("C:/Users/wfh/Desktop/save.ser");
			ObjectInputStream oi=new ObjectInputStream(is);
			//map=((MainFrame)oi.readObject()).Current;
			//mf.Current=mf.mapCorridor2;这条是管用的
			//System.out.println("读取地图"+map);//map一直是当前的地图
			//mf.Current=map; 会使界面卡住，原因不详
			h=(hero)oi.readObject();
			System.out.println(h.x);
			oi.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
