package ����;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class MapToilet extends Map{
	public MapToilet(MainFrame mf,hero h){
		x=0;
		y=0;
		height=750;
		width=1200;
		image = new ImageIcon(this.getClass().getResource("/picture/MapToilet.png")).getImage();
		image2 = new ImageIcon(this.getClass().getResource("/picture/MapToiletAfter.png")).getImage();
		door[0]=new Rectangle(950,60,150,471);
		door[1]=new Rectangle(950,60,150,471);
		door[2]=new Rectangle(950,60,150,471);
		N[0]=new Master();
		T[0]=new MapToiletHose(mf);
		N[0].x=0;
		//NPC���ڵ�ͼ��
		/*MapSet ms=new MapSet(mf,h);
		if(ms.mapCorridor1==null){	//���֮ǰ�������Կ�ָ������
			System.out.println("create destination");
		}*/
	}
}