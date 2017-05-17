package øŒ…Ë;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MapStart extends Map{
	public MapStart(MainFrame mf,hero h){
		x=0;
		y=0;
		height=720;
		width=1200;
		image=new ImageIcon(this.getClass().getResource("/picture/MapStart.png")).getImage();
	}
}
