package ����;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyListener implements KeyListener{
	MainFrame frame;
	hero h;
	public MyListener(MainFrame Frame,hero h1){
		frame=Frame;
		h=MainFrame.h;
	}
	public void keyPressed(KeyEvent e) {
		 if(e.getKeyCode() == KeyEvent.VK_RIGHT) {  	
			 h.right=true;
		 }
		 if(e.getKeyCode() == KeyEvent.VK_LEFT) {  
		     h.left=true;	
		 }
		 if(e.getKeyCode() == KeyEvent.VK_SPACE) {  
			 h.down=false;
			 h.up=true;
		 }
		 if(e.getKeyCode() == KeyEvent.VK_ENTER) {  	
			 frame.Current=frame.map1303;
		 }
	}
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {  
			 h.right=false;	
			 /*������д�������֮ǰ��д���ָк�.ԭ����ֻ�а���ȥһ��ʱ��Ż��ߣ������Ƕ��̵߳�Ե��
			  �ö��߳����������������ȡ�
			  */
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {  
			h.left=false;	
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {  
			h.up=false;
			h.down=true;	
		}	 
	}
	public void keyTyped(KeyEvent e) {
	}    
}