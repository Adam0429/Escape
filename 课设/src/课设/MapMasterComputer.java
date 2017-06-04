package 课设;

import javax.swing.JOptionPane;
import lock.*;
public class MapMasterComputer extends NPC {
	public MapMasterComputer(){
		x=230;
		y=358;
		width=200;
		height=200;
	}
		
	public void function(hero h) {
		new Drawing().d.init();
		JOptionPane.showMessageDialog(null, "电梯已开");//密码1309，代表楼长的房间
	}

}
