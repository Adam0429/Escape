package 课设;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChessBoard extends JPanel{
	public static final int MARGIN=35;
	public static final int DISTANCE=30;
	public static final int ROW=15;
	public static final int COLUMN=15;
	ImageIcon icon = new ImageIcon("C:/Users/wfh/Desktop/飞机/pic1.jpg");
	Image img=icon.getImage();
	ImageIcon blackicon = new ImageIcon("C:/Users/wfh/Desktop/飞机/black.jpg");
	Image black=blackicon.getImage();
	ImageIcon whiteicon = new ImageIcon("C:/Users/wfh/Desktop/飞机/white.jpg");
	Image white=whiteicon.getImage();
	static JFrame frame=new JFrame();
	static ChessBoard cb=new ChessBoard();
	static ChessBoard.MyListener mk=cb.new MyListener();
	int[] chess=new int[ROW*COLUMN];
	 boolean[] exist=new boolean[ROW*COLUMN];
	int[] chessX=new int[ROW*COLUMN];
	int[] chessY=new int[ROW*COLUMN];
	static int i=0;
	int xIndex,yIndex;
	public static void main(String[] Args){
		frame.setTitle("五子棋");
		frame.setSize(550, 600);
		frame.getContentPane().add(cb);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.setLocationRelativeTo(null); 
        frame.addMouseListener(mk);
		frame.setVisible(true);		
	}
	public ChessBoard(){
		init();
	}
	public void init(){
		for(int i=0;i<=exist.length-1;i++)
			exist[i]=true;
	}
	public void paint(Graphics g){
		for(int i=0;i<=ROW;i++){
			g.drawLine(MARGIN,i*DISTANCE+MARGIN, COLUMN*DISTANCE+MARGIN, i*DISTANCE+MARGIN);
		}
		for(int i=0;i<=COLUMN;i++){
			g.drawLine(i*DISTANCE+MARGIN,MARGIN,i*DISTANCE+MARGIN, COLUMN*DISTANCE+MARGIN);
		}
		for(int i=0;i<=chess.length-1;i++){
			if(chess[i]==1){
				g.drawImage(black,chessX[i],chessY[i],20,20,this);
			}
			else if(chess[i]==2){
				g.drawImage(white,chessX[i],chessY[i],20,20,this);
			}
		}
	 } 
	class MyListener implements MouseListener{
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
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
		public void mousePressed(MouseEvent e) {
			int x=(e.getX()-30)/30;
			int y=(e.getY()-60)/30;
			if(exist[x+y*10]==true){
				if(i%2==1)
					chess[i]=1;
				else 
					chess[i]=2;
				System.out.print(x+" ");
				System.out.println(y);
				chessX[i]=x*30+35-10;
				chessY[i]=y*30+35-10;
				repaint();
				exist[x+y*10]=false;
				i++;}
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}
	
}
