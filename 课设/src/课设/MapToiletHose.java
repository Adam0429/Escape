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
		if(mainFrame.Missoin>=1){
			JOptionPane.showMessageDialog(null, "水管坏了");
			mainFrame.Missoin=2;
			mainFrame.mapToilet.image=mainFrame.mapToilet.image2;
			new Thread(){
				public void run(){
					while(mainFrame.mapToilet.N[0].x<500){
						mainFrame.mapToilet.N[0].x++;
						try {
							sleep(5);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}.start();
		}
		else
			JOptionPane.showMessageDialog(null, "水管");
	}

}
