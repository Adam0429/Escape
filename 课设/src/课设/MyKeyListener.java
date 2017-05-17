package 课设;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;
import java.security.spec.DSAGenParameterSpec;

import javax.security.auth.x500.X500Principal;
import javax.swing.JFrame;

import org.omg.CORBA.Current;

public class MyKeyListener implements KeyListener{
	MainFrame mf;
	hero h;
	Map map;
	public MyKeyListener(MainFrame Frame,hero h1){
		mf=Frame;
		h=MainFrame.h;
	}
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_H){
			if(mf.Current!=mf.mapIntroduce){			
				new Sound();
				map=mf.Current;
				mf.Current=mf.mapIntroduce;
				
			}
			else if(mf.Current==mf.mapIntroduce){
				new Sound();
				mf.Current=map;	
			}
			
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {	 
			h.right=true;
			if(mf.Current==mf.mapCorridor1&&h.x>1000){
				mf.Current=mf.mapToilet;
			 	h.x=100;
			 }
			 if(mf.Current==mf.mapCorridor2&&h.x>1000){
				mf.Current=mf.mapCorridor1;
				h.x=100;
			 }
		 }
		 if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			 h.left=true;
			 if(mf.Current==mf.mapCorridor1&&h.x<100){
				 mf.Current=mf.mapCorridor2;
				 h.x=900;
			 }
			 if(mf.Current==mf.mapCorridor2&&h.x<100){
				 mf.Current=mf.mapMaster;
				 h.x=900;
			 }
			 if(mf.Current==mf.mapToilet&&h.x<100){
				 mf.Current=mf.mapCorridor1;
				 h.x=900;
			 }
		 }
		 if(e.getKeyCode() == KeyEvent.VK_DOWN&&h.x>265&&h.y<489){
			 if(mf.Current==mf.mapCorridor1){
				 mf.Current=mf.mapLift;
				
			 }
		 }
		 
		 if(e.getKeyCode() == KeyEvent.VK_UP){
			 if(mf.Current==mf.mapLift){
				 mf.Current=mf.mapCorridor1;
				
			 }
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
			// new Sound();				加了这个会特别卡
			 t.enter();
			 int i=0;
			 while(mf.Current.N[i]!=null){
				 t.check(mf.Current.N[i]);
				 i++;
			 }
		 }
		 if(e.getKeyCode() == KeyEvent.VK_1) {  	
			 Save s=new Save(mf,h);
			 System.out.println("存档");
		 }
		 if(e.getKeyCode() == KeyEvent.VK_0) {  	
			 Read r=new Read(mf,h);
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