package 课设;

import javax.swing.JOptionPane;

public class Map1303Plane extends NPC{
	public Map1303Plane(){
		x=567;
		y=417;
		width=35;
		height=35;
	}

	public void function(hero h) {
		JOptionPane.showMessageDialog(null, "这是国航的飞机....");
		
	}
}
