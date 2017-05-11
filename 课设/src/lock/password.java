package lock;

import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints.Key;

import javax.swing.ImageIcon;
import javax.swing.text.StyledEditorKit.ForegroundAction;

public class password extends picture{
	static int number = 0;
	public password()
	{
		x=300;
		y=100;
		height=512;
		width=512;
		img=new ImageIcon(this.getClass().getResource("/picture/timg.jpg")).getImage();
		int a=1;
		for(int j=0;j<3;j++)
		{
			for(int i=0;i<3;i++)
			{
				key[a] = new Rectangle(465+105*i, 293+j*77, 77, 50);
				a++;
			}
		}
		key[0] = new Rectangle(570, 533,77, 50);
		key[10] = new Rectangle(465, 533, 77, 50);
		key[11] = new Rectangle(675, 533, 77, 50);
		for(int i=0;i<4;i++)
		{
			a1[i] = new Digit( 540+45*i, 186);
		}
	}
	static int getXY(int x1,int y1)
	{
		int x=x1;
		int y=y1;
		Point p= new Point(x, y);
		for(int a=0;a<12;a++)
		{
			if(key[a].contains(p))
			{
				number = a;
			}
		}
		return number;
	}
}
