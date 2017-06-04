package øŒ…Ë;

import javax.swing.ImageIcon;

public class MapSuc extends Map{
	public MapSuc(MainFrame mf,hero h){
		x=0;
		y=0;
		height=720;
		width=1200;
		image=new ImageIcon(this.getClass().getResource("/picture/MapSuc.png")).getImage();
	}
}
