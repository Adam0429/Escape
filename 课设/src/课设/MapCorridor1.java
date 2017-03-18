package øŒ…Ë;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class MapCorridor1 extends Map{
	public MapCorridor1(MainFrame mf,hero h){
		x=0;
		y=0;
		height=750;
		width=1200;
		image = new ImageIcon(this.getClass().getResource("./MapCorridor1.png")).getImage();
		door[0]=new Rectangle(857,324,257,121);				
		door[1]=new Rectangle(511,345,150,471);
		door[2]=new Rectangle(121,343,150,471);
	}
}

