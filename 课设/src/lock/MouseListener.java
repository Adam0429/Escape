package lock;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.Map;

public class MouseListener implements java.awt.event.MouseListener{
	int count=0;
	static int[] number = new int[4];
	Drawing d;
	picture temp;
	public MouseListener(Drawing d1)
	{
		d=d1;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		 int x= e.getX();
		 int y= e.getY();
		 if(password.getXY(x, y)<10)
		 {
			 number[count]=password.getXY(x, y);
			 count++;
		 }
		 else if(password.getXY(x, y)>=10)
		 {
			 int a1 = password.getXY(x, y);
			 if(a1==10)
			 {
				 d.reset(0);
			 }
			 if(a1==11)
			 {
				 d.reset(count-1);
			 }
		 }
		 if(count==4)
		 {
			 Drawing.check();
		 }
		 d.time=count;
		 d.repaint();
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
