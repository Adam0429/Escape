package øŒ…Ë;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class MapCorridor2 extends Map{
	public MapCorridor2(MainFrame mf,hero h){
		x=0;
		y=0;
		h.x=0;
		h.y=350;
		height=750;
		width=1200;
		image = new ImageIcon(this.getClass().getResource("./MapCorridor2.png")).getImage();
		door[0]=new Rectangle(918,347,257,121);				
		destination[0]=mf.map1303;
	}
}
