package ����;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;

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
			 if(mf.Current==mf.mapToilet&&h.x<100){
				 mf.Current=mf.mapCorridor1;
				 h.x=900;
			 }
		 }
		 if(e.getKeyCode() == KeyEvent.VK_SPACE) {  
			 h.down=false;
			 h.up=true;
		 }
		 if(e.getKeyCode() == KeyEvent.VK_ENTER) {  	
			 if(mf.Current==mf.mapStart)
				 mf.Current=mf.map1303;
			
//				 ChessBoard chessBoard;
//				
//					 chessBoard=new ChessBoard();
//					 chessBoard.frame.setTitle("������");
//					 chessBoard.frame.setSize(550, 600);
//					 chessBoard.frame.getContentPane().add(chessBoard.cb);
//					 chessBoard.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
//					 chessBoard.frame.setLocationRelativeTo(null); 
//					 chessBoard.frame.addMouseListener(chessBoard.mk);
//					 chessBoard.frame.setVisible(true);		
		 }
		 if(e.getKeyCode() == KeyEvent.VK_E) {
			 Trigger t=new Trigger(mf,h);
			// new Sound();				����������ر�
			 t.enter();
			 int i=0;
			 while(mf.Current.N[i]!=null){
				 t.check(mf.Current.N[i]);
				 i++;
			 }
		 }
		 if(e.getKeyCode() == KeyEvent.VK_1) {  	
			 Save s=new Save(mf,h);
			 System.out.println("�浵");
		 }
		 if(e.getKeyCode() == KeyEvent.VK_0) {  	
			 Read r=new Read(mf,h);
			 System.out.println("����");
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