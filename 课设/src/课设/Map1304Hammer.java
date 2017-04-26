package 课设;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Map1304Hammer extends NPC{
	public Map1304Hammer(){
		x=652;
		y=488;
		width=70;
		height=120;
	}

	public void function(hero h) {
		JOptionPane.showMessageDialog(null, "获得锤子!");
	}
}
