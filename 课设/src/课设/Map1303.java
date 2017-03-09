package 课设;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Map1303 extends Map{
	public Map1303(MainFrame mf,hero h){
		x=0;
		y=0;
		h.x=0;
		h.y=350;
		height=750;
		width=1200;
		image = new ImageIcon(this.getClass().getResource("./Map1303.png")).getImage();
		door[0]=new Rectangle(900,60,150,471);
		door[1]=new Rectangle(900,60,150,471);
		door[2]=new Rectangle(900,60,150,471);
	//	if(mf.mapCorridor1==null){	这段之前用来测试空指针问题
		//	System.out.println("create destination");
		//}
		destination[0]=MapSet.mapCorridor1;
		destination[1]=MapSet.mapCorridor1;
		destination[2]=MapSet.mapCorridor1;
	}
}
