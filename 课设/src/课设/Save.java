package øŒ…Ë;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Save implements Serializable{
	public Save(MainFrame mf,hero h){
		try{
			FileOutputStream fs=new FileOutputStream("C:/Users/wfh/Desktop/save.ser");
			ObjectOutputStream os=new ObjectOutputStream(fs);
			os.writeObject(mf);
			System.out.println(mf.Current);
			os.writeObject(h);
			os.close();
		}catch(Exception e){
			e.printStackTrace();
			}	
	}	
}
