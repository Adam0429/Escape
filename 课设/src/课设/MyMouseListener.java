package øŒ…Ë;

import java.awt.Rectangle;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;

public class MyMouseListener implements MouseListener,Serializable{
	MainFrame mf;
	hero h;
	public MyMouseListener(MainFrame Frame,hero h1){
		mf=Frame;
		h=MainFrame.h;
	}
	public void mouseClicked(MouseEvent e) {
		Rectangle client=new Rectangle(0, 50, 138, 171);
		if(client.contains(e.getX(), e.getY())){
			new Client(mf).go();;
		}
		if(mf.Current==mf.mapComputer){
			mf.Current=mf.map1303;
		}
		System.out.println(e.getX());
		System.out.println(e.getY());
		int x=e.getX();
		int y=e.getY();
		Trigger t=new Trigger(mf,h);
		int i=0;
		while(mf.Current.T[i]!=null){
			t.use(mf.Current.T[i], x, y);
			i++;
		 }
		
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
