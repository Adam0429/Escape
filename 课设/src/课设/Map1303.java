package 课设;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Map1303 extends Map{
	public Map1303(MainFrame mf,hero h){
		x=0;
		y=0;
		height=750;
		width=1200;
		image = new ImageIcon(this.getClass().getResource("./Map1303.png")).getImage();
		door[0]=new Rectangle(900,60,150,471);
		door[1]=new Rectangle(900,60,150,471);
		door[2]=new Rectangle(900,60,150,471);
		N[0]=new WFH();
		N[1]=new WY();
		N[2]=new CYX();
		//NPC存在地图中
		/*MapSet ms=new MapSet(mf,h);
		if(ms.mapCorridor1==null){	//这段之前用来测试空指针问题
			System.out.println("create destination");
		}*/
	}
}
