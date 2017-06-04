package ¿ÎÉè;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Save{
	static MainFrame mf;
	static hero h;
	int[] number = new int[10];
	public Save (MainFrame Frame,hero h1){
		mf=Frame;
		h=MainFrame.h;
	}
	public void save(){
		if(mf.Current==mf.map1303)
		{
			number[0]=1;
		}
		else if(mf.Current == mf.mapCorridor1)
		{
			number[0]=2;
		}
		else if(mf.Current == mf.mapCorridor2)
		{
			number[0] = 3;
		}
		else if(mf.Current == mf.map1304)
		{
			number[0] =4;
		}
		else if(mf.Current == mf.map1305)
		{
			number[0] = 5;
		}
		else if(mf.Current ==mf.map1306)
		{
			number[0] = 6;
		}
		else if(mf.Current ==mf.map1307)
		{
			number[0] = 7;
		}
		else if(mf.Current ==mf.map1308)
		{
			number[0] = 8;
		}
		else if(mf.Current == mf.mapLift)
		{
			number[0] = 9;
		}
		else if(mf.Current ==mf.mapMaster)
		{
			number[0] = 10;
		}
		else if(mf.Current ==mf.mapToilet)
		{
			number[0]=11;
		}
		number[1] = h.x;
		number[2] = h.y;
		number[3]=mf.Missoin;
		try(DataOutputStream a = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("C:\\Users\\lenovo\\Desktop\\data.txt"))))
		{
			for(int i=0;i<4;i++)
			{
				a.writeInt(number[i]);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
