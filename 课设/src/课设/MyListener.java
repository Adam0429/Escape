package 课设;

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
			 /*用这种写法会比用之前的写法手感好.原来的只有按下去一段时间才会走，猜想是多线程的缘故
			  用多线程提高了人物的灵敏度。
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