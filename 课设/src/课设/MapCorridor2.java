package øŒ…Ë;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class MapCorridor2 extends Map{
	public MapCorridor2(MainFrame mf,hero h){
		x=0;
		y=0;
		height=750;
		width=1200;
		image = new ImageIcon(this.getClass().getResource("/picture/MapCorridor2.png")).getImage();
		door[0]=new Rectangle(876,380,120,150);				
		door[1]=new Rectangle(511,345,150,471);
		door[2]=new Rectangle(121,343,150,471);
		N[0]=new SLZ();
	}
}
