package ����;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Map1304 extends Map{
	public Map1304(MainFrame mf,hero h){
		x=0;
		y=0;
		height=750;
		width=1200;
		image = new ImageIcon(this.getClass().getResource("./Map1304.png")).getImage();
		door[0]=new Rectangle(0,60,150,471);
		door[1]=new Rectangle(0,60,150,471);
		door[2]=new Rectangle(0,60,150,471);
		/*MapSet ms=new MapSet(mf,h);
		if(ms.mapCorridor1==null){	//���֮ǰ�������Կ�ָ������
			System.out.println("create destination");
		}*/
	}
}
