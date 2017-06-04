package øŒ…Ë;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class MapMaster extends Map{
	public MapMaster(MainFrame mf,hero h){
		x=0;
		y=0;
		height=750;
		width=1200;
		image = new ImageIcon(this.getClass().getResource("/picture/MapMaster.png")).getImage();
		door[0]=new Rectangle(950,60,150,471);
		door[1]=new Rectangle(950,60,150,471);
		door[2]=new Rectangle(950,60,150,471);
		N[0]=new Master();
		T[0]=new MapMasterComputer(mf);
		
	}
}
