package pintugame;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PictureCanvas extends JPanel implements MouseListener {//guide the picture into the cell
	public Cell[] cell;
	public boolean hasAddActionListener=false;
	public Rectangle nullCell;
	public PictureCanvas(){
		this.setLayout(null);
		cell=new Cell[9];
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				ImageIcon icon=new ImageIcon(this.getClass().getResource("/picture/picture"+(i*3+j+1)+".jpg"));
				cell[i*3+j]=new Cell(icon);
				cell[i*3+j].setLocation(j*150+20, i*150+20);
				this.add(cell[i*3+j]);
			}
		}
		this.remove(cell[8]);//delete last cell,make it be null
		nullCell = new Rectangle(300+20,300+20,150,150);
	}

/*public void shoutcut(){
	
}*/

public void start(){//disorganize the picture
	if(!hasAddActionListener){
		for(int i=0;i<8;i++){
			cell[i].addMouseListener(this);
		}
		hasAddActionListener=true;
	}
	while(cell[0].getBounds().x<=170&&cell[0].getBounds().y<=170){
		int nullX=nullCell.getBounds().x;
		int nullY=nullCell.getBounds().y;
		int direction=(int)(Math.random()*4);
		switch (direction) {
		case 0://left
			nullX -= 150;
			cellMove(nullX,nullY,"right");
			break;
		case 1://right
			nullX += 150;
			cellMove(nullX,nullY,"left");
			break;
		case 2://up
			nullY -= 150;
			cellMove(nullX,nullY,"down");
			break;
		case 3://down
			nullY += 150;
			cellMove(nullX,nullY,"up");
			break;
		}	
	}	
}


public void cellMove(int nullX, int nullY, String direction) {
	// TODO Auto-generated method stub
	for(int i=0;i<8;i++){
		if(cell[i].getBounds().x==nullX&&cell[i].getBounds().y==nullY){
			cell[i].move(direction);
			nullCell.setLocation(nullX, nullY);
			break;
		}
	}
}


public void mouseClicked(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}


public void mouseEntered(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}


public void mouseExited(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}


public void mousePressed(MouseEvent e) {
	// click cell will make it change location with nullcell
	Cell button=(Cell)e.getSource();
	int clickX=button.getBounds().x;
	int clickY=button.getBounds().y;
	int nullX=nullCell.getBounds().x;
	int nullY=nullCell.getBounds().y;
	if(clickX==nullX&&clickY-nullY==150){
		button.move("up");
	}else if(clickX==nullX&&clickY-nullY==-150){
		button.move("down");
	}else if(clickX-nullX==150&&clickY==nullY){
		button.move("left");
	}else if(clickX-nullX==-150&&clickY==nullY){
		button.move("right");
	}else{
		return;
	}
	nullCell.setLocation(clickX, clickY);
	this.repaint();
	//win
	if(this.isFinish()){
	JOptionPane.showMessageDialog(this, "娱乐一下,并没有什么用~");
	for(int i=0;i<8;i++){
		cell[i].removeMouseListener(this);
	}
	hasAddActionListener=false;
	}
}

public boolean isFinish(){//Judge whether the game is over
	for(int i=0;i<8;i++){
		int x=cell[i].getBounds().x;
		int y=cell[i].getBounds().y;
		if((y-20)/150*3+(x-20)/150!=i){
			return false;
		}
	}
	return true;
}


























public void mouseReleased(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}









}