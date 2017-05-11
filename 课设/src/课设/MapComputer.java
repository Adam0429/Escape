package øŒ…Ë;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class MapComputer extends Map{
	public MapComputer(MainFrame mf,hero h){
		x=0;
		y=0;
		height=750;
		width=1200;
		image = new ImageIcon(this.getClass().getResource("/picture/Computer.png")).getImage();
	}
}
