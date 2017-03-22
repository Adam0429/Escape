package 课设;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;

public class MyKeyListener implements KeyListener,Serializable{
	MainFrame mf;
	hero h;
	public MyKeyListener(MainFrame Frame,hero h1){
		mf=Frame;
		h=MainFrame.h;
	}
	public void keyPressed(KeyEvent e) {
		 if(e.getKeyCode() == KeyEvent.VK_RIGHT) {	 
			 h.right=true;
			 if(mf.Current==mf.mapCorridor1&&h.x>1000)
				 mf.Current=mf.mapToilet;
			 if(mf.Current==mf.mapCorridor2&&h.x>1000)
				 mf.Current=mf.mapCorridor2;
		 }
		 if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			 h.left=true;
			 if(mf.Current==mf.mapCorridor1&&h.x<100)
				 mf.Current=mf.mapCorridor2;
			 if(mf.Current==mf.mapToilet&&h.x<100)
				 mf.Current=mf.mapCorridor1;
		 }
		 if(e.getKeyCode() == KeyEvent.VK_SPACE) {  
			 h.down=false;
			 h.up=true;
		 }
		 if(e.getKeyCode() == KeyEvent.VK_ENTER) {  	
			 if(mf.Current==mf.mapStart)
				 mf.Current=mf.map1303;
		 }
		 if(e.getKeyCode() == KeyEvent.VK_E) {
			 Trigger t=new Trigger(mf,h);
			 t.enter();
			 int i=0;
			 while(mf.Current.N[i]!=null){
				 t.check(mf.Current.N[i]);
				 i++;
			 }
			 System.out.println(mf.dialog);
		 }
		 if(e.getKeyCode() == KeyEvent.VK_1) {  	
			 Save s=new Save(mf,h);
			 System.out.println("存档");
		 }
		 if(e.getKeyCode() == KeyEvent.VK_0) {  	
			 Read r=new Read();
			 System.out.println("读档");
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