package 课设;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Map1308 extends Map{
	public Map1308(MainFrame mf,hero h){
		x=0;
		y=0;
		height=750;
		width=1200;
		image = new ImageIcon(this.getClass().getResource("/picture/Map1308.png")).getImage();
		door[0]=new Rectangle(0,60,150,471);
		door[1]=new Rectangle(0,60,150,471);
		door[2]=new Rectangle(0,60,150,471);
		/*MapSet ms=new MapSet(mf,h);
		if(ms.mapCorridor1==null){	//这段之前用来测试空指针问题
			System.out.println("create destination");
		}*/
	}
}
