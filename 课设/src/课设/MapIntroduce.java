package øŒ…Ë;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class MapIntroduce extends Map{
	public MapIntroduce(MainFrame mf,hero h){
		x=0;
		y=0;
		height=750;
		width=1200;
		image = new ImageIcon(this.getClass().getResource("/picture/Introduce.png")).getImage();
	}
}
