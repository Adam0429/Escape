package lock;

import javax.swing.ImageIcon;

public class Digit extends picture{
	public Digit(int x1,int y1)
	{
		x=x1;
		y=y1;
		height=41;
		width=36;
		img=new ImageIcon(this.getClass().getResource("/picture/abc.jpg")).getImage();
	}
}
