package øŒ…Ë;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class Read{  
	MainFrame mf;
	hero h;
	Map map;
	int[] number = new int[10];
	public void read(){
		try(DataInputStream s=new DataInputStream(new BufferedInputStream(new FileInputStream("C:\\Users\\lenovo\\Desktop\\data.txt"))))
		{
			for(int i=0;i<4;i++)
			{
				number[i]=s.readInt();
			}	
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
