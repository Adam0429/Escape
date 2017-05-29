package 课设;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
public class MapToiletHose extends NPC {
	MainFrame mainFrame;
	public MapToiletHose(MainFrame mf){
		x=1083;
		y=403;
		width=200;
		height=1000;
		mainFrame=mf;
	}
	
	public void function(hero h) {
		if(mainFrame.Missoin==1){
			JOptionPane.showMessageDialog(null, "水管坏了");
			mainFrame.Missoin=2;
		}
		else
			JOptionPane.showMessageDialog(null, "水管");
	}

}
