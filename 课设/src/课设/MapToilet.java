package 课设;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class MapToilet extends Map{
	public MapToilet(MainFrame mf,hero h){
		x=0;
		y=0;
		height=750;
		width=1200;
		image = new ImageIcon(this.getClass().getResource("./MapToilet.png")).getImage();
		image2 = new ImageIcon(this.getClass().getResource("./MapToiletAfter.png")).getImage();
		door[0]=new Rectangle(950,60,150,471);
		door[1]=new Rectangle(950,60,150,471);
		door[2]=new Rectangle(950,60,150,471);
		T[0]=new MapToiletHose(mf);
		//NPC存在地图中
		/*MapSet ms=new MapSet(mf,h);
		if(ms.mapCorridor1==null){	//这段之前用来测试空指针问题
			System.out.println("create destination");
		}*/
	}
}