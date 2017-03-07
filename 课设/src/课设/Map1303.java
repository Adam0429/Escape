package øŒ…Ë;

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
		destination[0]=mf.mapCorridor1;
		destination[1]=mf.mapCorridor1;
		destination[2]=mf.mapCorridor1;
	}
}
