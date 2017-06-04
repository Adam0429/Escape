package 课设;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;
import java.security.spec.DSAGenParameterSpec;

import javax.net.ssl.HostnameVerifier;
import javax.security.auth.x500.X500Principal;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.omg.CORBA.Current;

import 课设.Read;
import 课设.Save;

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
			 if(mf.Current==mf.mapToilet&&h.x>900&&h.x<1283&&mf.Missoin>1){
				 int n=JOptionPane.showConfirmDialog(null, "要从这里下去吗?");//是返回0，不是返回1
				 if(n==0){
					 new Thread(){
						 public void run(){
							 while(h.y<560){
								 h.y=h.y+3;
								 try {
									 sleep(10);
								 } catch (InterruptedException e) {
									 e.printStackTrace();
								 }
							}
						 }	 
					 }.start();
					 h.img=new ImageIcon(this.getClass().getResource("/picture/nodie.jpeg")).getImage();
				 }
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
			 s.save();
			 System.out.println("save file");
		 }
		 if(e.getKeyCode() == KeyEvent.VK_0) {  	
			 Read r=new Read();
			 r.read();
			/* for(int i=0;i<3;i++)
			 {
				 System.out.println(r.number[i]);
			 }*/
			 if(r.number[0]==1)
				{
					
					mf.Current=mf.map1303;
				}
				else if(r.number[0]==2)
				{
					mf.Current = mf.mapCorridor1;
				}
				else if(r.number[0]==3)
				{
					mf.Current = mf.mapCorridor2;
				}
				else if(r.number[0]==4)
				{
					mf.Current = mf.map1304;
				}
				else if(r.number[0]==5)
				{
					mf.Current = mf.map1305;
				}
				else if(r.number[0]==6)
				{
					mf.Current=mf.map1306;
				}
				else if(r.number[0]==7)
				{
					mf.Current = mf.map1307;
				}
				else if(r.number[0]==8)
				{
					mf.Current=mf.map1308;
				}
				else if(r.number[0]==9)
				{
					mf.Current=mf.mapLift;
				}
				else if(r.number[0]==10)
				{
					mf.Current = mf.mapMaster;
				}
				else if(r.number[0]==11)
				{
					mf.Current = mf.mapToilet;
				}
			 h.x = r.number[1];
			 h.y = r.number[2];
			 mf.Missoin=r.number[3];
			 System.out.println("read file");
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