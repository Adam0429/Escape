package ����;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class MapMaster extends Map{
	public MapMaster(MainFrame mf,hero h){
		x=0;
		y=0;
		height=750;
		width=1200;
		image = new ImageIcon(this.getClass().getResource("/picture/MapMaster.png")).getImage();
		door[0]=new Rectangle(950,60,150,471);
		door[1]=new Rectangle(950,60,150,471);
		door[2]=new Rectangle(950,60,150,471);
		T[0]=new MapMasterComputer();
		//NPC���ڵ�ͼ��
		/*MapSet ms=new MapSet(mf,h);
		if(ms.mapCorridor1==null){	//���֮ǰ�������Կ�ָ������
			System.out.println("create destination");
		}*/
	}
}
