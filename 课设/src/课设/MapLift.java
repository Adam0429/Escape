package øŒ…Ë;

import java.awt.Rectangle;

import javax.swing.ImageIcon;
public class MapLift extends Map{
	public MapLift(MainFrame mf,hero h){
		x=0;
		y=0;
		height=750;
		width=1200;
		image = new ImageIcon(this.getClass().getResource("/picture/MapLift.png")).getImage();
		door[0]=new Rectangle(0,0,0,0);				
		door[1]=new Rectangle(0,0,0,0);	
		door[2]=new Rectangle(0,0,0,0);	
		N[0]=new ZXW();
		T[0]=new MapLiftlift();
	}
}