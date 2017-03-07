package øŒ…Ë;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class MapCorridor1 extends Map{
	public MapCorridor1(MainFrame mf,hero h){
		x=0;
		y=0;
		h.x=0;
		h.y=350;
		height=750;
		width=1200;
		image = new ImageIcon(this.getClass().getResource("./MapCorridor1.png")).getImage();
		door[0]=new Rectangle(918,347,257,121);				
		door[1]=new Rectangle(900,60,150,471);
		door[2]=new Rectangle(900,60,150,471);
		destination[0]=mf.map1303;
		destination[1]=mf.map1303;
		destination[2]=mf.map1303;
	}
}

